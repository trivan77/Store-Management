package View;

import Database.DatabaseManager;
import Model.Kho;
import Model.SanPham;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import Controller.ctlKho;
import javax.swing.JTextArea;

public class frmKho extends JPanel {
	private JTable table;
	private JTextField txtTKMakho;
	private JTextField txtTKTenkho;
	private JTextArea txtTKDiachi;

	private JTextField txtMakho;
	private JTextField txtTenkho;
	private JTextArea txtDiachi;

	private DefaultTableModel model;

	private ctlKho controller;

	public frmKho(DatabaseManager dbManager) {

		// Truyền dữ liệu vào Controller
		this.controller = new ctlKho(dbManager.getDb()); // Pass db

		// Tạo Form
		createFormPanel();

		// Lấy danh sách
		layDanhSach("", "", "");
	}

	// Create the frame.
	private void createFormPanel() {
		// Tạo đường viền với tiêu đề, phông chữ và màu sắc tùy chỉnh
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 415, 205);
		panel.setBorder(BorderFactory.createTitledBorder("Tìm kiếm:"));
		add(panel);
		panel.setLayout(null);

		JLabel lblFMasp = new JLabel("Mã kho:");
		lblFMasp.setFont(new Font("Arial", Font.PLAIN, 14));
		lblFMasp.setBounds(10, 20, 116, 17);
		panel.add(lblFMasp);

		txtTKMakho = new JTextField();
		txtTKMakho.setFont(new Font("Arial", Font.PLAIN, 14));
		txtTKMakho.setColumns(10);
		txtTKMakho.setBounds(154, 18, 210, 20);
		panel.add(txtTKMakho);

		JLabel lblFTensp = new JLabel("Tên kho:");
		lblFTensp.setFont(new Font("Arial", Font.PLAIN, 14));
		lblFTensp.setBounds(10, 57, 134, 17);
		panel.add(lblFTensp);

		txtTKTenkho = new JTextField();
		txtTKTenkho.setFont(new Font("Arial", Font.PLAIN, 14));
		txtTKTenkho.setColumns(10);
		txtTKTenkho.setBounds(154, 56, 210, 20);
		panel.add(txtTKTenkho);

		JLabel lblFTensp_1 = new JLabel("Địa chỉ:");
		lblFTensp_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblFTensp_1.setBounds(10, 94, 134, 17);
		panel.add(lblFTensp_1);

		txtTKDiachi = new JTextArea();
		txtTKDiachi.setBounds(154, 94, 210, 70);
		panel.add(txtTKDiachi);

		JButton btnTimKiem = new JButton("Tìm");
		btnTimKiem.setBounds(183, 174, 75, 21);
		panel.add(btnTimKiem);
		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				findButton();
			}
		});
		btnTimKiem.setBackground(Color.LIGHT_GRAY);
		btnTimKiem.setFont(new Font("Arial", Font.PLAIN, 14));

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(435, 10, 546, 205);
		panel_1.setBorder(BorderFactory.createTitledBorder("Thông tin chi tiết:"));
		add(panel_1);

		txtMakho = new JTextField();
		txtMakho.setFont(new Font("Arial", Font.PLAIN, 14));
		txtMakho.setColumns(10);
		txtMakho.setBounds(166, 20, 210, 20);
		panel_1.add(txtMakho);

		txtTenkho = new JTextField();
		txtTenkho.setFont(new Font("Arial", Font.PLAIN, 14));
		txtTenkho.setColumns(10);
		txtTenkho.setBounds(166, 51, 210, 20);
		panel_1.add(txtTenkho);

		JLabel lblFMasp_1 = new JLabel("Mã kho:");
		lblFMasp_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblFMasp_1.setBounds(10, 22, 116, 17);
		panel_1.add(lblFMasp_1);

		JLabel lblFTensp_2 = new JLabel("Tên kho:");
		lblFTensp_2.setFont(new Font("Arial", Font.PLAIN, 14));
		lblFTensp_2.setBounds(10, 52, 134, 17);
		panel_1.add(lblFTensp_2);

		JLabel lblFTensp_1_2_1 = new JLabel("Địa chỉ:");
		lblFTensp_1_2_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblFTensp_1_2_1.setBounds(10, 82, 134, 17);
		panel_1.add(lblFTensp_1_2_1);

		JButton addButton = new JButton("Thêm");
		addButton.setBounds(85, 174, 75, 21);
		panel_1.add(addButton);
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addButton();
			}
		});
		addButton.setBackground(Color.LIGHT_GRAY);
		addButton.setFont(new Font("Arial", Font.PLAIN, 14));

		JButton editButton = new JButton("Sửa");
		editButton.setBounds(179, 174, 75, 21);
		panel_1.add(editButton);
		editButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editButton();
			}
		});
		editButton.setBackground(Color.LIGHT_GRAY);
		editButton.setFont(new Font("Arial", Font.PLAIN, 14));

		JButton deleteButton = new JButton("Xóa");
		deleteButton.setBounds(275, 174, 75, 21);
		panel_1.add(deleteButton);
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteButton();
			}
		});
		deleteButton.setBackground(Color.LIGHT_GRAY);
		deleteButton.setFont(new Font("Arial", Font.PLAIN, 14));

		JButton clearButton = new JButton("Clear");
		clearButton.setBounds(368, 174, 75, 21);
		panel_1.add(clearButton);
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearButton();
			}
		});
		clearButton.setBackground(Color.LIGHT_GRAY);
		clearButton.setFont(new Font("Arial", Font.PLAIN, 14));

		txtDiachi = new JTextArea();
		txtDiachi.setBounds(166, 81, 210, 70);
		panel_1.add(txtDiachi);

		// Thêm danh sách
		setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 285, 971, 401);
		add(scrollPane);

		String[] columnNames = { "Mã kho", "Tên kho", "Địa chỉ" };
		model = new DefaultTableModel(columnNames, 0);
		table = new JTable(model);

		// Thay đổi kích thước và font chữ
		table.setFont(new Font("Arial", Font.PLAIN, 14)); // Font Arial, kích thước 14
		table.setRowHeight(25); // Chiều cao mỗi hàng

		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setPreferredWidth(150);
		table.getColumnModel().getColumn(2).setPreferredWidth(147);
		scrollPane.setViewportView(table);

		// Thêm hiệu ứng zebra
		table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
					boolean hasFocus, int row, int column) {
				Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

				// Kiểm tra nếu hàng được chọn
				if (!isSelected) {
					if (row % 2 == 0) {
						c.setBackground(new Color(135, 206, 250)); // Màu cho hàng chẵn
					} else {
						c.setBackground(Color.WHITE); // Màu cho hàng lẻ
					}
				}

				return c;
			}
		});

		// Lấy dữ liệu dòng được chọn để truyền vào Thông tin chi tiết
		table.getSelectionModel().addListSelectionListener(selectionListener);

	}

	// Lấy dữ liệu dòng được chọn để truyền vào Thông tin chi tiết
	private ListSelectionListener selectionListener = new ListSelectionListener() {
		@Override
		public void valueChanged(ListSelectionEvent e) {
			int selectedRow = table.getSelectedRow();
			if (selectedRow != -1) {
				txtMakho.setText((String) model.getValueAt(selectedRow, 0));
				txtTenkho.setText((String) model.getValueAt(selectedRow, 1));
				txtDiachi.setText((String) model.getValueAt(selectedRow, 2));
			}
		}
	};

	private void layDanhSach(String Makho, String Tenkho, String Diachi) {
		// Lấy dữ liệu từ controller
		List<Kho> resrulList = controller.layDanhSach(Makho, Tenkho, Diachi);

		// Xóa các hàng cũ trong bảng
		model.setRowCount(0);

		// Thêm các hàng mới vào bảng
		for (Kho object : resrulList) {
			model.addRow(new Object[] { object.getMakho(), object.getTenkho(), object.getDiachi() });
			// System.out.println(object.toString());
		}
	}

	// Xử lý các button
	private void findButton() {
		String Makho = txtTKMakho.getText();
		String Tenkho = txtTKTenkho.getText();
		String Diachi = txtTKDiachi.getText();

		layDanhSach(Makho, Tenkho, Diachi); // Cập nhật bảng
		clearButton(); // Xóa thông tin chi tiết

	}

	private void addButton() {
		String Makho = txtMakho.getText();
		String Tenkho = txtTenkho.getText();
		String Diachi = txtDiachi.getText();

		if (controller.add(Makho, Tenkho, Diachi)) {
			String fMakho = txtTKMakho.getText();
			String fTenkho = txtTKTenkho.getText();
			String fDiachi = txtTKDiachi.getText();

			layDanhSach(fMakho, fTenkho, fDiachi); // Cập nhật bảng
			// clearButton(); // Xóa thông tin chi tiết
		}
	}

	private void editButton() {
		String Makho = txtMakho.getText();
		String Tenkho = txtTenkho.getText();
		String Diachi = txtDiachi.getText();

		if (controller.edit(Makho, Tenkho, Diachi)) {
			String fMakho = txtTKMakho.getText();
			String fTenkho = txtTKTenkho.getText();
			String fDiachi = txtTKDiachi.getText();

			layDanhSach(fMakho, fTenkho, fDiachi); // Cập nhật bảng
			// clearButton(); // Xóa thông tin chi tiết
		}
	}

	private void deleteButton() {
		String Masp = txtMakho.getText();
		if (controller.del(Masp)) {
			String fMakho = txtTKMakho.getText();
			String fTenkho = txtTKTenkho.getText();
			String fDiachi = txtTKDiachi.getText();

			layDanhSach(fMakho, fTenkho, fDiachi); // Cập nhật bảng
			clearButton(); // Xóa thông tin chi tiết
		}
	}

	private void clearButton() {
		// Tạm thời vô hiệu hóa ListSelectionListener
		table.getSelectionModel().removeListSelectionListener(selectionListener);

		// Xóa nội dung các trường
		txtMakho.setText("");
		txtTenkho.setText("");
		txtDiachi.setText("");

		// Xóa lựa chọn của bảng
		table.clearSelection();

		// Kích hoạt lại ListSelectionListener
		table.getSelectionModel().addListSelectionListener(selectionListener);
	}
}
