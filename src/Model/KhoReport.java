package Model;

import java.util.Date;

public class KhoReport {

	// Các thuộc tính
	private String maPhieu; // Mã phiếu nhập (Primary Key)
	private String maSp; // Mã sản phẩm
	private String tenSp; // Tên sản phẩm
	private float donGia; // Đơn giá
	private String donViTinh; // Đơn vị tính
	private int soLuong; // Số lượng
	private float thanhTien; // Thành tiền
	private String maNv; // Mã nhân viên
	private Date ngay; // Ngày nhập
	private String maKho; // Mã kho
	private float tongTien; // Tổng maKho

	private String maNvDi; // Mã nhân viên đi
	private String maNvDen; // Mã nhân viên đến
	private Date ngayDc; // Ngày điều chuyển
	private String maKhoDi; // Mã kho đi
	private String maKhoDen; // Mã kho đến

	// Constructor
	// Constructor
	public KhoReport(String maPhieu, String maSp, String tenSp, float donGia, String donViTinh, int soLuong,
			float thanhTien, String maNv, Date ngay, String maKho, float tongTien, String maNvDi, String maNvDen,
			Date ngayDc, String maKhoDi, String maKhoDen) {
		super();
		this.maPhieu = maPhieu;
		this.maSp = maSp;
		this.tenSp = tenSp;
		this.donGia = donGia;
		this.donViTinh = donViTinh;
		this.soLuong = soLuong;
		this.thanhTien = thanhTien;
		this.maNv = maNv;
		this.ngay = ngay;
		this.maKho = maKho;
		this.tongTien = tongTien;
		this.maNvDi = maNvDi;
		this.maNvDen = maNvDen;
		this.ngayDc = ngayDc;
		this.maKhoDi = maKhoDi;
		this.maKhoDen = maKhoDen;
	}

	public String getMaPhieu() {
		return maPhieu;
	}

	public void setMaPhieu(String mapn) {
		maPhieu = mapn;
	}

	public String getMaSp() {
		return maSp;
	}

	public void setMaSp(String maSp) {
		this.maSp = maSp;
	}

	public String getTenSp() {
		return tenSp;
	}

	public void setTenSp(String tenSp) {
		this.tenSp = tenSp;
	}

	public float getDonGia() {
		return donGia;
	}

	public void setDonGia(float donGia) {
		this.donGia = donGia;
	}

	public String getDonViTinh() {
		return donViTinh;
	}

	public void setDonViTinh(String donViTinh) {
		this.donViTinh = donViTinh;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public float getThanhTien() {
		return thanhTien;
	}

	public void setThanhTien(float thanhTien) {
		this.thanhTien = thanhTien;
	}

	public String getMaNv() {
		return maNv;
	}

	public void setMaNv(String maNv) {
		this.maNv = maNv;
	}

	public Date getNgay() {
		return ngay;
	}

	public void setNgay(Date ngay) {
		this.ngay = ngay;
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

	public String getMaNvDi() {
		return maNvDi;
	}

	public void setMaNvDi(String maNvDi) {
		this.maNvDi = maNvDi;
	}

	public String getMaNvDen() {
		return maNvDen;
	}

	public void setMaNvDen(String maNvDen) {
		this.maNvDen = maNvDen;
	}

	public Date getNgayDc() {
		return ngayDc;
	}

	public void setNgayDc(Date ngayDc) {
		this.ngayDc = ngayDc;
	}

	public String getMaKhoDi() {
		return maKhoDi;
	}

	public void setMaKhoDi(String maKhoDi) {
		this.maKhoDi = maKhoDi;
	}

	public String getMaKhoDen() {
		return maKhoDen;
	}

	public void setMaKhoDen(String maKhoDen) {
		this.maKhoDen = maKhoDen;
	}

	// Getters và Setters

}
