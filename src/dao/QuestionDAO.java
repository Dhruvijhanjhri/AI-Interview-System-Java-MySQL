package dao;

import java.sql.*;
import java.util.*;
import config.DBConnection;
import model.Question;

public class QuestionDAO {

    public List<Question> getQuestionsByRound(String round) {

        List<Question> questions = new ArrayList<>();

        try {
            Connection conn = DBConnection.getConnection();

            String sql = "SELECT * FROM questions WHERE round=? ORDER BY RAND() LIMIT 10";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, round);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Question q = new Question(
                        rs.getInt("id"),
                        rs.getString("question"),
                        rs.getString("optionA"),
                        rs.getString("optionB"),
                        rs.getString("optionC"),
                        rs.getString("optionD"),
                        rs.getString("correctAnswer")
                );

                questions.add(q);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return questions;
    }

}