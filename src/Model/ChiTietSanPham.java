package Model;

public class ChiTietSanPham {

    // Các thuộc tính
    private String maSp;      // Mã sản phẩm
    private String tenSp;     // Tên sản phẩm
    private String maKho;     // Mã kho
    private String tenKho;    // Tên kho
    private int soLuong;   // Số lượng

    // Constructor không tham số
    public ChiTietSanPham() {
    }

    // Constructor có tham số
    public ChiTietSanPham(String maSp, String tenSp, String maKho, String tenKho, int soLuong) {
        this.maSp = maSp;
        this.tenSp = tenSp;
        this.maKho = maKho;
        this.tenKho = tenKho;
        this.soLuong = soLuong;
    }

    // Getter và Setter cho maSp
    public String getMaSp() {
        return maSp;
    }

    public void setMaSp(String maSp) {
        this.maSp = maSp;
    }

    // Getter và Setter cho tenSp
    public String getTenSp() {
        return tenSp;
    }

    public void setTenSp(String tenSp) {
        this.tenSp = tenSp;
    }

    // Getter và Setter cho maKho
    public String getMaKho() {
        return maKho;
    }

    public void setMaKho(String maKho) {
        this.maKho = maKho;
    }

    // Getter và Setter cho tenKho
    public String getTenKho() {
        return tenKho;
    }

    public void setTenKho(String tenKho) {
        this.tenKho = tenKho;
    }

    // Getter và Setter cho soLuong
    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    // Phương thức toString để hiển thị thông tin đối tượng
    @Override
    public String toString() {
        return "ChiTietSanPham{" +
                "maSp='" + maSp + '\'' +
                ", tenSp='" + tenSp + '\'' +
                ", maKho='" + maKho + '\'' +
                ", tenKho='" + tenKho + '\'' +
                ", soLuong='" + soLuong + '\'' +
                '}';
    }
}
