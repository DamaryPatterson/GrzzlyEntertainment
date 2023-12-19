package client.com;

import models.com.*;


public class FinalClientDriver {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			Client client = new Client();
			Customer customer = new Customer("11001","JPatterson","0000",2000.0);
			CustomerMessage message = new CustomerMessage("xxxx","11001","This is a new message","");
			Transaction1 transaction = new Transaction1("t1263","11001","00011","2023-12-12",1000.0);
			
			
			 EventSchedule newEventSch = new EventSchedule();
		        newEventSch.setEventScheduleID("12345");
		        newEventSch.setEventID("654xx");
		        newEventSch.setEmployeeID("2000");
		        newEventSch.setEquipmentID("100");
		        newEventSch.setEventDate("2023-2-2"); // Set the event date as needed
		        
		        
		        
//			client.sendAction("Add Customer");
//			System.out.println("Message sent to server");
//			client.sendCustomer(customer);
//			System.out.println("record Sent to server");
//			client.receiveResponse();
//			System.out.println("Response recieved from server");

//			Employee emp = new Employee("2002", "damary", "test1");
//			client.sendAction("Add Employee");
//			System.out.println("Message sent to server");
//			client.sendEmployee(emp);
//			System.out.println("record Sent to server");
//			client.receiveResponse();
//			System.out.println("Response recieved from server");
		
//			client.sendAction("Find Employee");
//			System.out.println("Message sent to server");
//			client.sendCustomerId("2000");
//			System.out.println("ID Sent to server");
//			client.receiveResponse();
//			System.out.println("Response recieved from server");
			
//			client.sendAction("Add CustomerMessage");
//			System.out.println("Message sent to server");
//			client.sendMessage(message);
//			System.out.println("record Sent to server");
//			client.receiveResponse();
			
//			client.sendAction("Update CustomerMessage");
//			System.out.println("Message sent to server");
//			message.setEmployeeResponse("This is the employee response using update");
//			client.sendMessageUpdate("xxxx",message.getEmployeeResponse());
//			System.out.println("record Sent to server");
//			client.receiveResponse();
			
//			client.sendAction("Delete Event");
//			System.out.println("Message sent to server");
//			client.sendEventId("100xx");
//			System.out.println("ID Sent to server");
//			client.receiveResponse();
//			System.out.println("Response recieved from server");
		
//			client.sendAction("Add Transaction");
//			System.out.println("Message sent to server");
//			client.sendTransaction(transaction);
//			System.out.println("record Sent to server");
//			client.receiveResponse();
		

		        
		        
		        client.sendAction("Add EventSchedule");
		        System.out.println("Message sent to server");
		        client.sendEventSchedule(newEventSch);
		        System.out.println("record Sent to server");
			client.closeConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
