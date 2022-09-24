package com.solvd.carservice.persistence.impl;

import com.solvd.carservice.domain.department.Department;
import com.solvd.carservice.domain.employee.Employee;
import com.solvd.carservice.domain.equipment.Tool;
import com.solvd.carservice.persistence.ConnectionPool;
import com.solvd.carservice.persistence.DepartmentRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
            PreparedStatement preparedStatement = connection.prepareStatement("insert into departments(car_service_id, name) values (?,?), (?,?), (?,?)");
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

            Department department = findById(id, departments);
            department.setName(resultSet.getString("department_name"));

            List<Employee> employees = EmployeeRepositoryImpl.mapEmployee(resultSet, department.getEmployees());
            department.setEmployees(employees);

            List<Tool> tools = ToolRepositoryImpl.mapTool(resultSet, department.getTools());
            department.setTools(tools);
        }
        return departments;
    }

    private static Department findById(Long id, List<Department> departments) {
        return departments.stream().filter(department -> department.getId().equals(id)).findFirst().orElseGet(() -> {
            Department createdDepartment = new Department();
            createdDepartment.setId(id);
            departments.add(createdDepartment);
            return createdDepartment;
        });
    }
}
