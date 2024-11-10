package Model;

public class SanPham {
	private String maSp; // Mã sản phẩm - Primary Key
	private String tenSp; // Tên sản phẩm
	private float donGia; // Đơn giá
	private String donViTinh; // Đơn vị tính
	private String loaiSp; // Loại sản phẩm

	// Constructor
	public SanPham(String maSp, String tenSp, float donGia, String donViTinh, String loaiSp) {
		this.maSp = maSp;
		this.tenSp = tenSp;
		this.donGia = donGia;
		this.donViTinh = donViTinh;
		this.loaiSp = loaiSp;
	}
	
	public SanPham() {
	}

	// Getters và Setters cho từng thuộc tính

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

	public String getLoaiSp() {
		return loaiSp;
	}

	public void setLoaiSp(String loaiSp) {
		this.loaiSp = loaiSp;
	}

	@Override
	public String toString() {
		return "SanPham{" + "maSp='" + maSp + '\'' + ", tenSp='" + tenSp + '\'' + ", donGia=" + donGia + ", donViTinh='"
				+ donViTinh + '\'' + ", loaiSp='" + loaiSp + '\'' + '}';
	}
}
