package test;

import javax.swing.*; // Import thư viện giao diện
import java.awt.*;     // Import thư viện bố cục và màu sắc

public class bai20 {
    public static void main(String[] args) {
        // Tạo JFrame
        JFrame frame = new JFrame("JTabbedPane Example");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout()); // Sử dụng BorderLayout

        // Tạo JTabbedPane
        JTabbedPane tabbedPane = new JTabbedPane();

        // Tab "Home" với JLabel
        JPanel homePanel = new JPanel();
        homePanel.add(new JLabel("Welcome to the Home tab!"));
        tabbedPane.addTab("Home", homePanel);

        // Tab "Profile" với JLabel
        JPanel profilePanel = new JPanel();
        profilePanel.add(new JLabel("This is the Profile tab!"));
        tabbedPane.addTab("Profile", profilePanel);

        // Tab "Settings" với JLabel
        JPanel settingsPanel = new JPanel();
        settingsPanel.add(new JLabel("Here are your Settings!"));
        tabbedPane.addTab("Settings", settingsPanel);

        // Thêm JTabbedPane vào JFrame
        frame.add(tabbedPane, BorderLayout.CENTER);

        // Hiển thị JFrame
        frame.setVisible(true);
    }
}
