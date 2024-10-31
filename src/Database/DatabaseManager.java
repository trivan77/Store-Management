package Database;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

import Model.*;

public class DatabaseManager {
	private ObjectContainer db;
	public static final String DB_NAME = "QuanLyKhoDB.db4o";

	public DatabaseManager() {
		db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), DB_NAME);
	}

	public ObjectContainer getDb() {
		return db;
	}

	public void closeDB() {
		if (db != null) {
			db.close();
			System.out.println("Database closed successfully.");
		}
	}

	public void initializeSampleData() {

		// Kiểm tra xem có dữ liệu Nhân viên không
		ObjectSet<NhanVien> nhanVien = db.query(NhanVien.class);
		if (nhanVien.size() == 0) {
			// Thêm dữ liệu Nhân viên
			db.store(new NhanVien("admin", "Nguyễn Văn A", "Nam", "0123456789", "Hà Nội", "1234567890", "Trưởng phòng",
					"admin"));
			db.store(new NhanVien("A00001", "Nguyễn Văn A", "Nam", "0123456789", "Hà Nội", "1234567890", "Trưởng phòng",
					"123456"));
			db.store(new NhanVien("A00002", "Nguyễn Văn B", "Nam", "0123456789", "Hà Nội", "1234567890", "Nhân viên",
					"123456"));
			db.store(new NhanVien("A00003", "Nguyễn Văn C", "Nam", "0123456789", "Hà Nội", "1234567890", "Nhân viên",
					"123456"));
			db.store(new NhanVien("A00004", "Nguyễn Văn D", "Nam", "0123456789", "Hà Nội", "1234567890", "Nhân viên",
					"123456"));
			db.store(new NhanVien("A00005", "Nguyễn Văn E", "Nam", "0123456789", "Hà Nội", "1234567890", "Nhân viên",
					"123456"));
		}

		// Kiểm tra xem có dữ liệu LoaiSanPham
		ObjectSet<LoaiSanPham> loaiSanPham = db.query(LoaiSanPham.class);
		if (loaiSanPham.size() == 0) {
			// Thêm dữ liệu LoaiSanPham
			db.store(new LoaiSanPham("LSP001", "Ngắn hạn", "Sản phẩm yêu dùng ngắn hạn"));
			db.store(new LoaiSanPham("LSP002", "Dài hạn", "Sản phẩm tiêu dùng dài hạn"));
		}

		// Kiểm tra xem có dữ liệu SanPham
		ObjectSet<SanPham> sanPham = db.query(SanPham.class);
		if (sanPham.size() == 0) {
			// Thêm dữ liệu SanPham
			db.store(new SanPham("SP001", "Sản phẩm 01", 10, "KG", "LSP001"));
			db.store(new SanPham("SP002", "Sản phẩm 02", 20, "KG", "LSP002"));
		}

		// Kiểm tra xem có dữ liệu Kho
		ObjectSet<Kho> kho = db.query(Kho.class);
		if (kho.size() == 0) {
			// Thêm dữ liệu Kho
			db.store(new Kho("Kho001", "Kho 001", "LSP001"));
			db.store(new Kho("Kho002", "Kho 002", "LSP001"));
		}

	}
}
