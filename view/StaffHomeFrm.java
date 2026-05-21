package view;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class StaffHomeFrm extends JFrame {
    public StaffHomeFrm() {
        // 1. Cài đặt các thông số cơ bản cho cửa sổ (JFrame)
        setTitle("StaffHomeFrm");
        setSize(600, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Hiển thị ở giữa màn hình
        setLayout(new BorderLayout());
        getContentPane().setBackground(Color.WHITE);

        // 2. Tạo Panel phía trên (Top Panel) chứa "User's name"
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        topPanel.setBackground(Color.WHITE);
        JLabel userLabel = new JLabel("User's name");
        userLabel.setFont(new Font("Serif", Font.PLAIN, 14));
        topPanel.add(userLabel);
        
        // Thêm khoảng trống nhỏ ở viền để không sát lề
        topPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 20)); 

        // 3. Tạo Panel trung tâm chứa Tiêu đề và các Nút
        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0; // Tất cả các thành phần đều nằm trên 1 cột (cột 0)

        // --- Thêm Tiêu đề "HOME" ---
        JLabel titleLabel = new JLabel("HOME");
        titleLabel.setFont(new Font("Serif", Font.BOLD, 28));
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 40, 0); // Khoảng cách phía dưới title
        centerPanel.add(titleLabel, gbc);

        // --- Thiết lập chung cho các Nút ---
        gbc.fill = GridBagConstraints.HORIZONTAL; // Để các nút có cùng chiều rộng
        gbc.insets = new Insets(10, 0, 15, 0);    // Khoảng cách trên/dưới giữa các nút
        gbc.ipady = 15;                           // Tăng chiều cao bên trong nút
        gbc.ipadx = 50;                           // Tăng chiều rộng bên trong nút

        // --- Thêm các Nút ---
        JButton btnRegister = createCustomButton("Register racers");
        gbc.gridy = 1;
        centerPanel.add(btnRegister, gbc);

        JButton btnUpdate = createCustomButton("Update Result");
        gbc.gridy = 2;
        centerPanel.add(btnUpdate, gbc);

        JButton btnView = createCustomButton("View statistics");
        gbc.gridy = 3;
        centerPanel.add(btnView, gbc);

        // 4. Thêm các Panel vào Frame chính
        add(topPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
    }

    /**
     * Hàm phụ trợ để tạo nút với viền đen dày và nền trắng giống như trong bản vẽ.
     */
    private JButton createCustomButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Serif", Font.BOLD, 16));
        button.setBackground(Color.WHITE);
        button.setForeground(Color.BLACK);
        button.setFocusPainted(false); // Xóa viền mờ khi click
        
        // Tạo viền đen dày (độ dày = 3)
        Border lineBorder = BorderFactory.createLineBorder(Color.BLACK, 3);
        button.setBorder(lineBorder);
        
        // Thay đổi con trỏ chuột khi di chuột qua nút
        button.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
        
        return button;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new StaffHomeFrm().setVisible(true);
        });
    }
}