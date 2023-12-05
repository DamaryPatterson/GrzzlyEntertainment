package client.com;

import models.com.*;


public class FinalClientDriver {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			Client client = new Client();
			Customer customer = new Customer("11001","JPatterson","0000",2000.0);
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
		
			client.sendAction("Find Employee");
			System.out.println("Message sent to server");
			client.sendCustomerId("2000");
			System.out.println("ID Sent to server");
			client.receiveResponse();
			System.out.println("Response recieved from server");
			
			
//			client.sendAction("Delete Event");
//			System.out.println("Message sent to server");
//			client.sendEventId("100xx");
//			System.out.println("ID Sent to server");
//			client.receiveResponse();
//			System.out.println("Response recieved from server");
		
			
		
			client.closeConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
