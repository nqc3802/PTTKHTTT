package DB;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {
	private Connection connection;
	
    public Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pttkhttt", "root", "chinh238");
        return connection;
    }
    
    public void closeConnection(Connection connection) {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
