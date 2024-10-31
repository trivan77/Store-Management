package Main;

import javax.swing.SwingUtilities;

import Database.DatabaseManager;
import View.*;

public class Main {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {

			DatabaseManager dbManager = new DatabaseManager();
			dbManager.initializeSampleData(); // Gọi phương thức khởi tạo dữ liệu mẫu

			// Gọi screen Đăng nhập
			// frmDangNhap frame = new frmDangNhap(dbManager);

			// Gọi screen Đăng nhập
			MainFrame frame = new MainFrame(dbManager, "admin");

			frame.setVisible(true);
		});
	}
}
