package Model;

public class ChiTietPhieuNhap {

	// Các thuộc tính
	private String maPn; // Mã phiếu nhập (Primary Key)
	private String maSp; // Mã sản phẩm
	private int soLuong; // Số lượng
	private float thanhTien; // Thành tiền

	// Constructor
	public ChiTietPhieuNhap(String maPn, String maSp, int soLuong, float thanhTien) {
		this.maPn = maPn;
		this.maSp = maSp;
		this.soLuong = soLuong;
		this.thanhTien = thanhTien; // Tính thành tiền khi khởi tạo
	}

	public ChiTietPhieuNhap() {
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

	/*
	 * @Override public String toString() { return "ChiTietPhieuNhap{" + "maPn='" +
	 * maPn + '\'' + ", maSp='" + maSp + '\'' + ", tenSp='" + tenSp + '\'' +
	 * ", donGia=" + donGia + ", donViTinh='" + donViTinh + '\'' + ", soLuong=" +
	 * soLuong + ", thanhTien=" + thanhTien + '}'; }
	 */
}
