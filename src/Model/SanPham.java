package Model;

public class SanPham {
	private String Masp; // Mã sản phẩm - Primary Key
	private String Tensp; // Tên sản phẩm
	private float Dongia; // Đơn giá
	private String Donvitinh; // Đơn vị tính
	private String Loaisp; // Loại sản phẩm

	// Constructor
	public SanPham(String Masp, String Tensp, float Dongia, String Donvitinh, String Loaisp) {
		this.Masp = Masp;
		this.Tensp = Tensp;
		this.Dongia = Dongia;
		this.Donvitinh = Donvitinh;
		this.Loaisp = Loaisp;
	}

	// Getters và Setters cho từng thuộc tính

	public String getMasp() {
		return Masp;
	}

	public void setMasp(String Masp) {
		this.Masp = Masp;
	}

	public String getTensp() {
		return Tensp;
	}

	public void setTensp(String Tensp) {
		this.Tensp = Tensp;
	}

	public float getDongia() {
		return Dongia;
	}

	public void setDongia(float Dongia) {
		this.Dongia = Dongia;
	}

	public String getDonvitinh() {
		return Donvitinh;
	}

	public void setDonvitinh(String Donvitinh) {
		this.Donvitinh = Donvitinh;
	}

	public String getLoaisp() {
		return Loaisp;
	}

	public void setLoaisp(String Loaisp) {
		this.Loaisp = Loaisp;
	}

	@Override
	public String toString() {
		return "SanPham{" + "Masp='" + Masp + '\'' + ", Tensp='" + Tensp + '\'' + ", Dongia=" + Dongia + ", Donvitinh='"
				+ Donvitinh + '\'' + ", Loaisp='" + Loaisp + '\'' + '}';
	}
}
