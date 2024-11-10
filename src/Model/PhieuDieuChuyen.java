package Model;

import java.util.Date;

public class PhieuDieuChuyen {

	// Các thuộc tính
	private String maPdc; // Mã phiếu điều chuyển (Primary Key)
	private String maNvDi; // Mã nhân viên đi
	private String maNvDen; // Mã nhân viên đến
	private Date ngayDc; // Ngày điều chuyển
	private String maKhoDi; // Mã kho đi
	private String maKhoDen; // Mã kho đến
	private float tongTien; // Tổng tiền

	// Constructor
	public PhieuDieuChuyen(String maPdc, String maNvDi, String maNvDen, Date ngayDc, String maKhoDi, String maKhoDen,
			float tongTien) {
		this.maPdc = maPdc;
		this.maNvDi = maNvDi;
		this.maNvDen = maNvDen;
		this.ngayDc = ngayDc;
		this.maKhoDi = maKhoDi;
		this.maKhoDen = maKhoDen;
		this.tongTien = tongTien;
	}

	// Getters và Setters
	public String getMaPdc() {
		return maPdc;
	}

	public void setMaPdc(String maPdc) {
		this.maPdc = maPdc;
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

	public java.util.Date getNgayDc() {
		return ngayDc;
	}

	public void setNgayDc(java.util.Date ngayDc) {
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

	public float getTongTien() {
		return tongTien;
	}

	public void setTongTien(float tongTien) {
		this.tongTien = tongTien;
	}

	@Override
	public String toString() {
		return "PhieuDieuChuyen{" + "maPdc='" + maPdc + '\'' + ", maNvDi='" + maNvDi + '\'' + ", maNvDen='" + maNvDen
				+ '\'' + ", ngayDc=" + ngayDc + ", maKhoDi='" + maKhoDi + '\'' + ", maKhoDen='" + maKhoDen + '\''
				+ ", tongTien=" + tongTien + '}';
	}
}
