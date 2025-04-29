package test;

import java.awt.BorderLayout;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class bai34 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("JSpinner Example");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JSpinner spinner = new JSpinner(new SpinnerNumberModel(1, 1, 100, 1));
        JLabel label = new JLabel("Value: 1");

        spinner.addChangeListener(e -> label.setText("Value: " + spinner.getValue()));

        frame.add(spinner, BorderLayout.CENTER);
        frame.add(label, BorderLayout.SOUTH);
        frame.setVisible(true);
    }
}