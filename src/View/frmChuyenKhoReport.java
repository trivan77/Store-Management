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

import Controller.ctlTkChuyenKho;
import Controller.ctlTkNhapKho;

import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.List;
import java.awt.event.ActionEvent;

import Database.DatabaseManager;
import Model.KhoReport;

public class frmChuyenKhoReport extends JPanel {
	private JTextField txtMapn;
	private JTextField txtMasp;
	private JTextField txtToDate;
	private JTextField txtFromDate;
	private JTable table;
	private DefaultTableModel model;

	private ctlTkChuyenKho controller;
	private JTextField txtManvdi;
	private JTextField txtMakhodi;
	private JTextField txtMakhoden;
	private JTextField txtManvden;

	public frmChuyenKhoReport(DatabaseManager dbManager) {

		// Truyền dữ liệu vào Controller
		this.controller = new ctlTkChuyenKho(dbManager.getDb()); // Pass db

		// Tạo Form
		createFormPanel();

		// Lấy danh sách
		layDanhSach(null, null, null, null, null, null, null, null); // Cập nhật bảng
	}

	// Create the frame.
	private void createFormPanel() {
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(BorderFactory.createTitledBorder("Tìm kiếm:"));
		panel.setBounds(10, 70, 1114, 124);
		add(panel);

		JLabel lblFMapn = new JLabel("Mã phiếu DC");
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
		btnTimKiem.setBounds(522, 92, 75, 21);
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

		txtManvdi = new JTextField();
		txtManvdi.setFont(new Font("Arial", Font.PLAIN, 14));
		txtManvdi.setColumns(10);
		txtManvdi.setBounds(522, 18, 210, 20);
		panel.add(txtManvdi);

		JLabel lblMNhnVin = new JLabel("Mã nhân viên đi:");
		lblMNhnVin.setFont(new Font("Arial", Font.PLAIN, 14));
		lblMNhnVin.setBounds(379, 20, 116, 17);
		panel.add(lblMNhnVin);

		JLabel lblFMasp_1 = new JLabel("Mã kho đi:");
		lblFMasp_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblFMasp_1.setBounds(789, 22, 116, 17);
		panel.add(lblFMasp_1);

		txtMakhodi = new JTextField();
		txtMakhodi.setFont(new Font("Arial", Font.PLAIN, 14));
		txtMakhodi.setColumns(10);
		txtMakhodi.setBounds(894, 20, 210, 20);
		panel.add(txtMakhodi);

		txtMakhoden = new JTextField();
		txtMakhoden.setFont(new Font("Arial", Font.PLAIN, 14));
		txtMakhoden.setColumns(10);
		txtMakhoden.setBounds(894, 55, 210, 20);
		panel.add(txtMakhoden);

		JLabel lblFMasp_1_1 = new JLabel("Mã kho đến:");
		lblFMasp_1_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblFMasp_1_1.setBounds(789, 58, 116, 17);
		panel.add(lblFMasp_1_1);

		JLabel lblMNhnVin_2 = new JLabel("Mã nhân viên đến:");
		lblMNhnVin_2.setFont(new Font("Arial", Font.PLAIN, 14));
		lblMNhnVin_2.setBounds(380, 57, 140, 17);
		panel.add(lblMNhnVin_2);

		txtManvden = new JTextField();
		txtManvden.setFont(new Font("Arial", Font.PLAIN, 14));
		txtManvden.setColumns(10);
		txtManvden.setBounds(522, 55, 210, 20);
		panel.add(txtManvden);

		// Table list
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 204, 1114, 401);
		add(scrollPane);

		table = new JTable((TableModel) null);
		table.setRowHeight(25);
		table.setFont(new Font("Arial", Font.PLAIN, 14));

		String[] columnNames = { "Mã phiếu DC", "Mã sản phẩm", "Tên sản phẩm", "Đơn giá", "Đơn vị tính", "Số lượng",
				"Thành tiền", "Mã nhân viên đi", "Mã nhân viên đến", "Ngày xuất", "Mã kho đi", "Mã kho đến",
				"Tổng tiền" };
		model = new DefaultTableModel(columnNames, 0);
		table = new JTable(model);

		// Thay đổi kích thước và font chữ
		table.setFont(new Font("Arial", Font.PLAIN, 14)); // Font Arial, kích thước 14
		table.setRowHeight(25); // Chiều cao mỗi hàng

		scrollPane.setViewportView(table);

		JLabel lblBoCoChi = new JLabel("BÁO CÁO CHI TIẾT ĐIỀU CHUYỂN KHO");
		lblBoCoChi.setFont(new Font("Arial", Font.PLAIN, 30));
		lblBoCoChi.setBounds(10, 10, 759, 49);
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

	private void layDanhSach(String Mapn, String Masp, String Manvdi, String Manvden, String Makhodi, String Makhoden,
			Date fromDate, Date toDate) {
		// Lấy dữ liệu từ controller
		List<KhoReport> report = controller.getDataReport(Mapn, Masp, Manvdi, Manvden, Makhodi, Makhoden, fromDate,
				toDate);

		// Xóa các hàng cũ trong bảng
		model.setRowCount(0);

		// Thêm các hàng mới vào bảng
		for (KhoReport object : report) {
			model.addRow(new Object[] { object.getMaphieu(), object.getMasp(), object.getTensp(), object.getDongia(),
					object.getDonvitinh(), object.getSoluong(), object.getThanhtien(), object.getManvdi(),
					object.getManvden(), object.getNgay(), object.getMakhodi(), object.getMakhoden(),
					object.getTongtien() });
		}
	}

	private void loadReportData() {

		String Mapn = txtMapn.getText();
		String Masp = txtMasp.getText();
		String Manvdi = txtManvdi.getText();
		String Manvden = txtManvden.getText();
		String Makhodi = txtMakhodi.getText();
		String Makhoden = txtMakhoden.getText();
		Date fromDate = parseDate(txtFromDate.getText());
		Date toDate = parseDate(txtToDate.getText());

		layDanhSach(Mapn, Masp, Manvdi, Manvden, Makhodi, Makhoden, fromDate, toDate); // Cập nhật bảng

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
