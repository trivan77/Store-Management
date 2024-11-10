package View;

import javax.swing.*;

import Controller.ctlDangNhap;
import Database.DatabaseManager;
import View.MainFrame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class frmDangNhap extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ctlDangNhap ctlDangNhap;

	/**
	 * Create the frame.
	 */
	public frmDangNhap(DatabaseManager dbManager) {
		this.ctlDangNhap = new ctlDangNhap(dbManager.getDb()); // Pass db to StudentController

		setTitle("Phần mềm quản lý kho hàng");
		setSize(800, 450);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());

		// Panel màu xanh bên trái
		JPanel leftPanel = new JPanel();
		leftPanel.setBackground(new Color(0, 90, 160));
		leftPanel.setLayout(new GridBagLayout());

		JLabel titleLabel = new JLabel("PHẦN MỀM QUẢN LÝ KHO HÀNG");
		titleLabel.setForeground(Color.WHITE);
		titleLabel.setFont(new Font("Arial", Font.BOLD, 20));

		JLabel subLabel = new JLabel("Chuyên nghiệp - Tiện Lợi - Hiệu Quả");
		subLabel.setForeground(Color.WHITE);
		subLabel.setFont(new Font("Arial", Font.PLAIN, 14));

		// Sử dụng GridBagConstraints cho titleLabel
		GridBagConstraints gbcTitle = new GridBagConstraints();
		gbcTitle.gridx = 0;
		gbcTitle.gridy = 0;
		gbcTitle.insets = new Insets(10, 0, 10, 0);
		leftPanel.add(titleLabel, gbcTitle);

		// Sử dụng GridBagConstraints riêng cho subLabel
		GridBagConstraints gbcSubLabel = new GridBagConstraints();
		gbcSubLabel.gridx = 0;
		gbcSubLabel.gridy = 1;
		gbcSubLabel.insets = new Insets(5, 0, 10, 0);
		leftPanel.add(subLabel, gbcSubLabel);

		// Panel trắng bên phải
		JPanel rightPanel = new JPanel();
		rightPanel.setBackground(Color.WHITE);

		JLabel loginLabel = new JLabel("Tài khoản đăng nhập");
		loginLabel.setBounds(104, 34, 189, 52);
		loginLabel.setFont(new Font("Arial", Font.BOLD, 18));
		loginLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		loginLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 10, 0));

		JTextField usernameField = new JTextField();
		usernameField.setBounds(48, 115, 300, 43);
		usernameField.setMaximumSize(new Dimension(300, 30));
		usernameField.setAlignmentX(Component.CENTER_ALIGNMENT);
		usernameField.setBorder(BorderFactory.createTitledBorder("Tên đăng nhập"));

		JPasswordField passwordField = new JPasswordField();
		passwordField.setBounds(48, 168, 300, 43);
		passwordField.setMaximumSize(new Dimension(300, 30));
		passwordField.setAlignmentX(Component.CENTER_ALIGNMENT);
		passwordField.setBorder(BorderFactory.createTitledBorder("Mật khẩu"));

		JButton loginButton = new JButton("Đăng nhập →");
		loginButton.setBounds(123, 234, 150, 40);
		loginButton.setBackground(new Color(0, 120, 215));
		loginButton.setForeground(Color.WHITE);
		loginButton.setFocusPainted(false);
		loginButton.setMaximumSize(new Dimension(150, 40));
		loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);

		JButton exitButton = new JButton("Thoát");
		exitButton.setBounds(123, 284, 150, 40);
		exitButton.setBackground(Color.GRAY);
		exitButton.setForeground(Color.WHITE);
		exitButton.setFocusPainted(false);
		exitButton.setMaximumSize(new Dimension(150, 40));
		exitButton.setAlignmentX(Component.CENTER_ALIGNMENT);

		JLabel versionLabel = new JLabel("Phiên bản: v1.0.0");
		versionLabel.setBounds(161, 406, 90, 34);
		versionLabel.setFont(new Font("Arial", Font.ITALIC, 12));
		versionLabel.setForeground(Color.BLUE);
		versionLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		versionLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));

		// Thêm action cho các nút
		loginButton.addActionListener(e -> {
			String username = usernameField.getText();
			String password = new String(passwordField.getPassword());

			if (ctlDangNhap.validateUser(username, password)) {
				JOptionPane.showMessageDialog(this, "Đăng nhập thành công!");

				// Gọi screen MainFrame
				MainFrame frame = new MainFrame(dbManager, username);
				frame.setVisible(true);
				this.dispose(); // Đóng LoginScreen
			} else {
				JOptionPane.showMessageDialog(this, "Tên đăng nhập hoặc mật khẩu không chính xác", "Lỗi đăng nhập",
						JOptionPane.ERROR_MESSAGE);
			}

		});

		exitButton.addActionListener(e -> {
			dbManager.closeDB(); // Đóng cơ sở dữ liệu trước khi thoát
			System.exit(0); // Thoát khỏi ứng dụng
		});

		// Thêm WindowListener để xử lý sự kiện nhấn nút "X"
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dbManager.closeDB(); // Đóng cơ sở dữ liệu trước khi thoát
				System.out.println("Database closed before exit.");
			}
		});

		rightPanel.setLayout(null);

		// Thêm các thành phần vào rightPanel
		rightPanel.add(loginLabel);
		rightPanel.add(usernameField);
		rightPanel.add(passwordField);
		rightPanel.add(loginButton);
		rightPanel.add(exitButton);
		rightPanel.add(versionLabel);

		// Thêm các panel vào frame
		getContentPane().add(leftPanel, BorderLayout.WEST);
		getContentPane().add(rightPanel, BorderLayout.CENTER);

		// Điều chỉnh kích thước panel trái và phải
		leftPanel.setPreferredSize(new Dimension(400, 450));
		rightPanel.setPreferredSize(new Dimension(400, 450));
	}

}
