package test;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class bai26 extends JFrame {
    public bai26() {
        // Cài đặt tiêu đề và kích thước JFrame
        setTitle("Điều chỉnh độ sáng");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Tạo JSlider từ 0 đến 255
        JSlider bai26 = new JSlider(0, 255, 127);
        bai26.setMajorTickSpacing(50);
        bai26.setPaintTicks(true);
        bai26.setPaintLabels(true);

        // Panel chứa slider
        JPanel sliderPanel = new JPanel();
        sliderPanel.add(bai26);
        add(sliderPanel, BorderLayout.SOUTH);

        // Panel hiển thị màu nền thay đổi
        JPanel colorPanel = new JPanel();
        colorPanel.setBackground(new Color(127, 127, 127));
        add(colorPanel, BorderLayout.CENTER);

        // Lắng nghe sự kiện thay đổi slider
        bai26.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int value = bai26.getValue();
                Color color = new Color(value, value, value);
                colorPanel.setBackground(color);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new bai26().setVisible(true);
        });
    }
}
