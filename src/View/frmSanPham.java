package View;

import Database.DatabaseManager;
import Model.*;
import Controller.ctlSanPham;

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

public class frmSanPham extends JPanel {
	private JTable table;
	private JTextField txtTKMasp;
	private JTextField txtTKTensp;
	private JTextField txtTKDonvitinh;
	private JTextField txtTKLoaisp;

	private JTextField txtMasp;
	private JTextField txtTensp;
	private JTextField txtDonvitinh;
	private JTextField txtLoaisp;
	private JTextField txtDongia;

	private DefaultTableModel model;

	private ctlSanPham controller;

	public frmSanPham(DatabaseManager dbManager) {

		// Truyền dữ liệu vào Controller
		this.controller = new ctlSanPham(dbManager.getDb()); // Pass db

		// Tạo Form
		createFormPanel();

		// Lấy danh sách
		layDanhSach("", "", "", "");
	}

	// Create the frame.
	private void createFormPanel() {
		// Tạo đường viền với tiêu đề, phông chữ và màu sắc tùy chỉnh
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 415, 205);
		panel.setBorder(BorderFactory.createTitledBorder("Tìm kiếm:"));
		add(panel);
		panel.setLayout(null);

		JLabel lblFMasp = new JLabel("Mã sản phẩm:");
		lblFMasp.setFont(new Font("Arial", Font.PLAIN, 14));
		lblFMasp.setBounds(10, 20, 116, 17);
		panel.add(lblFMasp);

		txtTKMasp = new JTextField();
		txtTKMasp.setFont(new Font("Arial", Font.PLAIN, 14));
		txtTKMasp.setColumns(10);
		txtTKMasp.setBounds(154, 18, 210, 20);
		panel.add(txtTKMasp);

		JLabel lblFTensp = new JLabel("Tên sản phẩm:");
		lblFTensp.setFont(new Font("Arial", Font.PLAIN, 14));
		lblFTensp.setBounds(10, 57, 134, 17);
		panel.add(lblFTensp);

		txtTKTensp = new JTextField();
		txtTKTensp.setFont(new Font("Arial", Font.PLAIN, 14));
		txtTKTensp.setColumns(10);
		txtTKTensp.setBounds(154, 56, 210, 20);
		panel.add(txtTKTensp);

		txtTKDonvitinh = new JTextField();
		txtTKDonvitinh.setFont(new Font("Arial", Font.PLAIN, 14));
		txtTKDonvitinh.setColumns(10);
		txtTKDonvitinh.setBounds(154, 94, 210, 20);
		panel.add(txtTKDonvitinh);

		JLabel lblFTensp_1 = new JLabel("Đơn vị tính:");
		lblFTensp_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblFTensp_1.setBounds(10, 94, 134, 17);
		panel.add(lblFTensp_1);

		txtTKLoaisp = new JTextField();
		txtTKLoaisp.setFont(new Font("Arial", Font.PLAIN, 14));
		txtTKLoaisp.setColumns(10);
		txtTKLoaisp.setBounds(154, 132, 210, 20);
		panel.add(txtTKLoaisp);

		JLabel lblFTensp_1_1 = new JLabel("Loại sản phẩm:");
		lblFTensp_1_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblFTensp_1_1.setBounds(10, 131, 134, 17);
		panel.add(lblFTensp_1_1);

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

		txtMasp = new JTextField();
		txtMasp.setFont(new Font("Arial", Font.PLAIN, 14));
		txtMasp.setColumns(10);
		txtMasp.setBounds(166, 14, 210, 20);
		panel_1.add(txtMasp);

		txtTensp = new JTextField();
		txtTensp.setFont(new Font("Arial", Font.PLAIN, 14));
		txtTensp.setColumns(10);
		txtTensp.setBounds(166, 45, 210, 20);
		panel_1.add(txtTensp);

		txtDonvitinh = new JTextField();
		txtDonvitinh.setFont(new Font("Arial", Font.PLAIN, 14));
		txtDonvitinh.setColumns(10);
		txtDonvitinh.setBounds(166, 107, 210, 20);
		panel_1.add(txtDonvitinh);

		JLabel lblFMasp_1 = new JLabel("Mã sản phẩm:");
		lblFMasp_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblFMasp_1.setBounds(10, 16, 116, 17);
		panel_1.add(lblFMasp_1);

		JLabel lblFTensp_2 = new JLabel("Tên sản phẩm:");
		lblFTensp_2.setFont(new Font("Arial", Font.PLAIN, 14));
		lblFTensp_2.setBounds(10, 46, 134, 17);
		panel_1.add(lblFTensp_2);

		JLabel lblFTensp_1_2 = new JLabel("Đơn vị tính:");
		lblFTensp_1_2.setFont(new Font("Arial", Font.PLAIN, 14));
		lblFTensp_1_2.setBounds(10, 106, 134, 17);
		panel_1.add(lblFTensp_1_2);

		JLabel lblFTensp_1_1_1 = new JLabel("Loại sản phẩm:");
		lblFTensp_1_1_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblFTensp_1_1_1.setBounds(10, 136, 134, 17);
		panel_1.add(lblFTensp_1_1_1);

		txtLoaisp = new JTextField();
		txtLoaisp.setFont(new Font("Arial", Font.PLAIN, 14));
		txtLoaisp.setColumns(10);
		txtLoaisp.setBounds(166, 138, 210, 20);
		panel_1.add(txtLoaisp);

		txtDongia = new JTextField();
		txtDongia.setFont(new Font("Arial", Font.PLAIN, 14));
		txtDongia.setColumns(10);
		txtDongia.setBounds(166, 76, 210, 20);
		panel_1.add(txtDongia);

		JLabel lblFTensp_1_2_1 = new JLabel("Đơn giá:");
		lblFTensp_1_2_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblFTensp_1_2_1.setBounds(10, 76, 134, 17);
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

		// Thêm danh sách Loại sản phẩm
		setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 285, 971, 401);
		add(scrollPane);

		String[] columnNames = { "Mã sản phẩm", "Tên sản phẩm", "Đơn giá", "Đơn vị tính", "Loại sản phẩm" };
		model = new DefaultTableModel(columnNames, 0);
		table = new JTable(model);

		// Thay đổi kích thước và font chữ
		table.setFont(new Font("Arial", Font.PLAIN, 14)); // Font Arial, kích thước 14
		table.setRowHeight(25); // Chiều cao mỗi hàng

		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setPreferredWidth(150);
		table.getColumnModel().getColumn(2).setPreferredWidth(147);
		table.getColumnModel().getColumn(3).setPreferredWidth(147);
		table.getColumnModel().getColumn(4).setPreferredWidth(147);
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
				txtMasp.setText((String) model.getValueAt(selectedRow, 0));
				txtTensp.setText((String) model.getValueAt(selectedRow, 1));
				txtDongia.setText(String.valueOf(model.getValueAt(selectedRow, 2)));
				txtDonvitinh.setText((String) model.getValueAt(selectedRow, 3));
				txtLoaisp.setText((String) model.getValueAt(selectedRow, 4));
			}
		}
	};

	private void layDanhSach(String Masp, String Tensp, String Donvitinh, String Loaisp) {
		// Lấy dữ liệu từ controller
		List<SanPham> resrulList = controller.layDanhSach(Masp, Tensp, Donvitinh, Loaisp);

		// Xóa các hàng cũ trong bảng
		model.setRowCount(0);

		// Thêm các hàng mới vào bảng
		for (SanPham object : resrulList) {
			model.addRow(new Object[] { object.getMasp(), object.getTensp(), object.getDongia(), object.getDonvitinh(),
					object.getLoaisp() });
			// System.out.println(object.toString());
		}
	}

	// Xử lý các button
	private void findButton() {
		String Masp = txtTKMasp.getText();
		String Tensp = txtTKTensp.getText();
		String Donvitinh = txtTKDonvitinh.getText();
		String Loaisp = txtTKLoaisp.getText();

		layDanhSach(Masp, Tensp, Donvitinh, Loaisp); // Cập nhật bảng
		clearButton(); // Xóa thông tin chi tiết

	}

	private void addButton() {
		String Masp = txtMasp.getText();
		String Tensp = txtTensp.getText();
		String Dongia = txtDongia.getText();
		String Donvitinh = txtDonvitinh.getText();
		String Loaisp = txtLoaisp.getText();

		if (controller.add(Masp, Tensp, Dongia, Donvitinh, Loaisp)) {
			String fMasp = txtTKMasp.getText();
			String fTensp = txtTKTensp.getText();
			String fDonvitinh = txtTKDonvitinh.getText();
			String fLoaisp = txtTKLoaisp.getText();

			layDanhSach(fMasp, fTensp, fDonvitinh, fLoaisp); // Cập nhật bảng
			// clearButton(); // Xóa thông tin chi tiết
		}
	}

	private void editButton() {
		String Masp = txtMasp.getText();
		String Tensp = txtTensp.getText();
		String Dongia = txtDongia.getText();
		String Donvitinh = txtDonvitinh.getText();
		String Loaisp = txtLoaisp.getText();

		if (controller.edit(Masp, Tensp, Dongia, Donvitinh, Loaisp)) {
			String fMasp = txtTKMasp.getText();
			String fTensp = txtTKTensp.getText();
			String fDonvitinh = txtTKDonvitinh.getText();
			String fLoaisp = txtTKLoaisp.getText();

			layDanhSach(fMasp, fTensp, fDonvitinh, fLoaisp); // Cập nhật bảng
			// clearButton(); // Xóa thông tin chi tiết
		}
	}

	private void deleteButton() {
		String Masp = txtMasp.getText();
		if (controller.del(Masp)) {
			String fMasp = txtTKMasp.getText();
			String fTensp = txtTKTensp.getText();
			String fDonvitinh = txtTKDonvitinh.getText();
			String fLoaisp = txtTKLoaisp.getText();

			layDanhSach(fMasp, fTensp, fDonvitinh, fLoaisp); // Cập nhật bảng
			clearButton(); // Xóa thông tin chi tiết
		}
	}

	private void clearButton() {
		// Tạm thời vô hiệu hóa ListSelectionListener
		table.getSelectionModel().removeListSelectionListener(selectionListener);

		// Xóa nội dung các trường
		txtMasp.setText("");
		txtTensp.setText("");
		txtDongia.setText("");
		txtDonvitinh.setText("");
		txtLoaisp.setText("");

		// Xóa lựa chọn của bảng
		table.clearSelection();

		// Kích hoạt lại ListSelectionListener
		table.getSelectionModel().addListSelectionListener(selectionListener);
	}

}
