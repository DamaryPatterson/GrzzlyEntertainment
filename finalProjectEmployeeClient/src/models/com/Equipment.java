package models.com;

import java.io.Serializable;

public class Equipment implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String equipmentID;
    private String equipmentName;
    private String equipmentCategory;
    private int isAvailable;
    private double price;
    // Other equipment attributes, getters, setters, and methods
	public Equipment() {
	    	
	}
    
    
    public Equipment(Equipment equipment) {
    	this.equipmentID = equipment.equipmentID;
		this.equipmentName = equipment.equipmentName;
		this.equipmentCategory = equipment.equipmentCategory;
		this.isAvailable = equipment.isAvailable;
		this.price= equipment.price;
    }
	/**
	 * @param equipmentID
	 * @param equipmentName
	 * @param equipmentCategory
	 * @param availabilityStatus
	 */
	public Equipment(String equipmentID, String equipmentName, String equipmentCategory, int availabilityStatus) {
		
		this.equipmentID = equipmentID;
		this.equipmentName = equipmentName;
		this.equipmentCategory = equipmentCategory;
		this.isAvailable = availabilityStatus;
	}
	public String getEquipmentID() {
		return equipmentID;
	}
	public void setEquipmentID(String equipmentID) {
		this.equipmentID = equipmentID;
	}
	public String getEquipmentName() {
		return equipmentName;
	}
	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}
	public String getEquipmentCategory() {
		return equipmentCategory;
	}
	public void setEquipmentCategory(String equipmentCategory) {
		this.equipmentCategory = equipmentCategory;
	}
	public int isAvailabilityStatus() {
		return isAvailable;
	}
	public void setAvailabilityStatus(boolean isAvailable) {
	    this.isAvailable = isAvailable ? 1 : 0;
	}

	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}


	@Override
	public String toString() {
		return "Equipment [equipmentID=" + equipmentID + ", equipmentName=" + equipmentName + ", equipmentCategory="
				+ equipmentCategory + ", availabilityStatus=" + isAvailable + "]";
	}
    
}