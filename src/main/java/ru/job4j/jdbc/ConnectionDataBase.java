package ru.job4j.jdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.io.UsageLog4j;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;

public class ConnectionDataBase {
    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());
    private static AppProperties appProperties = new AppProperties();

    public static void connection() {
        try {
            String nameClass = appProperties.getValue("hibernate.connection.driver_class");
            LOG.debug("Driver class (JDBC): {}", nameClass);
            String url = appProperties.getValue("hibernate.connection.url");
            LOG.debug("URL (JDBC): {}", url);
            String login = appProperties.getValue("hibernate.connection.username");
            LOG.debug("Username (JDBC): {}", login);
            String password = appProperties.getValue("hibernate.connection.password");
            LOG.debug("Password (JDBC): {}", password);
            Class.forName(nameClass);
            try (Connection connection = DriverManager.getConnection(url, login, password)) {
                DatabaseMetaData metaData = connection.getMetaData();
                System.out.println(metaData.getUserName());
                System.out.println(metaData.getURL());
            }
        } catch (Exception e) {
            LOG.error("Error message:", e);
        }
    }

    public static void main(String[] args) {
        connection();
    }
}
