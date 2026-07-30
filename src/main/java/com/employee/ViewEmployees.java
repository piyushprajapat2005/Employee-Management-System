package com.employee;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

/**
 * ViewEmployees class - Table view for displaying and searching employee records.
 *
 * This class provides a comprehensive view of all employees stored in the database
 * with the following functionalities:
 * - Display all employees in a sortable table
 * - Search for a specific employee by ID
 * - Update an existing employee's details
 * - Print the employee table
 * - Navigate back to the home page
 */
public class ViewEmployees extends JFrame implements ActionListener {

    /**
     * Table component for displaying employee data.
     */
    JTable table;

    /**
     * Dropdown choice for selecting an employee to search or update.
     */
    Choice cemployee;

    /**
     * Button to search for a specific employee.
     */
    JButton search;

    /**
     * Button to print the employee table.
     */
    JButton print;

    /**
     * Button to open the Update Employee form.
     */
    JButton update;

    /**
     * Button to navigate back to the home page.
     */
    JButton back;

    /**
     * Constructor that initializes and displays the View Employees window.
     * Sets up the table, search controls, and buttons for employee management operations.
     */
    ViewEmployees() {
        getContentPane().setBackground(Color.white);
        setLayout(null);

          JLabel searchLabel = new JLabel("Search Employee");
          searchLabel.setBounds(20,40,100,20);
          add(searchLabel);

          cemployee =new Choice();
          cemployee.setBounds(130,40,130,40);
          cemployee.setBackground(Color.white);
          add(cemployee);



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

              // Populate the search dropdown with employee IDs
              ResultSet rs2 = c.statement.executeQuery("SELECT employeeId FROM employee");
              while (rs2.next()) {
                  cemployee.add(rs2.getString("employeeId"));
              }

          } catch (Exception e) {
              e.printStackTrace();
          }

          JScrollPane jsp = new JScrollPane(table);
          jsp.setBounds(0, 130, 984, 500);
          jsp.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));
          add(jsp);

          search = new JButton("Search");
          search.setBounds(20,90,100,20);
          search.addActionListener(this);
          add(search);

          print = new JButton("Print");
          print.setBounds(260,90,100,20);
          print.addActionListener(this);
          add(print);

          update = new JButton("Update");
          update.setBounds(140,90,100,20);
          update.addActionListener(this);
          add(update);

          back = new JButton("Back");
          back.setBounds(380,90,100,20);
          back.addActionListener(this);
          add(back);


         setSize(1000, 700);
         setLocationRelativeTo(null);
         setResizable(false);
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setVisible(true);

    }

    /**
     * Handles action events from the search, print, update, and back buttons.
     * - search: Filters the table to show the selected employee
     * - print: Opens the print dialog for the table
     * - update: Opens the UpdateEmployee form for the selected employee
     * - back: Navigates back to the home page
     *
     * @param e the action event triggered by button clicks
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == search) {
            // Search for employee by ID and display in table
            String selectedId = cemployee.getSelectedItem();
            if (selectedId == null || selectedId.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please select an employee ID to search.");
                return;
            }
            try {
                Conn c = new Conn();
                PreparedStatement ps = c.connection.prepareStatement(
                    "select * from employee where employeeId=?");
                ps.setString(1, selectedId);
                ResultSet rs = ps.executeQuery();
                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        } else if (e.getSource() == print) {
            // Print the employee table
            try {
                table.print();
            } catch (Exception e1) {
                e1.printStackTrace();
            }

        } else if (e.getSource() == update) {
            // Navigate to update form for selected employee
            setVisible(false);
            new UpdateEmployee(cemployee.getSelectedItem());

        } else {
            // Navigate back to home page
            setVisible(false);
            new HomePage();
        }
    }

    /**
     * Main entry point for the ViewEmployees application.
     * Launches the view employees window.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        new ViewEmployees();
    }
}
