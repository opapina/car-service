package com.solvd.carservice.persistence.impl;

import com.solvd.carservice.domain.employee.Child;
import com.solvd.carservice.domain.employee.Employee;
import com.solvd.carservice.domain.exception.RequestException;
import com.solvd.carservice.persistence.ConnectionPool;
import com.solvd.carservice.persistence.EmployeeRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.solvd.carservice.persistence.Config.getData;

public class EmployeeRepositoryImpl implements EmployeeRepository {

    private static final ConnectionPool connectionPool = ConnectionPool.getInstance(Integer.valueOf(Objects.requireNonNull(getData("poolSize"))));

    @Override
    public void create(Employee employee, Long departmentId) {
        Connection connection = connectionPool.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into employees(department_id,first_name,last_name,dob,experience,profession) values" +
                    " (?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setLong(1, departmentId);
            preparedStatement.setString(2, employee.getFirstName());
            preparedStatement.setString(3, employee.getLastName());
            preparedStatement.setTimestamp(4, Timestamp.valueOf(employee.getDob().atStartOfDay()));
            preparedStatement.setInt(5, employee.getExperience());
            preparedStatement.setString(6, employee.getProfession());
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while (resultSet.next()) {
                employee.setId(resultSet.getLong(1));
            }
        } catch (SQLException e) {
            throw new RequestException("Unable to create employee: ", e);
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void update(Long id, String firstName, String lastName) {
        Connection connection = connectionPool.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("update employees set first_name = ?, last_name = ? where id = ?");
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setLong(3, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RequestException("Unable to update this department: ", e);
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void delete(Long id) {
        Connection connection = connectionPool.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("delete from employees where id = ?");
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RequestException("Unable to delete employee");
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public List<Employee> findByProfession(String name) {
        List<Employee> employees;
        Connection connection = connectionPool.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("select e.id as employees_id, e.first_name as name, e.last_name as surname, " +
                    "e.dob as birth_day, e.experience as experience, e.profession as profession from employees e where e.profession = ?");
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            employees = mapEmployees(resultSet);
            while (resultSet.next()) {
                Long id = resultSet.getLong("employees_id");
            }
        } catch (SQLException e) {
            throw new RequestException("Unable to find employees which have this profession");
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return employees;
    }

    public static List<Employee> mapEmployees(ResultSet resultSet) throws SQLException {
        List<Employee> employees = new ArrayList<>();
        while (resultSet.next()) {
            employees = mapEmployee(resultSet, employees);
        }
        return employees;
    }

    public static List<Employee> mapEmployee(ResultSet resultSet, List<Employee> employees) throws SQLException {
        long id = resultSet.getLong("employee_id");
        if (id != 0) {
            if (employees == null) {
                employees = new ArrayList<>();
            }

            Employee employee = findById(id, employees);
            employee.setFirstName(resultSet.getString("parent_name"));
            employee.setLastName(resultSet.getString("parent_surname"));

            List<Child> children = ChildRepositoryImpl.mapChild(resultSet, employee.getChildren());
            employee.setChildren(children);
        }
        return employees;
    }

    private static Employee findById(Long id, List<Employee> employees) {
        return employees.stream()
                .filter(employee -> employee.getId().equals(id))
                .findFirst()
                .orElseGet(() -> {
                    Employee createdEmployee = new Employee();
                    createdEmployee.setId(id);
                    employees.add(createdEmployee);
                    return createdEmployee;
                });
    }
}
