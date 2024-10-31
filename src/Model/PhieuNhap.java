package Model;

import java.util.Date;

public class PhieuNhap {

	// Các thuộc tính
	private String Mapn; // Mã phiếu nhập (Primary Key)
	private String Manv; // Mã nhân viên
	private Date Ngaynhap; // Ngày nhập
	private String Makho; // Mã kho
	private float Tongtien; // Tổng tiền

	// Constructor
	public PhieuNhap(String Mapn, String Manv, Date Ngaynhap, String Makho, float Tongtien) {
		this.Mapn = Mapn;
		this.Manv = Manv;
		this.Ngaynhap = Ngaynhap;
		this.Makho = Makho;
		this.Tongtien = Tongtien;
	}

	// Getters và Setters
	public String getMapn() {
		return Mapn;
	}

	public void setMapn(String Mapn) {
		this.Mapn = Mapn;
	}

	public String getManv() {
		return Manv;
	}

	public void setManv(String Manv) {
		this.Manv = Manv;
	}

	public java.util.Date getNgaynhap() {
		return Ngaynhap;
	}

	public void setNgaynhap(Date Ngaynhap) {
		this.Ngaynhap = Ngaynhap;
	}

	public String getMakho() {
		return Makho;
	}

	public void setMakho(String Makho) {
		this.Makho = Makho;
	}

	public float getTongtien() {
		return Tongtien;
	}

	public void setTongtien(float Tongtien) {
		this.Tongtien = Tongtien;
	}

	@Override
	public String toString() {
		return "PhieuNhap{" + "Mapn='" + Mapn + '\'' + ", Manv='" + Manv + '\'' + ", Ngaynhap=" + Ngaynhap + ", Makho='"
				+ Makho + '\'' + ", Tongtien=" + Tongtien + '}';
	}
}
