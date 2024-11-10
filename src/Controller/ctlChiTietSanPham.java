package Controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;

import Model.*;

public class ctlChiTietSanPham {

	private ObjectContainer db;

	public ctlChiTietSanPham(ObjectContainer db) {
		this.db = db;
	}

	// Lấy danh sách Sản phẩm
	public List<SanPham> layDanhSach(String maSp, String tenSp, String donViTinh, String loaiSp) {
		List<SanPham> listSanPham = new ArrayList<>();

		// Tạo truy vấn SODA
		Query query = db.query();
		query.constrain(SanPham.class);

		// Thêm điều kiện
		if (maSp != null && !maSp.isEmpty()) {
			query.descend("maSp").constrain(maSp);
		}

		if (tenSp != null && !tenSp.isEmpty()) {
			query.descend("tenSp").constrain(tenSp);
		}

		if (donViTinh != null && !donViTinh.isEmpty()) {
			query.descend("donViTinh").constrain(donViTinh);
		}

		if (loaiSp != null && !loaiSp.isEmpty()) {
			query.descend("loaiSp").constrain(loaiSp);
		}

		// Thêm sắp xếp tăng dần
		query.descend("maSp").orderAscending();

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
	public boolean add(String maSp, long donGia, int soLuong, String donViTinh, String idLoaiSp) {
		// Lấy dữ liệu
		SanPham sanPham = getSanPham(maSp);
		LoaiSanPham loaiSanPham = getLoaiSanPham(idLoaiSp);

		// Kiểm tra dữ liệu
		if (maSp == null || maSp.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập Mã sản phẩm");
			return false;
		}

		if (sanPham != null) {
			JOptionPane.showMessageDialog(null, "Mã Sản phẩm đã tồn tại");
			return false;
		}

		if (idLoaiSp == null || idLoaiSp.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập Loại sản phẩm");
			return false;
		}

		if (loaiSanPham == null) {
			JOptionPane.showMessageDialog(null, "Mã Loại sản phẩm chưa tồn tại");
			return false;
		}

		/*
		 * try { Float.parseFloat(donGia); } catch (NumberFormatException e) {
		 * JOptionPane.showMessageDialog(null,
		 * "Đơn giá không phải là số thập phân hợp lệ"); return false; }
		 */

		int response = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn thêm?", "Thêm dữ liệu",
				JOptionPane.YES_NO_OPTION);
		if (response == JOptionPane.YES_OPTION) {
			// Lưu lại thay đổi
			/* Float donGia = Float.parseFloat(donGia); */
			db.store(new SanPham(maSp, donGia, soLuong, donViTinh, idLoaiSp));
			return true;
		}

		return false;
	}

	// Sửa
	public boolean edit(String maSp, long donGia, int soLuong, String donViTinh, String idLoaiSp) {
		// Lấy dữ liệu
		SanPham sanPham = getSanPham(maSp);
		LoaiSanPham loaiSanPham = getLoaiSanPham(idLoaiSp);

		// Kiểm tra dữ liệu
		if (maSp == null || maSp.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập Mã sản phẩm");
			return false;
		}

		if (sanPham == null) {
			JOptionPane.showMessageDialog(null, "Mã Sản phẩm chưa tồn tại");
			return false;
		}

		if (idLoaiSp == null || idLoaiSp.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập Loại sản phẩm");
			return false;
		}

		if (loaiSanPham == null) {
			JOptionPane.showMessageDialog(null, "Mã Loại sản phẩm chưa tồn tại");
			return false;
		}

		/*
		 * try { Float.parseFloat(stringdonGia); } catch (NumberFormatException e) {
		 * JOptionPane.showMessageDialog(null,
		 * "Đơn giá không phải là số thập phân hợp lệ"); return false; }
		 */

		int response = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn sửa?", "Sửa dữ liệu",
				JOptionPane.YES_NO_OPTION);
		if (response == JOptionPane.YES_OPTION) {
			// Cập nhật thông tin
			/* Float donGia = Float.parseFloat(stringdonGia); */
			sanPham.setMaSp(maSp);
			sanPham.setDonGia(donGia);
			sanPham.setSoLuong(soLuong);
			sanPham.setDonViTinh(donViTinh);
			sanPham.setIdLoaiSp(idLoaiSp);

			// Lưu lại thay đổi
			db.store(sanPham);

			return true;
		}
		return false;
	}

	// Xóa
	public boolean del(String maSp) {
		// Lấy dữ liệu
		SanPham del = getSanPham(maSp);
		ChiTietPhieuXuat xuat = getChiTietPhieuXuat(maSp);
		ChiTietPhieuNhap nhap = getChiTietPhieuNhap(maSp);
		ChiTietPhieuDieuChuyen dieuchuyen = getChiTietPhieuDieuChuyen(maSp);

		// Kiểm tra dữ liệu
		if (maSp == null || maSp.isEmpty()) {
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
	private SanPham getSanPham(String maSp) {
		// Tạo truy vấn SODA
		Query query = db.query();
		query.constrain(SanPham.class);
		query.descend("maSp").constrain(maSp);
		ObjectSet<SanPham> result = query.execute();
		return result.hasNext() ? result.next() : null;
	}

	// Tìm SanPham
	private LoaiSanPham getLoaiSanPham(String loaiSp) {
		// Tạo truy vấn SODA
		Query query = db.query();
		query.constrain(LoaiSanPham.class);
		query.descend("loaiSp").constrain(loaiSp);
		ObjectSet<LoaiSanPham> result = query.execute();
		return result.hasNext() ? result.next() : null;
	}

	// Tìm ChiTietPhieuNhap
	private ChiTietPhieuNhap getChiTietPhieuNhap(String maSp) {
		// Tạo truy vấn SODA
		Query query = db.query();
		query.constrain(ChiTietPhieuNhap.class);
		query.descend("maSp").constrain(maSp);
		ObjectSet<ChiTietPhieuNhap> result = query.execute();
		return result.hasNext() ? result.next() : null;
	}

	// Tìm ChiTietPhieuXuat
	private ChiTietPhieuXuat getChiTietPhieuXuat(String maSp) {
		// Tạo truy vấn SODA
		Query query = db.query();
		query.constrain(ChiTietPhieuXuat.class);
		query.descend("maSp").constrain(maSp);
		ObjectSet<ChiTietPhieuXuat> result = query.execute();
		return result.hasNext() ? result.next() : null;
	}

	// Tìm ChiTietPhieuDieuChuyen
	private ChiTietPhieuDieuChuyen getChiTietPhieuDieuChuyen(String maSp) {
		// Tạo truy vấn SODA
		Query query = db.query();
		query.constrain(ChiTietPhieuDieuChuyen.class);
		query.descend("maSp").constrain(maSp);
		ObjectSet<ChiTietPhieuDieuChuyen> result = query.execute();
		return result.hasNext() ? result.next() : null;
	}

}
