package Model;

public class NhanVien {
	private String Manv; // Mã nhân viên - Primary Key
	private String Tennv; // Tên nhân viên
	private String Gioitinh; // Giới tính
	private String Dienthoai; // Điện thoại
	private String Diachi; // Địa chỉ
	private String Socmnd; // Số CMND
	private String Chucvu; // Chức vụ
	private String Matkhau; // Mật khẩu

	// Constructor
	public NhanVien(String Manv, String Tennv, String Gioitinh, String Dienthoai, String Diachi, String Socmnd,
			String Chucvu, String Matkhau) {
		this.Manv = Manv;
		this.Tennv = Tennv;
		this.Gioitinh = Gioitinh;
		this.Dienthoai = Dienthoai;
		this.Diachi = Diachi;
		this.Socmnd = Socmnd;
		this.Chucvu = Chucvu;
		this.Matkhau = Matkhau;
	}

	public NhanVien() {
	}

	// Getters và Setters cho từng thuộc tính

	public String getManv() {
		return Manv;
	}

	public void setManv(String Manv) {
		this.Manv = Manv;
	}

	public String getTennv() {
		return Tennv;
	}

	public void setTennv(String Tennv) {
		this.Tennv = Tennv;
	}

	public String getGioitinh() {
		return Gioitinh;
	}

	public void setGioitinh(String Gioitinh) {
		this.Gioitinh = Gioitinh;
	}

	public String getDienthoai() {
		return Dienthoai;
	}

	public void setDienthoai(String Dienthoai) {
		this.Dienthoai = Dienthoai;
	}

	public String getDiachi() {
		return Diachi;
	}

	public void setDiachi(String Diachi) {
		this.Diachi = Diachi;
	}

	public String getSocmnd() {
		return Socmnd;
	}

	public void setSocmnd(String Socmnd) {
		this.Socmnd = Socmnd;
	}

	public String getChucvu() {
		return Chucvu;
	}

	public void setChucvu(String Chucvu) {
		this.Chucvu = Chucvu;
	}

	public String getMatkhau() {
		return Matkhau;
	}

	public void setMatkhau(String Matkhau) {
		this.Matkhau = Matkhau;
	}

	@Override
	public String toString() {
		return "NhanVien{" + "Manv='" + Manv + '\'' + ", Tennv='" + Tennv + '\'' + ", Gioitinh='" + Gioitinh + '\''
				+ ", Dienthoai=" + Dienthoai + ", Diachi='" + Diachi + '\'' + ", Socmnd=" + Socmnd + ", Chucvu='"
				+ Chucvu + '\'' + ", Matkhau='" + Matkhau + '\'' + '}';
	}
}
