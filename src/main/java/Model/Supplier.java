package Model;

public class Supplier {
	private int id;
	private String ten;
	private String dia_chi;
	private String sdt;
	private String email;

	public Supplier() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Supplier(int id, String ten, String dia_chi, String sdt, String email) {
		super();
		this.id = id;
		this.ten = ten;
		this.dia_chi = dia_chi;
		this.sdt = sdt;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "NCC [id=" + id + ", ten=" + ten + ", dia_chi=" + dia_chi + ", sdt=" + sdt + ", email=" + email + "]";
	}

}
