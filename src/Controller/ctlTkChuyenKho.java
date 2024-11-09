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

	public List<KhoReport> getDataReport(String Mapdc, String Masp, String Manvdi, String Manvden, String Makhodi,
			String Makhoden, Date fromDate, Date toDate) {

		List<KhoReport> listReport = new ArrayList<>();

		// Thực hiện truy vấn
		List<PhieuDieuChuyen> listPhieu = getPhieuDieuChuyen(Mapdc, Manvdi, Manvden, Makhodi, Makhoden, fromDate,
				toDate);
		for (PhieuDieuChuyen phieu : listPhieu) {
			List<ChiTietPhieuDieuChuyen> listChiTietPhieuDieuChuyen = getChiTietPhieuDieuChuyen(phieu.getMapdc(), Masp);

			for (ChiTietPhieuDieuChuyen chitiet : listChiTietPhieuDieuChuyen) {
				KhoReport record = new KhoReport(phieu.getMapdc(), chitiet.getMasp(), chitiet.getTensp(),
						chitiet.getDongia(), chitiet.getDonvitinh(), chitiet.getSoluong(), chitiet.getThanhtien(), null,
						null, null, phieu.getTongtien(), phieu.getManvdi(), phieu.getManvden(), phieu.getNgaydc(),
						phieu.getMakhodi(), phieu.getMakhoden());
				listReport.add(record);
			}
		}

		// Trả về
		return listReport;

	}

	// PhieuDieuChuyen
	public List<PhieuDieuChuyen> getPhieuDieuChuyen(String Mapdc, String Manvdi, String Manvden, String Makhodi,
			String Makhoden, Date fromDate, Date toDate) {
		List<PhieuDieuChuyen> listResult = new ArrayList<>();

		// Tạo truy vấn SODA
		Query query = db.query();
		query.constrain(PhieuDieuChuyen.class);

		// Thêm điều kiện
		if (Mapdc != null && !Mapdc.isEmpty()) {
			query.descend("Mapdc").constrain(Mapdc);
		}

		if (Manvdi != null && !Manvdi.isEmpty()) {
			query.descend("Manvdi").constrain(Manvdi);
		}

		if (Manvden != null && !Manvden.isEmpty()) {
			query.descend("Manvden").constrain(Manvden);
		}

		if (Makhodi != null && !Makhodi.isEmpty()) {
			query.descend("Makhodi").constrain(Makhodi);
		}

		if (Makhoden != null && !Makhoden.isEmpty()) {
			query.descend("Makhoden").constrain(Makhoden);
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
		query.constrain(ChiTietPhieuDieuChuyen.class);

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
