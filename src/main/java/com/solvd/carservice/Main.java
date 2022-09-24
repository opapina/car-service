package com.solvd.carservice;

import com.solvd.carservice.persistence.Config;
import com.solvd.carservice.persistence.ConnectionPool;

import java.sql.*;
import java.util.Objects;

import static com.solvd.carservice.persistence.Config.getData;

public class Main {
    public static void main(String[] arg) {
        ConnectionPool connectionPool = ConnectionPool.getInstance(Integer.valueOf(Objects.requireNonNull(getData("poolSize"))));
//        Config config = new Config();
//        Connection connection;
//        try {
//            Class.forName(getData("driver"));
//            connection = DriverManager.getConnection(getData("url"), getData("username"), getData("password"));
//        } catch (ClassNotFoundException|SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//        String name = "C_Update";
//        try {
//            PreparedStatement statement = connection.prepareStatement("insert into car_services(name) values(?)", Statement.RETURN_GENERATED_KEYS);
//            statement.setString(1,name);
//            statement.executeUpdate();
//            ResultSet resultSet =statement.getGeneratedKeys();
//            while(resultSet.next()) {
//                System.out.println(resultSet.getLong(1));
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }

//        try {
//            PreparedStatement statement = connection.prepareStatement("select id,name from car_services where id = ?");
//            statement.setLong(1,17);
//            ResultSet resultSet= statement.executeQuery();
//            while(resultSet.next()) {
//                Long id = resultSet.getLong(1);
//                String serviceName = resultSet.getString(2);
//                System.out.println(id + " " +serviceName);
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
    }
}
