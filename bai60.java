package test;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;

public class bai60 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JProgressBar progressBar;
	private JButton btnDownload;
	private JLabel lblStatus;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				bai60 frame = new bai60();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public bai60() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		contentPane.setLayout(new BorderLayout(10, 10));
		setContentPane(contentPane);

		// Progress bar
		progressBar = new JProgressBar(0, 100);
		contentPane.add(progressBar, BorderLayout.CENTER);

		// Button + Status panel
		JPanel panelBottom = new JPanel(new FlowLayout(FlowLayout.LEFT));
		btnDownload = new JButton("Download");
		lblStatus = new JLabel("Status: Waiting...");
		panelBottom.add(btnDownload);
		panelBottom.add(lblStatus);
		contentPane.add(panelBottom, BorderLayout.SOUTH);

		// Button action
		btnDownload.addActionListener((ActionEvent e) -> {
			btnDownload.setEnabled(false);
			new SwingWorker<Void, Void>() {
				@Override
				protected Void doInBackground() throws Exception {
					for (int i = 0; i <= 100; i++) {
						Thread.sleep(50); // giả lập tải file
						progressBar.setValue(i);
					}
					return null;
				}

				@Override
				protected void done() {
					lblStatus.setText("Status: Download Complete");
					btnDownload.setEnabled(true);
				}
			}.execute();
		});
	}
}
