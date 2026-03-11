package dao;

import java.sql.*;
import config.DBConnection;

public class ResultDAO {

    public static void saveResult(int userId, int aptitude, int technical, int hr) {

        try {

            Connection conn = DBConnection.getConnection();

            int finalScore = aptitude + technical + hr;

            String sql = "INSERT INTO results(user_id, aptitude_score, technical_score, hr_score, final_score) VALUES(?,?,?,?,?)";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, userId);
            ps.setInt(2, aptitude);
            ps.setInt(3, technical);
            ps.setInt(4, hr);
            ps.setInt(5, finalScore);

            ps.executeUpdate();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void showTopResults(){

        try{

            Connection conn = DBConnection.getConnection();

            String sql = "SELECT * FROM results ORDER BY final_score DESC LIMIT 5";

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            System.out.println("\n===== TOP INTERVIEW SCORES =====");

            while(rs.next()){

                System.out.println(
                        "User ID: " + rs.getInt("user_id") +
                        " | Final Score: " + rs.getInt("final_score")
                );
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}