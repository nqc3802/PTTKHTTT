package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import DB.DB;

public class BillDAO {
	Connection c = null;
	PreparedStatement s = null;
	ResultSet r = null;

	public void nhap(int tong, Date date, int id_nv, int id_ncc) {
		String query = "INSERT INTO `pttkhttt`.`hoa_don_nhap` (`tong_tien`, `ngay`, `id_nv`, `id_ncc`) VALUES (?, ?, ?, ?)";
		try {
			c = new DB().getConnection();
			s = c.prepareStatement(query);
			s.setInt(1, tong);
			s.setDate(2, date);
			s.setInt(3, id_nv);
			s.setInt(4, id_ncc);
			s.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
            new DB().closeConnection(c);
        }
	}

	public int getIdNCC(int id_mh) {
		String query = "SELECT `id_ncc` FROM `pttkhttt`.`mat_hang` WHERE `id_mh` = ?;";
		int id_ncc = 0;
		try {
			c = new DB().getConnection();
			s = c.prepareStatement(query);
			s.setInt(1, id_mh);
			r = s.executeQuery();
			if (r.next()) {
				id_ncc = Integer.parseInt(r.getString(1));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
            new DB().closeConnection(c);
        }
		return id_ncc;
	}

	public int getTong(int id_hdn) {
		String query = "SELECT id_hdn, SUM(thanh_tien) AS tong FROM pttkhttt.hangnhap_mathang WHERE id_hdn = ? GROUP BY id_hdn;";
		int tong = 0;
		try {
			c = new DB().getConnection();
			s = c.prepareStatement(query);
			s.setInt(1, id_hdn);
			r = s.executeQuery();
			if (r.next()) {
				String tongString = r.getString(2);
				if (tongString != null) {
					tong = Integer.parseInt(tongString);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
            new DB().closeConnection(c);
        }
		return tong;
	}

	public int getIdHDN() {
		String query = "SELECT MAX(`id_hdn`) FROM `pttkhttt`.`hoa_don_nhap`;";
		int id_hdn = 0;
		try {
			c = new DB().getConnection();
			s = c.prepareStatement(query);
			r = s.executeQuery();
			if (r.next()) {
				id_hdn = r.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}  finally {
            new DB().closeConnection(c);
        }
		return id_hdn;
	}
	
	public int getIdNCCbyHDN(int id_hdn) {
		String query = "SELECT `id_ncc` FROM `pttkhttt`.`hoa_don_nhap` WHERE `id_hdn` = ?;";
		int id_ncc = 0;
		try {
			c = new DB().getConnection();
			s = c.prepareStatement(query);
			s.setInt(1, id_hdn);
			r = s.executeQuery();
			if (r.next()) {
				id_ncc = Integer.parseInt(r.getString(1));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
            new DB().closeConnection(c);
        }
		return id_ncc;
	}

	public void UpdateIdHDN(int id_hdn) {
		String query = "UPDATE `pttkhttt`.`hangnhap_mathang` SET `id_hdn` = ? WHERE `id_hdn` = 0;";
		try {
			c = new DB().getConnection();
			s = c.prepareStatement(query);
			s.setInt(1, id_hdn);
			s.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
            new DB().closeConnection(c);
        }
	}
}
