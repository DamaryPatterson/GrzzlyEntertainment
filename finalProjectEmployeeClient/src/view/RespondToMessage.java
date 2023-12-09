package view;

import javax.swing.*;

import client.com.Client;
import models.com.CustomerMessage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RespondToMessage extends JInternalFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField messageIdField;
    private JTextArea messageArea;
    private Client client = new Client();
    private CustomerMessage message= new CustomerMessage();

    public RespondToMessage() {
        super("Respond To Message", true, true, true, true);
        initialize();
    }

    private void initialize() {
        JPanel panel = new JPanel(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(2, 2, 5, 5));
        JLabel lblMessageId = new JLabel("Message ID:");
        messageIdField = new JTextField();
        JLabel lblMessage = new JLabel("Employee Response:");

        messageArea = new JTextArea();
        messageArea.setLineWrap(true);
        JScrollPane scrollPane = new JScrollPane(messageArea);

        inputPanel.add(lblMessageId);
        inputPanel.add(messageIdField);
        inputPanel.add(lblMessage);
        inputPanel.add(scrollPane);

        JButton sendButton = new JButton("Send");
        sendButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sendMessageUpdateToServer();
            }
        });

        panel.add(inputPanel, BorderLayout.CENTER);
        panel.add(sendButton, BorderLayout.SOUTH);
        getContentPane().add(panel);
        pack();
    }

    private void sendMessageUpdateToServer() {
    	
    	message.setMessageID(messageIdField.getText());
    	message.setEmployeeResponse(messageArea.getText());

        // Assuming 'client' is your client instance
        client.sendAction("Update CustomerMessage");
        System.out.println("Message sent to server");

        // Replace "xxxx" with your actual message ID parameter
        client.sendMessageUpdate(messageIdField.getText(),messageArea.getText());
        System.out.println("Record sent to server");

        client.receiveResponse();

        // Clear fields after sending
        messageIdField.setText("");
        messageArea.setText("");
    }

    // Replace 'client' with your actual client class or instance

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("Internal Frame Example");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                JDesktopPane desktop = new JDesktopPane();
                frame.setContentPane(desktop);

                RespondToMessage internalFrame = new RespondToMessage();
                internalFrame.setVisible(true);
                desktop.add(internalFrame);

                frame.setSize(600, 400);
                frame.setVisible(true);
            }
        });
    }
}
