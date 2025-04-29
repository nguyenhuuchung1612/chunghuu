package test;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JScrollPane;

import javax.swing.JTextArea;

public class bai32 extends JFrame {

	
	public static void main(String[] args) {
	
		JFrame frame = new JFrame("JTextArea Example");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400,300);
		JButton clearButton = new JButton("clear");
		JTextArea textArea = new JTextArea();
		JScrollPane scrollPane = new JScrollPane(textArea);
		clearButton.addActionListener(e -> textArea.setText(""));
		
		 frame.add(scrollPane, BorderLayout.CENTER);
	        frame.add(clearButton, BorderLayout.SOUTH);
	        frame.setVisible(true);

		
		
		
	}
}
