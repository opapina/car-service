package com.solvd.carservice.persistence.impl;

import com.solvd.carservice.domain.client.Client;
import com.solvd.carservice.domain.exception.RequestException;
import com.solvd.carservice.persistence.ClientRepository;
import com.solvd.carservice.persistence.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.solvd.carservice.persistence.Config.getData;

public class ClientRepositoryImpl implements ClientRepository {

    private static final ConnectionPool connectionPool = ConnectionPool.getInstance(Integer.valueOf(Objects.requireNonNull(getData("poolSize"))));

    @Override
    public void create(Client client, Long carServiceId) {
        Connection connection = connectionPool.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into clients(car_service_id,first_name,last_name,dob,registration_date) values (?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setLong(1, carServiceId);
            preparedStatement.setString(2, client.getFirstName());
            preparedStatement.setString(3, client.getLastName());
            preparedStatement.setTimestamp(4, Timestamp.valueOf(client.getDob().atStartOfDay()));
            preparedStatement.setTimestamp(5, Timestamp.valueOf(client.getRegistrationDate().atStartOfDay()));

            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while (resultSet.next()) {
                client.setId(resultSet.getLong(1));
            }
        } catch (SQLException e) {
            throw new RequestException("Unable to create client: ", e);
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void update(Long id, String name) {
        Connection connection = connectionPool.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("update clients set first_name = ? where id = ?");
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
            PreparedStatement statement = connection.prepareStatement("delete from clients where id = ?");
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RequestException("Cannot delete client, because FOREIGN_KEY_CHECKS = 1");
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public List<Client> findById(Long carServiceId) {
        List<Client> clients;
        Connection connection = connectionPool.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("select c.id as client_id, c.first_name as name, c.last_name as surname, " +
                    "c.dob as birth_day from clients c where d.car_service_id = ?");
            statement.setLong(1, carServiceId);
            ResultSet resultSet = statement.executeQuery();
            clients = mapClients(resultSet);
            while (resultSet.next()) {
                Long id = resultSet.getLong("department_id");
                String serviceName = resultSet.getString("department_name");
            }
        } catch (SQLException e) {
            throw new RequestException("Cannot find client for this car service");
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return  clients;
    }

    @Override
    public List<Client> findByName(String name) {
        List<Client> clients;
        String query = "%" + name + "%";
        Connection connection = connectionPool.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("select c.id as client_id, c.first_name as name, c.last_name as surname, " +
                            "c.dob as birth_day from clients c where c.last_name like ?");
            statement.setString(1, query);
            ResultSet resultSet = statement.executeQuery();
            clients = mapClients(resultSet);
            while (resultSet.next()) {
                Long id = resultSet.getLong("client_id");
                String surName = resultSet.getString("surname");
            }
        } catch (SQLException e) {
            throw new RequestException("Cannot find client with this name");
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return clients;
    }

    private static List<Client> mapClients(ResultSet resultSet) throws SQLException {
        List<Client> clients = new ArrayList<>();

        while (resultSet.next()) {
            clients = mapClient(resultSet, clients);
        }
        return clients;
    }

    public static List<Client> mapClient(ResultSet resultSet, List<Client> clients) throws SQLException {
//        long id = resultSet.getLong("client_id");
//        if (id != 0) {
//            if (clients == null) {
//                clients = new ArrayList<>();
//            }
//
//            Client client = findById(id, clients);
//            client.setFirstName(resultSet.getString("first_name"));
//            client.setLastName(resultSet.getString("last_name"));
//            client.setDob(resultSet.getTimestamp("client_dob").toLocalDateTime().toLocalDate());
//            client.setRegistrationDate(resultSet.getTimestamp("registration_date").toLocalDateTime().toLocalDate());
//            client.setDiscountProgram(DiscountProgramRepositoryImpl.mapDiscountProgram(resultSet));
//            List<Car> cars = CarRepositoryImpl.mapCar(resultSet, client.getCars());
//            client.setCars(cars);
//        }
        return clients;
    }

    private static Client findById(Long id, List<Client> clients) {
        return clients.stream()
                .filter(client -> client.getId().equals(id))
                .findFirst()
                .orElseGet(() -> {
                    Client createdClient = new Client();
                    createdClient.setId(id);
                    clients.add(createdClient);
            return createdClient;
        });
    }
}