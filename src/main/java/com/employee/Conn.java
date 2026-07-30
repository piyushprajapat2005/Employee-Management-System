package com.employee;

import java.sql.*;

/**
 * Conn class - Database connection utility for the Employee Management System.
 *
 * This class establishes and maintains a connection to the MySQL database
 * used by the application. It provides connection and statement objects
 * that can be used by other classes to execute SQL queries.
 *
 * The database is configured with the following connection string:
 * - URL: jdbc:mysql://localhost:3306/employee_management
 * - Username: root
 * - Password: Uses application-specific password
 */
public class Conn {

    /**
     * Connection object for database connectivity.
     * Represents the active session with the database.
     */
    Connection connection;

    /**
     * Statement object for executing SQL queries.
     * Used to perform database operations like SELECT, INSERT, UPDATE, DELETE.
     */
    Statement statement;

    /**
     * Constructor that initializes the database connection.
     * Loads the MySQL JDBC driver and establishes a connection to the
     * employee_management database running on localhost.
     *
     * Note: Database credentials and connection details should ideally
     * be configured externally for better security and maintainability.
     */
    public Conn() {
        try {
            // Load MySQL JDBC driver class
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection to the database
            connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/employee_management",
                "root",
                "Piyush@2005"
            );

            // Create a statement object for executing queries
            statement = connection.createStatement();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
