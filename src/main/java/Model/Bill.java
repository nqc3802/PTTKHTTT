package Model;

import java.sql.Date;

public class Bill {
	private int id;
	private int tong_tien;
	private Date ngay;
	private int id_nv;
	private int id_ncc;

	public Bill() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bill(int id, int tong_tien, Date ngay, int id_nv, int id_ncc) {
		super();
		this.id = id;
		this.tong_tien = tong_tien;
		this.ngay = ngay;
		this.id_nv = id_nv;
		this.id_ncc = id_ncc;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTong_tien() {
		return tong_tien;
	}

	public void setTong_tien(int tong_tien) {
		this.tong_tien = tong_tien;
	}

	public Date getNgay() {
		return ngay;
	}

	public void setNgay(Date ngay) {
		this.ngay = ngay;
	}

	public int getId_nv() {
		return id_nv;
	}

	public void setId_nv(int id_nv) {
		this.id_nv = id_nv;
	}

	public int getId_ncc() {
		return id_ncc;
	}

	public void setId_ncc(int id_ncc) {
		this.id_ncc = id_ncc;
	}

	@Override
	public String toString() {
		return "Bill [id=" + id + ", tong_tien=" + tong_tien + ", ngay=" + ngay + ", id_nv=" + id_nv + ", id_ncc="
				+ id_ncc + "]";
	}
}
