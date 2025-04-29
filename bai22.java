package test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class bai22 extends JFrame {
    public bai22() {
        // Cài đặt tiêu đề và kích thước JFrame
        setTitle("Chọn trái cây");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Canh giữa màn hình

        // Tạo JComboBox với 5 loại trái cây
        String[] fruits = {"Táo", "Cam", "Chuối", "Xoài", "Dưa hấu"};
        JComboBox<String> fruitComboBox = new JComboBox<>(fruits);

        // Tạo JLabel để hiển thị lựa chọn
        JLabel selectionLabel = new JLabel("Vui lòng chọn một loại trái cây");

        // Thêm sự kiện cho JComboBox
        fruitComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedFruit = (String) fruitComboBox.getSelectedItem();
                selectionLabel.setText("Bạn đã chọn: " + selectedFruit);
            }
        });

        // Thiết lập layout và thêm thành phần vào JFrame
        setLayout(new FlowLayout());
        add(fruitComboBox);
        add(selectionLabel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new bai22().setVisible(true);
        });
    }
}

