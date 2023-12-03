package view;

import javax.swing.*;

import client.com.Client;
import models.com.Customer;

import java.awt.*;
import java.awt.event.*;

public class CustomerForm extends JInternalFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblCustomerId, lblUsername, lblPassword,lblBalance;
    private JTextField txtCustomerId, txtUsername, txtPassword,txtBalance;
    private JButton btnSave;

    public CustomerForm() {
        super("Add Customer", true, true, true, true);
        setLayout(new GridLayout(5, 3));

        lblCustomerId = new JLabel("Customer ID:");
        txtCustomerId = new JTextField();
        add(lblCustomerId);
        add(txtCustomerId);

        lblUsername = new JLabel("Username:");
        txtUsername = new JTextField();
        add(lblUsername);
        add(txtUsername);

        lblPassword = new JLabel("Password:");
        txtPassword = new JPasswordField();
        add(lblPassword);
        add(txtPassword);
        
        lblBalance = new JLabel("Account Balance:");
        txtBalance = new JTextField();
        add(lblBalance);
        add(txtBalance);
        

        btnSave = new JButton("Save");
        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveCustomer();
            }
        });
        add(btnSave);

        setSize(300, 200);
    }

    private void saveCustomer() {
        String customerId = txtCustomerId.getText();
        String username = txtUsername.getText();
        String password = txtPassword.getText();
        String balanceText = txtBalance.getText();

        if (customerId.isEmpty() || username.isEmpty() || password.isEmpty() || balanceText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Incomplete Form", JOptionPane.WARNING_MESSAGE);
            return;
        }

        double balance;
        try {
            balance = Double.parseDouble(balanceText);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid balance.", "Invalid Balance", JOptionPane.ERROR_MESSAGE);
            return;
        }

        SwingWorker<Void, Void> worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() {
                try {
                    Client client = new Client();
                    Customer customer = new Customer(customerId, username, password, balance);
                    client.sendAction("Add Customer");
                    client.sendCustomer(customer);
                } catch (Exception ex) {
                    ex.printStackTrace(); // Log any exceptions to the console
                }

                return null;
            }

            @Override
            protected void done() {
                System.out.println("Customer ID: " + customerId);
                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
                System.out.println("Balance: " + balance);

                clearFields();
            }
        };

        System.out.println("Executing worker..."); // Add this line to check if the action is triggered
        worker.execute();
    }



    private void clearFields() {
        txtCustomerId.setText("");
        txtUsername.setText("");
        txtPassword.setText("");
        txtBalance.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Customer Form");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JDesktopPane desktopPane = new JDesktopPane();
        CustomerForm customerForm = new CustomerForm();
        desktopPane.add(customerForm);
        customerForm.setVisible(true);

        frame.add(desktopPane);
        frame.setSize(600, 400);
        frame.setVisible(true);
    }
}
