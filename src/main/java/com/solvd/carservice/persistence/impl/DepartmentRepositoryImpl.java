package com.solvd.carservice.persistence.impl;

import com.solvd.carservice.domain.department.Department;
import com.solvd.carservice.domain.employee.Employee;
import com.solvd.carservice.domain.equipment.Tool;
import com.solvd.carservice.domain.exception.RequestException;
import com.solvd.carservice.persistence.ConnectionPool;
import com.solvd.carservice.persistence.DepartmentRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.solvd.carservice.persistence.Config.getData;

public class DepartmentRepositoryImpl implements DepartmentRepository {

    private static final ConnectionPool connectionPool = ConnectionPool.getInstance(Integer.valueOf(Objects.requireNonNull(getData("poolSize"))));

    @Override
    public void create(Department department, Long carServiceId) {
        Connection connection = connectionPool.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into departments(car_service_id, name) values (?,?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setLong(1, carServiceId);
            preparedStatement.setString(2, department.getName());
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while (resultSet.next()) {
                department.setId(resultSet.getLong(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Unable to create department: ", e);
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void update(Long id, String name) {
        Connection connection = connectionPool.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("update departments set name = ? where id = ?");
            statement.setString(1, name);
            statement.setLong(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Unable to update this department, because FOREIGN_KEY_CHECKS = 1 ", e);
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void delete(Long id) {
        Connection connection = connectionPool.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("delete from departments where id = ?");
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RequestException("Cannot to delete department, because FOREIGN_KEY_CHECKS = 1");
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public List<Department> findByName(String name) {
        List<Department> departments;
        String query = "%" + name + "%";
        Connection connection = connectionPool.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("select d.id as department_id, d.name as department_name from departments d where d.name like ?");
            statement.setString(1, query);
            ResultSet resultSet = statement.executeQuery();
            departments = mapDepartments(resultSet);
            while (resultSet.next()) {
                Long id = resultSet.getLong("department_id");
                String departmentName = resultSet.getString("department_name");
            }
        } catch (SQLException e) {
            throw new RequestException("Cannot find departments with this name");
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return departments;
    }

    @Override
    public List<Department> findById(Long id) {
        Department department;
        Connection connection = connectionPool.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("select d.id as department_id, d.name as department_name from departments d where d.id = ?");
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            department = (Department) mapDepartments(resultSet);
            while (resultSet.next()) {
                id = resultSet.getLong("department_id");
                String serviceName = resultSet.getString("department_name");
            }
        } catch (SQLException e) {
            throw new RequestException("Cannot find department");
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return null;
    }

    public List<Department> findByCarServiceId(Long carServiceId) {
        List<Department> departments;
        Connection connection = connectionPool.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("select d.id as department_id, d.name as department_name from departments d where d.car_service_id = ?");
            statement.setLong(1, carServiceId);
            ResultSet resultSet = statement.executeQuery();
            departments = mapDepartments(resultSet);
            while (resultSet.next()) {
                Long id = resultSet.getLong("department_id");
                String serviceName = resultSet.getString("department_name");
            }
        } catch (SQLException e) {
            throw new RequestException("Cannot find department for this car service");
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return departments;
    }

    private static List<Department> mapDepartments(ResultSet resultSet) throws SQLException {
        List<Department> departments = new ArrayList<>();

        while (resultSet.next()) {
            departments = mapDepartment(resultSet, departments);
        }
        return departments;
    }

    public static List<Department> mapDepartment(ResultSet resultSet, List<Department> departments) throws SQLException {
        long id = resultSet.getLong("department_id");
        if (id != 0) {
            if (departments == null) {
                departments = new ArrayList<>();
            }

            Department department = findByDepId(id, departments);
            department.setName(resultSet.getString("department_name"));

            List<Employee> employees = EmployeeRepositoryImpl.mapEmployee(resultSet, department.getEmployees());
            department.setEmployees(employees);

            List<Tool> tools = ToolRepositoryImpl.mapTool(resultSet, department.getTools());
            department.setTools(tools);
        }
        return departments;
    }

    private static Department findByDepId(Long id, List<Department> departments) {
        return departments.stream()
                .filter(department -> department.getId().equals(id))
                .findFirst()
                .orElseGet(() -> {
                    Department createdDepartment = new Department();
                    createdDepartment.setId(id);
                    departments.add(createdDepartment);
                    return createdDepartment;
                });
    }
}
