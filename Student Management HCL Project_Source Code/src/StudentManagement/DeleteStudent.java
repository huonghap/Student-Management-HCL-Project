package StudentManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteStudent {
	public Boolean deleteUser(int id) throws ClassNotFoundException {
		Connection con = null;
		try {
			con = DBConnection.getConnection();
    		String query = "delete from `std` where id = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);
			int i = ps.executeUpdate();
			if (i == 1)
				return true;
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					////
				}
			}
		}
		return false;
	}
}
