package Model;

public class ChiTietPhieuNhap {

	// Các thuộc tính
	private String maPn; // Mã phiếu nhập (Primary Key)
	private String maSp; // Mã sản phẩm
	private String tenSp; // Tên sản phẩm
	private float donGia; // Đơn giá
	private String donViTinh; // Đơn vị tính
	private int soLuong; // Số lượng
	private float thanhTien; // Thành tiền

	// Constructor
	public ChiTietPhieuNhap(String maPn, String maSp, String tenSp, float donGia, String donViTinh, int soLuong) {
		this.maPn = maPn;
		this.maSp = maSp;
		this.tenSp = tenSp;
		this.donGia = donGia;
		this.donViTinh = donViTinh;
		this.soLuong = soLuong;
		this.thanhTien = CalculateThanhTien(); // Tính thành tiền khi khởi tạo
	}

	// Phương thức tính thành tiền
	private float CalculateThanhTien() {
		return this.donGia * this.soLuong;
	}

	// Getters và Setters
	public String getMaPn() {
		return maPn;
	}

	public void setMaPn(String maPn) {
		this.maPn = maPn;
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
		this.thanhTien = CalculateThanhTien(); // Cập nhật thành tiền khi đơn giá thay đổi
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
		this.thanhTien = CalculateThanhTien(); // Cập nhật thành tiền khi số lượng thay đổi
	}

	public float getThanhTien() {
		return thanhTien;
	}

	@Override
	public String toString() {
		return "ChiTietPhieuNhap{" + "maPn='" + maPn + '\'' + ", maSp='" + maSp + '\'' + ", tenSp='" + tenSp + '\''
				+ ", donGia=" + donGia + ", donViTinh='" + donViTinh + '\'' + ", soLuong=" + soLuong + ", thanhTien="
				+ thanhTien + '}';
	}
}
