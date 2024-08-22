package pojo;
//id | first_name | last_name | email   | password | reg_amt | reg_date  | role

import java.sql.Date;

public class User {
	private int userId;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private int regAmount;
	private Date regDate;
	private String role;

	public User() {
		// later it will be used by hibernate framework
	}

	public User(int userId, String firstName, String lastName, String email, String password, int regAmount,
			Date regDate, String role) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.regAmount = regAmount;
		this.regDate = regDate;
		this.role = role;
	}

	public User(int userId, String firstName, String lastName, int regAmount, Date regDate, String role) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.regAmount = regAmount;
		this.regDate = regDate;
		this.role = role;
	}

	public User(String firstName, String lastName, String email, String password, int regAmount, Date regDate,
			String role) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.regAmount = regAmount;
		this.regDate = regDate;
		this.role = role;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRegAmount() {
		return regAmount;
	}

	public void setRegAmount(int regAmount) {
		this.regAmount = regAmount;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", regAmount=" + regAmount + ", regDate=" + regDate + ", role=" + role
				+ "]";
	}

}
