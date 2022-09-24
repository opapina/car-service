package com.solvd.carservice.persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class Config {

    private static final Logger LOGGER = LogManager.getLogger(Config.class);

    public static String getData(String propertyKey) {
        Properties properties = new Properties();
        try {
            InputStream in = new BufferedInputStream(new FileInputStream("src/main/resources/config.properties"));
            properties.load(in);
            in.close();
            return properties.getProperty(propertyKey);
        } catch (Exception e) {
            LOGGER.error(e);
            return null;
        }
    }
}
