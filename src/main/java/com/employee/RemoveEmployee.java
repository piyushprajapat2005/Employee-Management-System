package com.employee;


import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.sql.ResultSet;
import java.awt.event.*;

/**
 * RemoveEmployee class - Interface for removing employees from the system.
 *
 * This class provides functionality to:
 * - Search for employees by ID
 * - Remove employees from the database with confirmation
 * - Refresh the employee list and IDs
 * - Navigate back to the home page
 *
 * Includes a confirmation dialog before deletion to prevent accidental removal.
 */
public class RemoveEmployee extends JFrame implements ActionListener {

    /**
     * Dropdown choice for selecting an employee to search or remove.
     */
    Choice cEmpId;

    /**
     * Table component for displaying employee data.
     */
    JTable table;

    /**
     * Button to search for the selected employee.
     */
    JButton bSearch;

    /**
     * Button to remove the selected employee.
     */
    JButton bRemove;

    /**
     * Button to navigate back to the home page.
     */
    JButton bBack;

    /**
     * Button to refresh the employee list and dropdown.
     */
    JButton bRefresh;

    /**
     * Constructor that initializes and displays the Remove Employee window.
     * Sets up the UI with search controls, buttons, and employee table.
     */
    RemoveEmployee() {

        setTitle("Remove Employee");
        setLayout(null);
        getContentPane().setBackground(new Color(245, 245, 245));

        // ================= Heading =================
        JLabel heading = new JLabel("REMOVE EMPLOYEE");
        heading.setBounds(340, 15, 350, 35);
        heading.setFont(new Font("Segoe UI", Font.BOLD, 28));
        heading.setForeground(new Color(25, 118, 210));
        add(heading);

        // ================= Employee ID =================
        JLabel lbEmpId = new JLabel("Employee ID");
        lbEmpId.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lbEmpId.setBounds(50, 70, 120, 30);
        add(lbEmpId);

        cEmpId = new Choice();
        cEmpId.setBounds(180, 73, 150, 25);
        add(cEmpId);

        // ================= Buttons =================
        Font btnFont = new Font("Segoe UI", Font.BOLD, 13);

        bSearch = new JButton("Search");
        bSearch.setBounds(370, 70, 100, 30);
        bSearch.setBackground(new Color(33, 150, 243));
        bSearch.setForeground(Color.WHITE);
        bSearch.setFocusPainted(false);
        bSearch.setFont(btnFont);
        bSearch.setCursor(new Cursor(Cursor.HAND_CURSOR));
        bSearch.addActionListener(this);
        add(bSearch);

        bRemove = new JButton("Remove");
        bRemove.setBounds(490, 70, 100, 30);
        bRemove.setBackground(new Color(211, 47, 47));
        bRemove.setForeground(Color.WHITE);
        bRemove.setFocusPainted(false);
        bRemove.setFont(btnFont);
        bRemove.setCursor(new Cursor(Cursor.HAND_CURSOR));
        bRemove.addActionListener(this);
        add(bRemove);

        bBack = new JButton("Back");
        bBack.setBounds(730, 70, 100, 30);
        bBack.setBackground(Color.DARK_GRAY);
        bBack.setForeground(Color.WHITE);
        bBack.setFocusPainted(false);
        bBack.setFont(btnFont);
        bBack.setCursor(new Cursor(Cursor.HAND_CURSOR));
        bBack.addActionListener(this);
        add(bBack);

        bRefresh = new JButton("Refresh");
        bRefresh.setBounds(610, 70, 100, 30);
        bRefresh.setBackground(Color.green);
        bRefresh.setForeground(Color.WHITE);
        bRefresh.setFocusPainted(false);
        bRefresh.setFont(btnFont);
        bRefresh.setCursor(new Cursor(Cursor.HAND_CURSOR));
        bRefresh.addActionListener(this);
        add(bRefresh);

        // ================= Load Employee IDs =================
        try {
            Conn c = new Conn();
            ResultSet rs = c.statement.executeQuery("SELECT * FROM employee");

            while (rs.next()) {
                cEmpId.add(rs.getString("employeeId"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        // ================= Table =================
        table = new JTable();
        table.setRowHeight(28);
        table.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        table.setGridColor(new Color(220, 220, 220));
        table.setSelectionBackground(new Color(220, 235, 250));

        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("Segoe UI", Font.BOLD, 14));
        header.setBackground(new Color(33, 150, 243));
        header.setForeground(Color.WHITE);

        try {

            Conn c = new Conn();
            ResultSet rs = c.statement.executeQuery("SELECT * FROM employee");
            table.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            e.printStackTrace();
        }

        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 130, 984, 500);
        jsp.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));
        add(jsp);

        setSize(1000, 600);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    /**
     * Loads all employee records from the database and displays them in the table.
     * Also applies center alignment to all table columns.
     */
    private void loadEmployees() {

        try {

            Conn c = new Conn();

            ResultSet rs = c.statement.executeQuery(
                    "SELECT * FROM employee");

            table.setModel(DbUtils.resultSetToTableModel(rs));

            // Apply center alignment to all columns
            DefaultTableCellRenderer center =
                    new DefaultTableCellRenderer();

            center.setHorizontalAlignment(SwingConstants.CENTER);

            for (int i = 0; i < table.getColumnCount(); i++) {
                table.getColumnModel().getColumn(i).setCellRenderer(center);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    /**
     * Loads all employee IDs from the database and populates the dropdown choice.
     * Used to keep the dropdown updated after add/remove operations.
     */
    private void loadEmployeeIds() {

        try {
            cEmpId.removeAll();

            Conn c = new Conn();

            ResultSet rs = c.statement.executeQuery(
                    "SELECT employeeId FROM employee");

            while (rs.next()) {
                cEmpId.add(rs.getString("employeeId"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Removes the selected employee from the database.
     * Shows a confirmation dialog before deletion to prevent accidental removal.
     * After successful deletion, refreshes both the employee list and dropdown.
     */
    private void removeEmployee() {

        int option = JOptionPane.showConfirmDialog(
                this,
                "Do you really want to remove this employee?",
                "Confirm Delete",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);

        if (option != JOptionPane.YES_OPTION)
            return;

        try {

            Conn c = new Conn();

            // SQL DELETE statement - vulnerable to SQL injection
            String query =
                    "DELETE FROM employee WHERE employeeId='"
                            + cEmpId.getSelectedItem() + "'";

            c.statement.executeUpdate(query);

            JOptionPane.showMessageDialog(
                    this,
                    "Employee removed successfully.");

            // Refresh data after deletion
            loadEmployeeIds();

            loadEmployees();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    /**
     * Handles action events from the Search, Remove, Refresh, and Back buttons.
     * - bSearch: Filters the table to show the selected employee
     * - bRemove: Initiates the employee removal process with confirmation
     * - bRefresh: Reloads the employee list and dropdown
     * - bBack: Navigates back to the home page
     *
     * @param e the action event triggered by button clicks
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bSearch) {
            // Search for employee by ID and display in table
            String query = "select * from employee where employeeId='"
                + cEmpId.getSelectedItem() + "'";
            try {
                Conn c = new Conn();
                ResultSet rs = c.statement.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        } else if (e.getSource() == bRemove) {
            // Remove the selected employee
            removeEmployee();
        } else if (e.getSource() == bRefresh) {
            // Refresh both the dropdown and table
            loadEmployeeIds();
            loadEmployees();
        } else {
            // Navigate back to home page
            setVisible(false);
            new HomePage();
        }
    }

    /**
     * Main entry point for the RemoveEmployee application.
     * Launches the remove employee window.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        new RemoveEmployee();
    }
}
