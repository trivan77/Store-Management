package Model;

public class LoaiSanPham {
	private String loaiSp; // Loại sản phẩm - Primary Key, not null
	private String tenLoai; // Tên loại sản phẩm - nullable
	private String moTa; // Mô tả - nullable

	// Constructor
	public LoaiSanPham(String loaiSp, String tenLoai, String moTa) {
		this.loaiSp = loaiSp;
		this.tenLoai = tenLoai;
		this.moTa = moTa;
	}

	// Getters và Setters cho từng thuộc tính

	public String getLoaiSp() {
		return loaiSp;
	}

	public void setLoaiSp(String loaiSp) {
		this.loaiSp = loaiSp;
	}

	public String getTenLoai() {
		return tenLoai;
	}

	public void setTenLoai(String tenLoai) {
		this.tenLoai = tenLoai;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	@Override
	public String toString() {
		return "LoaiSanPham{" + "loaiSp='" + loaiSp + '\'' + ", tenLoai='" + tenLoai + '\'' + ", moTa='" + moTa + '\''
				+ '}';
	}
}
