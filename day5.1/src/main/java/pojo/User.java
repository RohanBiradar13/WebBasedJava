package pojo;

import java.sql.Date;

public class User {
	private int userId;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private double regAmount;
	private Date regDate;
	private String role;
    public User() {
		
	}
	public User(int userId, String firstName, String lastName, String email, String password, double regAmount,
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
	public double getRegAmount() {
		return regAmount;
	}
	public void setRegAmount(double regAmount) {
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
