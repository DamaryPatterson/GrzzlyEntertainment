package models.com;

import java.io.Serializable;

public class CustomerMessage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String messageID;
	private String customerID;
	private String messageContent;
	private String employeeResponse;
	
	
	public CustomerMessage(String messageID, String customerID, String messageContent, String employeeResponse) {
		super();
		this.messageID = messageID;
		this.customerID = customerID;
		this.messageContent = messageContent;
		this.employeeResponse = employeeResponse;
	}
	public CustomerMessage() {
		messageID="";
		customerID="";
		messageContent= "";
		employeeResponse="";
		
	}
	public String getMessageID() {
		return messageID;
	}
	public void setMessageID(String messageID) {
		this.messageID = messageID;
	}
	public String getCustomerID() {
		return customerID;
	}
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}
	public String getMessageContent() {
		return messageContent;
	}
	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}
	public String getEmployeeResponse() {
		return employeeResponse;
	}
	public void setEmployeeResponse(String employeeResponse) {
		this.employeeResponse = employeeResponse;
	}
	@Override
	public String toString() {
		return "CustomerMessage [messageID=" + messageID + ", customerID=" + customerID + ", messageContent="
				+ messageContent + ", EmployeeResponse=" + employeeResponse + "]";
	}
}


