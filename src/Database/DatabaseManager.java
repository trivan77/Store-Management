package Database;

import java.io.File;
import java.util.Date;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

import Model.*;

public class DatabaseManager {
	private ObjectContainer db;
	public static final String DB_NAME = "QuanLyKhoDB.db4o";

	public DatabaseManager() {
		File file = new File(DB_NAME);
		if (file.exists())
			file.delete();

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
			db.store(new SanPham("SP002", "Sản phẩm 02", 10, "KG", "LSP002"));
			db.store(new SanPham("SP003", "Sản phẩm 03", 10, "KG", "LSP001"));
			db.store(new SanPham("SP004", "Sản phẩm 04", 10, "KG", "LSP002"));
			db.store(new SanPham("SP005", "Sản phẩm 05", 10, "KG", "LSP001"));
		}

		// Kiểm tra xem có dữ liệu Kho
		ObjectSet<Kho> kho = db.query(Kho.class);
		if (kho.size() == 0) {
			// Thêm dữ liệu Kho
			db.store(new Kho("KHO001", "Kho 001", "LSP001"));
			db.store(new Kho("KHO002", "Kho 002", "LSP001"));
		}

		// Kiểm tra xem có dữ liệu PhieuNhap
		ObjectSet<PhieuNhap> phieuNhap = db.query(PhieuNhap.class);
		if (phieuNhap.size() == 0) {
			// Thêm dữ liệu Kho
			db.store(new PhieuNhap("PN001", "A00001", new Date(), "KHO001", 500));
			db.store(new PhieuNhap("PN002", "A00002", new Date(), "KHO002", 20));
		}

		// Kiểm tra xem có dữ liệu ChiTietPhieuNhap
		ObjectSet<ChiTietPhieuNhap> chiTietPhieuNhap = db.query(ChiTietPhieuNhap.class);
		if (chiTietPhieuNhap.size() == 0) {
			// Thêm dữ liệu Kho
			db.store(new ChiTietPhieuNhap("PN001", "SP001", "Sản phẩm 1", 10, "Cái", 10));
			db.store(new ChiTietPhieuNhap("PN001", "SP002", "Sản phẩm 2", 10, "Cái", 10));
			db.store(new ChiTietPhieuNhap("PN001", "SP003", "Sản phẩm 3", 10, "Cái", 10));
			db.store(new ChiTietPhieuNhap("PN001", "SP004", "Sản phẩm 4", 10, "Cái", 10));
			db.store(new ChiTietPhieuNhap("PN001", "SP005", "Sản phẩm 5", 10, "Cái", 10));
		}

		// Kiểm tra xem có dữ liệu PhieuXuat
		ObjectSet<PhieuXuat> phieuXuat = db.query(PhieuXuat.class);
		if (phieuXuat.size() == 0) {
			// Thêm dữ liệu Kho
			db.store(new PhieuXuat("PN001", "A00001", new Date(), "KHO001", 50));
			db.store(new PhieuXuat("PN002", "A00002", new Date(), "KHO002", 20));
		}

		// Kiểm tra xem có dữ liệu ChiTietPhieuXuat
		ObjectSet<ChiTietPhieuXuat> chiTietPhieuXuat = db.query(ChiTietPhieuXuat.class);
		if (chiTietPhieuXuat.size() == 0) {
			// Thêm dữ liệu Kho
			db.store(new ChiTietPhieuNhap("PN001", "SP001", "Sản phẩm 1", 10, "Cái", 1));
			db.store(new ChiTietPhieuNhap("PN001", "SP002", "Sản phẩm 2", 10, "Cái", 1));
			db.store(new ChiTietPhieuNhap("PN001", "SP003", "Sản phẩm 3", 10, "Cái", 1));
			db.store(new ChiTietPhieuNhap("PN001", "SP004", "Sản phẩm 4", 10, "Cái", 1));
			db.store(new ChiTietPhieuNhap("PN001", "SP005", "Sản phẩm 5", 10, "Cái", 1));
		}

		// Kiểm tra xem có dữ liệu PhieuDieuChuyen
		ObjectSet<PhieuDieuChuyen> phieuDieuChuyen = db.query(PhieuDieuChuyen.class);
		if (phieuDieuChuyen.size() == 0) {
			// Thêm dữ liệu Kho
			db.store(new PhieuDieuChuyen("DC001", "A00001", "A00002", new Date(), "KHO001", "KHO002", 10));
			db.store(new PhieuDieuChuyen("DC002", "A00002", "A00003", new Date(), "KHO001", "KHO002", 10));
		}

		// Kiểm tra xem có dữ liệu ChiTietPhieuDieuChuyen
		ObjectSet<ChiTietPhieuDieuChuyen> chiTietPhieuDieuChuyen = db.query(ChiTietPhieuDieuChuyen.class);
		if (chiTietPhieuDieuChuyen.size() == 0) {
			// Thêm dữ liệu Kho
			db.store(new ChiTietPhieuDieuChuyen("DC001", "SP001", "Sản phẩm A", 10, "Cái", 1));
			db.store(new ChiTietPhieuDieuChuyen("DC001", "SP002", "Sản phẩm B", 10, "Cái", 1));
		}

		// Kiểm tra xem có dữ liệu ChiTietSanPham
		ObjectSet<ChiTietSanPham> chiTietSanPham = db.query(ChiTietSanPham.class);
		if (chiTietSanPham.size() == 0) {
			// Thêm dữ liệu ChiTietSanPham
			db.store(new ChiTietSanPham("SP001", "Sản phẩm 01", "KHO001", "Kho 001", 8));
			db.store(new ChiTietSanPham("SP002", "Sản phẩm 02", "KHO001", "Kho 001", 8));
			db.store(new ChiTietSanPham("SP003", "Sản phẩm 03", "KHO001", "Kho 001", 9));
			db.store(new ChiTietSanPham("SP004", "Sản phẩm 04", "KHO001", "Kho 001", 9));
			db.store(new ChiTietSanPham("SP005", "Sản phẩm 05", "KHO001", "Kho 001", 9));
			db.store(new ChiTietSanPham("SP001", "Sản phẩm 01", "KHO002", "Kho 002", 1));
			db.store(new ChiTietSanPham("SP002", "Sản phẩm 02", "KHO002", "Kho 002", 1));
		}

	}
}
