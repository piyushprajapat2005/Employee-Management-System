package com.employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * HomePage class - The main dashboard window of the Employee Management System.
 *
 * This class serves as the central hub after successful login, providing
 * navigation buttons to access various employee management operations:
 * - Add Employee: Open form to add new employees
 * - View Employees: Display all employees in a table
 * - Update Employee: Modify existing employee details
 * - Remove Employee: Delete employees from the database
 *
 * The interface features a background image with a clean heading and
 * visually distinct buttons for each operation.
 */
public class HomePage extends JFrame implements ActionListener {

    /**
     * Button for navigating to the Add Employee form.
     */
    JButton addBtn;

    /**
     * Button for viewing all employees in a table.
     */
    JButton viewBtn;

    /**
     * Button for updating existing employee details.
     */
    JButton updateBtn;

    /**
     * Button for removing employees from the database.
     */
    JButton removeBtn;

    /**
     * Constructor that initializes and displays the home page window.
     * Sets up the UI with a background image, heading, and navigation buttons.
     */
    HomePage() {

        setTitle("Employee Management System");
        setLayout(null);

        // ================= Background =================
        ImageIcon icon = new ImageIcon(
                ClassLoader.getSystemResource("icons/home3.png"));

        Image img = icon.getImage().getScaledInstance(1120, 630, Image.SCALE_SMOOTH);
        JLabel background = new JLabel(new ImageIcon(img));
        background.setBounds(0, 0, 1120, 630);
        background.setLayout(null);
        add(background);

        // ================= Heading =================
        JLabel heading = new JLabel("Employee Management System");
        heading.setBounds(208, 18, 790, 190);
        heading.setFont(new Font("Segoe UI", Font.BOLD, 44));
        heading.setForeground(new Color(28, 67, 155));
        background.add(heading);

        Font btnFont = new Font("Segoe UI", Font.BOLD, 18);

        Color blue = new Color(49, 111, 255);

        // ================= Add =================
        addBtn = new JButton("Add Employee");
        addBtn.setBounds(270, 220, 190, 45);
        addBtn.setBackground(blue);
        addBtn.setForeground(Color.WHITE);
        addBtn.setFont(btnFont);
        addBtn.setFocusPainted(false);
        addBtn.setBorderPainted(false);
        addBtn.addActionListener(this);
        background.add(addBtn);

        // ================= View =================
        viewBtn = new JButton("View Employees");
        viewBtn.setBounds(590, 220, 190, 45);
        viewBtn.setBackground(blue);
        viewBtn.setForeground(Color.WHITE);
        viewBtn.setFont(btnFont);
        viewBtn.setFocusPainted(false);
        viewBtn.setBorderPainted(false);
        viewBtn.addActionListener(this);
        background.add(viewBtn);

        // ================= Update =================
        updateBtn = new JButton("Update Employee");
        updateBtn.setBounds(270, 370,190, 45);
        updateBtn.setBackground(blue);
        updateBtn.setForeground(Color.WHITE);
        updateBtn.setFont(btnFont);
        updateBtn.setFocusPainted(false);
        updateBtn.setBorderPainted(false);
        updateBtn.addActionListener(this);
        background.add(updateBtn);

        // ================= Remove =================
        removeBtn = new JButton("Remove Employee");
        removeBtn.setBounds(590, 370, 190, 45);
        removeBtn.setBackground(blue);
        removeBtn.setForeground(Color.WHITE);
        removeBtn.setFont(btnFont);
        removeBtn.setFocusPainted(false);
        removeBtn.setBorderPainted(false);
        removeBtn.addActionListener(this);
        background.add(removeBtn);

        // ================= Frame =================
        setSize(1120, 630);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    /**
     * Handles action events from navigation buttons.
     * Opens the appropriate form based on which button was clicked:
     * - addBtn: Opens the AddEmployee form
     * - viewBtn: Opens the ViewEmployees table view
     * - updateBtn: Opens the UpdateEmployee form
     * - removeBtn: Opens the RemoveEmployee form
     *
     * @param e the action event triggered by a button click
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addBtn) {
            // Navigate to Add Employee form
            setVisible(false);
            new AddEmployee();
        } else if (e.getSource() == viewBtn) {
            // Navigate to View Employees table
            setVisible(false);
            new ViewEmployees();

        } else if (e.getSource() == updateBtn) {
            // Navigate to Update Employee form
            setVisible(false);
            new UpdateEmployee("");
        } else {
            // Navigate to Remove Employee form
            setVisible(false);
            new RemoveEmployee();
        }
    }

    /**
     * Main entry point for the HomePage application.
     * Launches the main dashboard window.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        new HomePage();
    }
}