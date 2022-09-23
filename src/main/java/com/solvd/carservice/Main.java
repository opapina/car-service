package com.solvd.carservice;

import java.sql.*;

public class Main {
    public static void main(String[] arg) {
        Connection connection;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/car_services_db","root", "Mysql123!");
        } catch (ClassNotFoundException|SQLException e) {
            throw new RuntimeException(e);
        }
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

        try {
            PreparedStatement statement = connection.prepareStatement("select id,name from car_services where id = ?");
            statement.setLong(1,17);
            ResultSet resultSet= statement.executeQuery();
            while(resultSet.next()) {
                Long id = resultSet.getLong(1);
                String serviceName = resultSet.getString(2);
                System.out.println(id + " " +serviceName);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
