package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import DB.DB;
import Model.Client;

public class RegisterDAO {
	Connection c = null;
	PreparedStatement s = null;
	ResultSet r = null;

	public Client check(String sdt) {
		String query = "SELECT * FROM pttkhttt.taikhoan_kh where sdt = ?;";
		Client acc = null;
		try {
			c = new DB().getConnection();
			s = c.prepareStatement(query);
			s.setString(1, sdt);
			r = s.executeQuery();
			while (r.next()) {
				acc = new Client(r.getInt(1), r.getString(2), r.getString(3), r.getString(4), r.getString(5),
						r.getString(6));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
            new DB().closeConnection(c);
        }
		return acc;
	}
	
	public void register(String sdt, String pass, String ho_va_dem, String ten, String dia_chi) {
		String query = "INSERT INTO `pttkhttt`.`taikhoan_kh` (`sdt`, `pass`, `ho_va_dem`, `ten`, `dia_chi`) VALUES (?, ?, ?, ?, ?);";
		try {
			c = new DB().getConnection();
			s = c.prepareStatement(query);
			s.setString(1, sdt);
			s.setString(2, pass);
			s.setString(3, ho_va_dem);
			s.setString(4, ten);
			s.setString(5, dia_chi);
			s.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
            new DB().closeConnection(c);
        }
	}
}
