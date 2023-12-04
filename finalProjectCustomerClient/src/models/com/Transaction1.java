package models.com;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Transaction1 implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String transactionID;
    private String customerID; // or reference Customer directly
    private String requestID; // or reference RentalRequest directly
    private Date transactionDate;
    private double amountPaid;
    
    public Transaction1() {
    	
    }
    
    public Transaction1(Transaction1 transaction) {
		super();
		this.transactionID = transaction.transactionID;
		this.customerID = transaction.customerID;
		this.requestID = transaction.requestID;
		this.transactionDate = transaction.transactionDate;
		this.amountPaid = transaction.amountPaid;
	}
    /**
	 * @param transactionID
	 * @param customerID
	 * @param requestID
	 * @param transactionDate
	 * @param amountPaid
	 */
    public Transaction1(String transactionID, String customerID, String requestID, String transactionDate, double amountPaid) {
        this.transactionID = transactionID;
        this.customerID = customerID;
        this.requestID = requestID;
        this.amountPaid = amountPaid;

        // Convert String to Date
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            this.transactionDate = dateFormat.parse(transactionDate);
        } catch (ParseException e) {
            e.printStackTrace();
            // Handle parsing exception as needed
        }
    }
	// Other transaction attributes, getters, setters, and methods
	public String getTransactionID() {
		return transactionID;
	}
	public void setTransactionID(String transactionID) {
		this.transactionID = transactionID;
	}
	public String getCustomerID() {
		return customerID;
	}
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}
	public String getRequestID() {
		return requestID;
	}
	public void setRequestID(String requestID) {
		this.requestID = requestID;
	}
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(String date) {
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            this.transactionDate = dateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            // Handle parsing exception as needed
        }
	}
	public double getAmountPaid() {
		return amountPaid;
	}
	public void setAmountPaid(double amountPaid) {
		this.amountPaid = amountPaid;
	}
	@Override
	public String toString() {
		return "Transaction [transactionID=" + transactionID + ", customerID=" + customerID + ", requestID=" + requestID
				+ ", transactionDate=" + transactionDate + ", amountPaid=" + amountPaid  
				+ "]";
	}
}
