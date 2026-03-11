package config;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() {

        Connection conn = null;

        try {
            // JDBC URL
            String url = "jdbc:mysql://localhost:3306/interview_system";
            String user = "root";
            String password = "dhruvi123"; 

            // Load Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Create Connection
            conn = DriverManager.getConnection(url, user, password);

            System.out.println("Database Connected Successfully!");

        } catch (Exception e) {
            System.out.println("Database Connection Failed");
            e.printStackTrace();
        }

        return conn;
    }
}