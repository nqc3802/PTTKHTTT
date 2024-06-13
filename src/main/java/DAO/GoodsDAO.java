package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DB.DB;
import Model.Goods;

public class GoodsDAO {
	Connection c = null;
	PreparedStatement s = null;
	ResultSet r = null;

	public List<Goods> getListMH() {
		List<Goods> listMh = new ArrayList<>();
		String query = "SELECT * FROM pttkhttt.mat_hang;";
		try {
			c = new DB().getConnection();
			s = c.prepareStatement(query);
			r = s.executeQuery();
			while (r.next()) {
				listMh.add(new Goods(r.getInt(1), r.getString(2), r.getInt(3), r.getInt(4), r.getInt(5), r.getString(6)));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
            new DB().closeConnection(c);
        }
		return listMh;
	}

	public List<Goods> getListMHByNCC(int id_ncc) {
		List<Goods> listMh = new ArrayList<>();
		String query = "SELECT * FROM pttkhttt.mat_hang where id_ncc = ?";
		try {
			c = new DB().getConnection();
			s = c.prepareStatement(query);
			s.setInt(1, id_ncc);
			r = s.executeQuery();
			while (r.next()) {
				listMh.add(new Goods(r.getInt(1), r.getString(2), r.getInt(3), r.getInt(4), r.getInt(5), r.getString(6)));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
            new DB().closeConnection(c);
        }
		return listMh;
	}
	
	public Goods check(String ten) {
		String query = "SELECT * FROM pttkhttt.mat_hang where ten = ?;";
		Goods mh = null;
		try {
			c = new DB().getConnection();
			s = c.prepareStatement(query);
			s.setString(1, ten);
			r = s.executeQuery();
			while(r.next()) {
				mh = new Goods(r.getInt(1), r.getString(2), r.getInt(3), r.getInt(4), r.getInt(5), r.getString(6));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
            new DB().closeConnection(c);
        }
		return mh;
	}
	
	public void addMH(String ten, int id_ncc, String mo_ta) {
		String query = "INSERT INTO `pttkhttt`.`mat_hang` (`ten`, `id_ncc`, `don_gia`, `so_luong`, `mo_ta`) VALUES (?, ?, 0, 0, ?);";
		try {
			c = new DB().getConnection();
			s = c.prepareStatement(query);
			s.setString(1, ten);
			s.setInt(2, id_ncc);
			s.setString(3, mo_ta);
			s.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
            new DB().closeConnection(c);
        }
	}
	
	public void updateMH(int sl, int gia, int id_mh) {
		String query = "UPDATE `pttkhttt`.`mat_hang` SET `don_gia` = ?, `so_luong` = ? WHERE (`id_mh` = ?)";
		try {
			c = new DB().getConnection();
			s = c.prepareStatement(query);
			s.setInt(1, gia);
			s.setInt(2, sl);
			s.setInt(3, id_mh);
			s.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
            new DB().closeConnection(c);
        }
	}
	
	public int getSl(int id_mh) {
		String query = "SELECT `so_luong` FROM `pttkhttt`.`mat_hang` WHERE `id_mh` = ?;";
		int sl = 0;
		try {
			c = new DB().getConnection();
			s = c.prepareStatement(query);
			s.setInt(1, id_mh);
			r = s.executeQuery();
			while(r.next()) {
				sl = r.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
            new DB().closeConnection(c);
        }
		return sl;
	}
	
	public String getTenMH(int id_mh) {
		String query = "SELECT `ten` FROM `pttkhttt`.`mat_hang` WHERE `id_mh` = ?;";
		String ten = "";
		try {
			c = new DB().getConnection();
			s = c.prepareStatement(query);
			s.setInt(1, id_mh);
			r = s.executeQuery();
			while(r.next()) {
				ten = r.getString(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
            new DB().closeConnection(c);
        }
		return ten;
	}
}
