package Controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;

import Model.LoaiSanPham;
import Model.SanPham;

public class ctlLoaiSanPham {

	private ObjectContainer db;

	public ctlLoaiSanPham(ObjectContainer db) {
		this.db = db;
	}

	// Lấy danh sách Loại sản phẩm
	public List<LoaiSanPham> layDanhSachLoaiSanPham(String Loaisp, String Tenloai) {
		List<LoaiSanPham> loaiSanPham = new ArrayList<>();

		// Tạo truy vấn SODA
		Query query = db.query();
		query.constrain(LoaiSanPham.class);

		// Thêm điều kiện cho loaisp nếu không rỗng
		if (Loaisp != null && !Loaisp.isEmpty()) {
			query.descend("Loaisp").constrain(Loaisp);
		}

		// Thêm điều kiện cho tenloai nếu không rỗng
		if (Tenloai != null && !Tenloai.isEmpty()) {
			query.descend("Tenloai").constrain(Tenloai);
		}

		// Thêm sắp xếp tăng dần theo Loaisp
		query.descend("Loaisp").orderAscending();

		// Thực hiện truy vấn
		ObjectSet<LoaiSanPham> result = query.execute();

		// Lưu kết quả vào danh sách
		while (result.hasNext()) {
			loaiSanPham.add(result.next());
		}

		return loaiSanPham;

	}

	// Thêm LoaiSanPham
	public boolean add(String Loaisp, String Tenloai, String Mota) {
		// Lấy dữ liệu
		LoaiSanPham loaiSanPham = getLoaiSanPham(Loaisp);

		// Kiểm tra dữ liệu
		if (Loaisp == null || Loaisp.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập Loại sản phẩm");
			return false;
		}

		if (loaiSanPham != null) {
			JOptionPane.showMessageDialog(null, "Mã Loại sản phẩm đã tồn tại");
			return false;
		}

		int response = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn thêm?", "Thêm dữ liệu",
				JOptionPane.YES_NO_OPTION);
		if (response == JOptionPane.YES_OPTION) {
			// Lưu lại thay đổi
			db.store(new LoaiSanPham(Loaisp, Tenloai, Mota));
			return true;
		}

		return false;

	}

	// Sửa LoaiSanPham
	public boolean edit(String Loaisp, String Tenloai, String Mota) {
		// Lấy dữ liệu
		LoaiSanPham loaiSanPham = getLoaiSanPham(Loaisp);

		// Kiểm tra dữ liệu
		if (Loaisp == null || Loaisp.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập Loại sản phẩm");
			return false;
		}

		if (loaiSanPham == null) {
			JOptionPane.showMessageDialog(null, "Mã Loại sản phẩm chưa tồn tại");
			return false;
		}

		int response = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn sửa?", "Sửa dữ liệu",
				JOptionPane.YES_NO_OPTION);
		if (response == JOptionPane.YES_OPTION) {
			// Cập nhật thông tin trực tiếp cho đối tượng hiện tại
			loaiSanPham.setTenloai(Tenloai);
			loaiSanPham.setMota(Mota);

			// Lưu lại thay đổi
			db.store(loaiSanPham);
			return true;
		}
		return false;
	}

	// Xóa LoaiSanPham
	public boolean del(String Loaisp) {
		// Lấy dữ liệu
		LoaiSanPham loaiSanPham = getLoaiSanPham(Loaisp);
		SanPham sanPham = getSanPham(Loaisp);

		// Kiểm tra dữ liệu
		if (Loaisp == null || Loaisp.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập Loại sản phẩm");
			return false;
		}

		if (loaiSanPham == null) {
			JOptionPane.showMessageDialog(null, "Mã Loại sản phẩm chưa tồn tại");
			return false;
		}

		if (sanPham != null) {
			JOptionPane.showMessageDialog(null, "Xóa thất bại: Mã đang được tham chiếu ở các bản ghi liên quan.");
			return false;
		}

		int response = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa?", "Xóa dữ liệu",
				JOptionPane.YES_NO_OPTION);
		if (response == JOptionPane.YES_OPTION) {
			db.delete(loaiSanPham);
			return true;
		}
		return false;
	}

	// Tìm LoaiSanPham dựa trên mã sản phẩm
	private LoaiSanPham getLoaiSanPham(String Loaisp) {
		ObjectSet<LoaiSanPham> loaiSanPham = db.queryByExample(new LoaiSanPham(Loaisp, null, null));
		return loaiSanPham.hasNext() ? loaiSanPham.next() : null;
	}

	// Tìm SanPham dựa trên mã sản phẩm
	private SanPham getSanPham(String Loaisp) {
		// Tạo truy vấn SODA
		Query query = db.query();
		query.constrain(SanPham.class);
		query.descend("Loaisp").constrain(Loaisp);
		ObjectSet<SanPham> result = query.execute();
		return result.hasNext() ? result.next() : null;
	}
}
