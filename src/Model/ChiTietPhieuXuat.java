package Model;

public class ChiTietPhieuXuat {

	// Các thuộc tính
	private String maPx; // Mã phiếu xuất (Primary Key)
	private String maSp; // Mã sản phẩm
	private String tenSp; // Tên sản phẩm
	private float donGia; // Đơn giá
	private String donViTinh; // Đơn vị tính
	private int soLuong; // Số lượng
	private float thanhTien; // Thành tiền

	// Constructor
	public ChiTietPhieuXuat(String maPx, String maSp, String tenSp, float donGia, String donViTinh, int soLuong) {
		this.maPx = maPx;
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
	public String getMaPx() {
		return maPx;
	}

	public void setMaPx(String maPx) {
		this.maPx = maPx;
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
		return "PhieuXuat{" + "maPx='" + maPx + '\'' + ", maSp='" + maSp + '\'' + ", tenSp='" + tenSp + '\''
				+ ", donGia=" + donGia + ", donViTinh='" + donViTinh + '\'' + ", soLuong=" + soLuong + ", thanhTien="
				+ thanhTien + '}';
	}
}
