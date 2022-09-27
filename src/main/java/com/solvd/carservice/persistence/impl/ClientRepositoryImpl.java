package com.solvd.carservice.persistence.impl;

import com.solvd.carservice.domain.client.Client;
import com.solvd.carservice.domain.vehicle.Car;
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
            PreparedStatement preparedStatement = connection.prepareStatement("insert into clients(car_service_id,first_name,last_name,dob,registration_date) values (?,?,?,?,?), (?,?,?,?,?)");
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
            throw new RuntimeException("Unable to create client: ", e);
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    private static List<Client> mapClients(ResultSet resultSet) throws SQLException {
        List<Client> clients = new ArrayList<>();

        while (resultSet.next()) {
            clients = mapClient(resultSet, clients);
        }
        return clients;
    }

    public static List<Client> mapClient(ResultSet resultSet, List<Client> clients) throws SQLException {
        long id = resultSet.getLong("client_id");
        if (id != 0) {
            if (clients == null) {
                clients = new ArrayList<>();
            }

            Client client = findById(id, clients);
            client.setFirstName(resultSet.getString("first_name"));
            client.setLastName(resultSet.getString("last_name"));
            client.setDob(resultSet.getTimestamp("client_dob").toLocalDateTime().toLocalDate());
            client.setRegistrationDate(resultSet.getTimestamp("registration_date").toLocalDateTime().toLocalDate());
//            client.setDiscountProgram(DiscountProgramRepositoryImpl.mapDiscountProgram(resultSet));

            List<Car> cars = CarRepositoryImpl.mapCar(resultSet, client.getCars());
            client.setCars(cars);
        }
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