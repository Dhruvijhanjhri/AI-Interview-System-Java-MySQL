package ui;
import javax.swing.*;
import java.awt.*;

public class ResultUI extends JFrame {

    public ResultUI(int score) {

        setTitle("Interview Result");
        setSize(400,250);
        setLayout(new FlowLayout());

        JLabel title = new JLabel("Interview Completed!");
        title.setFont(new Font("Arial", Font.BOLD, 20));

        JLabel result = new JLabel("Your Score: " + score + " / 10");
        result.setFont(new Font("Arial", Font.PLAIN, 18));

        add(title);
        add(result);

        setLocationRelativeTo(null);
        setVisible(true);
    }
}