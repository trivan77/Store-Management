package Controller;

import com.db4o.*;
import com.db4o.query.*;

import Model.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ctlTkChuyenKho {
	private ObjectContainer db;

	public ctlTkChuyenKho(ObjectContainer db) {
		this.db = db;
	}

	public List<KhoReport> getDataReport(String maPdc, String maSp, String maNvDi, String maNvDen, String maKhoDi,
			String maKhoDen, Date fromDate, Date toDate) {

		List<KhoReport> listReport = new ArrayList<>();

		// Thực hiện truy vấn
		List<PhieuDieuChuyen> listPhieu = getPhieuDieuChuyen(maPdc, maNvDi, maNvDen, maKhoDi, maKhoDen, fromDate,
				toDate);
		for (PhieuDieuChuyen phieu : listPhieu) {
			List<ChiTietPhieuDieuChuyen> listChiTietPhieuDieuChuyen = getChiTietPhieuDieuChuyen(phieu.getMaPdc(), maSp);

			for (ChiTietPhieuDieuChuyen chitiet : listChiTietPhieuDieuChuyen) {
				KhoReport record = new KhoReport(phieu.getMaPdc(), chitiet.getMaSp(), chitiet.getTenSp(),
						chitiet.getDonGia(), chitiet.getDonViTinh(), chitiet.getSoLuong(), chitiet.getThanhTien(), null,
						null, null, phieu.getTongTien(), phieu.getMaNvDi(), phieu.getMaNvDen(), phieu.getNgayDc(),
						phieu.getMaKhoDi(), phieu.getMaKhoDen());
				listReport.add(record);
			}
		}

		// Trả về
		return listReport;

	}

	// PhieuDieuChuyen
	public List<PhieuDieuChuyen> getPhieuDieuChuyen(String maPdc, String maNvDi, String maNvDen, String maKhoDi,
			String maKhoDen, Date fromDate, Date toDate) {
		List<PhieuDieuChuyen> listResult = new ArrayList<>();

		// Tạo truy vấn SODA
		Query query = db.query();
		query.constrain(PhieuDieuChuyen.class);

		// Thêm điều kiện
		if (maPdc != null && !maPdc.isEmpty()) {
			query.descend("maPdc").constrain(maPdc);
		}

		if (maNvDi != null && !maNvDi.isEmpty()) {
			query.descend("maNvDi").constrain(maNvDi);
		}

		if (maNvDen != null && !maNvDen.isEmpty()) {
			query.descend("maNvDen").constrain(maNvDen);
		}

		if (maKhoDi != null && !maKhoDi.isEmpty()) {
			query.descend("maKhoDi").constrain(maKhoDi);
		}

		if (maKhoDen != null && !maKhoDen.isEmpty()) {
			query.descend("maKhoDen").constrain(maKhoDen);
		}

		if (fromDate != null) {
			query.descend("ngayDc").constrain(fromDate).greater(); // Ngày lớn hơn hoặc bằng fromDate
		}

		if (toDate != null) {
			query.descend("ngayDc").constrain(toDate).smaller(); // Ngày nhỏ hơn hoặc bằng toDate
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
	public List<ChiTietPhieuDieuChuyen> getChiTietPhieuDieuChuyen(String maPdc, String maSp) {
		List<ChiTietPhieuDieuChuyen> listResult = new ArrayList<>();

		// Tạo truy vấn SODA
		Query query = db.query();
		query.constrain(ChiTietPhieuDieuChuyen.class);

		// Thêm điều kiện
		if (maPdc != null && !maPdc.isEmpty()) {
			query.descend("maPdc").constrain(maPdc);
		}

		if (maSp != null && !maSp.isEmpty()) {
			query.descend("maSp").constrain(maSp);
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
