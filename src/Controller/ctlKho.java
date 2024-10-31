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
	public List<Kho> layDanhSach(String Makho, String Tenkho, String Diachi) {
		List<Kho> listKho = new ArrayList<>();

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

		if (Diachi != null && !Diachi.isEmpty()) {
			query.descend("Diachi").constrain(Diachi);
		}

		// Thêm sắp xếp tăng dần
		query.descend("Makho").orderAscending();

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
	public boolean add(String Makho, String Tenkho, String Diachi) {
		// Lấy dữ liệu
		Kho kho = getKho(Makho);

		// Kiểm tra dữ liệu
		if (Makho == null || Makho.isEmpty()) {
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
			db.store(new Kho(Makho, Tenkho, Diachi));
			return true;
		}

		return false;
	}

	// Sửa
	public boolean edit(String Makho, String Tenkho, String Diachi) {
		// Lấy dữ liệu
		Kho kho = getKho(Makho);

		// Kiểm tra dữ liệu
		if (Makho == null || Makho.isEmpty()) {
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
			kho.setMakho(Makho);
			kho.setTenkho(Tenkho);
			kho.setDiachi(Diachi);

			// Lưu lại thay đổi
			db.store(kho);

			return true;
		}
		return false;
	}

	// Xóa
	public boolean del(String Makho) {
		// Lấy dữ liệu
		Kho kho = getKho(Makho);
		PhieuXuat xuat = getPhieuXuat(Makho);
		PhieuNhap nhap = getPhieuNhap(Makho);
		PhieuDieuChuyen dieuchuyen = getPhieuDieuChuyen(Makho);

		// Kiểm tra dữ liệu
		if (Makho == null || Makho.isEmpty()) {
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
	private Kho getKho(String Makho) {
		// Tạo truy vấn SODA
		Query query = db.query();
		query.constrain(Kho.class);
		query.descend("Makho").constrain(Makho);
		ObjectSet<Kho> result = query.execute();
		return result.hasNext() ? result.next() : null;
	}

	// PhieuNhap
	private PhieuNhap getPhieuNhap(String Makho) {
		// Tạo truy vấn SODA
		Query query = db.query();
		query.constrain(PhieuNhap.class);
		query.descend("Makho").constrain(Makho);
		ObjectSet<PhieuNhap> result = query.execute();
		return result.hasNext() ? result.next() : null;
	}

	// Tìm PhieuXuat
	private PhieuXuat getPhieuXuat(String Makho) {
		// Tạo truy vấn SODA
		Query query = db.query();
		query.constrain(PhieuXuat.class);
		query.descend("Makho").constrain(Makho);
		ObjectSet<PhieuXuat> result = query.execute();
		return result.hasNext() ? result.next() : null;
	}

	// Tìm PhieuDieuChuyen
	private PhieuDieuChuyen getPhieuDieuChuyen(String Makho) {
		// Tạo truy vấn SODA
		Query query = db.query();
		query.constrain(PhieuDieuChuyen.class);
		query.descend("Makho").constrain(Makho);
		ObjectSet<PhieuDieuChuyen> result = query.execute();
		return result.hasNext() ? result.next() : null;
	}

}
