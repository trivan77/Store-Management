package View;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Database.DatabaseManager;
import View.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainFrame extends JFrame {

	private JPanel contentPane;

	private JPanel frmTrangChu;
	private JPanel frmNhanVien;
	private JPanel frmLoaiSanPham;
	private JPanel frmSanPham;
	private JPanel frmKho;
	private JPanel frmNhapKho;
	private JPanel frmXuatKho;
	private JPanel frmChuyenKho;

	public MainFrame(DatabaseManager dbManager, String username) {
		
		// Thiết lập Title cho screen
		setTitle("Quản lý Kho hàng");

		// Thiết lập kích thước cho screen
		setSize(1280, 720);

		// Thiết lập khi tắt screen
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Thiết lập vị trí screen: ở giữa screen
		setLocationRelativeTo(null);

		// setBounds(100, 100, 450, 300);
		contentPane = new JPanel(new CardLayout());
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		// Thêm WindowListener để xử lý sự kiện nhấn nút "X"
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dbManager.closeDB(); // Đóng cơ sở dữ liệu trước khi thoát
				System.out.println("Database closed before exit.");
			}
		});

		// Thanh menu
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		// Trang chủ
		JMenu mnTrangChu = new JMenu("Trang chủ");
		mnTrangChu.setForeground(Color.BLACK);
		mnTrangChu.setFont(new Font("Arial", Font.PLAIN, 14));
		menuBar.add(mnTrangChu);

		// Quản lý
		JMenu mnQuanLy = new JMenu("Quản lý");
		mnQuanLy.setForeground(Color.BLACK);
		mnQuanLy.setFont(new Font("Arial", Font.PLAIN, 14));
		menuBar.add(mnQuanLy);

		JMenuItem mnNhanVien = new JMenuItem("Nhân viên");
		mnNhanVien.setForeground(Color.BLACK);
		mnNhanVien.setFont(new Font("Arial", Font.PLAIN, 14));
		mnQuanLy.add(mnNhanVien);

		JMenuItem mnLoaiSanPham = new JMenuItem("Loại sản phẩm");
		mnLoaiSanPham.setForeground(Color.BLACK);
		mnLoaiSanPham.setFont(new Font("Arial", Font.PLAIN, 14));
		mnQuanLy.add(mnLoaiSanPham);

		JMenuItem mnSanPham = new JMenuItem("Sản phẩm");
		mnSanPham.setForeground(Color.BLACK);
		mnSanPham.setFont(new Font("Arial", Font.PLAIN, 14));
		mnQuanLy.add(mnSanPham);

		JMenuItem mnKho = new JMenuItem("Kho");
		mnKho.setForeground(Color.BLACK);
		mnKho.setFont(new Font("Arial", Font.PLAIN, 14));
		mnQuanLy.add(mnKho);

		// Chức năng
		JMenu mnChucNang = new JMenu("Chức năng");
		mnChucNang.setForeground(Color.BLACK);
		mnChucNang.setFont(new Font("Arial", Font.PLAIN, 14));
		menuBar.add(mnChucNang);

		JMenuItem mnXuatKho = new JMenuItem("Xuất kho");
		mnXuatKho.setForeground(Color.BLACK);
		mnXuatKho.setFont(new Font("Arial", Font.PLAIN, 14));
		mnChucNang.add(mnXuatKho);

		JMenuItem mnNhapKho = new JMenuItem("Nhập kho");
		mnNhapKho.setForeground(Color.BLACK);
		mnNhapKho.setFont(new Font("Arial", Font.PLAIN, 14));
		mnChucNang.add(mnNhapKho);

		JMenuItem mnChuyenKho = new JMenuItem("Chuyển kho");
		mnChuyenKho.setForeground(Color.BLACK);
		mnChuyenKho.setFont(new Font("Arial", Font.PLAIN, 14));
		mnChucNang.add(mnChuyenKho);

		// Thống kê
		JMenu mnThongke = new JMenu("Thống kê");
		mnThongke.setForeground(Color.BLACK);
		mnThongke.setFont(new Font("Arial", Font.PLAIN, 14));
		menuBar.add(mnThongke);

		// Khởi tạo các frame con
		frmTrangChu = new frmTrangChu(dbManager, username);
		frmNhanVien = new frmNhanVien(dbManager);
		frmLoaiSanPham = new frmLoaiSanPham(dbManager);
		frmSanPham = new frmSanPham(dbManager);
		frmKho = new frmKho(dbManager);
		frmNhapKho = new frmNhapKho(dbManager);
		frmXuatKho = new frmXuatKho(dbManager);
		frmChuyenKho = new frmChuyenKho(dbManager);

		// Thêm các frame vào contentPane với tên cụ thể
		contentPane.add(frmTrangChu, "frmTrangChu");
		contentPane.add(frmNhanVien, "frmNhanVien");
		contentPane.add(frmLoaiSanPham, "frmLoaiSanPham");
		contentPane.add(frmSanPham, "frmSanPham");
		contentPane.add(frmKho, "frmKho");
		contentPane.add(frmNhapKho, "frmNhapKho");
		contentPane.add(frmXuatKho, "frmXuatKho");
		contentPane.add(frmChuyenKho, "frmChuyenKho");

		// Đặt lệnh gọi showPanel khi menu được chọn
		mnTrangChu.addMenuListener(new MenuListenerAdapter(() -> showPanel("frmTrangChu")));
		mnNhanVien.addActionListener(e -> showPanel("frmNhanVien"));
		mnLoaiSanPham.addActionListener(e -> showPanel("frmLoaiSanPham"));
		mnSanPham.addActionListener(e -> showPanel("frmSanPham"));
		mnKho.addActionListener(e -> showPanel("frmKho"));
		mnNhapKho.addActionListener(e -> showPanel("frmNhapKho"));
		mnXuatKho.addActionListener(e -> showPanel("frmXuatKho"));
		mnChuyenKho.addActionListener(e -> showPanel("frmChuyenKho"));

		// Thêm contentPane vào MainFrame
		add(contentPane);

	}

	private void showPanel(String panelName) {

		CardLayout cl = (CardLayout) (contentPane.getLayout());
		cl.show(contentPane, panelName);

	}
	
    // Lớp adapter cho MenuListener để xử lý sự kiện chọn menu
    private static class MenuListenerAdapter implements javax.swing.event.MenuListener {
        private final Runnable action;

        public MenuListenerAdapter(Runnable action) {
            this.action = action;
        }

        @Override
        public void menuSelected(javax.swing.event.MenuEvent e) {
            action.run();
        }

        @Override
        public void menuDeselected(javax.swing.event.MenuEvent e) { }

        @Override
        public void menuCanceled(javax.swing.event.MenuEvent e) { }
    }
}
