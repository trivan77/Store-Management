package Controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;

import Model.*;

public class ctlNhanVien {

	private ObjectContainer db;

	public ctlNhanVien(ObjectContainer db) {
		this.db = db;
	}

	// Lấy danh sách NhanVien
	public List<NhanVien> layDanhSach(NhanVien nhanVien) {
		List<NhanVien> listNhanVien = new ArrayList<>();

		// Tạo truy vấn SODA
		Query query = db.query();
		query.constrain(NhanVien.class);

		// Kiểm tra từng trường và thêm điều kiện vào truy vấn
		if (nhanVien.getManv() != null && !nhanVien.getManv().isEmpty()) {
			query.descend("Manv").constrain(nhanVien.getManv());
		}
		if (nhanVien.getTennv() != null && !nhanVien.getTennv().isEmpty()) {
			query.descend("Tennv").constrain(nhanVien.getTennv()).contains();
		}
		if (nhanVien.getGioitinh() != null && !nhanVien.getGioitinh().isEmpty()) {
			query.descend("Gioitinh").constrain(nhanVien.getGioitinh());
		}
		if (nhanVien.getDienthoai() != null && !nhanVien.getDienthoai().isEmpty()) {
			query.descend("Dienthoai").constrain(nhanVien.getDienthoai());
		}
		if (nhanVien.getDiachi() != null && !nhanVien.getDiachi().isEmpty()) {
			query.descend("Diachi").constrain(nhanVien.getDiachi()).contains();
		}
		if (nhanVien.getSocmnd() != null && !nhanVien.getSocmnd().isEmpty()) {
			query.descend("Socmnd").constrain(nhanVien.getSocmnd());
		}
		if (nhanVien.getChucvu() != null && !nhanVien.getChucvu().isEmpty()) {
			query.descend("Chucvu").constrain(nhanVien.getChucvu()).contains();
		}
		if (nhanVien.getMatkhau() != null && !nhanVien.getMatkhau().isEmpty()) {
			query.descend("Matkhau").constrain(nhanVien.getMatkhau()).contains();
		}

		// Thêm sắp xếp tăng dần
		query.descend("Manv").orderAscending();

		// Thực hiện truy vấn
		try {
			ObjectSet<NhanVien> result = query.execute();
			// Lưu kết quả vào danh sách
			while (result.hasNext()) {
				listNhanVien.add(result.next());
			}
		} catch (Exception e) {
			System.err.println("Lỗi khi thực hiện truy vấn: " + e.getMessage());
			e.printStackTrace(); // In chi tiết lỗi để dễ dàng debug
		}

		return listNhanVien;

	}

	// Thêm
	public boolean add(NhanVien nhanVien) {
		// Lấy dữ liệu
		NhanVien existingNhanVien = getNhanVien(nhanVien);

		// Kiểm tra dữ liệu
		if (nhanVien.getManv() == null || nhanVien.getManv().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập Mã nhân viên");
			return false;
		}

		if (existingNhanVien != null) {
			JOptionPane.showMessageDialog(null, "Mã nhân viên đã tồn tại");
			return false;
		}

		int response = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn thêm?", "Thêm dữ liệu",
				JOptionPane.YES_NO_OPTION);
		if (response == JOptionPane.YES_OPTION) {
			// Lưu lại thay đổi
			db.store(nhanVien);
			return true;
		}

		return false;
	}

	// Sửa
	public boolean edit(NhanVien nhanVien) {
		// Lấy dữ liệu
		NhanVien existingNhanVien = getNhanVien(nhanVien);

		// Kiểm tra dữ liệu
		if (nhanVien.getManv() == null || nhanVien.getManv().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập Mã nhân viên");
			return false;
		}

		if (existingNhanVien == null) {
			JOptionPane.showMessageDialog(null, "Mã nhân viên chưa tồn tại");
			return false;
		}

		int response = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn sửa?", "Sửa dữ liệu",
				JOptionPane.YES_NO_OPTION);
		if (response == JOptionPane.YES_OPTION) {
			// Cập nhật thông tin
			existingNhanVien.setTennv(nhanVien.getTennv());
			existingNhanVien.setGioitinh(nhanVien.getGioitinh());
			existingNhanVien.setDienthoai(nhanVien.getDienthoai());
			existingNhanVien.setDiachi(nhanVien.getDiachi());
			existingNhanVien.setSocmnd(nhanVien.getSocmnd());
			existingNhanVien.setChucvu(nhanVien.getChucvu());
			existingNhanVien.setMatkhau(nhanVien.getMatkhau());

			// Lưu lại thay đổi
			db.store(existingNhanVien);
			return true;
		}
		return false;
	}

	// Xóa
	public boolean del(NhanVien nhanVien) {
		// Lấy dữ liệu
		NhanVien existingNhanVien = getNhanVien(nhanVien);

		// Kiểm tra dữ liệu
		if (nhanVien.getManv() == null || nhanVien.getManv().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập Mã nhân viên");
			return false;
		}

		if (existingNhanVien == null) {
			JOptionPane.showMessageDialog(null, "Mã nhân viên chưa tồn tại");
			return false;
		}

		int response = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa?", "Xóa dữ liệu",
				JOptionPane.YES_NO_OPTION);
		if (response == JOptionPane.YES_OPTION) {
			db.delete(existingNhanVien);
			return true;
		}
		return false;
	}

	// Tìm NhanVien
	public NhanVien getNhanVien(NhanVien nhanVien) {
		// Lấy mã nhân viên từ đối tượng NhanVien
		String manv = nhanVien.getManv();

		// Tạo truy vấn để tìm nhân viên theo mã nhân viên
		Query query = db.query();
		query.constrain(NhanVien.class);
		query.descend("Manv").constrain(manv);

		// Thực thi truy vấn
		ObjectSet<NhanVien> result = query.execute();

		// Kiểm tra xem có kết quả hay không và trả về nhân viên đầu tiên tìm được
		if (result.hasNext()) {
			return result.next();
		}

		return null; // Trả về null nếu không tìm thấy
	}

	// Tìm PhieuNhap
	private PhieuNhap getPhieuNhap(NhanVien nhanVien) {
		// Lấy mã nhân viên từ đối tượng NhanVien
		String manv = nhanVien.getManv();

		// Tạo truy vấn SODA
		Query query = db.query();
		query.constrain(PhieuNhap.class);
		query.descend("Manv").constrain(manv);
		ObjectSet<PhieuNhap> result = query.execute();
		return result.hasNext() ? result.next() : null;
	}

	// Tìm PhieuXuat
	private PhieuXuat getPhieuXuat(NhanVien nhanVien) {
		// Lấy mã nhân viên từ đối tượng NhanVien
		String manv = nhanVien.getManv();

		// Tạo truy vấn SODA
		Query query = db.query();
		query.constrain(PhieuXuat.class);
		query.descend("Manv").constrain(manv);
		ObjectSet<PhieuXuat> result = query.execute();
		return result.hasNext() ? result.next() : null;
	}

	// Tìm PhieuDieuChuyen
	private PhieuDieuChuyen getPhieuDieuChuyen(NhanVien nhanVien) {
		// Lấy mã nhân viên từ đối tượng NhanVien
		String manv = nhanVien.getManv();

		// Tạo truy vấn SODA
		Query query = db.query();
		query.constrain(PhieuDieuChuyen.class);
		query.descend("Manv").constrain(manv);
		ObjectSet<PhieuDieuChuyen> result = query.execute();
		return result.hasNext() ? result.next() : null;
	}

}
