package view;
import javax.swing.*;

import client.Client;
import models.com.CustomerMessage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class LeaveAMessage {
    private JFrame frame;
    private JTextField messageIdField, customerIdField, messageField;
    private Client client= new Client();
    private CustomerMessage message= new CustomerMessage();

    public LeaveAMessage() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Message Sender");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 5, 5));
        JLabel lblMessageId = new JLabel("Message ID:");
        JLabel lblCustomerId = new JLabel("Customer ID:");
        JLabel lblMessage = new JLabel("Message:");

        messageIdField = new JTextField();
        customerIdField = new JTextField();
        messageField = new JTextField();

        inputPanel.add(lblMessageId);
        inputPanel.add(messageIdField);
        inputPanel.add(lblCustomerId);
        inputPanel.add(customerIdField);
        inputPanel.add(lblMessage);
        inputPanel.add(messageField);

        JButton sendButton = new JButton("Send");
        sendButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sendMessageToServer();
            }
        });

        frame.add(inputPanel, BorderLayout.CENTER);
        frame.add(sendButton, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    private void sendMessageToServer() {
        message.setMessageID(messageIdField.getText());
        message.setCustomerID(customerIdField.getText());
        message.setMessageContent(messageField.getText());
        message.setEmployeeResponse("");


        // Assuming 'client' is your client instance
        client.sendAction("Add CustomerMessage");
        System.out.println("Message sent to server");
        client.sendMessage(message);
        System.out.println("Record sent to server");
        client.receiveResponse();

        // Clear fields after sending
        messageIdField.setText("");
        customerIdField.setText("");
        messageField.setText("");
    }

    // Replace 'client' with your actual client class or instance

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new LeaveAMessage();
            }
        });
    }
}
