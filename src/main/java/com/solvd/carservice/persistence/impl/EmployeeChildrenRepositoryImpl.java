package com.solvd.carservice.persistence.impl;

import com.solvd.carservice.domain.employee.EmployeeChildren;
import com.solvd.carservice.domain.exception.RequestException;
import com.solvd.carservice.persistence.ConnectionPool;
import com.solvd.carservice.persistence.EmployeeChildrenRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.solvd.carservice.persistence.Config.getData;

public class EmployeeChildrenRepositoryImpl implements EmployeeChildrenRepository {

    private static final ConnectionPool connectionPool = ConnectionPool.getInstance(Integer.valueOf(Objects.requireNonNull(getData("poolSize"))));

    @Override
    public void create(EmployeeChildren employeeChildren, Long employeeId, Long childrenId) {
        Connection connection = connectionPool.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into employee_children(employee_id, child_id) values(?,?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setLong(1, employeeId);
            preparedStatement.setLong(2, childrenId);
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while (resultSet.next()) {
                employeeChildren.setId(resultSet.getLong(1));
            }
        } catch (SQLException e) {
            throw new RequestException("Unable to create employee_children: ", e);
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void delete(Long id) {
        Connection connection = connectionPool.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("delete from employee_children where id = ?");
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RequestException("Unable to delete");
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public List<EmployeeChildren> selectById(Long employeeId) {
        List<EmployeeChildren> employeeChildren;
        Connection connection = connectionPool.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("select ec.id as id, ec.children_id as employee_id from employee_children ec where ec.employee_id = ?");
            statement.setLong(1, employeeId);
            ResultSet resultSet = statement.executeQuery();
            employeeChildren = mapEmployeeChild(resultSet);
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return employeeChildren;
    }

    private static List<EmployeeChildren> mapEmployeeChild(ResultSet resultSet) throws SQLException {
        List<EmployeeChildren> employeeChildren = new ArrayList<>();
        while (resultSet.next()) {
            employeeChildren = mapEmployeeChildren(resultSet, employeeChildren);
        }
        return employeeChildren;
    }

    private static List<EmployeeChildren> mapEmployeeChildren(ResultSet resultSet, List<EmployeeChildren> employeeChildren) throws SQLException {
        long id = resultSet.getLong("id");
        if (id != 0) {
            if (employeeChildren == null) {
                employeeChildren = new ArrayList<>();
            }

            EmployeeChildren employeeChild = findById(id, employeeChildren);
            employeeChild.setEmployeeId(resultSet.getLong("employee_id"));
            employeeChild.setChildrenId(resultSet.getLong("children_id"));
        }
        return employeeChildren;
    }

    private static EmployeeChildren findById(Long id, List<EmployeeChildren> employeeChildren) {
        return employeeChildren.stream().filter(tool -> tool.getId().equals(id)).findFirst().orElseGet(() -> {
            EmployeeChildren createdEmployeeChild = new EmployeeChildren();
            createdEmployeeChild.setId(id);
            employeeChildren.add(createdEmployeeChild);
            return  createdEmployeeChild;
        });
    }
}
