package com.solvd.carservice.persistence.impl;

import com.solvd.carservice.domain.CarService;
import com.solvd.carservice.domain.client.Client;
import com.solvd.carservice.domain.department.Department;
import com.solvd.carservice.persistence.CarServiceRepository;
import com.solvd.carservice.persistence.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.solvd.carservice.persistence.Config.getData;

public class CarServiceRepositoryImpl implements CarServiceRepository {

    ConnectionPool connectionPool = ConnectionPool.getInstance(Integer.valueOf(Objects.requireNonNull(getData("poolSize"))));

    @Override
    public void create(CarService carService) {
        Connection connection = connectionPool.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("insert into car_services(name) values(?)", Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, carService.getName());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            while(resultSet.next()) {
                carService.setId(resultSet.getLong(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Unable to create new car service: ", e);
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public List<CarService> findAllLeft() {
        List<CarService> carServices;
        Connection connection = connectionPool.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("select c.id as car_service_id, c.name as car_service_name, d.name as department_name, e.last_name as parents_surname \n" +
                    "from car_services c left join departments d on c.id = d.car_service_id left join employees e on  d.id = e.department_id;");
            ResultSet resultSet = statement.executeQuery();
            carServices = mapCarServices(resultSet);
            while(resultSet.next()) {
                Long id = resultSet.getLong("car_service_id");
                String serviceName = resultSet.getString("car_service_name");

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return carServices;
    }

    @Override
    public List<CarService> findAllRight() {
        List<CarService> carServices;
        Connection connection = connectionPool.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("select id,name from car_services where id = ?");
            statement.setLong(1, 17);
            ResultSet resultSet = statement.executeQuery();
            carServices = mapCarServices(resultSet);
            while (resultSet.next()) {
                Long id = resultSet.getLong(1);
                String serviceName = resultSet.getString(2);
                System.out.println(id + " " + serviceName);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return carServices;
    }

    public static List<CarService> mapCarServices(ResultSet resultSet) throws SQLException {
        List<CarService> carServices = new ArrayList<>();
        while(resultSet.next()) {
            Long id = resultSet.getLong("car_service_id");
            CarService carService = findById(id, carServices);
            carService.setName(resultSet.getString("car_service_name"));

            List<Department> departments = DepartmentRepositoryImpl.mapDepartment(resultSet, carService.getDepartments());
            carService.setDepartments(departments);

            List<Client> clients = ClientRepositoryImpl.mapClient(resultSet, carService.getClients());
            carService.setClients(clients);
        }
        return carServices;
    }

    private static CarService findById (Long id, List<CarService> carServices) {
        return carServices.stream()
                .filter(carService -> carService.getId().equals(id))
                .findFirst()
                .orElseGet(() -> {
                    CarService createdCarService = new CarService();
                    createdCarService.setId(id);
                    carServices.add(createdCarService);
                    return createdCarService;
                });
    }
}
