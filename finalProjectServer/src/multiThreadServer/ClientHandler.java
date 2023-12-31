package multiThreadServer;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import factories.SessionFactoryBuilder;
import models.com.Customer;
import models.com.Employee;
import models.com.Equipment;
import models.com.Inventory;
import models.com.Event;
import models.com.EventSchedule;
import models.com.CustomerMessage;
import models.com.RentalRequest;
import models.com.Transaction1;

public class ClientHandler implements Runnable {
	private Socket clientSocket;
	private ObjectInputStream objIs;
	private ObjectOutputStream objOs;
	private Connection dbConn;

	public ClientHandler(Socket socket) {
		this.clientSocket = socket;
		this.dbConn = AppServer.getDatabaseConnection();
		try {
			objIs = new ObjectInputStream(clientSocket.getInputStream());
			objOs = new ObjectOutputStream(clientSocket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		try {
			String action;
			while (true) {
				try {
					if (clientSocket != null) {
						action = (String) objIs.readObject();

						// Handle requests based on the action received from the client
						switch (action) {
						case "AddCustomer":
							Customer customer = (Customer) objIs.readObject();
							addCustomerToDatabase(customer);
							objOs.writeObject(true);
							break;
						case "FindCustomer":
							String customerId = (String) objIs.readObject();
							Customer foundCustomer = findCustomerById(customerId);
							objOs.writeObject(foundCustomer);
							break;
						case "Update Customer":
							break;
						case "DeleteCustomer":
							String delCustomerId = (String) objIs.readObject();
							deleteCustomerById(delCustomerId);
							objOs.writeObject(true);
							break;
						case "AddEmployee":
							// Handling code for adding an employee to the database
							Employee employee = (Employee) objIs.readObject();
							addEmployeeToDatabase(employee);
							objOs.writeObject(true);
							break;
						case "FindEmployee":
							// Handling code for finding an employee in the database
							String empId = (String) objIs.readObject();
							Employee foundEmployee = findEmployeeById(empId);
							objOs.writeObject(foundEmployee);
							break;
						case "Update Employee":
							break;
						case "DeleteEmployee":
							String delEmpId = (String) objIs.readObject();
							deleteEmployeeById(delEmpId);
							objOs.writeObject(true);
							break;
							
							
							
						case "AddEquipment":
							// Handling code for adding equipment to the database
							Equipment equipment = (Equipment) objIs.readObject();
							addEquipmentToDatabase(equipment);
							objOs.writeObject(true);
							break;
						case "FindEquipment":
							// Handling code for finding equipment in the database
							String equipId = (String) objIs.readObject();
							Equipment foundEquipment = findEquipmentById(equipId);
							objOs.writeObject(foundEquipment);
							break;
						case "Update Equipment":
							break;
						case "DeleteEquipment":
							String delEquipId = (String) objIs.readObject();
							deleteEquipmentById(delEquipId);
							objOs.writeObject(true);
							break;
							
							
						case "Add Inventory":
							// Handling code for adding equipment stock to the database
							Inventory equipmentStock = (Inventory) objIs.readObject();
							addEquipmentStockToDatabase(equipmentStock);
							objOs.writeObject(true);
							break;
						case "Find Inventory":
							// Handling code for finding equipment stock in the database
							String equipStockId = (String) objIs.readObject();
							Inventory foundEquipmentStock = findEquipmentStockById(equipStockId);
							objOs.writeObject(foundEquipmentStock);
							break;
						case "Update Inventory":
							break;
						case "Delete Inventory":
							String delEquipStockId = (String) objIs.readObject();
							deleteEquipmentStockById(delEquipStockId);
							objOs.writeObject(true);
							break;
							
							
						case "Add Event":
							// Handling code for adding an event to the database
							Event event = (Event) objIs.readObject();
							addEventToDatabase(event);
							objOs.writeObject(true);
							break;
						case "Find Event":
							// Handling code for finding an event in the database
							String eventId = (String) objIs.readObject();
							Event foundEvent = findEventById(eventId);
							objOs.writeObject(foundEvent);
							break;
						case "Update Event":
							break;
						case "Delete Event":
							String delEventId = (String) objIs.readObject();
							deleteEventById(delEventId);
							objOs.writeObject(true);
							break;
							
							
							
						case "Add EventSchedule":
							// Handling code for adding an event schedule to the database
							EventSchedule eventSchedule = (EventSchedule) objIs.readObject();
							addEventScheduleToDatabase(eventSchedule);
							objOs.writeObject(true);
							break;
						case "Find EventSchedule":
							// Handling code for finding an event schedule in the database
							String scheduleId = (String) objIs.readObject();
							EventSchedule foundSchedule = findEventScheduleById(scheduleId);
							objOs.writeObject(foundSchedule);
							break;
						case "Update EventSchedule":
							break;
						case "Delete EventSchedule":
							String delScheduleId = (String) objIs.readObject();
							deleteEventScheduleById(delScheduleId);
							objOs.writeObject(true);
							break;
							
							
							
						case "Add CustomerMessage":
							// Handling code for adding a message to the database
							CustomerMessage message = (CustomerMessage) objIs.readObject();
							addMessageToDatabase(message);
							objOs.writeObject(true);
							break;
						case "Find CustomerMessage":
							// Handling code for finding a message in the database
							String messageId = (String) objIs.readObject();
							CustomerMessage foundMessage = findMessageById(messageId);
							objOs.writeObject(foundMessage);
							break;
						case "Update CustomerMessage":
							break;
						case "Delete CustomerMessage":
							String delMessageId = (String) objIs.readObject();
							deleteMessageById(delMessageId);
							objOs.writeObject(true);
							break;
							
							
							
						case "Add RentalRequest":
							// Handling code for adding a rental request to the database
							RentalRequest rentalRequest = (RentalRequest) objIs.readObject();
							addRentalRequestToDatabase(rentalRequest);
							objOs.writeObject(true);
							break;
						case "Find RentalRequest":
							// Handling code for finding a rental request in the database
							String requestId = (String) objIs.readObject();
							RentalRequest foundRentalRequest = findRentalRequestById(requestId);
							objOs.writeObject(foundRentalRequest);
							break;
						case "Update RentalRequest":
							break;
						case "Delete RentalRequest":
							String delRequestId = (String) objIs.readObject();
							deleteRentalRequestById(delRequestId);
							objOs.writeObject(true);
							break;
							
							
							
						case "AddTransaction":
							// Handling code for adding a transaction to the database
							Transaction1 transaction = (Transaction1) objIs.readObject();
							addTransactionToDatabase(transaction);
							objOs.writeObject(true);
							break;
						case "FindTransaction":
							// Handling code for finding a transaction in the database
							String transactionId = (String) objIs.readObject();
							Transaction1 foundTransaction = findTransactionById(transactionId);
							objOs.writeObject(foundTransaction);
							break;
						case "Update Transaction":
							break;
						case "DeleteTransaction":
							String delTransactionId = (String) objIs.readObject();
							deleteTransactionById(delTransactionId);
							objOs.writeObject(true);
							break;
						
						default:
							break;
						
						}
					}
				} catch (ClassCastException | ClassNotFoundException e) {
					e.printStackTrace();
				}
				objOs.close();
				objIs.close();
				clientSocket.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

		}
	}

	
	private void deleteTransactionById(String delTransactionId) {
	    try {
	        String sql = "DELETE FROM Transaction WHERE transactionID = '" + delTransactionId + "';";
	        Statement stmt = dbConn.createStatement();
	        int rowsAffected = stmt.executeUpdate(sql);
	        if (rowsAffected > 0) {
	            objOs.writeObject(true);
	        } else {
	            objOs.writeObject(false);
	        }
	    } catch (SQLException | IOException e) {
	        e.printStackTrace();
	    }
	}

	private void deleteRentalRequestById(String delRequestId) {
	    try {
	        String sql = "DELETE FROM RentalRequest WHERE requestID = '" + delRequestId + "';";
	        Statement stmt = dbConn.createStatement();
	        int rowsAffected = stmt.executeUpdate(sql);
	        if (rowsAffected > 0) {
	            objOs.writeObject(true);
	        } else {
	            objOs.writeObject(false);
	        }
	    } catch (SQLException | IOException e) {
	        e.printStackTrace();
	    }
	}

	private void deleteMessageById(String delMessageId) {
	    try {
	        String sql = "DELETE FROM Message WHERE messageID = '" + delMessageId + "';";
	        Statement stmt = dbConn.createStatement();
	        int rowsAffected = stmt.executeUpdate(sql);
	        if (rowsAffected > 0) {
	            objOs.writeObject(true);
	        } else {
	            objOs.writeObject(false);
	        }
	    } catch (SQLException | IOException e) {
	        e.printStackTrace();
	    }
	}

	private void deleteEventScheduleById(String delScheduleId) {
	    try {
	        String sql = "DELETE FROM EventSchedule WHERE EventscheduleID = '" + delScheduleId + "';";
	        Statement stmt = dbConn.createStatement();
	        int rowsAffected = stmt.executeUpdate(sql);
	        if (rowsAffected > 0) {
	            objOs.writeObject(true);
	        } else {
	            objOs.writeObject(false);
	        }
	    } catch (SQLException | IOException e) {
	        e.printStackTrace();
	    }
	}

	private void deleteEventById(String delEventId) {
	    try {
	        String sql = "DELETE FROM Event WHERE eventID = '" + delEventId + "';";
	        Statement stmt = dbConn.createStatement();
	        int rowsAffected = stmt.executeUpdate(sql);
	        if (rowsAffected > 0) {
	            objOs.writeObject(true);
	        } else {
	            objOs.writeObject(false);
	        }
	    } catch (SQLException | IOException e) {
	        e.printStackTrace();
	    }
	}

	private void deleteEquipmentStockById(String delEquipStockId) {
	    try {
	        String sql = "DELETE FROM Equipmentstock WHERE equipmentID = '" + delEquipStockId + "';";
	        Statement stmt = dbConn.createStatement();
	        int rowsAffected = stmt.executeUpdate(sql);
	        if (rowsAffected > 0) {
	            objOs.writeObject(true);
	        } else {
	            objOs.writeObject(false);
	        }
	    } catch (SQLException | IOException e) {
	        e.printStackTrace();
	    }
	}

	private void deleteEmployeeById(String deleteEmpId) {
	    try {
	        String sql = "DELETE FROM Employee WHERE employeeID = '" + deleteEmpId + "';";
	        Statement stmt = dbConn.createStatement();
	        int rowsAffected = stmt.executeUpdate(sql);
	        if (rowsAffected > 0) {
	            objOs.writeObject(true);
	        } else {
	            objOs.writeObject(false);
	        }
	    } catch (SQLException | IOException e) {
	        e.printStackTrace();
	    }
	}

	private void deleteEquipmentById(String deleteEquipId) {
	    try {
	        String sql = "DELETE FROM Equipment WHERE equipmentID = '" + deleteEquipId + "';";
	        Statement stmt = dbConn.createStatement();
	        int rowsAffected = stmt.executeUpdate(sql);
	        if (rowsAffected > 0) {
	            objOs.writeObject(true);
	        } else {
	            objOs.writeObject(false);
	        }
	    } catch (SQLException | IOException e) {
	        e.printStackTrace();
	    }
	}

	private Transaction1 findTransactionById(String transactionId) {
	    Transaction1 transaction = new Transaction1();
	    try {
	        String sql = "SELECT * FROM transaction WHERE transactionID = '" + transactionId + "';";
	        Statement stmt = dbConn.createStatement();
	        ResultSet rs = stmt.executeQuery(sql);
	        
	        if (rs.next()) {
	            transaction.setTransactionID(rs.getString("transactionID"));
	            transaction.setCustomerID(rs.getString(2));
	            transaction.setRequestID(rs.getString(3));
	            transaction.setTransactionDate(rs.getString(4));
	            transaction.setAmountPaid(rs.getDouble(5));
	            
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return transaction;
	}

	private RentalRequest findRentalRequestById(String requestId) {
	    RentalRequest rentalRequest = new RentalRequest();
	    try {
	        String sql = "SELECT * FROM RentalRequest WHERE requestID = '" + requestId + "';";
	        Statement stmt = dbConn.createStatement();
	        ResultSet rs = stmt.executeQuery(sql);
	        
	        if (rs.next()) {
	            rentalRequest.setRequestID(rs.getString(1));
	            rentalRequest.setCustomerID(rs.getString(2));
	            rentalRequest.setEquipmentID(rs.getString(3));
	            rentalRequest.setRentalDate(rs.getString(4));
	            rentalRequest.setQuotationCost(rs.getDouble(5));
	            rentalRequest.setRentalStatus(rs.getBoolean(6));
	         
	        
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return rentalRequest;
	}

	private CustomerMessage findMessageById(String messageId) {
	    CustomerMessage message = new CustomerMessage();
	    try {
	        String sql = "SELECT * FROM Message WHERE messageID = '" + messageId + "';";
	        Statement stmt = dbConn.createStatement();
	        ResultSet rs = stmt.executeQuery(sql);
	        
	        if (rs.next()) {
	            message.setMessageID(rs.getString(1));
	            message.setCustomerID(rs.getString(2));
	            message.setMessageContent(rs.getString(3));
	            
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return message;
	}

	private EventSchedule findEventScheduleById(String scheduleId) {
	    EventSchedule eventSchedule = new EventSchedule();
	    try {
	        String sql = "SELECT * FROM EventSchedule WHERE EventscheduleID = '" + scheduleId + "';";
	        Statement stmt = dbConn.createStatement();
	        ResultSet rs = stmt.executeQuery(sql);
	        
	        if (rs.next()) {
	            eventSchedule.setEventScheduleID(rs.getString(1));
	            eventSchedule.setEventID(rs.getString(2));
	            eventSchedule.setEmployeeID(rs.getString(3));
	            eventSchedule.setEquipment(rs.getString(4));
	            eventSchedule.setEventDate(rs.getString(5));
	            // Retrieve other fields as needed from the ResultSet
	            // Create an EventSchedule object with retrieved data
	            
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return eventSchedule;
	}

	private Event findEventById(String eventId) {
	    Event event = new Event(); 
	    try {
	        String sql = "SELECT * FROM Event WHERE eventID = '" + eventId + "';";
	        Statement stmt = dbConn.createStatement();
	        ResultSet rs = stmt.executeQuery(sql);
	        
	        if (rs.next()) {
	            event.setEventID(rs.getString(1));
	            event.setEventName(rs.getString(2));
	            event.setEventDate(rs.getString(3));
	            // Retrieve other fields as needed from the ResultSet
	            
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return event;
	}

	private Inventory findEquipmentStockById(String equipStockId) {
	    Inventory stock = null;
	    try {
	        String sql = "SELECT * FROM Equipmentstock WHERE equipmentID = '" + equipStockId + "';";
	        Statement stmt = dbConn.createStatement();
	        ResultSet rs = stmt.executeQuery(sql);

	        if (rs.next()) {
	            String foundEquipStockId = rs.getString("equipmentID");
	            String equipmentName = rs.getString("equipmentName");
	            int quantity =rs.getInt(3);
	            String equipmentCategory =rs.getString(4);
	            // Retrieve other fields as needed from the ResultSet

	            // Create an Equipment object with retrieved data
	            stock = new Inventory(foundEquipStockId, equipmentName, quantity,equipmentCategory);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return stock;
	}


	private Equipment findEquipmentById(String equipId) {
	    Equipment equipment = new Equipment();
	    try {
	        String sql = "SELECT * FROM Equipment WHERE equipmentID = '" + equipId + "';";
	        Statement stmt = dbConn.createStatement();
	        ResultSet rs = stmt.executeQuery(sql);
	        
	        if (rs.next()) {
	            equipment.setEquipmentID(rs.getString(1));
	            equipment.setEquipmentName(rs.getString(2));
	            equipment.setEquipmentCategory(rs.getString(3));
	            equipment.setAvailabilityStatus(rs.getBoolean(4));
	            equipment.setPrice(rs.getDouble(5));
	            
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return equipment;
	}

	public boolean authenticateEmployee(String username, String password) {
	    try {
	        String sql = "SELECT * FROM Employee WHERE username = ? AND password = ?";
	        PreparedStatement pstmt = dbConn.prepareStatement(sql);
	        pstmt.setString(1, username);
	        pstmt.setString(2, password);
	        ResultSet rs = pstmt.executeQuery();
	        
	        // If there's at least one result, authentication succeeds
	        return rs.next();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    // Return false in case of exceptions or no matching record
	    return false;
	}
	private Employee findEmployeeById(String empId) {
	    Employee employee = new Employee();
	    try {
	        String sql = "SELECT * FROM Employee WHERE employeeID = '" + empId + "';";
	        Statement stmt = dbConn.createStatement();
	        ResultSet rs = stmt.executeQuery(sql);
	        
	        if (rs.next()) {
	            employee.setEmployeeID(rs.getString(1));
	            employee.setUsername(rs.getString(2));
	            employee.setPassword(rs.getString(3));
	            
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return employee;
	}
	private void addEquipmentToDatabase(Equipment equipment) {
		// TODO Auto-generated method stub
		String sql = "INSERT into grizzlyequipment.equipment(equipmentID,equipmentName,equipmentCategory"
				+ "isAvailable,price)" + "VALUES('" + equipment.getEquipmentID() + "','" + equipment.getEquipmentName()
				+ "','" + equipment.getEquipmentCategory() + "','" + equipment.isAvailabilityStatus() + "');";
		try {
			Statement stmt = dbConn.createStatement();

			if ((stmt.executeUpdate(sql) == 1)) {
				objOs.writeObject(true);
			} else {
				objOs.writeObject(false);
			}
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void addEmployeeToDatabase(Employee employee) {
		// TODO Auto-generated method stub
		String sql = "INSERT into grizzlyequipment.employee(employeeID,username,password)" + "VALUES('"
				+ employee.getEmployeeID() + "','" + employee.getUsername() + "','" + employee.getPassword() + "');";
		try {
			Statement stmt = dbConn.createStatement();

			if ((stmt.executeUpdate(sql) == 1)) {
				objOs.writeObject(true);
			} else {
				objOs.writeObject(false);
			}
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Example for adding a Customer record
	private void addCustomerToDatabase(Customer customer) {
		String sql = "INSERT INTO dblab.customers(customerID, username,password)" + " VALUES('"
				+ customer.getCustomerID() + "','" + customer.getUsername() + "','" + customer.getPassword() + "');";

		try {
			Statement stmt = dbConn.createStatement();

			if ((stmt.executeUpdate(sql) == 1)) {
				objOs.writeObject(true);
			} else {
				objOs.writeObject(false);
			}
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
	}
	// Example for finding a Customer record by ID
	private Customer findCustomerById(String customerId) {
		Customer customer = null;
		String sql = "SELECT * FROM dblab.customers WHERE customerID='" + customerId + "';";
		try {
			Statement stmt = dbConn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			if (rs.next()) {
				// Retrieve customer data and create a Customer object

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customer;
	}
	// Example for deleting a Customer record by ID

	private void deleteCustomerById(String customerId) {
		String sql = "DELETE FROM dblab.customers WHERE customerID='" + customerId + "';";
		try {
			Statement stmt = dbConn.createStatement();

			if ((stmt.executeUpdate(sql) == 1)) {
				objOs.writeObject(true);
			} else {
				objOs.writeObject(false);
			}
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
	}

	private void addTransactionToDatabase(Transaction1 transaction) {
	    String sql = "INSERT INTO Transaction(transactionID, transactionDate, amountPaid)" +
	            " VALUES('" + transaction.getTransactionID() + "','" + transaction.getTransactionDate() +
	            "','" + transaction.getAmountPaid() + "');";
	    try {
	        Statement stmt = dbConn.createStatement();

	        if ((stmt.executeUpdate(sql) == 1)) {
	            objOs.writeObject(true);
	        } else {
	            objOs.writeObject(false);
	        }
	    } catch (SQLException | IOException e) {
	        e.printStackTrace();
	    }
	}

	private void addRentalRequestToDatabase(RentalRequest rentalRequest) {
	    String sql = "INSERT INTO RentalRequest(requestID, rentalDate, quotationCost, rentalStatus)" +
	            " VALUES('" + rentalRequest.getRequestID() + "','" + rentalRequest.getRentalDate() +
	            "','" + rentalRequest.getQuotationCost() + "','" + rentalRequest.isRentalStatus() + "');";
	    try {
	        Statement stmt = dbConn.createStatement();

	        if ((stmt.executeUpdate(sql) == 1)) {
	            objOs.writeObject(true);
	        } else {
	            objOs.writeObject(false);
	        }
	    } catch (SQLException | IOException e) {
	        e.printStackTrace();
	    }
	}

	private void addMessageToDatabase(CustomerMessage message) {
	    String sql = "INSERT INTO Message(messageID, messageContent)" +
	            " VALUES('" + message.getMessageID() + "','" + message.getMessageContent() + "');";
	    try {
	        Statement stmt = dbConn.createStatement();

	        if ((stmt.executeUpdate(sql) == 1)) {
	            objOs.writeObject(true);
	        } else {
	            objOs.writeObject(false);
	        }
	    } catch (SQLException | IOException e) {
	        e.printStackTrace();
	    }
	}

	private void addEventScheduleToDatabase(EventSchedule eventSchedule) {
	    String sql = "INSERT INTO EventSchedule(EventscheduleID)" +
	            " VALUES('" + eventSchedule.getEventScheduleID() + "');";
	    try {
	        Statement stmt = dbConn.createStatement();

	        if ((stmt.executeUpdate(sql) == 1)) {
	            objOs.writeObject(true);
	        } else {
	            objOs.writeObject(false);
	        }
	    } catch (SQLException | IOException e) {
	        e.printStackTrace();
	    }
	}

	private void addEventToDatabase(Event event) {
	    String sql = "INSERT INTO Event(eventID, eventName, date)" +
	            " VALUES('" + event.getEventID() + "','" + event.getEventName() +
	            "','" + event.getEventDate() + "');";
	    try {
	        Statement stmt = dbConn.createStatement();

	        if ((stmt.executeUpdate(sql) == 1)) {
	            objOs.writeObject(true);
	        } else {
	            objOs.writeObject(false);
	        }
	    } catch (SQLException | IOException e) {
	        e.printStackTrace();
	    }
	}

	private void addEquipmentStockToDatabase(Inventory equipmentStock) {
	    String sql = "INSERT INTO Equipmentstock(equipmentID, quantityAvailable)" +
	            " VALUES('" + equipmentStock.getEquipmentID() + "','" + equipmentStock.getQuantityAvailable() + "');";
	    try {
	        Statement stmt = dbConn.createStatement();

	        if ((stmt.executeUpdate(sql) == 1)) {
	            objOs.writeObject(true);
	        } else {
	            objOs.writeObject(false);
	        }
	    } catch (SQLException | IOException e) {
	        e.printStackTrace();
	    }
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
		event= session.get(Event.class,((Event) event).getEventID());
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
		event= session.get(Event.class,((Event) event).getEventID());
		event.setEventName(event.getEventName());
		transaction.commit();
		session.clear();
	}
}
