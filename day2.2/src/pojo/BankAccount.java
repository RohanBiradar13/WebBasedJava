package pojo;

public class BankAccount {
	//| id | name | type | bal
	private int id;
	private String name;
	private String accType;
	private double balance; 
	
	public BankAccount() {
		super();
	}
	@Override
	public String toString() {
		return "BankAccount [id=" + id + ", name=" + name + ", accType=" + accType + ", balance=" + balance + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAccType() {
		return accType;
	}
	public void setAccType(String accType) {
		this.accType = accType;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	

}
