package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DB.DB;
import Model.Supplier;

public class SupplierDAO {
	Connection c = null;
	PreparedStatement s = null;
	ResultSet r = null;

	public List<Supplier> getListNCC() {
		List<Supplier> listNcc = new ArrayList<>();
		String query = "SELECT * FROM pttkhttt.nha_cung_cap;";
		try {
			c = new DB().getConnection();
			s = c.prepareStatement(query);
			r = s.executeQuery();
			while (r.next()) {
				listNcc.add(new Supplier(r.getInt(1), r.getString(2), r.getString(3), r.getString(4), r.getString(5))); 
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
            new DB().closeConnection(c);
        }
		return listNcc;
	}
	
	public Supplier check(String sdt, String email) {
		String query = "SELECT * FROM pttkhttt.nha_cung_cap where sdt = ? or email = ?;";
		Supplier ncc = null;
		try {
			c = new DB().getConnection();
			s = c.prepareStatement(query);
			s.setString(1, sdt);
			s.setString(2, email);
			r = s.executeQuery();
			while(r.next()) {
				ncc = new Supplier(r.getInt(1), r.getString(2), r.getString(3), r.getString(4), r.getString(5));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
            new DB().closeConnection(c);
        }
		return ncc;
	}
	
	public void addNCC(String ten, String dia_chi, String sdt, String email) {
		String query = "INSERT INTO `pttkhttt`.`nha_cung_cap` (`ten_ncc`, `dia_chi`, `sdt`, `email`) VALUES (?, ?, ?, ?);";
		try {
			c = new DB().getConnection();
			s = c.prepareStatement(query);
			s.setString(1, ten);
			s.setString(2, dia_chi);
			s.setString(3, sdt);
			s.setString(4, email);
			s.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
            new DB().closeConnection(c);
        }
	}
	
	public String getTenNCC(int id_ncc) {
		String query = "SELECT `ten_ncc` FROM `pttkhttt`.`nha_cung_cap` WHERE `id_ncc` = ?;";
		String ten = "";
		try {
			c = new DB().getConnection();
			s = c.prepareStatement(query);
			s.setInt(1, id_ncc);
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
