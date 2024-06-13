package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import DB.DB;
import Model.Client;

public class ClientLoginDAO {
	Connection c = null;
	PreparedStatement s = null;
	ResultSet r = null;

	public Client login(String sdt, String pass) {
		String query = "SELECT * FROM pttkhttt.taikhoan_kh where sdt = ? and pass = ?;";
		Client acc = null;
		try {
			c = new DB().getConnection();
			s = c.prepareStatement(query);
			s.setString(1, sdt);
			s.setString(2, pass);
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
}
