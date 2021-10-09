package StudentManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateStudent {
	public int updatestudent(Student student) throws ClassNotFoundException {
		// your code goes here...
        Connection con = null;
        int result = 0;
    	try {
			con = DBConnection.getConnection();
			String email = student.getEmail();
			String query = "update `std` set name =?, dob =?, score=?, gender=?, email=? where email =?;";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, student.getName());
			ps.setString(2, student.getDob());
			ps.setDouble(3, student.getScore());
			ps.setString(4, student.getGender());
			ps.setString(5, email);
			ps.setString(6, email);
            result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
    	return result;
	}
}
