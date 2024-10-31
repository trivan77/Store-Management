package Controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;

import Model.*;

public class ctlSanPham {

	private ObjectContainer db;

	public ctlSanPham(ObjectContainer db) {
		this.db = db;
	}

	// Lấy danh sách Sản phẩm
	public List<SanPham> layDanhSach(String Masp, String Tensp, String Donvitinh, String Loaisp) {
		List<SanPham> listSanPham = new ArrayList<>();

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

		if (Donvitinh != null && !Donvitinh.isEmpty()) {
			query.descend("Donvitinh").constrain(Donvitinh);
		}

		if (Loaisp != null && !Loaisp.isEmpty()) {
			query.descend("Loaisp").constrain(Loaisp);
		}

		// Thêm sắp xếp tăng dần
		query.descend("Masp").orderAscending();

		// Thực hiện truy vấn
		try {
			ObjectSet<SanPham> result = query.execute();
			// Lưu kết quả vào danh sách
			while (result.hasNext()) {
				listSanPham.add(result.next());
			}
		} catch (Exception e) {
			System.err.println("Lỗi khi thực hiện truy vấn: " + e.getMessage());
			e.printStackTrace(); // In chi tiết lỗi để dễ dàng debug
		}

		return listSanPham;

	}

	// Thêm
	public boolean add(String Masp, String Tensp, String stringDongia, String Donvitinh, String Loaisp) {
		// Lấy dữ liệu
		SanPham sanPham = getSanPham(Masp);
		LoaiSanPham loaiSanPham = getLoaiSanPham(Loaisp);

		// Kiểm tra dữ liệu
		if (Masp == null || Masp.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập Mã sản phẩm");
			return false;
		}

		if (sanPham != null) {
			JOptionPane.showMessageDialog(null, "Mã Sản phẩm đã tồn tại");
			return false;
		}

		if (Loaisp == null || Loaisp.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập Loại sản phẩm");
			return false;
		}

		if (loaiSanPham == null) {
			JOptionPane.showMessageDialog(null, "Mã Loại sản phẩm chưa tồn tại");
			return false;
		}

		try {
			Float.parseFloat(stringDongia);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Đơn giá không phải là số thập phân hợp lệ");
			return false;
		}

		int response = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn thêm?", "Thêm dữ liệu",
				JOptionPane.YES_NO_OPTION);
		if (response == JOptionPane.YES_OPTION) {
			// Lưu lại thay đổi
			Float Dongia = Float.parseFloat(stringDongia);
			db.store(new SanPham(Masp, Tensp, Dongia, Donvitinh, Loaisp));
			return true;
		}

		return false;
	}

	// Sửa
	public boolean edit(String Masp, String Tensp, String stringDongia, String Donvitinh, String Loaisp) {
		// Lấy dữ liệu
		SanPham sanPham = getSanPham(Masp);
		LoaiSanPham loaiSanPham = getLoaiSanPham(Loaisp);

		// Kiểm tra dữ liệu
		if (Masp == null || Masp.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập Mã sản phẩm");
			return false;
		}

		if (sanPham == null) {
			JOptionPane.showMessageDialog(null, "Mã Sản phẩm chưa tồn tại");
			return false;
		}

		if (Loaisp == null || Loaisp.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập Loại sản phẩm");
			return false;
		}

		if (loaiSanPham == null) {
			JOptionPane.showMessageDialog(null, "Mã Loại sản phẩm chưa tồn tại");
			return false;
		}

		try {
			Float.parseFloat(stringDongia);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Đơn giá không phải là số thập phân hợp lệ");
			return false;
		}

		int response = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn sửa?", "Sửa dữ liệu",
				JOptionPane.YES_NO_OPTION);
		if (response == JOptionPane.YES_OPTION) {
			// Cập nhật thông tin
			Float Dongia = Float.parseFloat(stringDongia);
			sanPham.setMasp(Masp);
			sanPham.setTensp(Tensp);
			sanPham.setDongia(Dongia);
			sanPham.setDonvitinh(Donvitinh);
			sanPham.setLoaisp(Loaisp);

			// Lưu lại thay đổi
			db.store(sanPham);

			return true;
		}
		return false;
	}

	// Xóa
	public boolean del(String Masp) {
		// Lấy dữ liệu
		SanPham del = getSanPham(Masp);
		ChiTietPhieuXuat xuat = getChiTietPhieuXuat(Masp);
		ChiTietPhieuNhap nhap = getChiTietPhieuNhap(Masp);
		ChiTietPhieuDieuChuyen dieuchuyen = getChiTietPhieuDieuChuyen(Masp);

		// Kiểm tra dữ liệu
		if (Masp == null || Masp.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập Mã sản phẩm");
			return false;
		}

		if (del == null) {
			JOptionPane.showMessageDialog(null, "Mã chưa tồn tại");
		}

		if (xuat != null || nhap != null || dieuchuyen != null) {
			JOptionPane.showMessageDialog(null, "Xóa thất bại: Mã đang được tham chiếu ở các bản ghi liên quan.");
		}

		int response = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa?", "Xóa dữ liệu",
				JOptionPane.YES_NO_OPTION);
		if (response == JOptionPane.YES_OPTION) {
			db.delete(del);
			return true;
		}
		return false;
	}

	// Tìm SanPham
	private SanPham getSanPham(String Masp) {
		// Tạo truy vấn SODA
		Query query = db.query();
		query.constrain(SanPham.class);
		query.descend("Masp").constrain(Masp);
		ObjectSet<SanPham> result = query.execute();
		return result.hasNext() ? result.next() : null;
	}

	// Tìm SanPham
	private LoaiSanPham getLoaiSanPham(String Loaisp) {
		// Tạo truy vấn SODA
		Query query = db.query();
		query.constrain(LoaiSanPham.class);
		query.descend("Loaisp").constrain(Loaisp);
		ObjectSet<LoaiSanPham> result = query.execute();
		return result.hasNext() ? result.next() : null;
	}

	// Tìm ChiTietPhieuNhap
	private ChiTietPhieuNhap getChiTietPhieuNhap(String Masp) {
		// Tạo truy vấn SODA
		Query query = db.query();
		query.constrain(ChiTietPhieuNhap.class);
		query.descend("Masp").constrain(Masp);
		ObjectSet<ChiTietPhieuNhap> result = query.execute();
		return result.hasNext() ? result.next() : null;
	}

	// Tìm ChiTietPhieuXuat
	private ChiTietPhieuXuat getChiTietPhieuXuat(String Masp) {
		// Tạo truy vấn SODA
		Query query = db.query();
		query.constrain(ChiTietPhieuXuat.class);
		query.descend("Masp").constrain(Masp);
		ObjectSet<ChiTietPhieuXuat> result = query.execute();
		return result.hasNext() ? result.next() : null;
	}

	// Tìm ChiTietPhieuDieuChuyen
	private ChiTietPhieuDieuChuyen getChiTietPhieuDieuChuyen(String Masp) {
		// Tạo truy vấn SODA
		Query query = db.query();
		query.constrain(ChiTietPhieuDieuChuyen.class);
		query.descend("Masp").constrain(Masp);
		ObjectSet<ChiTietPhieuDieuChuyen> result = query.execute();
		return result.hasNext() ? result.next() : null;
	}

}
