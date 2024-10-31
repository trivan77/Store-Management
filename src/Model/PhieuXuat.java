package Model;

import java.util.Date;

public class PhieuXuat {
	private String Mapx; // Mã phiếu xuất - Primary Key, not null
	private String Manv; // Mã nhân viên - nullable
	private Date Ngayxuat; // Ngày xuất - nullable
	private String Makho; // Mã kho - nullable
	private float Tongtien; // Tổng tiền - nullable

	// Constructor
	public PhieuXuat(String Mapx, String Manv, Date Ngayxuat, String Makho, float Tongtien) {
		this.Mapx = Mapx;
		this.Manv = Manv;
		this.Ngayxuat = Ngayxuat;
		this.Makho = Makho;
		this.Tongtien = Tongtien;
	}

	// Getters và Setters cho từng thuộc tính

	public String getMapx() {
		return Mapx;
	}

	public void setMapx(String Mapx) {
		this.Mapx = Mapx;
	}

	public String getManv() {
		return Manv;
	}

	public void setManv(String Manv) {
		this.Manv = Manv;
	}

	public Date getNgayxuat() {
		return Ngayxuat;
	}

	public void setNgayxuat(Date Ngayxuat) {
		this.Ngayxuat = Ngayxuat;
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
		return "PhieuXuat{" + "Mapx='" + Mapx + '\'' + ", Manv='" + Manv + '\'' + ", Ngayxuat=" + Ngayxuat + ", Makho='"
				+ Makho + '\'' + ", Tongtien=" + Tongtien + '}';
	}
}
