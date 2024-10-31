package Model;

public class LoaiSanPham {
	private String Loaisp; // Loại sản phẩm - Primary Key, not null
	private String Tenloai; // Tên loại sản phẩm - nullable
	private String Mota; // Mô tả - nullable

	// Constructor
	public LoaiSanPham(String Loaisp, String Tenloai, String Mota) {
		this.Loaisp = Loaisp;
		this.Tenloai = Tenloai;
		this.Mota = Mota;
	} 

	// Getters và Setters cho từng thuộc tính

	public String getLoaisp() {
		return Loaisp;
	}
 
	public void setLoaisp(String Loaisp) {
		this.Loaisp = Loaisp;
	}

	public String getTenloai() {
		return Tenloai;
	}

	public void setTenloai(String Tenloai) {
		this.Tenloai = Tenloai;
	}

	public String getMota() {
		return Mota;
	}

	public void setMota(String Mota) {
		this.Mota = Mota;
	}

	@Override
	public String toString() {
		return "LoaiSanPham{" + "Loaisp='" + Loaisp + '\'' + ", Tenloai='" + Tenloai + '\'' + ", Mota='" + Mota + '\''
				+ '}';
	}
}
