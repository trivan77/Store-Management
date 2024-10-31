package Model;

public class Kho {

	// Các thuộc tính
	private String Makho; // Mã kho (Primary Key)
	private String Tenkho; // Tên kho
	private String Diachi; // Địa chỉ

	// Constructor
	public Kho(String Makho, String Tenkho, String Diachi) {
		this.Makho = Makho;
		this.Tenkho = Tenkho;
		this.Diachi = Diachi;
	}

	// Getters và Setters
	public String getMakho() {
		return Makho;
	}

	public void setMakho(String Makho) {
		this.Makho = Makho;
	}

	public String getTenkho() {
		return Tenkho;
	}

	public void setTenkho(String Tenkho) {
		this.Tenkho = Tenkho;
	}

	public String getDiachi() {
		return Diachi;
	}

	public void setDiachi(String Diachi) {
		this.Diachi = Diachi;
	}

	@Override
	public String toString() {
		return "Kho{" + "Makho='" + Makho + '\'' + ", Tenkho='" + Tenkho + '\'' + ", Diachi='" + Diachi + '\'' + '}';
	}
}
