package com.solvd.carservice.persistence.impl;

import com.solvd.carservice.domain.CarService;
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

    @Override
    public List<Child> findAll() {
        List<Child> children = null;
        Connection connection = connectionPool.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("select ch.id as child_id, ch.first_name as child_name, ch.last_name as child_surname, " +
                    "c.id as car_service_id, c.name as car_service_name, d.id as department_id, d.name as department_name, e.id as employee_id, e.last_name as parents_surname " +
                    "from children ch left join employee_children ec on ch.id = ec.child_id left join employees e on e.id = ec.employee_id  left join departments d " +
                    "on d.id = e.department_id left join  car_services c on c.id = d.car_service_id;");
            ResultSet resultSet = statement.executeQuery();
            children = mapChildren(resultSet);
        } catch (SQLException e) {
            throw new RequestException("Unable to find children", e);
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
        return children.stream().filter(tool -> tool.getId().equals(id)).findFirst().orElseGet(() -> {
            Child createdChild = new Child();
            createdChild.setId(id);
            children.add(createdChild);
            return createdChild;
        });
    }
}
