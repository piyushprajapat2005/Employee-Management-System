package com.employee;

import com.toedter.calendar.JDateChooser;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Random;

/**
 * UpdateEmployee class - Form for updating existing employee records.
 *
 * This class provides an interface to modify employee details including:
 * - Contact information (phone, email, address)
 * - Employment details (salary, designation, education)
 * - Displays read-only fields: name, father's name, date of birth, aadhar
 *
 * The employee ID can be passed during construction to pre-load the employee's
 * current details for updating.
 */
public class UpdateEmployee extends JFrame implements ActionListener {

    /**
     * Random number generator (currently unused in update functionality).
     */
    Random ran = new Random();

    /**
     * Unused random number variable.
     */
    int number = ran.nextInt(999999);

    /**
     * Text field for updating employee's email address.
     */
    JTextField tfemail;

    /**
     * Text field for updating employee's phone number.
     */
    JTextField tfphone;

    /**
     * Text field for updating employee's designation.
     */
    JTextField tfdesignation;

    /**
     * Text field for updating employee's salary.
     */
    JTextField tfsalary;

    /**
     * Text field for updating employee's address.
     */
    JTextField tfAddress;

    /**
     * Label to display the employee ID.
     */
    JLabel lbemployeeId;

    /**
     * Combo box for selecting employee's highest education level.
     */
    JComboBox cbeducation;

    /**
     * Button to save the updated employee details.
     */
    JButton updateBtn;

    /**
     * Button to navigate back to the view employees window.
     */
    JButton backBtn;

    /**
     * The employee ID to be updated, passed from the calling form.
     */
    String empId;

    /**
     * Constructor that initializes and displays the Update Employee form.
     * Pre-loads the employee's current details if an employeeId is provided.
     *
     * @param employeeId the ID of the employee to update; if empty, form starts with blank values
     */
    public UpdateEmployee(String employeeId) {
        this.empId = employeeId;

        setLayout(null);
        getContentPane().setBackground(Color.white);

        JLabel heading = new JLabel("Update Employee Details");
        heading.setForeground(Color.black);
        heading.setBounds(280,-150,400,400);
        heading.setFont(new Font("Times New Roman",Font.BOLD,30));
        add(heading);

        JLabel lbName = new JLabel("Name");
        lbName.setBounds(50,-85,400,400);
        lbName.setFont(new Font("Times New Roman",Font.BOLD,20));
        add(lbName);

        JLabel tfName = new JLabel();
        tfName.setBounds(203,100,160,28);
        add(tfName);

        JLabel lbFName = new JLabel("Father's Name");
        lbFName.setBounds(450,-85,400,400);
        lbFName.setFont(new Font("Times New Roman",Font.BOLD,20));
        add(lbFName);

        JLabel tfFName = new JLabel();
        tfFName.setBounds(618,100,170,28);
        add(tfFName);

        JLabel lbDoB = new JLabel("Date Of Birth");
        lbDoB.setBounds(50,-25,400,400);
        lbDoB.setFont(new Font("Times New Roman",Font.BOLD,20));
        add(lbDoB);

        JLabel dcDoB = new JLabel();
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

        JLabel tfaadhar = new JLabel();
        tfaadhar.setBounds(618,352,170,28);
        add(tfaadhar);

        JLabel lbemplId = new JLabel("Employee ID");
        lbemplId.setBounds(50,230,400,400);
        lbemplId.setFont(new Font("Times New Roman",Font.BOLD,22));
        add(lbemplId);

        lbemployeeId = new JLabel();
        lbemployeeId.setBounds(203,230,400,400);
        lbemployeeId.setFont(new Font("Times New Roman",Font.BOLD,22));
        add(lbemployeeId);

        updateBtn = new JButton("Update Details");
        updateBtn.setBounds(230, 520, 140, 45);
        updateBtn.setBackground(Color.black);
        updateBtn.setForeground(Color.WHITE);
        updateBtn.setFocusPainted(false);
        updateBtn.setBorderPainted(false);
        updateBtn.addActionListener(this);
        add(updateBtn);

        backBtn = new JButton("Back");
        backBtn.setBounds(490, 520, 140, 45);
        backBtn.setBackground(Color.black);
        backBtn.setForeground(Color.WHITE);
        backBtn.setFocusPainted(false);
        backBtn.setBorderPainted(false);
        backBtn.addActionListener(this);
        add(backBtn);

        try{
            Conn c = new Conn();
            String query = "select * from employee where employeeId = '"+employeeId+"'";
            ResultSet rs = c.statement.executeQuery(query);

            while(rs.next()){
                tfName.setText(rs.getString("name"));
                tfFName.setText(rs.getString("fName"));
                tfemail.setText(rs.getString("email"));
                tfphone.setText(rs.getString("phone"));
                tfaadhar.setText(rs.getString("Aadhar"));
                tfdesignation.setText(rs.getString("designation"));
                tfsalary.setText(rs.getString("salary"));
                tfAddress.setText(rs.getString("address"));
                dcDoB.setText(rs.getString("DoB"));
                cbeducation.setSelectedItem(rs.getString("education"));
                lbemployeeId.setText(rs.getString("employeeId"));

            }

        }catch(Exception e){
            e.printStackTrace();
        }

        setSize(900,700);
        setLocation(300,50);
        setVisible(true);
    }

    /**
     * Handles action events from the Update and Back buttons.
     * When the Update button is clicked, it saves the modified employee
     * details to the database.
     *
     * Note: This implementation uses string concatenation for SQL queries,
     * which is vulnerable to SQL injection. Consider using PreparedStatement
     * for better security.
     *
     * @param ae the action event triggered by button clicks
     */
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == updateBtn) {
            // Collect updated values from the form
            String salary = tfsalary.getText();
            String email = tfemail.getText();
            String phone = tfphone.getText();
            String designation = tfdesignation.getText();
            String address = tfAddress.getText();
            String education = cbeducation.getSelectedItem().toString();

            try {
                // Establish connection and update employee record
                Conn conn = new Conn();

                // SQL UPDATE statement - vulnerable to SQL injection
                String query = "update employee set salary = '" + salary
                    + "',email = '" + email + "', phone = '" + phone
                    + "', designation = '" + designation + "', address = '"
                    + address + "',education = '" + education
                    + "' where employeeId = '" + lbemployeeId.getText() + "'";

                conn.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Employee details Updated Successfully");

                // Navigate back to view employees
                setVisible(false);
                new ViewEmployees();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            // Navigate back to view employees without saving
            setVisible(false);
            new ViewEmployees();
        }
    }

    /**
     * Main entry point for the UpdateEmployee application.
     * Launches the update employee form with an empty employee ID.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        new UpdateEmployee("");
    }
}
