package Controller;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;

import Model.NhanVien;

public class ctlDangNhap {
	private static ObjectContainer db;

	public ctlDangNhap(ObjectContainer db) {
		this.db = db;
	}

	public static boolean validateUser(String userName, String passWord) {
		Query query = db.query();
		query.constrain(NhanVien.class);
		query.descend("maNv").constrain(userName);
		query.descend("matKhau").constrain(passWord);
		ObjectSet<NhanVien> result = query.execute();
		return result.size() > 0;
	}

}
