package models.com;

import java.io.Serializable;

public class Customer implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String customerID;
    private String username;
    private String password;
    private double accountBalance;
    
 public Customer() {
    	
    }
    
    public Customer(Customer customer) {
		super();
		this.customerID = customer.customerID;
		this.username = customer.username;
		this.password = customer.password;
		this.accountBalance = customer.accountBalance;
	}
    
    /**
	 * @param customerID
	 * @param username
	 * @param password
	 * @param accountBalance
	 */
	public Customer(String customerID, String username, String password, double accountBalance) {
		super();
		this.customerID = customerID;
		this.username = username;
		this.password = password;
		this.accountBalance = accountBalance;
	}
	// Other customer-specific attributes, getters, setters, and methods
	public String getCustomerID() {
		return customerID;
	}
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public double getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}
	@Override
	public String toString() {
		return "Customer [customerID=" + customerID + ", username=" + username + ", password=" + password
				+ ", accountBalance=" + accountBalance + "]";
	}
}