package com.solvd.carservice.persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import static com.solvd.carservice.persistence.Config.getData;

public class ConnectionPool {

    private static final Logger LOGGER = LogManager.getLogger(ConnectionPool.class);

    private static ConnectionPool INSTANCE;
    private static BlockingQueue<Connection> connections;

    private ConnectionPool(Integer maxConnection) {
        connections = new ArrayBlockingQueue<>(maxConnection);
        for (int i = 0; i < maxConnection; i++) {
            Config config = new Config();
            Connection connection;
            try {
                Class.forName(getData("driver"));
                connection = DriverManager.getConnection(getData("url"), getData("username"), getData("password"));
                connections.put(connection);
            } catch (ClassNotFoundException|SQLException|InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static ConnectionPool getInstance(Integer maxConnection) {
        if (INSTANCE == null) {
            INSTANCE = new ConnectionPool(maxConnection);
        }
        return INSTANCE;
    }

    public synchronized Connection getConnection() {
        try {
            return connections.take();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void releaseConnection(Connection connection) {
        try {
            connections.put(connection);
        } catch (InterruptedException e) {
            LOGGER.error(e);
        }
    }
}
