package Model;

public class Kho {

	// Các thuộc tính
	private String maKho; // Mã kho (Primary Key)
	private String tenKho; // Tên kho
	private String diaChi; // Địa chỉ

	// Constructor
	public Kho(String maKho, String tenKho, String diaChi) {
		this.maKho = maKho;
		this.tenKho = tenKho;
		this.diaChi = diaChi;
	}

	// Getters và Setters
	public String getMaKho() {
		return maKho;
	}

	public void setMaKho(String maKho) {
		this.maKho = maKho;
	}

	public String getTenKho() {
		return tenKho;
	}

	public void setTenKho(String tenKho) {
		this.tenKho = tenKho;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	@Override
	public String toString() {
		return "Kho{" + "maKho='" + maKho + '\'' + ", tenKho='" + tenKho + '\'' + ", diaChi='" + diaChi + '\'' + '}';
	}
}
