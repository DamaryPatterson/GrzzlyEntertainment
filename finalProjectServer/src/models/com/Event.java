package models.com;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import factories.SessionFactoryBuilder;

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

	public void addEvent() {
		Session session=null;
		try {
			session= SessionFactoryBuilder
					.getSessionFactory()
					.getCurrentSession();
			Transaction transaction = session.beginTransaction();
			session.save(this);
			transaction.commit();
			//session.clear();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
		    if (session != null && session.isOpen()) {
		        session.close(); // Close the session only if it's open
		    }
		}
	}
	public void update() {
		Event event = new Event();
		Session session= SessionFactoryBuilder
				.getSessionFactory()
				.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		event= (Event)session.get(Event.class,this.getEventID());
		event.setEventName(event.getEventName());
		transaction.commit();
		session.close();
	}
	@SuppressWarnings("unchecked")
	public List<Event> readAll(){
		List<Event> studentList = new ArrayList<>();
		Session session= SessionFactoryBuilder
				.getSessionFactory()
				.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		studentList =(List<Event>) session.createQuery("FROM event").getResultList();
		transaction.commit();
		session.close();
		return studentList;
	}
	
	public void deleteEvent() {
		Event event = new Event();
		Session session= SessionFactoryBuilder
				.getSessionFactory()
				.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		event= (Event)session.get(Event.class,this.getEventID());
		event.setEventName(event.getEventName());
		transaction.commit();
		session.clear();
	}
}
