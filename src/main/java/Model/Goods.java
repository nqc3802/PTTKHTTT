package Model;

public class Goods {
	private int id;
	private String ten;
	private int id_NCC;
	private int don_gia;
	private int so_luong;
	private String mo_ta;
	public Goods() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Goods(int id, String ten, int id_NCC, int don_gia, int so_luong, String mo_ta) {
		super();
		this.id = id;
		this.ten = ten;
		this.id_NCC = id_NCC;
		this.don_gia = don_gia;
		this.so_luong = so_luong;
		this.mo_ta = mo_ta;
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
	public int getId_NCC() {
		return id_NCC;
	}
	public void setId_NCC(int id_NCC) {
		this.id_NCC = id_NCC;
	}
	public int getDon_gia() {
		return don_gia;
	}
	public void setDon_gia(int don_gia) {
		this.don_gia = don_gia;
	}
	public int getSo_luong() {
		return so_luong;
	}
	public void setSo_luong(int so_luong) {
		this.so_luong = so_luong;
	}
	public String getMo_ta() {
		return mo_ta;
	}
	public void setMo_ta(String mo_ta) {
		this.mo_ta = mo_ta;
	}
	@Override
	public String toString() {
		return "MH [id=" + id + ", ten=" + ten + ", id_NCC=" + id_NCC + ", don_gia=" + don_gia + ", so_luong="
				+ so_luong + ", mo_ta=" + mo_ta + "]";
	}
}
