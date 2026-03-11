package dao;
import model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import config.DBConnection;

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
}