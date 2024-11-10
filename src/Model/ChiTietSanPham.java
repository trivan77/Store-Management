package Model;

public class ChiTietSanPham {

	// Các thuộc tính
	private String maCtSp; // Mã chi tiết sản phẩm
    private String maSp;      // Mã sản phẩm
    private String maKho;     // Mã kho
    private int soLuong;   // Số lượng

    // Constructor không tham số
    public ChiTietSanPham() {
    }

    // Constructor có tham số
    public ChiTietSanPham(String maCtSp, String maSp, String maKho, int soLuong) {
        this.maCtSp = maCtSp;
        this.maSp = maSp;
        this.maKho = maKho;
        this.soLuong = soLuong;
    }

    // Getter và Setter cho maSp

    public String getMaCtSp() {
		return maCtSp;
	}

	public void setMaCtSp(String maCtSp) {
		this.maCtSp = maCtSp;
	}
	
    public String getMaSp() {
        return maSp;
    }

    public void setMaSp(String maSp) {
        this.maSp = maSp;
    }

    // Getter và Setter cho maKho
    public String getMaKho() {
        return maKho;
    }

    public void setMaKho(String maKho) {
        this.maKho = maKho;
    }

    // Getter và Setter cho soLuong
    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    // Phương thức toString để hiển thị thông tin đối tượng
	/*
	 * @Override public String toString() { return "ChiTietSanPham{" + "maSp='" +
	 * maSp + '\'' + ", tenSp='" + tenSp + '\'' + ", maKho='" + maKho + '\'' +
	 * ", tenKho='" + tenKho + '\'' + ", soLuong='" + soLuong + '\'' + '}'; }
	 */
}
