package Controller;

import com.db4o.*;
import com.db4o.query.*;

import Model.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ctlTkXuatKho {
	private ObjectContainer db;

	public ctlTkXuatKho(ObjectContainer db) {
		this.db = db;
	}

	public List<KhoReport> getDataReport(String Mapn, String Masp, String Manv, String Makho, Date fromDate,
			Date toDate) {

		List<KhoReport> listReport = new ArrayList<>();

		// Thực hiện truy vấn
		List<PhieuXuat> listPhieuXuat = getPhieuXuat(Mapn, Makho, Manv, fromDate, toDate);
		for (PhieuXuat phieuXuat : listPhieuXuat) {
			List<ChiTietPhieuXuat> listChiTietPhieuXuat = getChiTietPhieuXuat(phieuXuat.getMapx(), Masp);

			for (ChiTietPhieuXuat chitiet : listChiTietPhieuXuat) {
				KhoReport record = new KhoReport(phieuXuat.getMapx(), chitiet.getMasp(), chitiet.getTensp(),
						chitiet.getDongia(), chitiet.getDonvitinh(), chitiet.getSoluong(), chitiet.getThanhtien(),
						phieuXuat.getManv(), phieuXuat.getNgayxuat(), phieuXuat.getMakho(), phieuXuat.getTongtien(),
						null, null, null, null, null);
				listReport.add(record);
			}
		}

		// Trả về
		return listReport;

	}

	// PhieuXuat
	public List<PhieuXuat> getPhieuXuat(String Mapn, String Makho, String Manv, java.util.Date fromDate,
			java.util.Date toDate) {
		List<PhieuXuat> listResult = new ArrayList<>();

		// Tạo truy vấn SODA
		Query query = db.query();
		query.constrain(PhieuXuat.class);

		// Thêm điều kiện
		if (Mapn != null && !Mapn.isEmpty()) {
			query.descend("Mapn").constrain(Mapn);
		}

		if (Makho != null && !Makho.isEmpty()) {
			query.descend("Makho").constrain(Makho);
		}

		if (Manv != null && !Manv.isEmpty()) {
			query.descend("Manv").constrain(Manv);
		}

		if (fromDate != null) {
			query.descend("NgayXuat").constrain(fromDate).greater(); // Ngày lớn hơn hoặc bằng fromDate
		}

		if (toDate != null) {
			query.descend("NgayXuat").constrain(toDate).smaller(); // Ngày nhỏ hơn hoặc bằng toDate
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
	public List<ChiTietPhieuXuat> getChiTietPhieuXuat(String Mapn, String Masp) {
		List<ChiTietPhieuXuat> listResult = new ArrayList<>();
		// Tạo truy vấn SODA
		Query query = db.query();
		query.constrain(ChiTietPhieuXuat.class);

		// Thêm điều kiện
		if (Mapn != null && !Mapn.isEmpty()) {
			query.descend("Mapn").constrain(Mapn);
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

}
