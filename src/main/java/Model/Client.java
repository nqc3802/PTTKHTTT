package Model;

public class Client {
	private int id;
	private String sdt;
	private String pass;
	private String ho_va_dem;
	private String ten;
	private String dia_chi;

	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Client(int id, String sdt, String pass, String ho_va_dem, String ten, String dia_chi) {
		super();
		this.id = id;
		this.sdt = sdt;
		this.pass = pass;
		this.ho_va_dem = ho_va_dem;
		this.ten = ten;
		this.dia_chi = dia_chi;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getHo_va_dem() {
		return ho_va_dem;
	}

	public void setHo_va_dem(String ho_va_dem) {
		this.ho_va_dem = ho_va_dem;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getDia_chi() {
		return dia_chi;
	}

	public void setDia_chi(String dia_chi) {
		this.dia_chi = dia_chi;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", sdt=" + sdt + ", pass=" + pass + ", ho_va_dem=" + ho_va_dem + ", ten=" + ten
				+ ", dia_chi=" + dia_chi + "]";
	}
}
