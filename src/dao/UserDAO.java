package dao;

import model.User;
import config.DBConnection;
import java.sql.*;

public class UserDAO {

    public static void registerUser(User user) {

        try {

            Connection conn = DBConnection.getConnection();

            String query = "INSERT INTO users (name,email,password) VALUES (?,?,?)";

            PreparedStatement ps = conn.prepareStatement(query);

            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());

            ps.executeUpdate();

            System.out.println("User Registered Successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // LOGIN METHOD FOR GUI
    public static boolean loginUser(String email, String password) {

        try {

            Connection conn = DBConnection.getConnection();

            String query = "SELECT * FROM users WHERE email=? AND password=?";

            PreparedStatement ps = conn.prepareStatement(query);

            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                return true;
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}