package Database;

import java.util.Date;

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

		// Kiểm tra xem có dữ liệu PhieuNhap
		ObjectSet<PhieuNhap> phieuNhap = db.query(PhieuNhap.class);
		if (phieuNhap.size() == 0) {
			// Thêm dữ liệu Kho
			db.store(new PhieuNhap("PN001", "A00001", new Date(), "Kho001", 20));
			db.store(new PhieuNhap("PN002", "A00002", new Date(), "Kho002", 20));
		}

		// Kiểm tra xem có dữ liệu ChiTietPhieuNhap
		ObjectSet<ChiTietPhieuNhap> chiTietPhieuNhap = db.query(ChiTietPhieuNhap.class);
		if (chiTietPhieuNhap.size() == 0) {
			// Thêm dữ liệu Kho
			db.store(new ChiTietPhieuNhap("PN001", "SP001", "Sản phẩm 1", 10, "Cái", 1));
			db.store(new ChiTietPhieuNhap("PN002", "SP002", "Sản phẩm 2", 10, "Cái", 1));
		}

		// Kiểm tra xem có dữ liệu PhieuXuat
		ObjectSet<PhieuXuat> phieuXuat = db.query(PhieuXuat.class);
		if (phieuXuat.size() == 0) {
			// Thêm dữ liệu Kho
			db.store(new PhieuXuat("PN001", "A00001", new Date(), "Kho001", 20));
			db.store(new PhieuXuat("PN002", "A00002", new Date(), "Kho002", 20));
		}

		// Kiểm tra xem có dữ liệu ChiTietPhieuXuat
		ObjectSet<ChiTietPhieuXuat> chiTietPhieuXuat = db.query(ChiTietPhieuXuat.class);
		if (chiTietPhieuXuat.size() == 0) {
			// Thêm dữ liệu Kho
			db.store(new ChiTietPhieuXuat("PN001", "SP001", "Sản phẩm 1", 10, "Cái", 1));
			db.store(new ChiTietPhieuXuat("PN002", "SP002", "Sản phẩm 2", 10, "Cái", 1));
		}

		// Kiểm tra xem có dữ liệu PhieuDieuChuyen
		ObjectSet<PhieuDieuChuyen> phieuDieuChuyen = db.query(PhieuDieuChuyen.class);
		if (phieuDieuChuyen.size() == 0) {
			// Thêm dữ liệu Kho
			db.store(new PhieuDieuChuyen("DC001", "A00001", "A00002", new Date(), "Kho001", "Kho002", 100000));
			db.store(new PhieuDieuChuyen("DC002", "A00002", "A00003", new Date(), "Kho002", "Kho003", 150000));
			db.store(new PhieuDieuChuyen("DC003", "A00001", "A00003", new Date(), "Kho001", "Kho003", 200000));
			db.store(new PhieuDieuChuyen("DC004", "A00003", "A00001", new Date(), "Kho003", "Kho001", 300000));
			db.store(new PhieuDieuChuyen("DC005", "A00002", "A00001", new Date(), "Kho002", "Kho001", 250000));
		}

		// Kiểm tra xem có dữ liệu ChiTietPhieuDieuChuyen
		ObjectSet<ChiTietPhieuDieuChuyen> chiTietPhieuDieuChuyen = db.query(ChiTietPhieuDieuChuyen.class);
		if (chiTietPhieuDieuChuyen.size() == 0) {
			// Thêm dữ liệu Kho
			db.store(new ChiTietPhieuDieuChuyen("DC001", "SP001", "Sản phẩm A", 10000, "Cái", 5));
			db.store(new ChiTietPhieuDieuChuyen("DC001", "SP002", "Sản phẩm B", 15000, "Cái", 3));
			db.store(new ChiTietPhieuDieuChuyen("DC002", "SP003", "Sản phẩm C", 20000, "Cái", 4));
			db.store(new ChiTietPhieuDieuChuyen("DC002", "SP004", "Sản phẩm D", 25000, "Cái", 2));
			db.store(new ChiTietPhieuDieuChuyen("DC003", "SP001", "Sản phẩm A", 10000, "Cái", 10));
		}

	}
}
