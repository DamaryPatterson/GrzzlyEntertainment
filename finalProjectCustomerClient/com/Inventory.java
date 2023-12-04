package models.com;

import java.io.Serializable;

public class Inventory implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String equipmentStockID;
	private String equipmentID; // Reference to Equipment
	private int quantityAvailable;
	private String equipmentCategory; // Category of the equipment
	/**
	 * 
	 */
	public Inventory() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param equipmentStockID
	 * @param equipmentID
	 * @param quantityAvailable
	 * @param equipmentCategory
	 */
	public Inventory(String equipmentStockID, String equipmentID, int quantityAvailable, String equipmentCategory) {
		super();
		this.equipmentStockID = equipmentStockID;
		this.equipmentID = equipmentID;
		this.quantityAvailable = quantityAvailable;
		this.equipmentCategory = equipmentCategory;
	}
	
	public Inventory(Inventory equipmentStock) {
		super();
		this.equipmentStockID = equipmentStock.equipmentStockID;
		this.equipmentID = equipmentStock.equipmentID;
		this.quantityAvailable = equipmentStock.quantityAvailable;
		this.equipmentCategory = equipmentStock.equipmentCategory;
	}
	// Other inventory-related attributes, getters, setters, and methods
	public String getEquipmentStockID() {
		return equipmentStockID;
	}
	public void setEquipmentStockID(String equipmentStockID) {
		this.equipmentStockID = equipmentStockID;
	}
	public String getEquipmentID() {
		return equipmentID;
	}
	public void setEquipmentID(String equipmentID) {
		this.equipmentID = equipmentID;
	}
	public int getQuantityAvailable() {
		return quantityAvailable;
	}
	public void setQuantityAvailable(int quantityAvailable) {
		this.quantityAvailable = quantityAvailable;
	}
	public String getEquipmentCategory() {
		return equipmentCategory;
	}
	public void setEquipmentCategory(String equipmentCategory) {
		this.equipmentCategory = equipmentCategory;
	}
	@Override
	public String toString() {
		return "EquipmentStock [equipmentStockID=" + equipmentStockID + ", equipmentID=" + equipmentID
				+ ", quantityAvailable=" + quantityAvailable + ", equipmentCategory=" + equipmentCategory + "]";
	}
}