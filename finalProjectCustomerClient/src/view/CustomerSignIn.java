package view;

import javax.swing.*;

import client.Client;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerSignIn extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField idField;
    private JPasswordField passwordField;
    private JButton signInButton;
    private Client client= new Client();

    public CustomerSignIn() {
        initializeComponents();
        setLayout();
        setWindowsProperty();
        addSignInListener();
    }

    private void initializeComponents() {
        idField = new JTextField(15);
        passwordField = new JPasswordField(15);
        signInButton = new JButton("Sign In");
    }

    private void setLayout() {
        setLayout(new BorderLayout());
        JPanel panel = new JPanel(new GridLayout(3, 2));
        panel.add(new JLabel("ID: "));
        panel.add(idField);
        panel.add(new JLabel("Password: "));
        panel.add(passwordField);
        panel.add(new JLabel(""));
        panel.add(signInButton);
        add(panel, BorderLayout.CENTER);
    }

    private void setWindowsProperty() {
        setTitle("Customer Sign In");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void addSignInListener() {
        signInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = idField.getText();
                String password = new String(passwordField.getPassword());
                // For demo purposes, just check if fields are not empty
                try {
					client.sendAction("Customer Login");
					client.sendLoginDetails(id, password); // Call your method here to send details to server
					boolean loginResult = client.receiveResponse(); // Modify receiveResponse to return a boolean
					if (loginResult) {
					    JOptionPane.showMessageDialog(null, "Login Successful!");
					    new CustomerDashboard();
					    // Add code to navigate to the next screen or perform necessary actions on successful login
					} else {
					    JOptionPane.showMessageDialog(null, "Login Failed. Please check your credentials.");
					}
					clearFields();
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        });
    }
    public void clearFields() {
    	idField.setText("");
    	passwordField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new CustomerSignIn();
        });
    }
}
