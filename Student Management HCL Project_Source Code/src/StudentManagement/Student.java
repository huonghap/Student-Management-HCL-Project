package StudentManagement;

public class Student {
	private String name;
	private String dob;
	private double score;
	private String gender;
	private String email;

	public Student() {

	}

	public Student(String name, String dob, double score, String gender, String email) {
		if (!validateName(name))
			System.out.println("Error: Maximum name's length is 30 and must be an alphabet");
		this.name = name;
		if (!validateDob(dob))
			System.out.println("Error: Date must be in DD/MM/YYYY format");
		this.dob = dob;
		if (!validateScore(score))
			System.out.println("Error: Score must be in range 0 to 10");
		this.score = score;
		if (!validateGender(gender))
			System.out.println("Error: Gender must be in alias M/F");
		this.gender = gender;
		if (!validateMailDomain(email))
			System.out.println("Error: Email must be in right format");
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (validateName(name))
			this.name = name;
	}

	public boolean validateName(String name) {
		if (name.length() <= 30 && name.length() > 0 && name.matches("[a-zA-Z]+"))
			return true;
		return false;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		if (validateDob(dob))
			this.dob = dob;
	}

	public boolean validateDob(String dob) {
		if (dob.matches("\\d{2}/\\d{2}/\\d{4}"))
			return true;
		return false;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		if (validateScore(score))
			this.score = score;
	}

	public boolean validateScore(double score) {
		if (score >= 0 && score <= 10)
			return true;
		return false;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		if (validateGender(gender))
			this.gender = gender;
	}

	public boolean validateGender(String gender) {
		if (gender.equalsIgnoreCase("M") || gender.equalsIgnoreCase("F"))
			return true;
		return false;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		if (validateMailDomain(email))
			this.email = email;
	}

	public boolean validateMailDomain(String email) {
		String domain = (email.substring(email.lastIndexOf('.') + 1));
		if (domain.equals("com") || domain.equals("in") || domain.equals("org") || domain.equals("net"))
			return true;
		return false;
	}

	public boolean repOK() {
		return validateDob(dob) && validateGender(gender) && validateMailDomain(email) && validateName(name)
				&& validateScore(score);
	}
}
