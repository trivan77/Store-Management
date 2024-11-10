package Controller;

import com.db4o.*;
import com.db4o.query.*;

import Model.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ctlTkTonKho {
	private ObjectContainer db;

	public ctlTkTonKho(ObjectContainer db) {
		this.db = db;
	}

	public List<ChiTietSanPham> getDataReport(String maSp, String maKho) {
		// Thực hiện truy vấn để lấy dữ liệu từ ChiTietSanPham
		List<ChiTietSanPham> listReport = new ArrayList<>();
		List<ChiTietSanPham> listChiTietSanPham = getChiTietSanPham(maSp, maKho);

		/*
		 * for (ChiTietSanPham chiTietSanPham : listChiTietSanPham) { // Lấy tên sản
		 * phẩm từ bảng SanPham List<SanPham> listSanPham =
		 * getSanPham(chiTietSanPham.getMaSp()); String tenSp = listSanPham.isEmpty() ?
		 * null : listSanPham.get(0).getTenSp();
		 * 
		 * // Lấy tên kho từ bảng Kho List<Kho> listKho =
		 * getKho(chiTietSanPham.getMaKho()); String tenKho = listKho.isEmpty() ? null :
		 * listKho.get(0).getTenKho();
		 * 
		 * // Tạo đối tượng KhoReport và thêm vào danh sách ChiTietSanPham record = new
		 * ChiTietSanPham(chiTietSanPham.getMaSp(), tenSp, chiTietSanPham.getMaKho(),
		 * tenKho, chiTietSanPham.getSoLuong()); listReport.add(record); }
		 */

		return listReport;
	}

	// Phương thức lấy ChiTietSanPham
	public List<ChiTietSanPham> getChiTietSanPham(String maSp, String maKho) {
		List<ChiTietSanPham> listResult = new ArrayList<>();

		Query query = db.query();
		query.constrain(ChiTietSanPham.class);

		if (maSp != null && !maSp.isEmpty()) {
			query.descend("maSp").constrain(maSp);
		}
		if (maKho != null && !maKho.isEmpty()) {
			query.descend("maKho").constrain(maKho);
		}

		try {
			ObjectSet<ChiTietSanPham> result = query.execute();
			while (result.hasNext()) {
				listResult.add(result.next());
			}
		} catch (Exception e) {
			System.err.println("Lỗi khi thực hiện truy vấn ChiTietSanPham: " + e.getMessage());
			e.printStackTrace();
		}

		listResult.sort(Comparator.comparing(ChiTietSanPham::getMaSp).thenComparing(ChiTietSanPham::getMaKho));
		return listResult;
	}

	// Phương thức lấy SanPham
	public List<SanPham> getSanPham(String maSp) {
		List<SanPham> listResult = new ArrayList<>();

		Query query = db.query();
		query.constrain(SanPham.class);

		if (maSp != null && !maSp.isEmpty()) {
			query.descend("maSp").constrain(maSp);
		}

		try {
			ObjectSet<SanPham> result = query.execute();
			while (result.hasNext()) {
				listResult.add(result.next());
			}
		} catch (Exception e) {
			System.err.println("Lỗi khi thực hiện truy vấn SanPham: " + e.getMessage());
			e.printStackTrace();
		}

		return listResult;
	}

	// Phương thức lấy Kho
	public List<Kho> getKho(String maKho) {
		List<Kho> listResult = new ArrayList<>();

		Query query = db.query();
		query.constrain(Kho.class);

		if (maKho != null && !maKho.isEmpty()) {
			query.descend("maKho").constrain(maKho);
		}

		try {
			ObjectSet<Kho> result = query.execute();
			while (result.hasNext()) {
				listResult.add(result.next());
			}
		} catch (Exception e) {
			System.err.println("Lỗi khi thực hiện truy vấn Kho: " + e.getMessage());
			e.printStackTrace();
		}

		return listResult;
	}
}
