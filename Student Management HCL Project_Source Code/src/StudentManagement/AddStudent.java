package StudentManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddStudent {
	public int saveStudent(Student student) {
		// write your code here
		int result = 0;
		try {
			Connection con = DBConnection.getConnection();
			String name = student.getName();
			String dob = student.getDob();
			double score = student.getScore();
			String gender = student.getGender();
			String email = student.getEmail();
			String query = "insert into `std`(name, dob, score, gender, email) values (?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, name);
			ps.setString(2, dob);
			ps.setDouble(3, score);
			ps.setString(4, gender);
			ps.setString(5, email);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
