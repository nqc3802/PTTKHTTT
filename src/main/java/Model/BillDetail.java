package Model;

public class BillDetail {
	private int id;
	private int sl;
	private int gia;
	private int tt;
	private String note;
	private int id_hd;
	private int id_mh;

	public BillDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BillDetail(int id, int sl, int gia, int tt, String note, int id_hd, int id_mh) {
		super();
		this.id = id;
		this.sl = sl;
		this.gia = gia;
		this.tt = tt;
		this.note = note;
		this.id_hd = id_hd;
		this.id_mh = id_mh;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSl() {
		return sl;
	}

	public void setSl(int sl) {
		this.sl = sl;
	}

	public int getGia() {
		return gia;
	}

	public void setGia(int gia) {
		this.gia = gia;
	}

	public int getTt() {
		return tt;
	}

	public void setTt(int tt) {
		this.tt = tt;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public int getId_hd() {
		return id_hd;
	}

	public void setId_hd(int id_hd) {
		this.id_hd = id_hd;
	}

	public int getId_mh() {
		return id_mh;
	}

	public void setId_mh(int id_mh) {
		this.id_mh = id_mh;
	}

	@Override
	public String toString() {
		return "BillDetail [id=" + id + ", sl=" + sl + ", gia=" + gia + ", tt=" + tt + ", note=" + note + ", id_hd="
				+ id_hd + ", id_mh=" + id_mh + "]";
	}
}
