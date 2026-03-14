package ui;

import javax.swing.*;
import java.awt.*;
import dao.UserDAO;
import model.User;

public class LoginGUI extends JFrame {

    JTextField nameField;
    JTextField emailField;
    JPasswordField passwordField;

    public LoginGUI() {

        setTitle("AI Interview System");
        setSize(350,250);
        setLayout(new GridLayout(4,2));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(new JLabel("Name"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel("Email"));
        emailField = new JTextField();
        add(emailField);

        add(new JLabel("Password"));
        passwordField = new JPasswordField();
        add(passwordField);

        JButton loginBtn = new JButton("Login");
        JButton registerBtn = new JButton("Register");

        add(loginBtn);
        add(registerBtn);

        loginBtn.addActionListener(e -> login());
        registerBtn.addActionListener(e -> register());

        setVisible(true);
    }

    private void login() {

        String email = emailField.getText();
        String password = new String(passwordField.getPassword());

        if(UserDAO.loginUser(email,password)) {

            JOptionPane.showMessageDialog(this,"Login Successful");
            new DashboardGUI();
            dispose();

        } else {

            JOptionPane.showMessageDialog(this,"Invalid Login");

        }
    }

    private void register() {

        String name = nameField.getText();
        String email = emailField.getText();
        String password = new String(passwordField.getPassword());

        User user = new User(name,email,password);

        UserDAO.registerUser(user);

        JOptionPane.showMessageDialog(this,"User Registered! Now Login.");

    }
}