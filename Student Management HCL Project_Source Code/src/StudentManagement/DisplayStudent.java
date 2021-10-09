package StudentManagement;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DisplayStudent {
	public void getAllStudent() throws ClassNotFoundException, IOException {
		Connection con = null;
		try {
			con = DBConnection.getConnection();
			String query = "select * from `std` order by name";
			Statement st = con.createStatement();
			ResultSet result = st.executeQuery(query);
			System.out.format("%-5s %-12s %-7s %-7s %-5s\n", "Name", "DOB", "Score", "Gender", "Email");

			while (result.next()) {
				System.out.format("%-5s %-12s %-7s %-7s %-5s\n", result.getString("name"), result.getString("dob"),
						result.getDouble("score"), result.getString("gender"), result.getString("email"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					////
				}
			}

		}
	}

}
