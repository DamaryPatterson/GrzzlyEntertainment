package models.com;

import java.io.Serializable;


public class Employee implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String employeeID;
    private String username;
    private String password;
    
    
    public Employee(Employee emp) {
		super();
		this.employeeID = emp.employeeID;
		this.username = emp.username;
		this.password = emp.password;
    }
	/**
	 * @param employeeID
	 * @param username
	 * @param password
	 */
	public Employee(String employeeID, String username, String password) {
		super();
		this.employeeID = employeeID;
		this.username = username;
		this.password = password;
	}
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	public String getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
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
	@Override
	public String toString() {
		return "Employee [employeeID=" + employeeID + ", username=" + username + ", password="
	+ password+ "]";
	}
	
	

    
}