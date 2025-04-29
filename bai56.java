package test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.Timer;

public class bai56 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Timer timer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bai56 frame = new bai56();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public bai56() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout());
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		
		JButton stopButton = new JButton("stop");
		contentPane.add(stopButton, BorderLayout.SOUTH);
		
		timer = new Timer(1000, e -> panel.setBackground(new Color(
				new Random().nextInt(256),
				new Random().nextInt(256),
				new Random().nextInt(256)
				)));
		timer.start();
		
		stopButton.addActionListener(e ->{
		  timer.stop();
		  stopButton.setEnabled(false);
		});
	}
}

