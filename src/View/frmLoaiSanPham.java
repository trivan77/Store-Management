package View;

import Database.DatabaseManager;
import Model.LoaiSanPham;
import Controller.ctlLoaiSanPham;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class frmLoaiSanPham extends JPanel {
	private JTable table;
	private JTextField txtTKLoaisp;
	private JTextField txtTKTenloai;
	private JTextField txtLoaisp;
	private JTextField txtTenloai;
	private JTextField txtMota;

	private DefaultTableModel model;

	private ctlLoaiSanPham controller;

	public frmLoaiSanPham(DatabaseManager dbManager) {

		// Truyền dữ liệu vào Controller
		this.controller = new ctlLoaiSanPham(dbManager.getDb()); // Pass db 

		// Tạo Form
		createFormPanel();

		// Lấy danh sách Loại sản phẩm
		layDanhSachLoaiSanPham("", "");
	}

	// Create the frame.
	private void createFormPanel() {
		// Tạo đường viền với tiêu đề, phông chữ và màu sắc tùy chỉnh
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 415, 171);
		panel.setBorder(BorderFactory.createTitledBorder("Tìm kiếm:"));
		add(panel);
		panel.setLayout(null);

		JLabel lblFLoaisp = new JLabel("Loại sản phẩm:");
		lblFLoaisp.setFont(new Font("Arial", Font.PLAIN, 14));
		lblFLoaisp.setBounds(10, 21, 116, 17);
		panel.add(lblFLoaisp);

		txtTKLoaisp = new JTextField();
		txtTKLoaisp.setFont(new Font("Arial", Font.PLAIN, 14));
		txtTKLoaisp.setColumns(10);
		txtTKLoaisp.setBounds(154, 19, 210, 20);
		panel.add(txtTKLoaisp);

		JLabel lblFTenloai = new JLabel("Tên loại sản phẩm:");
		lblFTenloai.setFont(new Font("Arial", Font.PLAIN, 14));
		lblFTenloai.setBounds(10, 48, 134, 17);
		panel.add(lblFTenloai);

		txtTKTenloai = new JTextField();
		txtTKTenloai.setFont(new Font("Arial", Font.PLAIN, 14));
		txtTKTenloai.setColumns(10);
		txtTKTenloai.setBounds(154, 48, 210, 20);
		panel.add(txtTKTenloai);

		JButton btnTimKiem = new JButton("Tìm");
		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				findButton();
			}
		});
		btnTimKiem.setBackground(Color.LIGHT_GRAY);
		btnTimKiem.setFont(new Font("Arial", Font.PLAIN, 14));
		btnTimKiem.setBounds(171, 88, 75, 21);
		panel.add(btnTimKiem);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(435, 10, 546, 171);
		panel_1.setBorder(BorderFactory.createTitledBorder("Thông tin chi tiết:"));
		add(panel_1);

		JLabel lblLoaisp = new JLabel("Loại sản phẩm:");
		lblLoaisp.setFont(new Font("Arial", Font.PLAIN, 14));
		lblLoaisp.setBounds(22, 26, 116, 17);
		panel_1.add(lblLoaisp);

		txtLoaisp = new JTextField();
		txtLoaisp.setFont(new Font("Arial", Font.PLAIN, 14));
		txtLoaisp.setColumns(10);
		txtLoaisp.setBounds(166, 24, 210, 20);
		panel_1.add(txtLoaisp);

		JLabel lblTenloai = new JLabel("Tên loại sản phẩm:");
		lblTenloai.setFont(new Font("Arial", Font.PLAIN, 14));
		lblTenloai.setBounds(22, 53, 134, 17);
		panel_1.add(lblTenloai);

		txtTenloai = new JTextField();
		txtTenloai.setFont(new Font("Arial", Font.PLAIN, 14));
		txtTenloai.setColumns(10);
		txtTenloai.setBounds(166, 53, 210, 20);
		panel_1.add(txtTenloai);

		JLabel lblMota = new JLabel("Mô tả:");
		lblMota.setFont(new Font("Arial", Font.PLAIN, 14));
		lblMota.setBounds(22, 80, 134, 17);
		panel_1.add(lblMota);

		JButton addButton = new JButton("Thêm");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addButton();
			}
		});
		addButton.setBackground(Color.LIGHT_GRAY);
		addButton.setFont(new Font("Arial", Font.PLAIN, 14));
		addButton.setBounds(100, 138, 75, 21);
		panel_1.add(addButton);

		JButton editButton = new JButton("Sửa");
		editButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editButton();
			}
		});
		editButton.setBackground(Color.LIGHT_GRAY);
		editButton.setFont(new Font("Arial", Font.PLAIN, 14));
		editButton.setBounds(194, 138, 75, 21);
		panel_1.add(editButton);

		JButton deleteButton = new JButton("Xóa");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteButton();
			}
		});
		deleteButton.setBackground(Color.LIGHT_GRAY);
		deleteButton.setFont(new Font("Arial", Font.PLAIN, 14));
		deleteButton.setBounds(290, 138, 75, 21);
		panel_1.add(deleteButton);

		JButton clearButton = new JButton("Clear");
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearButton();
			}
		});
		clearButton.setBackground(Color.LIGHT_GRAY);
		clearButton.setFont(new Font("Arial", Font.PLAIN, 14));
		clearButton.setBounds(383, 138, 75, 21);
		panel_1.add(clearButton);

		txtMota = new JTextField();
		txtMota.setFont(new Font("Arial", Font.PLAIN, 14));
		txtMota.setColumns(10);
		txtMota.setBounds(166, 80, 210, 20);
		panel_1.add(txtMota);

		// Thêm danh sách Loại sản phẩm
		setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 191, 971, 401);
		add(scrollPane);

		String[] columnNames = { "Loại sản phẩm", "Tên loại sản phẩm", "Mô tả" };
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
				txtLoaisp.setText((String) model.getValueAt(selectedRow, 0));
				txtTenloai.setText((String) model.getValueAt(selectedRow, 1));
				txtMota.setText(String.valueOf(model.getValueAt(selectedRow, 2)));
			}
		}
	};

	private void layDanhSachLoaiSanPham(String Loaisp, String Tenloai) {
		// Lấy dữ liệu từ controller
		List<LoaiSanPham> loaiSanPhamList = controller.layDanhSachLoaiSanPham(Loaisp, Tenloai);

		// Xóa các hàng cũ trong bảng
		model.setRowCount(0);

		// Thêm các hàng mới vào bảng
		for (LoaiSanPham object : loaiSanPhamList) {
			model.addRow(new Object[] { object.getLoaisp(), object.getTenloai(), object.getMota() });
			// System.out.println(object.toString());
		}
	}

	// Xử lý các button
	private void findButton() {
		String Loaisp = txtTKLoaisp.getText();
		String Tenloai = txtTKTenloai.getText();

		layDanhSachLoaiSanPham(Loaisp, Tenloai); // Cập nhật bảng
		clearButton(); // Xóa thông tin chi tiết

	}

	private void addButton() {
		String Loaisp = txtLoaisp.getText();
		String Tenloai = txtTenloai.getText();
		String Mota = txtMota.getText();
		if (controller.add(Loaisp, Tenloai, Mota)) {
			String fLoaisp = txtTKLoaisp.getText();
			String fTenloai = txtTKTenloai.getText();

			layDanhSachLoaiSanPham(fLoaisp, fTenloai); // Cập nhật bảng
			// clearButton(); // Xóa thông tin chi tiết
		}
	}

	private void editButton() {
		String Loaisp = txtLoaisp.getText();
		String Tenloai = txtTenloai.getText();
		String Mota = txtMota.getText();
		if (controller.edit(Loaisp, Tenloai, Mota)) {
			String fLoaisp = txtTKLoaisp.getText();
			String fTenloai = txtTKTenloai.getText();

			layDanhSachLoaiSanPham(fLoaisp, fTenloai); // Cập nhật bảng
			// clearButton(); // Xóa thông tin chi tiết
		}
	}

	private void deleteButton() {
		String Loaisp = txtLoaisp.getText();
		if (controller.del(Loaisp)) {
			String fLoaisp = txtTKLoaisp.getText();
			String fTenloai = txtTKTenloai.getText();

			layDanhSachLoaiSanPham(fLoaisp, fTenloai); // Cập nhật bảng
			clearButton(); // Xóa thông tin chi tiết
		}
	}

	private void clearButton() {
		// Tạm thời vô hiệu hóa ListSelectionListener
		table.getSelectionModel().removeListSelectionListener(selectionListener);

		// Xóa nội dung các trường
		txtLoaisp.setText("");
		txtTenloai.setText("");
		txtMota.setText("");

		// Xóa lựa chọn của bảng
		table.clearSelection();

		// Kích hoạt lại ListSelectionListener
		table.getSelectionModel().addListSelectionListener(selectionListener);
	}

}
