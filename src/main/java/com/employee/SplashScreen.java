package com.employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventListener;

public class SplashScreen extends JFrame implements ActionListener {
    SplashScreen() {
        getContentPane().setBackground(Color.lightGray);
        setLayout(null);

        // Background image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/splash1.png"));
        Image i2 = i1.getImage().getScaledInstance(1170, 650, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1170, 650);
        image.setLayout(null);      // Important
        add(image);

// Title
        JLabel title = new JLabel("Employee Data Management System");
        title.setBounds(180, 40, 800, 50);
        title.setForeground(Color.LIGHT_GRAY.brighter());
        title.setFont(new Font("Segoe UI", Font.BOLD, 36));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        image.add(title);

// Button
        JButton click = new JButton("Click Here To Continue");
        click.setBounds(420, 500, 330, 55);
        click.setFont(new Font("Segoe UI", Font.BOLD, 20));
        click.setForeground(Color.WHITE);
        click.addActionListener(this);
        click.setCursor(new Cursor(Cursor.HAND_CURSOR));

// Transparent
        click.setOpaque(false);
        click.setContentAreaFilled(false);
        click.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        click.setFocusPainted(false);

        image.add(click);

        setSize(1170,650);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(184,60);

        while(true){
            title.setVisible(false);

            try{
                Thread.sleep(500);
            }catch(InterruptedException e){

            }

            title.setVisible(true);
            try{
                Thread.sleep(500);
            }catch(InterruptedException e){

            }
        }

    }

    public void actionPerformed(ActionEvent e){
        setVisible(false);
        new LoginFrame();
    }

public static void main(String[] args){

        new SplashScreen();
    }
}