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

import Controller.ctlTkNhapKho;

import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.List;
import java.awt.event.ActionEvent;

import Database.DatabaseManager;
import Model.KhoReport;

public class frmXuatKhoReport extends JPanel {
	private JTextField txtMapn;
	private JTextField txtMasp;
	private JTextField txtToDate;
	private JTextField txtFromDate;
	private JTable table;
	private DefaultTableModel model;

	private ctlTkNhapKho controller;
	private JTextField txtManv;
	private JTextField txtMakho;

	public frmXuatKhoReport(DatabaseManager dbManager) {

		// Truyền dữ liệu vào Controller
		this.controller = new ctlTkNhapKho(dbManager.getDb()); // Pass db

		// Tạo Form
		createFormPanel();

		// Lấy danh sách
		layDanhSach("", "", "", "", null, null); // Cập nhật bảng

	}

	// Create the frame.
	private void createFormPanel() {
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(BorderFactory.createTitledBorder("Tìm kiếm:"));
		panel.setBounds(10, 70, 1114, 124);
		add(panel);

		JLabel lblFMapn = new JLabel("Mã phiếu xuất:");
		lblFMapn.setFont(new Font("Arial", Font.PLAIN, 14));
		lblFMapn.setBounds(10, 20, 116, 17);
		panel.add(lblFMapn);

		txtMapn = new JTextField();
		txtMapn.setFont(new Font("Arial", Font.PLAIN, 14));
		txtMapn.setColumns(10);
		txtMapn.setBounds(115, 18, 210, 20);
		panel.add(txtMapn);

		JLabel lblFTensp = new JLabel("Mã sản phẩm:");
		lblFTensp.setFont(new Font("Arial", Font.PLAIN, 14));
		lblFTensp.setBounds(10, 57, 134, 17);
		panel.add(lblFTensp);

		txtMasp = new JTextField();
		txtMasp.setFont(new Font("Arial", Font.PLAIN, 14));
		txtMasp.setColumns(10);
		txtMasp.setBounds(115, 55, 210, 20);
		panel.add(txtMasp);

		JLabel lblFTensp_1 = new JLabel("Thời gian:");
		lblFTensp_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblFTensp_1.setBounds(10, 94, 134, 17);
		panel.add(lblFTensp_1);

		JButton btnTimKiem = new JButton("Tìm");
		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadReportData();
			}
		});
		btnTimKiem.setFont(new Font("Arial", Font.PLAIN, 14));
		btnTimKiem.setBackground(Color.LIGHT_GRAY);
		btnTimKiem.setBounds(509, 92, 75, 21);
		panel.add(btnTimKiem);

		txtToDate = new JTextField();
		txtToDate.setFont(new Font("Arial", Font.PLAIN, 14));
		txtToDate.setColumns(10);
		txtToDate.setBounds(225, 94, 100, 20);
		panel.add(txtToDate);

		txtFromDate = new JTextField();
		txtFromDate.setFont(new Font("Arial", Font.PLAIN, 14));
		txtFromDate.setColumns(10);
		txtFromDate.setBounds(115, 94, 100, 20);
		panel.add(txtFromDate);

		JLabel lblFTensp_1_1 = new JLabel("-");
		lblFTensp_1_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblFTensp_1_1.setBounds(217, 94, 78, 17);
		panel.add(lblFTensp_1_1);

		txtManv = new JTextField();
		txtManv.setFont(new Font("Arial", Font.PLAIN, 14));
		txtManv.setColumns(10);
		txtManv.setBounds(509, 16, 210, 20);
		panel.add(txtManv);

		JLabel lblMNhnVin = new JLabel("Mã nhân viên:");
		lblMNhnVin.setFont(new Font("Arial", Font.PLAIN, 14));
		lblMNhnVin.setBounds(404, 22, 116, 17);
		panel.add(lblMNhnVin);

		JLabel lblFMasp_1 = new JLabel("Mã kho:");
		lblFMasp_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblFMasp_1.setBounds(404, 61, 116, 17);
		panel.add(lblFMasp_1);

		txtMakho = new JTextField();
		txtMakho.setFont(new Font("Arial", Font.PLAIN, 14));
		txtMakho.setColumns(10);
		txtMakho.setBounds(509, 52, 210, 20);
		panel.add(txtMakho);

		// Table list
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 204, 1114, 401);
		add(scrollPane);

		table = new JTable((TableModel) null);
		table.setRowHeight(25);
		table.setFont(new Font("Arial", Font.PLAIN, 14));

		String[] columnNames = { "Mã phiếu xuất", "Mã sản phẩm", "Tên sản phẩm", "Đơn giá", "Đơn vị tính", "Số lượng",
				"Thành tiền", "Mã nhân viên", "Ngày xuất", "Mã kho", "Tổng tiền" };
		model = new DefaultTableModel(columnNames, 0);
		table = new JTable(model);

		// Thay đổi kích thước và font chữ
		table.setFont(new Font("Arial", Font.PLAIN, 14)); // Font Arial, kích thước 14
		table.setRowHeight(25); // Chiều cao mỗi hàng

		scrollPane.setViewportView(table);

		JLabel lblBoCoChi = new JLabel("BÁO CÁO CHI TIẾT XUẤT KHO");
		lblBoCoChi.setFont(new Font("Arial", Font.PLAIN, 30));
		lblBoCoChi.setBounds(10, 10, 440, 49);
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

	private void layDanhSach(String Mapn, String Masp, String Manv, String Makho, Date fromDate, Date toDate) {
		// Lấy dữ liệu từ controller
		List<KhoReport> report = controller.getDataReport(Mapn, Masp, Manv, Makho, fromDate, toDate);

		// Xóa các hàng cũ trong bảng
		model.setRowCount(0);

		// Thêm các hàng mới vào bảng
		for (KhoReport object : report) {
			model.addRow(new Object[] { object.getMaPhieu(), object.getMaSp(), object.getTenSp(), object.getDonGia(),
					object.getDonViTinh(), object.getSoLuong(), object.getThanhTien(), object.getMaNv(),
					object.getNgay(), object.getMaKho(), object.getTongTien() });
		}
	}

	private void loadReportData() {

		String Mapn = txtMapn.getText();
		String Masp = txtMasp.getText();
		String Manv = txtManv.getText();
		String Makho = txtMakho.getText();
		Date fromDate = parseDate(txtFromDate.getText());
		Date toDate = parseDate(txtToDate.getText());

		layDanhSach(Mapn, Masp, Manv, Makho, fromDate, toDate); // Cập nhật bảng

	}

	private Date parseDate(String dateStr) {
		try {
			return Date.valueOf(dateStr); // Requires format "yyyy-MM-dd"
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return null; // Return null or handle the error as needed
		}
	}
}
