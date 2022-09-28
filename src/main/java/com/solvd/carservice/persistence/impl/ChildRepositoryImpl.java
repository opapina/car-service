package com.solvd.carservice.persistence.impl;

import com.solvd.carservice.domain.employee.Child;
import com.solvd.carservice.domain.exception.RequestException;
import com.solvd.carservice.persistence.ChildRepository;
import com.solvd.carservice.persistence.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.solvd.carservice.persistence.Config.getData;

public class ChildRepositoryImpl implements ChildRepository {

    private static final ConnectionPool connectionPool = ConnectionPool.getInstance(Integer.valueOf(Objects.requireNonNull(getData("poolSize"))));

    @Override
    public void create(Child child) {
        Connection connection = connectionPool.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into children(first_name,last_name,dob) values (?,?,?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, child.getFirstName());
            preparedStatement.setString(2, child.getLastName());
            preparedStatement.setTimestamp(3, Timestamp.valueOf(child.getDob().atStartOfDay()));
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while (resultSet.next()) {
                child.setId(resultSet.getLong(1));
            }
        } catch (SQLException e) {
            throw new RequestException("Unable to create child: ", e);
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void update(Long id, String name) {
        Connection connection = connectionPool.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("update children set dob = ? where id = ?");
            statement.setString(1, name);
            statement.setLong(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RequestException("Unable to update this child: ", e);
        } finally {
            connectionPool.releaseConnection(connection);
        }

    }

    @Override
    public void delete(Long id) {
        Connection connection = connectionPool.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("delete from children where id = ?");
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RequestException("Unable to delete child");
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public List<Child> findByName(String name) {
        List<Child> children;
        Connection connection = connectionPool.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("select ch.firstName as child_name, ch.lastName as child_surname " + "from children ch where ch.name = ?");
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            children = mapChildren(resultSet);
            while (resultSet.next()) {
                Long id = resultSet.getLong("child_id");
            }
        } catch (SQLException e) {
            throw new RequestException("Cannot find children with that name", e);
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return children;
    }

    public static List<Child> mapChildren(ResultSet resultSet) throws SQLException {
        List<Child> children = new ArrayList<>();
        while (resultSet.next()) {
            children = mapChild(resultSet, children);
        }
        return children;
    }

    public static List<Child> mapChild(ResultSet resultSet, List<Child> children) throws SQLException {
        long id = resultSet.getLong("child_id");
        if (id != 0) {
            if (children == null) {
                children = new ArrayList<>();
            }

            Child child = findById(id, children);
            child.setFirstName(resultSet.getString("child_name"));
            child.setLastName(resultSet.getString("child_surname"));
        }
        return children;
    }

    private static Child findById(Long id, List<Child> children) {
        return children.stream().
                filter(tool -> tool.getId().equals(id))
                .findFirst()
                .orElseGet(() -> {
                    Child createdChild = new Child();
                    createdChild.setId(id);
                    children.add(createdChild);
                    return createdChild;
                });
    }
}
