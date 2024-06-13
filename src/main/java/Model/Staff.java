package Model;

import java.sql.Date;

public class Staff {
	private int id;
	private String sdt;
	private String pass;
	private String ho_va_dem;
	private String ten;
	private String dia_chi;
	private Date dob;
	private String chuc_vu;
	public Staff() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Staff(int id, String sdt, String pass, String ho_va_dem, String ten, String dia_chi, Date dob,
			String chuc_vu) {
		super();
		this.id = id;
		this.sdt = sdt;
		this.pass = pass;
		this.ho_va_dem = ho_va_dem;
		this.ten = ten;
		this.dia_chi = dia_chi;
		this.dob = dob;
		this.chuc_vu = chuc_vu;
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
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getChuc_vu() {
		return chuc_vu;
	}
	public void setChuc_vu(String chuc_vu) {
		this.chuc_vu = chuc_vu;
	}
	@Override
	public String toString() {
		return "Staff [id=" + id + ", sdt=" + sdt + ", pass=" + pass + ", ho_va_dem=" + ho_va_dem + ", ten=" + ten
				+ ", dia_chi=" + dia_chi + ", dob=" + dob + ", chuc_vu=" + chuc_vu + "]";
	}
}
