package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import DB.DB;
import Model.Staff;

public class StaffLoginDAO {
	Connection c = null;
	PreparedStatement s = null;
	ResultSet r = null;

	public Staff login(String sdt, String pass) {
		String query = "SELECT * FROM pttkhttt.taikhoan_nv where sdt = ? and pass = ?;";
		Staff staff = null;
		try {
			c = new DB().getConnection();
			s = c.prepareStatement(query);
			s.setString(1, sdt);
			s.setString(2, pass);
			r = s.executeQuery();
			while (r.next()) {
				staff = new Staff(r.getInt(1), r.getString(2), r.getString(3), r.getString(4), r.getString(5),
						r.getString(6), r.getDate(7), r.getString(8));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
            new DB().closeConnection(c);
        }
		return staff;
	}
}
