package Model;

import java.util.Date;

public class PhieuXuat {
	private String maPx; // Mã phiếu xuất - Primary Key, not null
	private String maNv; // Mã nhân viên - nullable
	private Date ngayXuat; // Ngày xuất - nullable
	private String maKho; // Mã kho - nullable
	private float tongTien; // Tổng tiền - nullable

	// Constructor
	public PhieuXuat(String maPx, String maNv, Date ngayXuat, String maKho, float tongTien) {
		this.maPx = maPx;
		this.maNv = maNv;
		this.ngayXuat = ngayXuat;
		this.maKho = maKho;
		this.tongTien = tongTien;
	}

	// Getters và Setters cho từng thuộc tính

	public String getMaPx() {
		return maPx;
	}

	public void setMaPx(String maPx) {
		this.maPx = maPx;
	}

	public String getMaNv() {
		return maNv;
	}

	public void setMaNv(String maNv) {
		this.maNv = maNv;
	}

	public Date getNgayXuat() {
		return ngayXuat;
	}

	public void setNgayXuat(Date ngayXuat) {
		this.ngayXuat = ngayXuat;
	}

	public String getMaKho() {
		return maKho;
	}

	public void setMaKho(String maKho) {
		this.maKho = maKho;
	}

	public float getTongTien() {
		return tongTien;
	}

	public void setTongTien(float tongTien) {
		this.tongTien = tongTien;
	}

	@Override
	public String toString() {
		return "PhieuXuat{" + "maPx='" + maPx + '\'' + ", maNv='" + maNv + '\'' + ", ngayXuat=" + ngayXuat + ", maKho='"
				+ maKho + '\'' + ", tongTien=" + tongTien + '}';
	}
}
