package ui;

import javax.swing.*;

public class DashboardGUI extends JFrame {

    public DashboardGUI() {

        setTitle("Interview Dashboard");
        setSize(300,250);
        setLayout(null);

        JButton apt = new JButton("Aptitude Round");
        apt.setBounds(70,30,150,30);

        JButton tech = new JButton("Technical Round");
        tech.setBounds(70,80,150,30);

        JButton hr = new JButton("HR Round");
        hr.setBounds(70,130,150,30);

        add(apt);
        add(tech);
        add(hr);

        apt.addActionListener(e -> new AptitudeRoundUI().startRound());
        tech.addActionListener(e -> new TechnicalRoundUI().startRound());
        hr.addActionListener(e -> new HRRoundUI().startRound());

        setVisible(true);
    }
}