package StudentManagement;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		Scanner sc = new Scanner(System.in);
		String name = null, dob = null, gender = null, email = null, option;
		double score = 0;
		SearchStudent se = null;
		int choice = 0;
		while (choice != 6) {
			try {
				System.out.println();
				System.out.println("/*********************************/");
				System.out.println("Choose one of the functions below\n");
				System.out
						.println("1. Create new student\n" + "2. Update student information\n" + "3. Delete a student\n"
								+ "4. Search a student\n" + "5. Display all student details \n" + "6. Quit");
				choice = sc.nextInt();

				switch (choice) {
				case 1:
					System.out.println("Enter name: ");
					name = sc.next();
					System.out.println("Enter the dob (DD/MM/YYYY): ");
					dob = sc.next();
					System.out.println("Enter the gender (M/F): ");
					gender = sc.next();
					System.out.println("Enter email: ");
					email = sc.next();
					sc.nextLine();
					System.out.println("Enter the score: ");
					score = sc.nextDouble();

					AddStudent addStudent = new AddStudent();
					Student student = new Student(name, dob, score, gender, email);
					if (student.repOK()) {
						int result = addStudent.saveStudent(student);
						if (result > 0)
							System.out.println("Create successfuly!!!\n\n");
					} else
						System.out.println("No student created");
					break;

				case 2:
					System.out.println("Enter id of student to update: ");
					int id = sc.nextInt();
					se = new SearchStudent();
					student = se.findItemsById(id);
					System.out.println("Update name? (y/n)");
					option = sc.next();
					if (option.equalsIgnoreCase("y")) {
						System.out.println("Enter name: ");
						name = sc.next();
					} else
						name = student.getName();
					System.out.println("Update dob? (y/n)");
					option = sc.next();
					if (option.equalsIgnoreCase("y")) {
						System.out.println("Enter dob (DD/MM/YYYY): ");
						dob = sc.next();
					} else
						dob = student.getDob();
					System.out.println("Update gender? (y/n)");
					option = sc.next();
					if (option.equalsIgnoreCase("y")) {
						System.out.println("Enter gender (M/F): ");
						gender = sc.next();
					} else
						gender = student.getGender();
					System.out.println("Update email? (y/n)");
					option = sc.next();
					if (option.equalsIgnoreCase("y")) {
						System.out.println("Enter email: ");
						email = sc.next();
					} else
						email = student.getEmail();
					System.out.println("Update score? (y/n)");
					option = sc.next();
					if (option.equalsIgnoreCase("y")) {
						System.out.println("Enter score: ");
						score = sc.nextDouble();
					} else
						score = student.getScore();
					student = new Student(name, dob, score, gender, email);
					UpdateStudent updateStudent = new UpdateStudent();
					if (student.repOK() && !student.getName().equalsIgnoreCase(name) && !student.getDob().equals(dob)
							&& !student.getEmail().equalsIgnoreCase(email)
							&& !student.getGender().equalsIgnoreCase(gender) && student.getScore() != score) {
						int result = updateStudent.updatestudent(student);
						if (result > 0)
							System.out.println("Update successfully!!!\n\n");
					} else
						System.out.println("No student updated");
					break;
				case 3:
					DeleteStudent deleteStudent = new DeleteStudent();
					System.out.println("Enter the student id you want to delete:");
					id = sc.nextInt();
					System.out.println("Do you want to delete this student? (y/n)");
					option = sc.next();
					if (option.equalsIgnoreCase("y")) {
						boolean check = deleteStudent.deleteUser(id);
						if (check)
							System.out.println("Delete successfully!!!\n\n");
						else
							System.out.println("No student deleted");
					}
					break;

				case 4:
					System.out.println("Enter the name of student you want to find:");
					name = sc.next();
					se = new SearchStudent();
					se.findItemsByName(name);
					System.out.println("\n");
					break;
				case 5:
					DisplayStudent displayStudent = new DisplayStudent();
					displayStudent.getAllStudent();
					System.out.println("\n");
					break;
				case 6:
					System.out.println("Program ended");
					break;
				default:
					System.out.println("Please enter number from 1-6.\n\n");
					break;
				}
			} catch (Exception e) {
				System.out.println("You must enter number. Please try again!");
				sc.nextLine();
			}
		}
	}
}
