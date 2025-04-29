package test;

import java.awt.EventQueue;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class thongtin extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField MaSVtxt;
    private JTextField Hotentxt;
    private JTextField Ngaysinhtxt;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    thongtin frame = new thongtin();
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
    public thongtin() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 603, 450);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Họ và tên:");
        lblNewLabel.setBounds(167, 63, 83, 16);
        contentPane.add(lblNewLabel);

        Hotentxt = new JTextField();
        Hotentxt.setBounds(236, 62, 143, 19);
        contentPane.add(Hotentxt);
        Hotentxt.setColumns(10);

        MaSVtxt = new JTextField();
        MaSVtxt.setBounds(236, 144, 143, 19);
        contentPane.add(MaSVtxt);
        MaSVtxt.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("MSV:");
        lblNewLabel_1.setBounds(192, 147, 45, 13);
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("Ngày tháng năm sinh:");
        lblNewLabel_2.setBounds(111, 107, 126, 13);
        contentPane.add(lblNewLabel_2);

        Ngaysinhtxt = new JTextField();
        Ngaysinhtxt.setBounds(236, 104, 143, 19);
        contentPane.add(Ngaysinhtxt);
        Ngaysinhtxt.setColumns(10);

        // Thêm JComboBox để chọn định dạng ngày tháng
        JLabel lblFormat = new JLabel("Chọn định dạng:");
        lblFormat.setBounds(111, 180, 126, 13);
        contentPane.add(lblFormat);

        String[] formats = { "dd-MM-yyyy", "yyyy/MM/dd", "MM/dd/yyyy" };
        JComboBox<String> formatComboBox = new JComboBox<>(formats);
        formatComboBox.setBounds(236, 176, 143, 21);
        contentPane.add(formatComboBox);

        JTextArea textArea = new JTextArea();
        textArea.setBounds(83, 279, 460, 100);
        contentPane.add(textArea);

        JButton btnNewButton = new JButton("Hiển thị");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String HoTen = Hotentxt.getText();
                String Ngaysinh = Ngaysinhtxt.getText();
                String Msv = MaSVtxt.getText();

                // Kiểm tra ràng buộc họ và tên (chỉ chứa chữ cái và khoảng trắng)
                if (!HoTen.matches("[a-zA-Z\\s]+")) {
                    textArea.setText("Họ và tên chỉ được chứa chữ cái và khoảng trắng!");
                    return;
                }

                // Kiểm tra ràng buộc MSV (chỉ chứa số)
                if (!Msv.matches("\\d+")) {
                    textArea.setText("MSV chỉ được chứa số!");
                    return;
                }

                // Lấy định dạng ngày tháng từ JComboBox
                String selectedFormat = (String) formatComboBox.getSelectedItem();

                // Xử lý định dạng ngày tháng năm sinh
                String formattedDate = "";
                try {
                    SimpleDateFormat inputFormat = new SimpleDateFormat("dd-MM-yyyy");
                    Date date = inputFormat.parse(Ngaysinh); // Chuyển đổi từ chuỗi sang Date

                    SimpleDateFormat outputFormat = new SimpleDateFormat(selectedFormat);
                    formattedDate = outputFormat.format(date); // Định dạng lại ngày tháng
                } catch (ParseException ex) {
                    textArea.setText("Định dạng ngày sinh không hợp lệ! Vui lòng nhập theo dạng dd-MM-yyyy.");
                    return;
                }

                // Hiển thị kết quả
                textArea.setText("Ho Ten: " + HoTen + 
                                 "\nNgay sinh: " + formattedDate + 
                                 "\nMSV: " + Msv);
            }
        });
        btnNewButton.setBounds(270, 230, 85, 21);
        contentPane.add(btnNewButton);
    }
}