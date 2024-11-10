package View;

import Database.DatabaseManager;
import Model.NhanVien;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.MessageDigest;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import Controller.ctlNhanVien;

public class frmNhanVien extends JPanel {

	private JTable table;
	private JTextField txtTKManv;
	private JTextField txtTKTennv;
	private JTextArea txtTKDiachi;
	private JComboBox txtTKGioitinh;
	private JTextField txtTKDienthoai;
	private JTextField txtTKSocmnd;
	private JTextField txtTKChucvu;
	private JTextField txtChucvu;
	private JTextField txtSocmnd;
	private JTextField txtDienthoai;
	private JComboBox txtGioitinh;
	private JTextField txtTennv;
	private JTextField txtManv;
	private JPasswordField txtMatkhau;
	private JTextArea txtDiachi;

	private DefaultTableModel model;

	private ctlNhanVien controller;

	public frmNhanVien(DatabaseManager dbManager) {
		// Truyền dữ liệu vào Controller
		this.controller = new ctlNhanVien(dbManager.getDb()); // Pass db

		// Tạo Form
		createFormPanel();

		// Lấy danh sách
		NhanVien nhanVien = new NhanVien();
		layDanhSach(nhanVien);
	}

	// Create the frame.
	private void createFormPanel() {
		// Tạo đường viền với tiêu đề, phông chữ và màu sắc tùy chỉnh
		JPanel panel = new JPanel();
		panel.setBounds(10, 66, 620, 234);
		panel.setBorder(BorderFactory.createTitledBorder("Tìm kiếm:"));
		add(panel);
		panel.setLayout(null);

		JLabel lblFMasp = new JLabel("Mã nhân viên:");
		lblFMasp.setFont(new Font("Arial", Font.PLAIN, 14));
		lblFMasp.setBounds(10, 28, 116, 17);
		panel.add(lblFMasp);

		txtTKManv = new JTextField();
		txtTKManv.setFont(new Font("Arial", Font.PLAIN, 14));
		txtTKManv.setColumns(10);
		txtTKManv.setBounds(112, 28, 210, 20);
		panel.add(txtTKManv);

		JLabel lblFTensp = new JLabel("Tên nhân viên:");
		lblFTensp.setFont(new Font("Arial", Font.PLAIN, 14));
		lblFTensp.setBounds(10, 64, 134, 17);
		panel.add(lblFTensp);

		txtTKTennv = new JTextField();
		txtTKTennv.setFont(new Font("Arial", Font.PLAIN, 14));
		txtTKTennv.setColumns(10);
		txtTKTennv.setBounds(112, 62, 210, 20);
		panel.add(txtTKTennv);

		JLabel lblFTensp_1 = new JLabel("Giới tính:");
		lblFTensp_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblFTensp_1.setBounds(10, 98, 134, 17);
		panel.add(lblFTensp_1);

		txtTKDiachi = new JTextArea();
		txtTKDiachi.setBounds(404, 93, 210, 70);
		panel.add(txtTKDiachi);

		JLabel lblFTensp_1_1 = new JLabel("Điện thoại:");
		lblFTensp_1_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblFTensp_1_1.setBounds(10, 132, 134, 17);
		panel.add(lblFTensp_1_1);

		JLabel lblFTensp_1_1_1 = new JLabel("Địa chỉ:");
		lblFTensp_1_1_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblFTensp_1_1_1.setBounds(332, 96, 134, 17);
		panel.add(lblFTensp_1_1_1);

		JLabel lblFTensp_1_1_2 = new JLabel("Số CMND:");
		lblFTensp_1_1_2.setFont(new Font("Arial", Font.PLAIN, 14));
		lblFTensp_1_1_2.setBounds(332, 30, 134, 17);
		panel.add(lblFTensp_1_1_2);

		JLabel lblFTensp_1_1_3 = new JLabel("Chức vụ:");
		lblFTensp_1_1_3.setFont(new Font("Arial", Font.PLAIN, 14));
		lblFTensp_1_1_3.setBounds(332, 64, 134, 17);
		panel.add(lblFTensp_1_1_3);

		// Khai báo JComboBox cho giới tính
		txtTKGioitinh = new JComboBox<>();
		txtTKGioitinh.addItem("");
		txtTKGioitinh.addItem("Nam");
		txtTKGioitinh.addItem("Nữ");
		txtTKGioitinh.setFont(new Font("Arial", Font.PLAIN, 14));
		txtTKGioitinh.setBounds(112, 96, 210, 20);
		panel.add(txtTKGioitinh);

		txtTKDienthoai = new JTextField();
		txtTKDienthoai.setFont(new Font("Arial", Font.PLAIN, 14));
		txtTKDienthoai.setColumns(10);
		txtTKDienthoai.setBounds(112, 130, 210, 20);
		panel.add(txtTKDienthoai);

		txtTKSocmnd = new JTextField();
		txtTKSocmnd.setFont(new Font("Arial", Font.PLAIN, 14));
		txtTKSocmnd.setColumns(10);
		txtTKSocmnd.setBounds(404, 28, 210, 20);
		panel.add(txtTKSocmnd);

		txtTKChucvu = new JTextField();
		txtTKChucvu.setFont(new Font("Arial", Font.PLAIN, 14));
		txtTKChucvu.setColumns(10);
		txtTKChucvu.setBounds(404, 62, 210, 20);
		panel.add(txtTKChucvu);

		JButton btnTimKiem = new JButton("Tìm");
		btnTimKiem.setBounds(262, 203, 75, 21);
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
		panel_1.setBounds(631, 66, 633, 234);
		panel_1.setBorder(BorderFactory.createTitledBorder("Thông tin chi tiết:"));
		add(panel_1);

		txtDiachi = new JTextArea();
		txtDiachi.setBounds(399, 86, 210, 70);
		panel_1.add(txtDiachi);

		JLabel lblFMasp_1 = new JLabel("Mã nhân viên:");
		lblFMasp_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblFMasp_1.setBounds(10, 21, 116, 17);
		panel_1.add(lblFMasp_1);

		JLabel lblFTensp_2 = new JLabel("Tên nhân viên:");
		lblFTensp_2.setFont(new Font("Arial", Font.PLAIN, 14));
		lblFTensp_2.setBounds(10, 57, 134, 17);
		panel_1.add(lblFTensp_2);

		JLabel lblFTensp_1_2 = new JLabel("Giới tính:");
		lblFTensp_1_2.setFont(new Font("Arial", Font.PLAIN, 14));
		lblFTensp_1_2.setBounds(10, 91, 134, 17);
		panel_1.add(lblFTensp_1_2);

		JLabel lblFTensp_1_1_4 = new JLabel("Điện thoại:");
		lblFTensp_1_1_4.setFont(new Font("Arial", Font.PLAIN, 14));
		lblFTensp_1_1_4.setBounds(10, 125, 134, 17);
		panel_1.add(lblFTensp_1_1_4);

		JLabel lblFTensp_1_1_2_1 = new JLabel("Số CMND:");
		lblFTensp_1_1_2_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblFTensp_1_1_2_1.setBounds(329, 23, 134, 17);
		panel_1.add(lblFTensp_1_1_2_1);

		JLabel lblFTensp_1_1_3_1 = new JLabel("Chức vụ:");
		lblFTensp_1_1_3_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblFTensp_1_1_3_1.setBounds(329, 57, 134, 17);
		panel_1.add(lblFTensp_1_1_3_1);

		JLabel lblFTensp_1_1_1_1 = new JLabel("Địa chỉ:");
		lblFTensp_1_1_1_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblFTensp_1_1_1_1.setBounds(329, 89, 134, 17);
		panel_1.add(lblFTensp_1_1_1_1);

		txtChucvu = new JTextField();
		txtChucvu.setFont(new Font("Arial", Font.PLAIN, 14));
		txtChucvu.setColumns(10);
		txtChucvu.setBounds(399, 55, 210, 20);
		panel_1.add(txtChucvu);

		txtSocmnd = new JTextField();
		txtSocmnd.setFont(new Font("Arial", Font.PLAIN, 14));
		txtSocmnd.setColumns(10);
		txtSocmnd.setBounds(399, 21, 210, 20);
		panel_1.add(txtSocmnd);

		txtDienthoai = new JTextField();
		txtDienthoai.setFont(new Font("Arial", Font.PLAIN, 14));
		txtDienthoai.setColumns(10);
		txtDienthoai.setBounds(109, 123, 210, 20);
		panel_1.add(txtDienthoai);

		// Khai báo JComboBox cho giới tính
		txtGioitinh = new JComboBox<>();
		txtGioitinh.addItem("");
		txtGioitinh.addItem("Nam");
		txtGioitinh.addItem("Nữ");
		txtGioitinh.setFont(new Font("Arial", Font.PLAIN, 14));
		txtGioitinh.setBounds(109, 89, 210, 20);
		panel_1.add(txtGioitinh);

		txtTennv = new JTextField();
		txtTennv.setFont(new Font("Arial", Font.PLAIN, 14));
		txtTennv.setColumns(10);
		txtTennv.setBounds(109, 55, 210, 20);
		panel_1.add(txtTennv);

		txtManv = new JTextField();
		txtManv.setFont(new Font("Arial", Font.PLAIN, 14));
		txtManv.setColumns(10);
		txtManv.setBounds(109, 21, 210, 20);
		panel_1.add(txtManv);

		JLabel lblFTensp_1_1_4_1 = new JLabel("Mật khẩu:");
		lblFTensp_1_1_4_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblFTensp_1_1_4_1.setBounds(10, 158, 134, 17);
		panel_1.add(lblFTensp_1_1_4_1);

		txtMatkhau = new JPasswordField();
		txtMatkhau.setFont(new Font("Arial", Font.PLAIN, 14));
		txtMatkhau.setColumns(10);
		txtMatkhau.setBounds(109, 156, 210, 20);
		panel_1.add(txtMatkhau);

		JButton addButton = new JButton("Thêm");
		addButton.setBounds(166, 203, 75, 21);
		panel_1.add(addButton);
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addButton();
			}
		});
		addButton.setBackground(Color.LIGHT_GRAY);
		addButton.setFont(new Font("Arial", Font.PLAIN, 14));

		JButton editButton = new JButton("Sửa");
		editButton.setBounds(260, 203, 75, 21);
		panel_1.add(editButton);
		editButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editButton();
			}
		});
		editButton.setBackground(Color.LIGHT_GRAY);
		editButton.setFont(new Font("Arial", Font.PLAIN, 14));

		JButton deleteButton = new JButton("Xóa");
		deleteButton.setBounds(356, 203, 75, 21);
		panel_1.add(deleteButton);
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteButton();
			}
		});
		deleteButton.setBackground(Color.LIGHT_GRAY);
		deleteButton.setFont(new Font("Arial", Font.PLAIN, 14));

		JButton clearButton = new JButton("Clear");
		clearButton.setBounds(449, 203, 75, 21);
		panel_1.add(clearButton);
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearButton();
			}
		});
		clearButton.setBackground(Color.LIGHT_GRAY);
		clearButton.setFont(new Font("Arial", Font.PLAIN, 14));

		// Thêm danh sách
		setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 301, 1254, 401);
		add(scrollPane);

		String[] columnNames = { "Mã nhân viên", "Tên nhân viên", "Giới tính", "Điện thoại", "Địa chỉ", "Số CMND",
				"Chức vụ", "Mật khẩu" };
		model = new DefaultTableModel(columnNames, 0);
		table = new JTable(model);

		// Thay đổi kích thước và font chữ
		table.setFont(new Font("Arial", Font.PLAIN, 14)); // Font Arial, kích thước 14
		table.setRowHeight(25); // Chiều cao mỗi hàng

		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setPreferredWidth(150);
		table.getColumnModel().getColumn(2).setPreferredWidth(50);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		table.getColumnModel().getColumn(4).setPreferredWidth(150);
		table.getColumnModel().getColumn(5).setPreferredWidth(147);
		table.getColumnModel().getColumn(6).setPreferredWidth(100);
		table.getColumnModel().getColumn(7).setPreferredWidth(100);
		scrollPane.setViewportView(table);
		
		JLabel lblQunLNhn = new JLabel("QUẢN LÝ NHÂN VIÊN");
		lblQunLNhn.setFont(new Font("Arial", Font.PLAIN, 30));
		lblQunLNhn.setBounds(10, 0, 684, 49);
		add(lblQunLNhn);

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
				txtManv.setText((String) model.getValueAt(selectedRow, 0));
				txtTennv.setText((String) model.getValueAt(selectedRow, 1));
				txtGioitinh.setSelectedItem(model.getValueAt(selectedRow, 2));
				txtDienthoai.setText((String) model.getValueAt(selectedRow, 3));
				txtDiachi.setText((String) model.getValueAt(selectedRow, 4));
				txtSocmnd.setText((String) model.getValueAt(selectedRow, 5));
				txtChucvu.setText((String) model.getValueAt(selectedRow, 6));
				txtMatkhau.setText((String) model.getValueAt(selectedRow, 7));
			}
		}
	};

	private void layDanhSach(NhanVien nhanVien) {
		// Lấy dữ liệu từ controller
		List<NhanVien> resultList = controller.layDanhSach(nhanVien);

		// Xóa các hàng cũ trong bảng
		model.setRowCount(0);

		// Thêm các hàng mới vào bảng
		for (NhanVien object : resultList) {

			String matKhau = object.getMatKhau(); // Lấy mật khẩu
			String maskedPassword = matKhau != null ? "*".repeat(matKhau.length()) : ""; // Mã hóa mật khẩu thành dấu *

			model.addRow(new Object[] { object.getMaNv(), // Mã nhân viên
					object.getTenNv(), // Tên nhân viên
					object.getGioiTinh(), // Giới tính
					object.getDienThoai(), // Điện thoại
					object.getDiaChi(), // Địa chỉ
					object.getSoCmnd(), // Số CMND
					object.getChucVu(), // Chức vụ
					maskedPassword // Hiển thị dấu * thay vì mật khẩu thực
			});
			// System.out.println(object.toString());
		}
	}

	// Xử lý các button
	private void findButton() {
		// Lấy giá trị từ JComboBox
		Object selectedItem = txtTKGioitinh.getSelectedItem();

		// Tạo đối tượng NhanVien với các giá trị từ các trường đầu vào
		NhanVien nhanVien = new NhanVien();
		nhanVien.setMaNv(txtTKManv.getText());
		nhanVien.setTenNv(txtTKTennv.getText());
		if (selectedItem != null) {
			nhanVien.setGioiTinh(selectedItem.toString());
		}
		nhanVien.setDienThoai(txtTKDienthoai.getText());
		nhanVien.setDiaChi(txtTKDiachi.getText());
		nhanVien.setSoCmnd(txtTKSocmnd.getText());
		nhanVien.setChucVu(txtTKChucvu.getText());

		// Cập nhật bảng với danh sách nhân viên theo tiêu chí tìm kiếm
		layDanhSach(nhanVien);

		// Xóa thông tin chi tiết
		clearButton();

	}

	private void addButton() {
		// Lấy giá trị được chọn từ JComboBox
		Object selectedItem = txtTKGioitinh.getSelectedItem();

		// Lấy thông tin từ các trường nhập liệu để thêm mới nhân viên
		NhanVien nhanVien = new NhanVien();
		nhanVien.setMaNv(txtManv.getText());
		nhanVien.setTenNv(txtTennv.getText());
		if (selectedItem != null) {
			nhanVien.setGioiTinh((String) txtGioitinh.getSelectedItem());
		}
		nhanVien.setDienThoai(txtDienthoai.getText());
		nhanVien.setDiaChi(txtDiachi.getText());
		nhanVien.setSoCmnd(txtSocmnd.getText());
		nhanVien.setChucVu(txtChucvu.getText());
		nhanVien.setMatKhau(txtMatkhau.getText());

		// Thêm nhân viên và cập nhật danh sách nếu thành công
		if (controller.add(nhanVien)) {
			// Tạo đối tượng tìm kiếm NhanVien
			NhanVien nhanVienSearch = new NhanVien();
			nhanVienSearch.setMaNv(txtTKManv.getText());
			nhanVienSearch.setTenNv(txtTKTennv.getText());
			nhanVienSearch.setDiaChi(txtTKDiachi.getText());
			if (selectedItem != null) {
				nhanVienSearch.setGioiTinh(selectedItem.toString());
			}
			nhanVienSearch.setDienThoai(txtTKDienthoai.getText());
			nhanVienSearch.setSoCmnd(txtTKSocmnd.getText());
			nhanVienSearch.setChucVu(txtTKChucvu.getText());

			// Cập nhật bảng
			layDanhSach(nhanVienSearch);

			// Xóa các thông tin chi tiết trên giao diện nếu cần thiết
			// clearButton();
		}
	}

	private void editButton() {
		// Lấy giá trị được chọn từ JComboBox
		Object selectedItem = txtTKGioitinh.getSelectedItem();

		// Lấy thông tin từ các trường nhập liệu để chỉnh sửa nhân viên
		NhanVien nhanVien = new NhanVien();
		nhanVien.setMaNv(txtManv.getText());
		nhanVien.setTenNv(txtTennv.getText());
		nhanVien.setGioiTinh((String) txtGioitinh.getSelectedItem());
		nhanVien.setDienThoai(txtDienthoai.getText());
		nhanVien.setDiaChi(txtDiachi.getText());
		nhanVien.setSoCmnd(txtSocmnd.getText());
		nhanVien.setChucVu(txtChucvu.getText());
		nhanVien.setMatKhau(txtMatkhau.getText());

		// Chỉnh sửa nhân viên và cập nhật danh sách nếu thành công
		if (controller.edit(nhanVien)) {
			// Tạo đối tượng tìm kiếm NhanVien
			NhanVien nhanVienSearch = new NhanVien();
			nhanVienSearch.setMaNv(txtTKManv.getText());
			nhanVienSearch.setTenNv(txtTKTennv.getText());
			nhanVienSearch.setDiaChi(txtTKDiachi.getText());
			if (selectedItem != null) {
				nhanVienSearch.setGioiTinh(selectedItem.toString());
			}
			nhanVienSearch.setDienThoai(txtTKDienthoai.getText());
			nhanVienSearch.setSoCmnd(txtTKSocmnd.getText());
			nhanVienSearch.setChucVu(txtTKChucvu.getText());

			// Cập nhật bảng
			layDanhSach(nhanVienSearch);

			// Xóa các thông tin chi tiết trên giao diện nếu cần thiết
			// clearButton();
		}
	}

	private void deleteButton() {
		// Lấy giá trị được chọn từ JComboBox
		Object selectedItem = txtTKGioitinh.getSelectedItem();

		// Lấy thông tin từ trường nhập liệu để xóa nhân viên
		NhanVien nhanVien = new NhanVien();
		nhanVien.setMaNv(txtManv.getText());

		// Gọi phương thức xóa nhân viên trong controller
		if (controller.del(nhanVien)) {
			// Lấy thông tin tìm kiếm từ các trường
			NhanVien nhanVienSearch = new NhanVien();
			nhanVienSearch.setMaNv(txtTKManv.getText());
			nhanVienSearch.setTenNv(txtTKTennv.getText());
			nhanVienSearch.setDiaChi(txtTKDiachi.getText());
			if (selectedItem != null) {
				nhanVienSearch.setGioiTinh(selectedItem.toString());
			}
			nhanVienSearch.setDienThoai(txtTKDienthoai.getText());
			nhanVienSearch.setSoCmnd(txtTKSocmnd.getText());
			nhanVienSearch.setChucVu(txtTKChucvu.getText());

			// Cập nhật bảng sau khi xóa
			layDanhSach(nhanVienSearch);

			// Xóa các thông tin chi tiết trên giao diện nếu cần thiết
			clearButton(); // Xóa thông tin chi tiết
		}
	}

	private void clearButton() {
		// Tạm thời vô hiệu hóa ListSelectionListener
		table.getSelectionModel().removeListSelectionListener(selectionListener);

		// Xóa nội dung các trường liên quan đến nhân viên
		txtManv.setText("");
		txtTennv.setText("");
		txtGioitinh.setSelectedItem("");
		txtDienthoai.setText("");
		txtDiachi.setText("");
		txtSocmnd.setText("");
		txtChucvu.setText("");
		txtMatkhau.setText("");

		// Xóa lựa chọn của bảng
		table.clearSelection();

		// Kích hoạt lại ListSelectionListener
		table.getSelectionModel().addListSelectionListener(selectionListener);
	}

}
