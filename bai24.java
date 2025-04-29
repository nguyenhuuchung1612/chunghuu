package test;

import javax.swing.*; 
import java.awt.*;     
import java.awt.event.*; 

public class bai24 {
    public static void main(String[] args) {
        // Tạo JFrame
        JFrame frame = new JFrame("JCheckBox Example");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new FlowLayout());

        // Tạo JCheckBox
        JCheckBox chckbxnVo = new JCheckBox("ẤN VÀO ĐỂ ĐỔI  MÀU");

        // Thêm sự kiện cho JCheckBox
        chckbxnVo.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (chckbxnVo.isSelected()) {
                    // Khi được chọn, đổi màu nền thành xanh
                    frame.getContentPane().setBackground(Color.PINK);
                } else {
                    // Khi bỏ chọn, trả về màu nền mặc định
                    frame.getContentPane().setBackground(null);
                }
            }
        });

        // Thêm JCheckBox vào JFrame
        frame.getContentPane().add(chckbxnVo);

        // Hiển thị JFrame
        frame.setVisible(true);
    }
}