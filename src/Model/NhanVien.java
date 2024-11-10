package Model;

public class NhanVien {
	private String maNv; // Mã nhân viên - Primary Key
	private String tenNv; // Tên nhân viên
	private String gioiTinh; // Giới tính
	private String dienThoai; // Điện thoại
	private String diaChi; // Địa chỉ
	private String soCmnd; // Số CMND
	private String chucVu; // Chức vụ
	private String matKhau; // Mật khẩu

	// Constructor
	public NhanVien(String maNv, String tenNv, String gioiTinh, String dienThoai, String diaChi, String soCmnd,
			String chucVu, String matKhau) {
		this.maNv = maNv;
		this.tenNv = tenNv;
		this.gioiTinh = gioiTinh;
		this.dienThoai = dienThoai;
		this.diaChi = diaChi;
		this.soCmnd = soCmnd;
		this.chucVu = chucVu;
		this.matKhau = matKhau;
	}

	public NhanVien() {
	}

	// Getters và Setters cho từng thuộc tính
	public String getMaNv() {
		return maNv;
	}

	public void setMaNv(String maNv) {
		this.maNv = maNv;
	}

	public String getTenNv() {
		return tenNv;
	}

	public void setTenNv(String tenNv) {
		this.tenNv = tenNv;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getDienThoai() {
		return dienThoai;
	}

	public void setDienThoai(String dienThoai) {
		this.dienThoai = dienThoai;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getSoCmnd() {
		return soCmnd;
	}

	public void setSoCmnd(String soCmnd) {
		this.soCmnd = soCmnd;
	}

	public String getChucVu() {
		return chucVu;
	}

	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	@Override
	public String toString() {
		return "NhanVien{" + "maNv='" + maNv + '\'' + ", tenNv='" + tenNv + '\'' + ", gioiTinh='" + gioiTinh + '\''
				+ ", dienThoai=" + dienThoai + ", diaChi='" + diaChi + '\'' + ", soCmnd=" + soCmnd + ", chucVu='"
				+ chucVu + '\'' + ", matKhau='" + matKhau + '\'' + '}';
	}
}
