package Model;

import java.util.Date;

public class PhieuNhap {

	// Các thuộc tính
	private String maPn; // Mã phiếu nhập (Primary Key)
	private String maNv; // Mã nhân viên
	private Date ngayNhap; // Ngày nhập
	private String maKho; // Mã kho
	private float tongTien; // Tổng tiền

	// Constructor
	public PhieuNhap(String maPn, String maNv, Date ngayNhap, String maKho, float tongTien) {
		this.maPn = maPn;
		this.maNv = maNv;
		this.ngayNhap = ngayNhap;
		this.maKho = maKho;
		this.tongTien = tongTien;
	}

	// Getters và Setters
	public String getMaPn() {
		return maPn;
	}

	public void setMaPn(String maPn) {
		this.maPn = maPn;
	}

	public String getMaNv() {
		return maNv;
	}

	public void setMaNv(String maNv) {
		this.maNv = maNv;
	}

	public java.util.Date getNgayNhap() {
		return ngayNhap;
	}

	public void setNgayNhap(Date ngayNhap) {
		this.ngayNhap = ngayNhap;
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
		return "PhieuNhap{" + "maPn='" + maPn + '\'' + ", maNv='" + maNv + '\'' + ", ngayNhap=" + ngayNhap + ", maKho='"
				+ maKho + '\'' + ", tongTien=" + tongTien + '}';
	}
}
