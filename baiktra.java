package test;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class baiktra extends JFrame {
    private JTextField txtHoVaTen, txtNgaySinh, txtQueQuan;
    private JTable table;
    private DefaultTableModel tableModel;

    public baiktra() {
        // Thiết lập cửa sổ
        setTitle("Kiểm tra thông tin");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new BorderLayout());

        // Panel nhập liệu
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(4, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
                JLabel label = new JLabel("Họ và tên:");
                inputPanel.add(label);
        txtHoVaTen = new JTextField();
        inputPanel.add(txtHoVaTen);

        inputPanel.add(new JLabel("Ngày sinh (dd/MM/yyyy):"));
        txtNgaySinh = new JTextField();
        inputPanel.add(txtNgaySinh);

        inputPanel.add(new JLabel("Quê quán:"));
        txtQueQuan = new JTextField();
        inputPanel.add(txtQueQuan);

        JButton btnSubmit = new JButton("Thêm vào bảng");
        inputPanel.add(btnSubmit);

        getContentPane().add(inputPanel, BorderLayout.NORTH);

        // Bảng hiển thị dữ liệu
        tableModel = new DefaultTableModel(new String[]{"Họ và tên", "Ngày sinh", "Quê quán"}, 0);
        table = new JTable(tableModel);
        getContentPane().add(new JScrollPane(table), BorderLayout.SOUTH);

        // Xử lý sự kiện nút "Thêm vào bảng"
        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String hoVaTen = txtHoVaTen.getText().trim();
                String ngaySinh = txtNgaySinh.getText().trim();
                String queQuan = txtQueQuan.getText().trim();

                // Kiểm tra tính hợp lệ
                if (!hoVaTen.matches("^[\\p{L}\\s]+$")) {
                    JOptionPane.showMessageDialog(baiktra.this, "Họ và tên chỉ được chứa chữ cái (có dấu) và khoảng trắng.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (!isValidDate(ngaySinh)) {
                    JOptionPane.showMessageDialog(baiktra.this, "Ngày sinh không hợp lệ. Vui lòng nhập đúng định dạng dd/MM/yyyy.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (!queQuan.matches("^[\\p{L}\\s]+$")) {
                    JOptionPane.showMessageDialog(baiktra.this, "Quê quán chỉ được chứa chữ cái (có dấu) và khoảng trắng.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Thêm dữ liệu hợp lệ vào bảng
                tableModel.addRow(new Object[]{hoVaTen, ngaySinh, queQuan});

                // Xóa dữ liệu trong các ô nhập
                txtHoVaTen.setText("");
                txtNgaySinh.setText("");
                txtQueQuan.setText("");
            }
        });
    }

    // Hàm kiểm tra ngày sinh hợp lệ
    private boolean isValidDate(String dateStr) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        format.setLenient(false);
        try {
            format.parse(dateStr);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
        	baiktra app = new baiktra();
            app.setVisible(true);
        });
    }
}