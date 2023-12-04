package models.com;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity(name = "rentalent")
@Table(name = "event")
public class Event implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "eventID")
	private String eventID;

	@Column(name = "eventName")
	private String eventName;

	@Temporal(TemporalType.DATE)
	@Column(name = "date")
	private Date date;

	public Event() {

	}

	/**
	 * @param eventID
	 * @param eventName
	 * @param date
	 */
	public Event(String eventID, String eventName, String eventDate) {
		super();
		this.eventID = eventID;
		this.eventName = eventName;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			this.date = dateFormat.parse(eventDate);
		} catch (ParseException e) {
			e.printStackTrace();
			// Handle parsing exception as needed
		}

	}

	public String getEventID() {
		return eventID;
	}

	public void setEventID(String eventID) {
		this.eventID = eventID;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public Date getEventDate() {
		return date;
	}

	public void setEventDate(String date) {

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			this.date = dateFormat.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
			// Handle parsing exception as needed
		}
	}

	@Override
	public String toString() {
		return "Event [eventID=" + eventID + ", eventName=" + eventName + ", date=" + date + "]";
	}
}
