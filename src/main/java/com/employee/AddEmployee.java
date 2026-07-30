package com.employee;

import javax.swing.*;
import java.awt.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;
import java.awt.event.*;

/**
 * AddEmployee class - Form for adding new employees to the system.
 *
 * This class provides a comprehensive form to capture employee details including:
 * - Personal information (name, father's name, date of birth)
 * - Contact information (phone, email, address)
 * - Employment details (salary, designation, education)
 * - Unique employee ID (auto-generated)
 *
 * Upon submission, the data is stored in the 'employee' table in the database.
 */
public class AddEmployee extends JFrame implements ActionListener {

    /**
     * Random number generator for creating unique employee IDs.
     */
    Random ran = new Random();

    /**
     * Auto-generated unique employee ID.
     */
    int number = ran.nextInt(999999);

    /**
     * Text field for entering employee's full name.
     */
    JTextField tfName;

    /**
     * Text field for entering employee's father's name.
     */
    JTextField tfFName;

    /**
     * Text field for entering employee's email address.
     */
    JTextField tfemail;

    /**
     * Text field for entering employee's phone number.
     */
    JTextField tfphone;

    /**
     * Text field for entering employee's Aadhar number.
     */
    JTextField tfaadhar;

    /**
     * Text field for entering employee's designation.
     */
    JTextField tfdesignation;

    /**
     * Text field for entering employee's salary.
     */
    JTextField tfsalary;

    /**
     * Text field for entering employee's address.
     */
    JTextField tfAddress;

    /**
     * Date chooser component for selecting employee's date of birth.
     */
    JDateChooser dcDoB;

    /**
     * Label to display the generated employee ID.
     */
    JLabel lbemployeeId;

    /**
     * Combo box for selecting employee's highest education level.
     */
    JComboBox cbeducation;

    /**
     * Button to submit the employee details to the database.
     */
    JButton addBtn;

    /**
     * Button to navigate back to the home page.
     */
    JButton backBtn;

    /**
     * Constructor that initializes and displays the Add Employee form.
     * Sets up all input fields, labels, and buttons for data entry.
     */
    public AddEmployee() {
        setLayout(null);
        getContentPane().setBackground(Color.white);

        JLabel heading = new JLabel("Add Employee Details");
        heading.setForeground(Color.black);
        heading.setBounds(280,-150,400,400);
        heading.setFont(new Font("Times New Roman",Font.BOLD,30));
        add(heading);

        JLabel lbName = new JLabel("Name");
        lbName.setBounds(50,-85,400,400);
        lbName.setFont(new Font("Times New Roman",Font.BOLD,20));
        add(lbName);

        tfName = new JTextField();
        tfName.setBounds(203,100,160,28);
        add(tfName);

        JLabel lbFName = new JLabel("Father's Name");
        lbFName.setBounds(450,-85,400,400);
        lbFName.setFont(new Font("Times New Roman",Font.BOLD,20));
        add(lbFName);

        tfFName = new JTextField();
        tfFName.setBounds(618,100,170,28);
        add(tfFName);

        JLabel lbDoB = new JLabel("Date Of Birth");
        lbDoB.setBounds(50,-25,400,400);
        lbDoB.setFont(new Font("Times New Roman",Font.BOLD,20));
        add(lbDoB);

        dcDoB = new JDateChooser();
        dcDoB.setBounds(203,158,170,28);
        add(dcDoB);

        JLabel lbsalary = new JLabel("Salary");
        lbsalary.setBounds(450,-25,400,400);
        lbsalary.setFont(new Font("Times New Roman",Font.BOLD,20));
        add(lbsalary);

        tfsalary = new JTextField();
        tfsalary.setBounds(618,160,170,28);
        add(tfsalary);

        JLabel lbaddress = new JLabel("Address");
        lbaddress.setBounds(50,35,400,400);
        lbaddress.setFont(new Font("Times New Roman",Font.BOLD,22));
        add(lbaddress);

        tfAddress = new JTextField();
        tfAddress.setBounds(203,222,170,28);
        add(tfAddress);

        JLabel lbphone = new JLabel("Phone Number");
        lbphone.setBounds(450,35,400,400);
        lbphone.setFont(new Font("Times New Roman",Font.BOLD,20));
        add(lbphone);

        tfphone = new JTextField();
        tfphone.setBounds(618,222,170,28);
        add(tfphone);

        JLabel lbemail = new JLabel("Email");
        lbemail.setBounds(50,100,400,400);
        lbemail.setFont(new Font("Times New Roman",Font.BOLD,22));
        add(lbemail);

        tfemail = new JTextField();
        tfemail.setBounds(203,284,170,28);
        add(tfemail);

        JLabel lbeducation = new JLabel("Highest Education");
        lbeducation.setBounds(450,100,400,400);
        lbeducation.setFont(new Font("Times New Roman",Font.BOLD,20));
        add(lbeducation);

        String courses[] = {"","BBA","BA","BSC","B.COM","BCA","B.TECH","MBA","MCA","MA","M.TECH","MSC","M.COM","PHD"};
        cbeducation = new JComboBox(courses);
        cbeducation.setBackground(Color.white);
        cbeducation.setBounds(618,282,170,28);
        add(cbeducation);

        JLabel lbdesignation = new JLabel("Designation");
        lbdesignation.setBounds(50,165,400,400);
        lbdesignation.setFont(new Font("Times New Roman",Font.BOLD,22));
        add(lbdesignation);

        tfdesignation = new JTextField();
        tfdesignation.setBounds(203,352,170,28);
        add(tfdesignation);

        JLabel lbaadhar = new JLabel("Aadhar Number");
        lbaadhar.setBounds(450,165,400,400);
        lbaadhar.setFont(new Font("Times New Roman",Font.BOLD,20));
        add(lbaadhar);

        tfaadhar = new JTextField();
        tfaadhar.setBounds(618,352,170,28);
        add(tfaadhar);

        JLabel lbemplId = new JLabel("Employee ID");
        lbemplId.setBounds(50,230,400,400);
        lbemplId.setFont(new Font("Times New Roman",Font.BOLD,22));
        add(lbemplId);

        lbemployeeId = new JLabel("" + number);
        lbemployeeId.setBounds(203,230,400,400);
        lbemployeeId.setFont(new Font("Times New Roman",Font.BOLD,22));
        add(lbemployeeId);

        addBtn = new JButton("Add Details");
        addBtn.setBounds(230, 520, 140, 45);
        addBtn.setBackground(Color.black);
        addBtn.setForeground(Color.WHITE);
        addBtn.setFocusPainted(false);
        addBtn.setBorderPainted(false);
        addBtn.addActionListener(this);
        add(addBtn);

        backBtn = new JButton("Back");
        backBtn.setBounds(490, 520, 140, 45);
        backBtn.setBackground(Color.black);
        backBtn.setForeground(Color.WHITE);
        backBtn.setFocusPainted(false);
        backBtn.setBorderPainted(false);
        backBtn.addActionListener(this);
        add(backBtn);

        setSize(900,700);
        setLocation(300,50);
        setVisible(true);
    }

    /**
     * Handles action events from the Add and Back buttons.
     * When the Add button is clicked, it collects all form data and inserts
     * a new employee record into the database.
     *
     * Note: This implementation uses string concatenation for SQL queries,
     * which is vulnerable to SQL injection. Consider using PreparedStatement
     * for better security.
     *
     * @param ae the action event triggered by button clicks
     */
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == addBtn) {
            // Collect all input values from the form
            String name = tfName.getText();
            String fName = tfFName.getText();
            String salary = tfsalary.getText();
            String email = tfemail.getText();
            String phone = tfphone.getText();
            String designation = tfdesignation.getText();
            String address = tfAddress.getText();
            String Aadhar = tfaadhar.getText();
            String education = cbeducation.getSelectedItem().toString();
            String employeeId = lbemployeeId.getText();
            String DoB = ((JTextField) dcDoB.getDateEditor().getUiComponent()).getText();

            try {
                // Establish database connection and insert employee record
                Conn conn = new Conn();

                // SQL INSERT statement - vulnerable to SQL injection
                String query = "insert into employee values('" + name + "','" + fName
                    + "','" + salary + "','" + email + "','" + phone + "','"
                    + designation + "','" + address + "','" + Aadhar + "','"
                    + education + "','" + DoB + "','" + employeeId + "')";

                conn.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Employee details Added Successfully");

                // Navigate back to home page
                setVisible(false);
                new HomePage();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            // Navigate back to home page without saving
            setVisible(false);
            new HomePage();
        }
    }

    /**
     * Main entry point for the AddEmployee application.
     * Launches the add employee form.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        new AddEmployee();
    }
}
