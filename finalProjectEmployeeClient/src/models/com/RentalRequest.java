package models.com;



import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class RentalRequest implements Serializable {
	

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String requestID;
    private String customerID; // or reference Customer directly
    private String equipmentID; // or reference Equipment directly
    private Date rentalDate;
    private double quotationCost;
    private boolean rentalStatus;
    
    
    public RentalRequest() {
    	
    }
    public RentalRequest(RentalRequest rReq) {
		super();
		this.requestID = rReq.requestID;
		this.customerID = rReq.customerID;
		this.equipmentID = rReq.equipmentID;
		this.rentalDate = rReq.rentalDate;
		this.quotationCost = rReq.quotationCost;
		this.rentalStatus = rReq.rentalStatus;
	}
    /**
	 * @param requestID
	 * @param customerID
	 * @param equipmentID
	 * @param rentalDate
	 * @param quotationCost
	 * @param rentalStatus
	 */
    public RentalRequest(String requestID, String customerID, String equipmentID, String rentalDate,
            double quotationCost, boolean rentalStatus) {
        super();
        this.requestID = requestID;
        this.customerID = customerID;
        this.equipmentID = equipmentID;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            this.rentalDate = dateFormat.parse(rentalDate);
        } catch (ParseException e) {
            // Handle parsing exception (e.g., log, throw, etc.)
            e.printStackTrace();
        }
        this.quotationCost = quotationCost;
        this.rentalStatus = rentalStatus;
    }


	// Other request attributes, getters, setters, and methods
	public String getRequestID() {
		return requestID;
	}
	public void setRequestID(String requestID) {
		this.requestID = requestID;
	}
	public String getCustomerID() {
		return customerID;
	}
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}
	public String getEquipmentID() {
		return equipmentID;
	}
	public void setEquipmentID(String equipmentID) {
		this.equipmentID = equipmentID;
	}
	public Date getRentalDate() {
		return rentalDate;
	}
	public void setRentalDate(String date) {
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            this.rentalDate = dateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            // Handle parsing exception as needed
        }
	}
	public double getQuotationCost() {
		return quotationCost;
	}
	public void setQuotationCost(double quotationCost) {
		this.quotationCost = quotationCost;
	}
	public boolean isRentalStatus() {
		return rentalStatus;
	}
	public void setRentalStatus(boolean rentalStatus) {
		this.rentalStatus = rentalStatus;
	}
	@Override
	public String toString() {
		return "RentalRequest [requestID=" + requestID + ", customerID=" + customerID + ", equipmentID=" + equipmentID
				+ ", rentalDate=" + rentalDate + ", quotationCost=" + quotationCost +
				", rentalStatus=" + rentalStatus+ "]";
	}
}
