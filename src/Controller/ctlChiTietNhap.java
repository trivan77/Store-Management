package Controller;

import com.db4o.*;
import com.db4o.query.*;

import Model.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ctlChiTietNhap {
	private ObjectContainer db;

	public ctlChiTietNhap(ObjectContainer db) {
		this.db = db;
	}
	
	public void SetChiTietPhieuNhap(String maPn, String maSp, int soLuong) {
		
		Query queryDonGia = db.query();
        queryDonGia.constrain(SanPham.class);
        queryDonGia.descend("maSp").constrain(maSp);
        ObjectSet<SanPham> resultDonGia = queryDonGia.execute();
        SanPham sanPham = resultDonGia.next();
        float donGia = sanPham.getDonGia();
        
        float thanhTien = donGia * soLuong;
		
		ChiTietPhieuNhap chiTiet = new ChiTietPhieuNhap(maPn, maSp, soLuong, thanhTien);
		
        // Kiểm tra xem đối tượng đã tồn tại chưa
        Query query = db.query();
        query.constrain(ChiTietPhieuNhap.class);
        query.descend("maPn").constrain(chiTiet.getMaPn());
        query.descend("maSp").constrain(chiTiet.getMaSp());

        ObjectSet<ChiTietPhieuNhap> result = query.execute();
        if (result.isEmpty()) {
            // Nếu không tồn tại, lưu đối tượng vào cơ sở dữ liệu
            db.store(chiTiet);
            db.commit();
        } else {
        }
    }
	
	public List<ChiTietPhieuNhap> layChiTietPhieuNhapTheoMaPn(String maPn) {
        // Tạo truy vấn SODA để lấy danh sách ChiTietPhieuNhap theo maPn
        Query query = db.query();
        query.constrain(ChiTietPhieuNhap.class);
        query.descend("maPn").constrain(maPn);

        ObjectSet<ChiTietPhieuNhap> result = query.execute();
        return new ArrayList<>(result);
    }
}
