package Controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;

import Model.*;

public class ctlKho {

	private ObjectContainer db;

	public ctlKho(ObjectContainer db) {
		this.db = db;
	}

	// Lấy danh sách Kho
	public List<Kho> layDanhSach(String maKho, String tenKho, String diaChi) {
		List<Kho> listKho = new ArrayList<>();

		// Tạo truy vấn SODA
		Query query = db.query();
		query.constrain(Kho.class);

		// Thêm điều kiện
		if (maKho != null && !maKho.isEmpty()) {
			query.descend("maKho").constrain(maKho);
		}

		if (tenKho != null && !tenKho.isEmpty()) {
			query.descend("tenKho").constrain(tenKho);
		}

		if (diaChi != null && !diaChi.isEmpty()) {
			query.descend("diaChi").constrain(diaChi);
		}

		// Thêm sắp xếp tăng dần
		query.descend("maKho").orderAscending();

		// Thực hiện truy vấn
		try {
			ObjectSet<Kho> result = query.execute();
			// Lưu kết quả vào danh sách
			while (result.hasNext()) {
				listKho.add(result.next());
			}
		} catch (Exception e) {
			System.err.println("Lỗi khi thực hiện truy vấn: " + e.getMessage());
			e.printStackTrace(); // In chi tiết lỗi để dễ dàng debug
		}

		return listKho;

	}

	// Thêm
	public boolean add(String maKho, String tenKho, String diaChi) {
		// Lấy dữ liệu
		Kho kho = getKho(maKho);

		// Kiểm tra dữ liệu
		if (maKho == null || maKho.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập Mã kho");
			return false;
		}

		if (kho != null) {
			JOptionPane.showMessageDialog(null, "Mã kho đã tồn tại");
			return false;
		}

		int response = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn thêm?", "Thêm dữ liệu",
				JOptionPane.YES_NO_OPTION);
		if (response == JOptionPane.YES_OPTION) {
			// Lưu lại thay đổi
			db.store(new Kho(maKho, tenKho, diaChi));
			return true;
		}

		return false;
	}

	// Sửa
	public boolean edit(String maKho, String tenKho, String diaChi) {
		// Lấy dữ liệu
		Kho kho = getKho(maKho);

		// Kiểm tra dữ liệu
		if (maKho == null || maKho.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập Mã kho");
			return false;
		}

		if (kho == null) {
			JOptionPane.showMessageDialog(null, "Mã kho chưa tồn tại");
			return false;
		}

		int response = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn sửa?", "Sửa dữ liệu",
				JOptionPane.YES_NO_OPTION);
		if (response == JOptionPane.YES_OPTION) {
			// Cập nhật thông tin
			kho.setMaKho(maKho);
			kho.setTenKho(tenKho);
			kho.setDiaChi(diaChi);

			// Lưu lại thay đổi
			db.store(kho);

			return true;
		}
		return false;
	}

	// Xóa
	public boolean del(String maKho) {
		// Lấy dữ liệu
		Kho kho = getKho(maKho);
		PhieuXuat xuat = getPhieuXuat(maKho);
		PhieuNhap nhap = getPhieuNhap(maKho);
		PhieuDieuChuyen dieuchuyen = getPhieuDieuChuyen(maKho);

		// Kiểm tra dữ liệu
		if (maKho == null || maKho.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập Mã kho");
			return false;
		}

		if (kho == null) {
			JOptionPane.showMessageDialog(null, "Mã kho chưa tồn tại");
		}

		if (xuat != null || nhap != null || dieuchuyen != null) {
			JOptionPane.showMessageDialog(null, "Xóa thất bại: Mã đang được tham chiếu ở các bản ghi liên quan.");
		}

		int response = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa?", "Xóa dữ liệu",
				JOptionPane.YES_NO_OPTION);
		if (response == JOptionPane.YES_OPTION) {
			db.delete(kho);
			return true;
		}
		return false;
	}

	// Tìm Kho
	private Kho getKho(String maKho) {
		// Tạo truy vấn SODA
		Query query = db.query();
		query.constrain(Kho.class);
		query.descend("maKho").constrain(maKho);
		ObjectSet<Kho> result = query.execute();
		return result.hasNext() ? result.next() : null;
	}

	// PhieuNhap
	private PhieuNhap getPhieuNhap(String maKho) {
		// Tạo truy vấn SODA
		Query query = db.query();
		query.constrain(PhieuNhap.class);
		query.descend("maKho").constrain(maKho);
		ObjectSet<PhieuNhap> result = query.execute();
		return result.hasNext() ? result.next() : null;
	}

	// Tìm PhieuXuat
	private PhieuXuat getPhieuXuat(String maKho) {
		// Tạo truy vấn SODA
		Query query = db.query();
		query.constrain(PhieuXuat.class);
		query.descend("maKho").constrain(maKho);
		ObjectSet<PhieuXuat> result = query.execute();
		return result.hasNext() ? result.next() : null;
	}

	// Tìm PhieuDieuChuyen
	private PhieuDieuChuyen getPhieuDieuChuyen(String maKho) {
		// Tạo truy vấn SODA
		Query query = db.query();
		query.constrain(PhieuDieuChuyen.class);
		query.descend("maKho").constrain(maKho);
		ObjectSet<PhieuDieuChuyen> result = query.execute();
		return result.hasNext() ? result.next() : null;
	}

}
