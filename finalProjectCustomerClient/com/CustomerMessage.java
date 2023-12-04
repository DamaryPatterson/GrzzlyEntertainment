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
	private String EmployeeResponse;
	
	
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
		return EmployeeResponse;
	}
	public void setEmployeeResponse(String employeeResponse) {
		EmployeeResponse = employeeResponse;
	}
	@Override
	public String toString() {
		return "CustomerMessage [messageID=" + messageID + ", customerID=" + customerID + ", messageContent="
				+ messageContent + ", EmployeeResponse=" + EmployeeResponse + "]";
	}
}


