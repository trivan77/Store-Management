package Controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;

import Model.*;

public class ctlLayDanhSachPhieu {

	private ObjectContainer db;

	public ctlLayDanhSachPhieu(ObjectContainer db) {
		this.db = db;
	}

	// Kho
	public List<Kho> getKho(String Makho, String Tenkho) {
		List<Kho> listResult = new ArrayList<>();
		// Tạo truy vấn SODA
		Query query = db.query();
		query.constrain(Kho.class);

		// Thêm điều kiện
		if (Makho != null && !Makho.isEmpty()) {
			query.descend("Makho").constrain(Makho);
		}

		if (Tenkho != null && !Tenkho.isEmpty()) {
			query.descend("Tenkho").constrain(Tenkho);
		}

		// Thực hiện truy vấn
		try {
			ObjectSet<Kho> result = query.execute();
			// Lưu kết quả vào danh sách
			while (result.hasNext()) {
				listResult.add(result.next());
			}
		} catch (Exception e) {
			System.err.println("Lỗi khi thực hiện truy vấn: " + e.getMessage());
			e.printStackTrace(); // In chi tiết lỗi để dễ dàng debug
		}

		return listResult;
	}

	// SanPham
	public List<SanPham> getSanPham(String Masp, String Tensp) {
		List<SanPham> listResult = new ArrayList<>();

		// Tạo truy vấn SODA
		Query query = db.query();
		query.constrain(SanPham.class);

		// Thêm điều kiện
		if (Masp != null && !Masp.isEmpty()) {
			query.descend("Masp").constrain(Masp);
		}

		if (Tensp != null && !Tensp.isEmpty()) {
			query.descend("Tensp").constrain(Tensp);
		}

		// Thực hiện truy vấn
		try {
			ObjectSet<SanPham> result = query.execute();
			// Lưu kết quả vào danh sách
			while (result.hasNext()) {
				listResult.add(result.next());
			}
		} catch (Exception e) {
			System.err.println("Lỗi khi thực hiện truy vấn: " + e.getMessage());
			e.printStackTrace(); // In chi tiết lỗi để dễ dàng debug
		}

		return listResult;
	}

	

	// PhieuXuat
	public List<PhieuXuat> getPhieuXuat(String Mapx, String Makho, String Manv, Date fromDate, Date toDate) {
		List<PhieuXuat> listResult = new ArrayList<>();

		// Tạo truy vấn SODA
		Query query = db.query();
		query.constrain(PhieuXuat.class);

		// Thêm điều kiện
		if (Mapx != null && !Mapx.isEmpty()) {
			query.descend("Mapx").constrain(Mapx);
		}

		if (Makho != null && !Makho.isEmpty()) {
			query.descend("Makho").constrain(Makho);
		}

		if (Manv != null && !Manv.isEmpty()) {
			query.descend("Manv").constrain(Manv);
		}

		if (fromDate != null) {
			query.descend("Ngayxuat").constrain(fromDate).greater(); // Ngày lớn hơn hoặc bằng fromDate
		}

		if (toDate != null) {
			query.descend("Ngayxuat").constrain(toDate).smaller(); // Ngày nhỏ hơn hoặc bằng toDate
		}

		// Thực hiện truy vấn
		try {
			ObjectSet<PhieuXuat> result = query.execute();
			// Lưu kết quả vào danh sách
			while (result.hasNext()) {
				listResult.add(result.next());
			}
		} catch (Exception e) {
			System.err.println("Lỗi khi thực hiện truy vấn: " + e.getMessage());
			e.printStackTrace(); // In chi tiết lỗi để dễ dàng debug
		}

		return listResult;
	}

	// ChiTietPhieuXuat
	public List<ChiTietPhieuXuat> getChiTietPhieuXuat(String Mapx, String Masp) {
		List<ChiTietPhieuXuat> listResult = new ArrayList<>();

		// Tạo truy vấn SODA
		Query query = db.query();
		query.constrain(ChiTietPhieuXuat.class);

		// Thêm điều kiện
		if (Mapx != null && !Mapx.isEmpty()) {
			query.descend("Mapx").constrain(Mapx);
		}

		if (Masp != null && !Masp.isEmpty()) {
			query.descend("Masp").constrain(Masp);
		}

		// Thực hiện truy vấn
		try {
			ObjectSet<ChiTietPhieuXuat> result = query.execute();
			// Lưu kết quả vào danh sách
			while (result.hasNext()) {
				listResult.add(result.next());
			}
		} catch (Exception e) {
			System.err.println("Lỗi khi thực hiện truy vấn: " + e.getMessage());
			e.printStackTrace(); // In chi tiết lỗi để dễ dàng debug
		}

		return listResult;
	}

	// PhieuDieuChuyen
	public List<PhieuDieuChuyen> getPhieuDieuChuyen(String Mapdc, String Makho, Date fromDate, Date toDate) {
		List<PhieuDieuChuyen> listResult = new ArrayList<>();

		// Tạo truy vấn SODA
		Query query = db.query();
		query.constrain(PhieuDieuChuyen.class);

		// Thêm điều kiện
		if (Mapdc != null && !Mapdc.isEmpty()) {
			query.descend("Mapdc").constrain(Mapdc);
		}

		if (Makho != null && !Makho.isEmpty()) {
			query.descend("Makho").constrain(Makho);
		}

		if (fromDate != null) {
			query.descend("Ngaydc").constrain(fromDate).greater(); // Ngày lớn hơn hoặc bằng fromDate
		}

		if (toDate != null) {
			query.descend("Ngaydc").constrain(toDate).smaller(); // Ngày nhỏ hơn hoặc bằng toDate
		}

		// Thực hiện truy vấn
		try {
			ObjectSet<PhieuDieuChuyen> result = query.execute();
			// Lưu kết quả vào danh sách
			while (result.hasNext()) {
				listResult.add(result.next());
			}
		} catch (Exception e) {
			System.err.println("Lỗi khi thực hiện truy vấn: " + e.getMessage());
			e.printStackTrace(); // In chi tiết lỗi để dễ dàng debug
		}

		return listResult;
	}

	// ChiTietPhieuDieuChuyen
	public List<ChiTietPhieuDieuChuyen> getChiTietPhieuDieuChuyen(String Mapdc, String Masp) {
		List<ChiTietPhieuDieuChuyen> listResult = new ArrayList<>();

		// Tạo truy vấn SODA
		Query query = db.query();
		query.constrain(PhieuNhap.class);

		// Thêm điều kiện
		if (Mapdc != null && !Mapdc.isEmpty()) {
			query.descend("Mapdc").constrain(Mapdc);
		}

		if (Masp != null && !Masp.isEmpty()) {
			query.descend("Masp").constrain(Masp);
		}

		// Thực hiện truy vấn
		try {
			ObjectSet<ChiTietPhieuDieuChuyen> result = query.execute();
			// Lưu kết quả vào danh sách
			while (result.hasNext()) {
				listResult.add(result.next());
			}
		} catch (Exception e) {
			System.err.println("Lỗi khi thực hiện truy vấn: " + e.getMessage());
			e.printStackTrace(); // In chi tiết lỗi để dễ dàng debug
		}

		return listResult;
	}

}
