package Model;

import java.util.Date;

public class KhoReport {

	// Các thuộc tính
	private String Maphieu; // Mã phiếu nhập (Primary Key)
	private String Masp; // Mã sản phẩm
	private String Tensp; // Tên sản phẩm
	private float Dongia; // Đơn giá
	private String Donvitinh; // Đơn vị tính
	private int Soluong; // Số lượng
	private float Thanhtien; // Thành tiền
	private String Manv; // Mã nhân viên
	private Date Ngay; // Ngày nhập
	private String Makho; // Mã kho
	private float Tongtien; // Tổng tiền

	private String Manvdi; // Mã nhân viên đi
	private String Manvden; // Mã nhân viên đến
	private Date Ngaydc; // Ngày điều chuyển
	private String Makhodi; // Mã kho đi
	private String Makhoden; // Mã kho đến

	// Constructor
	public KhoReport(String maphieu, String masp, String tensp, float dongia, String donvitinh, int soluong,
			float thanhtien, String manv, Date ngay, String makho, float tongtien, String manvdi, String manvden,
			Date ngaydc, String makhodi, String makhoden) {
		super();
		Maphieu = maphieu;
		Masp = masp;
		Tensp = tensp;
		Dongia = dongia;
		Donvitinh = donvitinh;
		Soluong = soluong;
		Thanhtien = thanhtien;
		Manv = manv;
		Ngay = ngay;
		Makho = makho;
		Tongtien = tongtien;
		Manvdi = manvdi;
		Manvden = manvden;
		Ngaydc = ngaydc;
		Makhodi = makhodi;
		Makhoden = makhoden;
	}

	public String getMaphieu() {
		return Maphieu;
	}

	public void setMaphieu(String mapn) {
		Maphieu = mapn;
	}

	public String getMasp() {
		return Masp;
	}

	public void setMasp(String masp) {
		Masp = masp;
	}

	public String getTensp() {
		return Tensp;
	}

	public void setTensp(String tensp) {
		Tensp = tensp;
	}

	public float getDongia() {
		return Dongia;
	}

	public void setDongia(float dongia) {
		Dongia = dongia;
	}

	public String getDonvitinh() {
		return Donvitinh;
	}

	public void setDonvitinh(String donvitinh) {
		Donvitinh = donvitinh;
	}

	public int getSoluong() {
		return Soluong;
	}

	public void setSoluong(int soluong) {
		Soluong = soluong;
	}

	public float getThanhtien() {
		return Thanhtien;
	}

	public void setThanhtien(float thanhtien) {
		Thanhtien = thanhtien;
	}

	public String getManv() {
		return Manv;
	}

	public void setManv(String manv) {
		Manv = manv;
	}

	public Date getNgay() {
		return Ngay;
	}

	public void setNgay(Date ngay) {
		Ngay = ngay;
	}

	public String getMakho() {
		return Makho;
	}

	public void setMakho(String makho) {
		Makho = makho;
	}

	public float getTongtien() {
		return Tongtien;
	}

	public void setTongtien(float tongtien) {
		Tongtien = tongtien;
	}

	public String getManvdi() {
		return Manvdi;
	}

	public void setManvdi(String manvdi) {
		Manvdi = manvdi;
	}

	public String getManvden() {
		return Manvden;
	}

	public void setManvden(String manvden) {
		Manvden = manvden;
	}

	public Date getNgaydc() {
		return Ngaydc;
	}

	public void setNgaydc(Date ngaydc) {
		Ngaydc = ngaydc;
	}

	public String getMakhodi() {
		return Makhodi;
	}

	public void setMakhodi(String makhodi) {
		Makhodi = makhodi;
	}

	public String getMakhoden() {
		return Makhoden;
	}

	public void setMakhoden(String makhoden) {
		Makhoden = makhoden;
	}

	// Getters và Setters

}
