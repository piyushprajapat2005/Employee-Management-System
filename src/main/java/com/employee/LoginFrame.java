package com.employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

/**
 * LoginFrame class - The login window for the Employee Management System.
 *
 * This class provides the authentication interface where users can enter
 * their credentials to access the main application. It validates credentials
 * against the 'login' table in the database and opens the HomePage upon
 * successful authentication.
 *
 * Features:
 * - Username and password input fields
 * - Background image display on the right side
 * - Login button for credential validation
 * - Error handling for invalid credentials
 */
public class LoginFrame extends JFrame implements ActionListener {

    /**
     * Text field for entering the username.
     */
    JTextField userField;

    /**
     * Password field for entering the password (masked input).
     */
    JPasswordField passwordField;

    /**
     * Constructor that initializes and displays the login window.
     * Sets up the UI components including labels, input fields, buttons,
     * and background image for the login form.
     */
    public LoginFrame() {

        getContentPane().setBackground(Color.WHITE);

        setTitle("Employee Management System - Login");
        setSize(800, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Username
        JLabel user = new JLabel("Username");
        user.setFont(new Font("Arial", Font.BOLD, 18));
        user.setBounds(60, 120, 120, 30);
        add(user);

        userField = new JTextField();
        userField.setBounds(180, 120, 180, 35);
        add(userField);

        // Password
        JLabel password = new JLabel("Password");
        password.setFont(new Font("Arial", Font.BOLD, 18));
        password.setBounds(60, 190, 120, 30);
        add(password);

        passwordField = new JPasswordField();
        passwordField.setBounds(180, 190, 180, 35);
        add(passwordField);

        // Login Button
        JButton loginButton = new JButton("Login");
        loginButton.setBounds(180, 270, 120, 40);
        loginButton.addActionListener(this);
        add(loginButton);

        // Right Side Image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(350, 500, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel image = new JLabel(i3);
        image.setBounds(430, 0, 350, 500);
        add(image);

        setVisible(true);
    }
    /**
     * Handles action events from the login button.
     * Validates the entered credentials against the database and either
     * opens the HomePage (for valid credentials) or shows an error message
     * (for invalid credentials).
     *
     * Note: This implementation uses string concatenation for SQL queries,
     * which is vulnerable to SQL injection. Consider using PreparedStatement
     * for better security.
     *
     * @param e the action event triggered by the login button
     */
    public void actionPerformed(ActionEvent e) {
        try {
            // Get input values from the text fields
            String userName = userField.getText();
            String password = passwordField.getText();

            // Establish database connection
            Conn conn = new Conn();

            // Query to validate user credentials
            // Warning: SQL injection vulnerability - should use PreparedStatement
            String query = "select * from login where username='" + userName
                + "' and password= '" + password + "'";

            // Execute query and check if user exists
            ResultSet rs = conn.statement.executeQuery(query);
            if (rs.next()) {
                // Successful login - close this window and open HomePage
                setVisible(false);
                new HomePage().setVisible(true);
            } else {
                // Invalid credentials - show error message
                JOptionPane.showMessageDialog(null, "Username or password is incorrect");
                setVisible(false);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Main entry point for the LoginFrame application.
     * Creates and displays the login window.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        new LoginFrame();
    }
}