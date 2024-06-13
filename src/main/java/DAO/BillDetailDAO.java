package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DB.DB;
import Model.BillDetail;
import Model.Goods;

public class BillDetailDAO {
	Connection c = null;
	PreparedStatement s = null;
	ResultSet r = null;

	public void detail(int sl, int gia, int tt, String note, int id_hdn, int id_mh) {
		String query = "INSERT INTO `pttkhttt`.`hangnhap_mathang` (`so_luong`, `don_gia`, `thanh_tien`, `ghi_chu`, `id_hdn`, `id_mh`) VALUES (?, ?, ?, ?, ?, ?);";
		try {
			c = new DB().getConnection();
			s = c.prepareStatement(query);
			s.setInt(1, sl);
			s.setInt(2, gia);
			s.setInt(3, tt);
			s.setString(4, note);
			s.setInt(5, id_hdn);
			s.setInt(6, id_mh);
			s.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
            new DB().closeConnection(c);
        }
	}
	
	public List<BillDetail> getBillDetail(int id_hdn) {
		List<BillDetail> bill = new ArrayList<>();
		String query = "SELECT * FROM `pttkhttt`.`hangnhap_mathang` where `id_hdn` = ?;";
		try {
			c = new DB().getConnection();
			s = c.prepareStatement(query);
			s.setInt(1, id_hdn);
			r = s.executeQuery();
			while (r.next()) {
				bill.add(new BillDetail(r.getInt(1), r.getInt(2), r.getInt(3), r.getInt(4), r.getString(5), r.getInt(6), r.getInt(7)));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
            new DB().closeConnection(c);
        }
		return bill;
	}
}
