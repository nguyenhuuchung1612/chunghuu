package test;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class bai30 extends JFrame {
	public bai30() {
	}

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
    public static void main(String[] args) {
        JFrame frame = new JFrame("JTextArea Example");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextArea textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);

        JButton clearButton = new JButton("Clear");
        clearButton.addActionListener(e -> textArea.setText(""));

        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
        frame.getContentPane().add(clearButton, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

}
