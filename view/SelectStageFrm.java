package view;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;

import dao.StageDAO;

import java.util.ArrayList;

import model.Stage;

public class SelectStageFrm extends JFrame{
    public SelectStageFrm(){
        // 1. Cài đặt các thông số cơ bản cho cửa sổ
        setTitle("SelectStageFrm");
        setSize(600, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        getContentPane().setBackground(Color.WHITE);

        // 2. Tạo Panel phía trên (Top Panel) chứa "User's name"
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        topPanel.setBackground(Color.WHITE);
        JLabel userLabel = new JLabel("User's name");
        userLabel.setFont(new Font("Serif", Font.PLAIN, 14));
        topPanel.add(userLabel);
        topPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 20));

        // 3. Tạo Panel trung tâm chứa Tiêu đề, ComboBox và nút View
        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;

        // --- Thêm Tiêu đề ---
        JLabel titleLabel = new JLabel("View Statistic");
        titleLabel.setFont(new Font("Serif", Font.BOLD, 24));
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 30, 0); // Khoảng cách phía dưới tiêu đề
        centerPanel.add(titleLabel, gbc);

        // --- Thiết lập chung cho ComboBox ---
        gbc.fill = GridBagConstraints.HORIZONTAL; // Kéo dài theo chiều ngang
        gbc.insets = new Insets(10, 0, 15, 0);
        gbc.ipadx = 100; // Chiều rộng cho combobox
        gbc.ipady = 10;  // Chiều cao cho combobox

        // --- Thêm ComboBox 1: Select statistic type ---
        String[] statTypes = {"Select statistic type", "View the current racer rankings", "View the current racing team rankings"};
        JComboBox <String> cbStatType = createCustomComboBox(statTypes);
        gbc.gridy = 1;
        centerPanel.add(cbStatType, gbc);

        // --- Thêm ComboBox 2: Select stage ---
        // 1. Khởi tạo StageDAO và gọi hàm lấy dữ liệu
        StageDAO stageDAO = new StageDAO();
        ArrayList<Stage> listStages = stageDAO.getAllStages();
        
        // 2. Tạo một mảng String có kích thước = số lượng stage + 1 (cho mục mặc định)
        String[] stages = new String[listStages.size() + 1];
        stages[0] = "Select stage"; // Mục mặc định
        
        // 3. Đổ dữ liệu từ ArrayList vào mảng String
        for (int i = 0; i < listStages.size(); i++) {
            stages[i + 1] = listStages.get(i).getStageName();
        }

        // 4. Truyền mảng vừa tạo vào ComboBox
        JComboBox <String> cbStage = createCustomComboBox(stages);
        gbc.gridy = 2;
        centerPanel.add(cbStage, gbc);

        // --- Thêm Nút View ---
        JButton btnView = createCustomButton("View", 120, 40);
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.NONE; // Không kéo dài nút View, giữ nguyên kích thước
        gbc.insets = new Insets(20, 0, 0, 0);
        centerPanel.add(btnView, gbc);

        // 4. Tạo Panel phía dưới (Bottom Panel) chứa nút "Back"
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        bottomPanel.setBackground(Color.WHITE);
        JButton btnBack = createCustomButton("Back", 80, 40);
        bottomPanel.add(btnBack);
        // Căn lề để nút Back cách lề dưới và lề phải một chút
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 20)); 

        // 5. Thêm các Panel vào Frame chính
        add(topPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
    }


    private JComboBox<String> createCustomComboBox(String[] items) {
        JComboBox<String> comboBox = new JComboBox<>(items);
        comboBox.setFont(new Font("Serif", Font.BOLD, 16));
        comboBox.setBackground(Color.WHITE);
        ((JLabel)comboBox.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER); // Căn giữa chữ

        Border lineBorder = BorderFactory.createLineBorder(Color.BLACK, 3);
        comboBox.setBorder(lineBorder);
        
        return comboBox;
    }

    private JButton createCustomButton(String text, int width, int height) {
        JButton button = new JButton(text);
        button.setFont(new Font("Serif", Font.BOLD, 16));
        button.setBackground(Color.WHITE);
        button.setForeground(Color.BLACK);
        button.setFocusPainted(false);
        
        Border lineBorder = BorderFactory.createLineBorder(Color.BLACK, 3);
        button.setBorder(lineBorder);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setPreferredSize(new Dimension(width, height));
        
        return button;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new SelectStageFrm().setVisible(true);
        });
    }
}