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
		if (nhanVien.getMaNv() != null && !nhanVien.getMaNv().isEmpty()) {
			query.descend("maNv").constrain(nhanVien.getMaNv());
		}
		if (nhanVien.getTenNv() != null && !nhanVien.getTenNv().isEmpty()) {
			query.descend("tenNv").constrain(nhanVien.getTenNv()).contains();
		}
		if (nhanVien.getGioiTinh() != null && !nhanVien.getGioiTinh().isEmpty()) {
			query.descend("gioiTinh").constrain(nhanVien.getGioiTinh());
		}
		if (nhanVien.getDienThoai() != null && !nhanVien.getDienThoai().isEmpty()) {
			query.descend("dienThoai").constrain(nhanVien.getDienThoai());
		}
		if (nhanVien.getDiaChi() != null && !nhanVien.getDiaChi().isEmpty()) {
			query.descend("diaChi").constrain(nhanVien.getDiaChi()).contains();
		}
		if (nhanVien.getSoCmnd() != null && !nhanVien.getSoCmnd().isEmpty()) {
			query.descend("soCmnd").constrain(nhanVien.getSoCmnd());
		}
		if (nhanVien.getChucVu() != null && !nhanVien.getChucVu().isEmpty()) {
			query.descend("chucVu").constrain(nhanVien.getChucVu()).contains();
		}
		if (nhanVien.getMatKhau() != null && !nhanVien.getMatKhau().isEmpty()) {
			query.descend("matKhau").constrain(nhanVien.getMatKhau()).contains();
		}

		// Thêm sắp xếp tăng dần
		query.descend("maNv").orderAscending();

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
		if (nhanVien.getMaNv() == null || nhanVien.getMaNv().isEmpty()) {
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
		if (nhanVien.getMaNv() == null || nhanVien.getMaNv().isEmpty()) {
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
			existingNhanVien.setTenNv(nhanVien.getTenNv());
			existingNhanVien.setGioiTinh(nhanVien.getGioiTinh());
			existingNhanVien.setDienThoai(nhanVien.getDienThoai());
			existingNhanVien.setDiaChi(nhanVien.getDiaChi());
			existingNhanVien.setSoCmnd(nhanVien.getSoCmnd());
			existingNhanVien.setChucVu(nhanVien.getChucVu());
			existingNhanVien.setMatKhau(nhanVien.getMatKhau());

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
		if (nhanVien.getMaNv() == null || nhanVien.getMaNv().isEmpty()) {
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
		String maNv = nhanVien.getMaNv();

		// Tạo truy vấn để tìm nhân viên theo mã nhân viên
		Query query = db.query();
		query.constrain(NhanVien.class);
		query.descend("maNv").constrain(maNv);

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
		String maNv = nhanVien.getMaNv();

		// Tạo truy vấn SODA
		Query query = db.query();
		query.constrain(PhieuNhap.class);
		query.descend("maNv").constrain(maNv);
		ObjectSet<PhieuNhap> result = query.execute();
		return result.hasNext() ? result.next() : null;
	}

	// Tìm PhieuXuat
	private PhieuXuat getPhieuXuat(NhanVien nhanVien) {
		// Lấy mã nhân viên từ đối tượng NhanVien
		String maNv = nhanVien.getMaNv();

		// Tạo truy vấn SODA
		Query query = db.query();
		query.constrain(PhieuXuat.class);
		query.descend("maNv").constrain(maNv);
		ObjectSet<PhieuXuat> result = query.execute();
		return result.hasNext() ? result.next() : null;
	}

	// Tìm PhieuDieuChuyen
	private PhieuDieuChuyen getPhieuDieuChuyen(NhanVien nhanVien) {
		// Lấy mã nhân viên từ đối tượng NhanVien
		String maNv = nhanVien.getMaNv();

		// Tạo truy vấn SODA
		Query query = db.query();
		query.constrain(PhieuDieuChuyen.class);
		query.descend("maNv").constrain(maNv);
		ObjectSet<PhieuDieuChuyen> result = query.execute();
		return result.hasNext() ? result.next() : null;
	}

}
