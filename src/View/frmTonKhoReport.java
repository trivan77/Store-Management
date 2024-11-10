package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.List;
import java.awt.event.ActionEvent;

import Controller.ctlTkTonKho;
import Database.DatabaseManager;
import Model.ChiTietSanPham;

public class frmTonKhoReport extends JPanel {
	private JTextField txtMasp;
	private JTable table;
	private DefaultTableModel model;

	private ctlTkTonKho controller;
	private JTextField txtMakho;

	public frmTonKhoReport(DatabaseManager dbManager) {

		// Truyền dữ liệu vào Controller
		this.controller = new ctlTkTonKho(dbManager.getDb()); // Pass db

		// Tạo Form
		createFormPanel();

		// Lấy danh sách
		layDanhSach("", ""); // Cập nhật bảng

	}

	// Create the frame.
	private void createFormPanel() {
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(BorderFactory.createTitledBorder("Tìm kiếm:"));
		panel.setBounds(10, 70, 1114, 96);
		add(panel);

		JLabel lblFTensp = new JLabel("Mã sản phẩm:");
		lblFTensp.setFont(new Font("Arial", Font.PLAIN, 14));
		lblFTensp.setBounds(10, 30, 134, 17);
		panel.add(lblFTensp);

		txtMasp = new JTextField();
		txtMasp.setFont(new Font("Arial", Font.PLAIN, 14));
		txtMasp.setColumns(10);
		txtMasp.setBounds(125, 28, 210, 20);
		panel.add(txtMasp);

		JButton btnTimKiem = new JButton("Tìm");
		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadReportData();
			}
		});
		btnTimKiem.setFont(new Font("Arial", Font.PLAIN, 14));
		btnTimKiem.setBackground(Color.LIGHT_GRAY);
		btnTimKiem.setBounds(509, 65, 75, 21);
		panel.add(btnTimKiem);

		JLabel lblFMasp_1 = new JLabel("Mã kho:");
		lblFMasp_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblFMasp_1.setBounds(394, 30, 116, 17);
		panel.add(lblFMasp_1);

		txtMakho = new JTextField();
		txtMakho.setFont(new Font("Arial", Font.PLAIN, 14));
		txtMakho.setColumns(10);
		txtMakho.setBounds(509, 28, 210, 20);
		panel.add(txtMakho);

		// Table list
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 164, 1114, 441);
		add(scrollPane);

		table = new JTable((TableModel) null);
		table.setRowHeight(25);
		table.setFont(new Font("Arial", Font.PLAIN, 14));

		String[] columnNames = { "Mã sản phẩm", "Tên sản phẩm", "Mã kho", "Tên kho", "Số lượng" };
		model = new DefaultTableModel(columnNames, 0);
		table = new JTable(model);

		// Thay đổi kích thước và font chữ
		table.setFont(new Font("Arial", Font.PLAIN, 14)); // Font Arial, kích thước 14
		table.setRowHeight(25); // Chiều cao mỗi hàng

		scrollPane.setViewportView(table);

		JLabel lblBoCoChi = new JLabel("BÁO CÁO CHI TIẾT SẢN PHẨM");
		lblBoCoChi.setFont(new Font("Arial", Font.PLAIN, 30));
		lblBoCoChi.setBounds(10, 10, 684, 49);
		add(lblBoCoChi);

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

	}

	private void layDanhSach(String maSp, String maKho) {
		// Lấy dữ liệu từ controller
		List<ChiTietSanPham> report = controller.getDataReport(maSp, maKho);

		// Xóa các hàng cũ trong bảng
		model.setRowCount(0);

		// Thêm các hàng mới vào bảng
		for (ChiTietSanPham object : report) {
			model.addRow(new Object[] { object.getMaSp(), object.getTenSp(), object.getMaKho(), object.getTenKho(), object.getSoLuong() });
		}
	}

	private void loadReportData() {

		String Masp = txtMasp.getText();
		String Makho = txtMakho.getText();

		layDanhSach(Masp, Makho); // Cập nhật bảng

	}
}
