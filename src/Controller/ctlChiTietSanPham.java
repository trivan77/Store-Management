package Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	// Thêm mới chi tiết sản phẩm
	public void SetChiTietSanPham(String maSp, String maKho, int num) {
		// Tạo một truy vấn để tìm ChiTietSanPham theo idsanPhamDetail và idStore
		Query query = db.query();
		query.constrain(ChiTietSanPham.class);
		query.descend("maSp").constrain(maSp);
		query.descend("maKho").constrain(maKho);

		ObjectSet<ChiTietSanPham> results = query.execute();

		if (!results.isEmpty()) {
			// Nếu tìm thấy, lấy bản ghi đầu tiên và cập nhật số lượng
			ChiTietSanPham chiTietSanPham = results.get(0);
			chiTietSanPham.setSoLuong(chiTietSanPham.getSoLuong() + num);
			db.store(chiTietSanPham); // Lưu bản ghi đã cập nhật vào db4o
		} else {
			// Nếu không tìm thấy, tạo một bản ghi mới
			ChiTietSanPham newChiTietSanPham = new ChiTietSanPham();
			newChiTietSanPham.setMaSp(maSp);
			newChiTietSanPham.setMaKho(maKho);
			newChiTietSanPham.setSoLuong(num);
			db.store(newChiTietSanPham); // Lưu bản ghi mới vào db4o
		}
		db.commit(); // Commit để đảm bảo thay đổi được lưu
	}

	// List tổng số lượng sản phẩm trên hệ thống => trả ra Map: Tên sản phẩm - Tổng số lượng
	public Map<String, Integer> GetSoLuongSanPham() {
		
		// Bước 1: Tính tổng số lượng của mỗi mã sản phẩm (maSp)
		ObjectSet<ChiTietSanPham> listChiThietSanPham = db.query(ChiTietSanPham.class);
		Map<String, Integer> mapSoLuong = new HashMap<>();

		for (ChiTietSanPham ctsp : listChiThietSanPham) {
			String maSp = ctsp.getMaSp();
			int num = ctsp.getSoLuong();
			mapSoLuong.put(maSp, mapSoLuong.getOrDefault(maSp, 0) + num);
		}

		// Bước 2: Truy vấn tên sản phẩm (tenSp) và tạo Map<tenSp, soLuong>
		Map<String, Integer> result = new HashMap<>();

		for (Map.Entry<String, Integer> entry : mapSoLuong.entrySet()) {
			String maSp = entry.getKey();
			int soLuong = entry.getValue();

			// Tìm đối tượng SanPham dựa trên maSp để lấy tenSp
			SanPham sanPhamExample = new SanPham();
			sanPhamExample.setMaSp(maSp);
			ObjectSet<SanPham> sanPhamResults = db.queryByExample(sanPhamExample);

			if (!sanPhamResults.isEmpty()) {
				SanPham sanPham = sanPhamResults.get(0);
				String tenSp = sanPham.getTenSp();

				// Thêm tenSp và tổng số lượng vào Map kết quả
				result.put(tenSp, soLuong);
			}
		}

		return result;
	}
	
	// List tổng số lượng sản phẩm trong kho chỉ đinh => trả ra Map: Tên sản phẩm - Tổng số lượng
	public Map<String, Integer> GetNumOfsanPham(String storeID){
		// Bước 1: Lọc các bản ghi ChiTietSanPham theo maKho và tính tổng số lượng cho mỗi maSp
        ChiTietSanPham example = new ChiTietSanPham();
        example.setMaKho(storeID);
        ObjectSet<ChiTietSanPham> chiTietSanPhamResults = db.queryByExample(example);

        Map<String, Integer> numOfsanPham = new HashMap<>();

        for (ChiTietSanPham ctsp : chiTietSanPhamResults) {
            String maSp = ctsp.getMaSp();
            int num = ctsp.getSoLuong();
            numOfsanPham.put(maSp, numOfsanPham.getOrDefault(maSp, 0) + num);
        }

        // Bước 2: Truy vấn tên sản phẩm từ bảng SanPham và tạo Map<tenSp, soLuong>
        Map<String, Integer> result = new HashMap<>();

        for (Map.Entry<String, Integer> entry : numOfsanPham.entrySet()) {
            String maSp = entry.getKey();
            int soLuong = entry.getValue();

            // Tìm đối tượng SanPham dựa trên maSp để lấy tenSp
            SanPham sanPhamExample = new SanPham();
            sanPhamExample.setMaSp(maSp);
            ObjectSet<SanPham> sanPhamResults = db.queryByExample(sanPhamExample);

            if (!sanPhamResults.isEmpty()) {
                SanPham sanPham = sanPhamResults.get(0);
                String tenSp = sanPham.getTenSp();

                // Thêm tenSp và tổng số lượng vào Map kết quả
                result.put(tenSp, soLuong);
            }
        }

        return result;
	}
}
