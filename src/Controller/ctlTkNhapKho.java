package Controller;

import com.db4o.*;
import com.db4o.query.*;

import Model.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ctlTkNhapKho {
	private ObjectContainer db;

	public ctlTkNhapKho(ObjectContainer db) {
		this.db = db;
	}

	public List<KhoReport> getDataReport(String Mapn, String Masp, String Manv, String Makho, Date fromDate,
			Date toDate) {

		List<KhoReport> listReport = new ArrayList<>();

		// Thực hiện truy vấn
		List<PhieuNhap> listPhieuNhap = getPhieuNhap(Mapn, Makho, Manv, fromDate, toDate);
		for (PhieuNhap phieuNhap : listPhieuNhap) {
			List<ChiTietPhieuNhap> listChiTietPhieuNhap = getChiTietPhieuNhap(phieuNhap.getMapn(), Masp);

			for (ChiTietPhieuNhap chitiet : listChiTietPhieuNhap) {
				KhoReport record = new KhoReport(phieuNhap.getMapn(), chitiet.getMasp(), chitiet.getTensp(),
						chitiet.getDongia(), chitiet.getDonvitinh(), chitiet.getSoluong(), chitiet.getThanhtien(),
						phieuNhap.getManv(), phieuNhap.getNgaynhap(), phieuNhap.getMakho(), phieuNhap.getTongtien(),
						null, null, null, null, null);
				listReport.add(record);
			}
		}

		// Trả về
		return listReport;

	}

	// PhieuNhap
	public List<PhieuNhap> getPhieuNhap(String Mapn, String Makho, String Manv, java.util.Date fromDate,
			java.util.Date toDate) {
		List<PhieuNhap> listResult = new ArrayList<>();

		// Tạo truy vấn SODA
		Query query = db.query();
		query.constrain(PhieuNhap.class);

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
			query.descend("Ngaynhap").constrain(fromDate).greater(); // Ngày lớn hơn hoặc bằng fromDate
		}

		if (toDate != null) {
			query.descend("Ngaynhap").constrain(toDate).smaller(); // Ngày nhỏ hơn hoặc bằng toDate
		}

		// Thực hiện truy vấn
		try {
			ObjectSet<PhieuNhap> result = query.execute();
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

	// ChiTietPhieuNhap
	public List<ChiTietPhieuNhap> getChiTietPhieuNhap(String Mapn, String Masp) {
		List<ChiTietPhieuNhap> listResult = new ArrayList<>();
		// Tạo truy vấn SODA
		Query query = db.query();
		query.constrain(ChiTietPhieuNhap.class);

		// Thêm điều kiện
		if (Mapn != null && !Mapn.isEmpty()) {
			query.descend("Mapn").constrain(Mapn);
		}

		if (Masp != null && !Masp.isEmpty()) {
			query.descend("Masp").constrain(Masp);
		}

		// Thực hiện truy vấn
		try {
			ObjectSet<ChiTietPhieuNhap> result = query.execute();
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
