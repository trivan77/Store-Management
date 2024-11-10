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

	public List<KhoReport> getDataReport(String maPn, String Masp, String maNv, String maKho, Date fromDate,
			Date toDate) {

		List<KhoReport> listReport = new ArrayList<>();

		// Thực hiện truy vấn
		List<PhieuNhap> listPhieuNhap = getPhieuNhap(maPn, maKho, maNv, fromDate, toDate);
		for (PhieuNhap phieuNhap : listPhieuNhap) {
			List<ChiTietPhieuNhap> listChiTietPhieuNhap = getChiTietPhieuNhap(phieuNhap.getMaPn(), Masp);

			for (ChiTietPhieuNhap chitiet : listChiTietPhieuNhap) {
				KhoReport record = new KhoReport(phieuNhap.getMaPn(), chitiet.getMaSp(), chitiet.getTenSp(),
						chitiet.getDonGia(), chitiet.getDonViTinh(), chitiet.getSoLuong(), chitiet.getThanhTien(),
						phieuNhap.getMaNv(), phieuNhap.getNgayNhap(), phieuNhap.getMaKho(), phieuNhap.getTongTien(),
						null, null, null, null, null);
				listReport.add(record);
			}
		}

		// Trả về
		return listReport;

	}

	// PhieuNhap
	public List<PhieuNhap> getPhieuNhap(String maPn, String maKho, String maNv, java.util.Date fromDate,
			java.util.Date toDate) {
		List<PhieuNhap> listResult = new ArrayList<>();

		// Tạo truy vấn SODA
		Query query = db.query();
		query.constrain(PhieuNhap.class);

		// Thêm điều kiện
		if (maPn != null && !maPn.isEmpty()) {
			query.descend("maPn").constrain(maPn);
		}

		if (maKho != null && !maKho.isEmpty()) {
			query.descend("maKho").constrain(maKho);
		}

		if (maNv != null && !maNv.isEmpty()) {
			query.descend("maNv").constrain(maNv);
		}

		if (fromDate != null) {
			query.descend("ngayNhap").constrain(fromDate).greater(); // Ngày lớn hơn hoặc bằng fromDate
		}

		if (toDate != null) {
			query.descend("ngayNhap").constrain(toDate).smaller(); // Ngày nhỏ hơn hoặc bằng toDate
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
	public List<ChiTietPhieuNhap> getChiTietPhieuNhap(String maPn, String Masp) {
		List<ChiTietPhieuNhap> listResult = new ArrayList<>();
		// Tạo truy vấn SODA
		Query query = db.query();
		query.constrain(ChiTietPhieuNhap.class);

		// Thêm điều kiện
		if (maPn != null && !maPn.isEmpty()) {
			query.descend("maPn").constrain(maPn);
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
