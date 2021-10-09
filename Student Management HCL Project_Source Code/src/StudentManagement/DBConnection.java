package StudentManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	public DBConnection() {

	}

	public static Connection getConnection() throws SQLException {
		String username = "root";
		String password = "";
		String url = "jdbc:mysql://localhost/student_management";
		Connection con = DriverManager.getConnection(url, username, password);
		return con;
	}

	public static void main(String[] args) throws SQLException {
		Connection con = DBConnection.getConnection();
		if (con != null)
			System.out.println("Connected");
	}
}
