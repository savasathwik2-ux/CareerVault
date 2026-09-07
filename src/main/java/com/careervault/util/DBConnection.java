package com.careervault.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Utility class responsible for creating database connections.
 *
 * This class centralizes the database connection logic so that
 * DAO classes do not need to duplicate JDBC connection code.
 */
public class DBConnection {

    // Database connection details
    private static final String URL =
            "jdbc:mysql://localhost:3306/career_vault";

    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    /**
     * Creates and returns a connection to the CareerVault database.
     *
     * @return an active database connection
     * @throws RuntimeException if the database connection fails
     */
    public static Connection getConnection() {

        try {

            return DriverManager.getConnection(
                    URL,
                    USERNAME,
                    PASSWORD
            );

        } catch (SQLException e) {

            throw new RuntimeException(
                    "Failed to connect to the CareerVault database",
                    e
            );
        }
    }
}