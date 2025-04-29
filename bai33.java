package test;

import javax.swing.*;
import java.awt.*;

public class bai33 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("GridBagLayout Example");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField(15);
        JLabel ageLabel = new JLabel("Age:");
        JSpinner ageSpinner = new JSpinner(new SpinnerNumberModel(18, 0, 100, 1));
        JButton submitButton = new JButton("Submit");

        gbc.gridx = 0; gbc.gridy = 0;
        frame.add(nameLabel, gbc);
        gbc.gridx = 1;
        frame.add(nameField, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        frame.add(ageLabel, gbc);
        gbc.gridx = 1;
        frame.add(ageSpinner, gbc);

        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 2;
        frame.add(submitButton, gbc);

        frame.setVisible(true);
    }
}


