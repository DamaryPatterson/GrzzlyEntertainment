package models.com;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EventSchedule implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String eventScheduleID;
	private String eventID;
    private String employeeID;
    private String equipmentID;
    private Date eventDate;
    
    public EventSchedule() {
    	
    }
    
	public String getEventScheduleID() {
		return eventScheduleID;
	}
	public void setEventScheduleID(String eventScheduleID) {
		this.eventScheduleID = eventScheduleID;
	}
	public String getEventID() {
		return eventID;
	}
	public void setEventID(String eventID) {
		this.eventID = eventID;
	}
	public String getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(String id) {
		this.employeeID = id;
	}
	public String getEquipmentID() {
		return equipmentID;
	}
	public void setEquipmentID(String equipmentID) {
		this.equipmentID = equipmentID;
	}
	public Date getEventDate() {
		return eventDate;
	}
	public void setEventDate(String eventDate) {
		 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	        try {
	        	this.eventDate = dateFormat.parse(eventDate);
	        } catch (ParseException e) {
	            e.printStackTrace();
	            // Handle parsing exception as needed
	        }
	}
	
	
}
