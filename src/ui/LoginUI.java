package ui;

import javax.swing.*;
import java.awt.event.*;

import model.User;
import dao.UserDAO;
//import ui.DashboardUI;

public class LoginUI extends JFrame {

    JTextField nameField;
    JTextField emailField;
    JPasswordField passwordField;

    public LoginUI() {

        setTitle("AI Interview System - Register");
        setSize(400,300);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(50,50,100,30);
        add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(150,50,150,30);
        add(nameField);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(50,100,100,30);
        add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(150,100,150,30);
        add(emailField);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(50,150,100,30);
        add(passLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(150,150,150,30);
        add(passwordField);

        JButton registerBtn = new JButton("Register");
        registerBtn.setBounds(130,200,120,35);
        add(registerBtn);

        registerBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String name = nameField.getText();
                String email = emailField.getText();
                String password = new String(passwordField.getPassword());

                User user = new User(name,email,password);

                UserDAO.registerUser(user);

                JOptionPane.showMessageDialog(null,"Registration Successful!");

                new DashboardUI().showMenu();
                dispose();

            }
        });

        setVisible(true);
    }
}