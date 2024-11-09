package Model;

public class TonKhoReport {
    private String maKho;
    private String tenKho;
    private String maSanPham;
    private String tenSanPham;
    private int soLuongNhap;
    private int soLuongXuat;
    private int soLuongTon;
    private String donViTinh;

    // Constructor
    public TonKhoReport(String maKho, String tenKho, String maSanPham, String tenSanPham,
                        int soLuongNhap, int soLuongXuat, int soLuongTon, String donViTinh) {
        this.maKho = maKho;
        this.tenKho = tenKho;
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        this.soLuongNhap = soLuongNhap;
        this.soLuongXuat = soLuongXuat;
        this.soLuongTon = soLuongTon;
        this.donViTinh = donViTinh;
    }

    // Getter methods
    public String getMaKho() {
        return maKho; // Trả về mã kho
    }

    public String getTenKho() {
        return tenKho; // Trả về tên kho
    }

    public String getMaSanPham() {
        return maSanPham; // Trả về mã sản phẩm
    }

    public String getTenSanPham() {
        return tenSanPham; // Trả về tên sản phẩm
    }

    public int getSoLuongNhap() {
        return soLuongNhap; // Trả về số lượng nhập
    }

    public int getSoLuongXuat() {
        return soLuongXuat; // Trả về số lượng xuất
    }

    public int getSoLuongTon() {
        return soLuongTon; // Trả về số lượng tồn kho
    }

    public String getDonViTinh() {
        return donViTinh; // Trả về đơn vị tính
    }
}
