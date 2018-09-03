package com.crud.library.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseManager {
    private Connection connection;
    private static DatabaseManager databaseManager;

    private DatabaseManager() throws SQLException {
        Properties connectionProperties = new Properties();
        connectionProperties.put("user", "librarian");
        connectionProperties.put("password", "ksiazki123");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_database?serverTimezone=Europe/Warsaw" +
        "&useSSL=False", connectionProperties);
    }

    public static DatabaseManager getInstance() throws SQLException {
        if (databaseManager == null) {
            databaseManager = new DatabaseManager();
        }
        return databaseManager;
    }

    public Connection getConnection() {
        return connection;
    }
}
