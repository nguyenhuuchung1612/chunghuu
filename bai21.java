package test;

import javax.swing.*; // Import thư viện giao diện
import java.awt.*;     // Import thư viện bố cục và màu sắc

public class bai21 {
    public static void main(String[] args) {
        // Tạo JFrame
        JFrame frame = new JFrame("JList Example");
        frame.setSize(300, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout()); // Sử dụng BorderLayout

        // Danh sách các thành phố
        String[] cities = {
            "Hanoi", "Ho Chi Minh City", "Da Nang", "Hue", 
            "Nha Trang", "Vung Tau", "Can Tho", "Hai Phong", 
            "Da Lat", "Quang Ninh"
        };

        // Tạo JList với danh sách các thành phố
        JList<String> cityList = new JList<>(cities);

        // Đặt JList vào JScrollPane
        JScrollPane scrollPane = new JScrollPane(cityList);

        // Tạo JLabel để hiển thị số lượng thành phố
        JLabel label = new JLabel("Number of cities: " + cities.length);

        // Thêm JScrollPane (chứa JList) vào trung tâm JFrame
        frame.add(scrollPane, BorderLayout.CENTER);

        // Thêm JLabel vào phía dưới JFrame
        frame.add(label, BorderLayout.SOUTH);

        // Hiển thị JFrame
        frame.setVisible(true);
    }
}
