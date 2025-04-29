package test;

import javax.swing.*; // Import thư viện giao diện
import java.awt.*;     // Import thư viện bố cục và màu sắc
import java.awt.event.*; // Import thư viện xử lý sự kiện

public class bai25 {
    public static void main(String[] args) {
        // Tạo JFrame
        JFrame frame = new JFrame("JRadioButton Example");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout()); // Sử dụng FlowLayout

        // Tạo JLabel để hiển thị lựa chọn
        JLabel label = new JLabel("Your choice: None");

        // Tạo các JRadioButton
        JRadioButton maleButton = new JRadioButton("Male");
        JRadioButton femaleButton = new JRadioButton("Female");

        // Tạo ButtonGroup để nhóm các JRadioButton
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleButton);
        genderGroup.add(femaleButton);

        // Thêm ActionListener để xử lý sự kiện khi người dùng chọn
        maleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText("Your choice: Male");
            }
        });

        femaleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText("Your choice: Female");
            }
        });

        // Thêm các thành phần vào JFrame
        frame.add(maleButton);
        frame.add(femaleButton);
        frame.add(label);

        // Hiển thị JFrame
        frame.setVisible(true);
    }
}