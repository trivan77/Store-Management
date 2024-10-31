package Model;

import java.util.Date;

public class PhieuDieuChuyen {

	// Các thuộc tính
	private String Mapdc; // Mã phiếu điều chuyển (Primary Key)
	private String Manvdi; // Mã nhân viên đi
	private String Manvden; // Mã nhân viên đến
	private Date Ngaydc; // Ngày điều chuyển
	private String Makhodi; // Mã kho đi
	private String Makhoden; // Mã kho đến
	private float Tongtien; // Tổng tiền

	// Constructor
	public PhieuDieuChuyen(String Mapdc, String Manvdi, String Manvden, Date Ngaydc, String Makhodi, String Makhoden,
			float Tongtien) {
		this.Mapdc = Mapdc;
		this.Manvdi = Manvdi;
		this.Manvden = Manvden;
		this.Ngaydc = Ngaydc;
		this.Makhodi = Makhodi;
		this.Makhoden = Makhoden;
		this.Tongtien = Tongtien;
	}

	// Getters và Setters
	public String getMapdc() {
		return Mapdc;
	}

	public void setMapdc(String Mapdc) {
		this.Mapdc = Mapdc;
	}

	public String getManvdi() {
		return Manvdi;
	}

	public void setManvdi(String Manvdi) {
		this.Manvdi = Manvdi;
	}

	public String getManvden() {
		return Manvden;
	}

	public void setManvden(String Manvden) {
		this.Manvden = Manvden;
	}

	public java.util.Date getNgaydc() {
		return Ngaydc;
	}

	public void setNgaydc(java.util.Date Ngaydc) {
		this.Ngaydc = Ngaydc;
	}

	public String getMakhodi() {
		return Makhodi;
	}

	public void setMakhodi(String Makhodi) {
		this.Makhodi = Makhodi;
	}

	public String getMakhoden() {
		return Makhoden;
	}

	public void setMakhoden(String Makhoden) {
		this.Makhoden = Makhoden;
	}

	public float getTongtien() {
		return Tongtien;
	}

	public void setTongtien(float Tongtien) {
		this.Tongtien = Tongtien;
	}

	@Override
	public String toString() {
		return "PhieuDieuChuyen{" + "Mapdc='" + Mapdc + '\'' + ", Manvdi='" + Manvdi + '\'' + ", Manvden='" + Manvden
				+ '\'' + ", Ngaydc=" + Ngaydc + ", Makhodi='" + Makhodi + '\'' + ", Makhoden='" + Makhoden + '\''
				+ ", Tongtien=" + Tongtien + '}';
	}
}
