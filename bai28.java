package test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
public class bai28 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("JTextArea Example");
        frame.setBackground(SystemColor.textHighlight);
        frame.setFont(null);
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextArea textArea = new JTextArea();
        textArea.setBackground(SystemColor.activeCaption);
        JScrollPane scrollPane = new JScrollPane(textArea);

        JButton clearButton = new JButton("Clear");
       
        clearButton.addActionListener(e -> textArea.setText(""));

        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(clearButton, BorderLayout.SOUTH);
        frame.setVisible(true);
    }
}