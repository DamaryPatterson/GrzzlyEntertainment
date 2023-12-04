package view;

import javax.swing.*;

import client.com.Client;

import java.awt.event.*;

public class EmployeeSignIn {
    private JFrame frame;
    private JTextField idField;
    private JPasswordField passwordField;
    private Client client= new Client();

    public EmployeeSignIn() {
    	
        frame = new JFrame("Employee Sign-In");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel idLabel = new JLabel("ID:");
        idLabel.setBounds(30, 30, 80, 25);
        frame.add(idLabel);

        idField = new JTextField();
        idField.setBounds(120, 30, 150, 25);
        frame.add(idField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(30, 70, 80, 25);
        frame.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(120, 70, 150, 25);
        frame.add(passwordField);

        JButton signInButton = new JButton("Sign In");
        signInButton.setBounds(100, 120, 100, 25);
        frame.add(signInButton);

        signInButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String id = idField.getText();
                String password = new String(passwordField.getPassword());
                
                client.sendAction("Employee Login");
                client.sendLoginDetails(id, password); // Call your method here to send details to server
                boolean loginResult = client.receiveResponse(); // Modify receiveResponse to return a boolean
                if (loginResult) {
                    JOptionPane.showMessageDialog(frame, "Login Successful!");
                    ParentWindow parentWindow = new ParentWindow();
                    parentWindow.setVisible(true);
                    // Add code to navigate to the next screen or perform necessary actions on successful login
                } else {
                    JOptionPane.showMessageDialog(frame, "Login Failed. Please check your credentials.");
                }
                clearFields();
            }
        });

        frame.setVisible(true);
    }

    public void clearFields() {
    	idField.setText("");
    	passwordField.setText("");
    }


    public static void main(String[] args) {
        new EmployeeSignIn();
    }
}

