package test;

import javax.swing.*;
import java.awt.*;

public class bai35 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Multi-Layout Example");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLayout(new BorderLayout());

        JPanel gridPanel = new JPanel(new GridLayout(3, 3));
        for (int i = 1; i <= 9; i++) {
            gridPanel.add(new JButton("Button " + i));
        }

        JButton resetButton = new JButton("Reset");

        frame.add(gridPanel, BorderLayout.CENTER);
        frame.add(resetButton, BorderLayout.SOUTH);
        frame.setVisible(true);
    }
}


