package Model;

public class ChiTietPhieuNhap {

	// Các thuộc tính
	private String Mapn; // Mã phiếu nhập (Primary Key)
	private String Masp; // Mã sản phẩm
	private String Tensp; // Tên sản phẩm
	private float Dongia; // Đơn giá
	private String Donvitinh; // Đơn vị tính
	private int Soluong; // Số lượng
	private float Thanhtien; // Thành tiền

	// Constructor
	public ChiTietPhieuNhap(String Mapn, String Masp, String Tensp, float Dongia, String Donvitinh, int Soluong) {
		this.Mapn = Mapn;
		this.Masp = Masp;
		this.Tensp = Tensp;
		this.Dongia = Dongia;
		this.Donvitinh = Donvitinh; 
		this.Soluong = Soluong;
		this.Thanhtien = calculateThanhtien(); // Tính thành tiền khi khởi tạo
	}

	// Phương thức tính thành tiền
	private float calculateThanhtien() {
		return this.Dongia * this.Soluong;
	}

	// Getters và Setters
	public String getMapn() {
		return Mapn;
	}

	public void setMapn(String Mapn) {
		this.Mapn = Mapn;
	}

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
		this.Thanhtien = calculateThanhtien(); // Cập nhật thành tiền khi đơn giá thay đổi
	}

	public String getDonvitinh() {
		return Donvitinh;
	}

	public void setDonvitinh(String Donvitinh) {
		this.Donvitinh = Donvitinh;
	}

	public int getSoluong() {
		return Soluong;
	}

	public void setSoluong(int Soluong) {
		this.Soluong = Soluong;
		this.Thanhtien = calculateThanhtien(); // Cập nhật thành tiền khi số lượng thay đổi
	}

	public float getThanhtien() {
		return Thanhtien;
	}

	@Override
	public String toString() {
		return "ChiTietPhieuNhap{" + "Mapn='" + Mapn + '\'' + ", Masp='" + Masp + '\'' + ", Tensp='" + Tensp + '\''
				+ ", Dongia=" + Dongia + ", Donvitinh='" + Donvitinh + '\'' + ", Soluong=" + Soluong + ", Thanhtien="
				+ Thanhtien + '}';
	}
}
