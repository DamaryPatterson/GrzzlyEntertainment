package client.com;

import models.com.Customer;
import models.com.Equipment;
import models.com.CustomerMessage;
import models.com.RentalRequest;
import models.com.Transaction;

@SuppressWarnings("unused")
public class FinalClientDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		Client client = new Client();

//		Customer customer = new Customer("11001","JPatterson","0000",2000.0);
//		client.sendAction("Add Customer");
//		System.out.println("Message sent to server");
//		client.sendCustomer(customer);
//		System.out.println("record Sent to server");
//		client.receiveResponse();
//		System.out.println("Response recieved from server");
//		
		client.sendAction("Find Customer");
		client.sendCustomerId("1000");
		client.receiveResponse();
		
		client.closeConnection();
	}

}
