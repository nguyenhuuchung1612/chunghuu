package test;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class bai23 extends JFrame {
    private JTextField display;
    private String firstNumber = "";
    private String operator = "";

    public bai23() {
        setTitle("Máy Tính - Nhân");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // JTextField hiển thị kết quả
        display = new JTextField();
        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setFont(new Font("Arial", Font.BOLD, 24));

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(display, gbc);

        // Các nút máy tính
        String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", "=", "+", 
        };

        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH;

        int row = 1;
        int col = 0;
        for (String text : buttons) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.PLAIN, 20));

            button.addActionListener(new ButtonClickListener());

            gbc.gridx = col;
            gbc.gridy = row;
            add(button, gbc);

            col++;
            if (col > 3) {
                col = 0;
                row++;
            }
        }
    }

    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String cmd = ((JButton) e.getSource()).getText();

            if (cmd.matches("[0-9]")) {
                display.setText(display.getText() + cmd);
            } else if (cmd.equals("*")) {
                firstNumber = display.getText();
                operator = "*";
                display.setText("");
            } else if (cmd.equals("=")) {
                String secondNumber = display.getText();
                try {
                    int a = Integer.parseInt(firstNumber);
                    int b = Integer.parseInt(secondNumber);
                    int result = 0;

                    if (operator.equals("*")) {
                        result = a * b;
                    }

                    display.setText(String.valueOf(result));
                    // Reset sau khi tính xong
                    firstNumber = "";
                    operator = "";
                } catch (NumberFormatException ex) {
                    display.setText("Lỗi");
                }
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new bai23().setVisible(true);
        });
    }
}
