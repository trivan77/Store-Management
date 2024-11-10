package Model;

public class ChiTietPhieuDieuChuyen {

	// Các thuộc tính
	private String maPdc; // Mã phiếu điều chuyển (Primary Key)
	private String maSp; // Mã sản phẩm
	private String tenSp; // Tên sản phẩm
	private float donGia; // Đơn giá
	private String donViTinh; // Đơn vị tính
	private int soLuong; // Số lượng
	private float thanhTien; // Thành tiền

	// Constructor
	public ChiTietPhieuDieuChuyen(String maPdc, String maSp, String tenSp, float donGia, String donViTinh,
			int soLuong) {
		this.maPdc = maPdc;
		this.maSp = maSp;
		this.tenSp = tenSp;
		this.donGia = donGia;
		this.donViTinh = donViTinh;
		this.soLuong = soLuong;
		this.thanhTien = calculateThanhTien(); // Tính thành tiền khi khởi tạo
	}

	// Phương thức tính thành tiền
	private float calculateThanhTien() {
		return this.donGia * this.soLuong;
	}

	// Getters và Setters
	public String getMaPdc() {
		return maPdc;
	}

	public void setMaPdc(String maPdc) {
		this.maPdc = maPdc;
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
		this.thanhTien = calculateThanhTien(); // Cập nhật thành tiền khi đơn giá thay đổi
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
		this.thanhTien = calculateThanhTien(); // Cập nhật thành tiền khi số lượng thay đổi
	}

	public float getThanhTien() {
		return thanhTien;
	}

	@Override
	public String toString() {
		return "ChiTietPhieuDieuChuyen{" + "maPdc='" + maPdc + '\'' + ", maSp='" + maSp + '\'' + ", tenSp='" + tenSp
				+ '\'' + ", donGia=" + donGia + ", donViTinh='" + donViTinh + '\'' + ", soLuong=" + soLuong
				+ ", thanhTien=" + thanhTien + '}';
	}
}
