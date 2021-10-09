package StudentManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SearchStudent {
	public void findItemsByName(String name) {
		List<Student> studentList = new ArrayList<Student>();
		// your code goes here...
		Connection con = null;
		try {
			con = DBConnection.getConnection();
			String query = "select * from `std` where name = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, name);
			ResultSet result = ps.executeQuery();
			while (result.next()) {
				Student student = new Student(result.getString("name"), result.getString("dob"),
						result.getDouble("score"), result.getString("gender"), result.getString("email"));
				studentList.add(student);
			}
			if (studentList.isEmpty())
				System.out.println("Student is not exist");
			else {
				System.out.format("%-5s %-12s %-7s %-7s %-5s\n", "Name", "DOB", "Score", "Gender", "Email");
				for (Student s : studentList) {
					System.out.format("%-5s %-12s %-7s %-7s %-5s\n", name, s.getDob(), s.getScore(), s.getGender(),
							s.getEmail());
				}
			}
		} catch (Exception e) {
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
	}

	public Student findItemsById(int id) {
		// your code goes here...
		Connection con = null;
		Student student = null;
		try {
			con = DBConnection.getConnection();
			String query = "select * from `std` where id = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet result = ps.executeQuery();
			while (result.next()) {
				student = new Student(result.getString("name"), result.getString("dob"),
						result.getDouble("score"), result.getString("gender"), result.getString("email"));
			}
			if (student.equals(null))
				System.out.println("Student is not exist");

		} catch (Exception e) {
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
		return student;
	}
}
