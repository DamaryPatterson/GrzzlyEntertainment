package view;

import javax.swing.*;

import client.com.Client;
import models.com.Event;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddEventsForm extends JInternalFrame {
    private static final long serialVersionUID = 1L;
    private JTextField eventIdField;
    private JTextField eventNameField;
    private JTextField eventDateField;
    private JButton addButton;
    private Client client = new Client();

    public AddEventsForm() {
        initComponents();
        addComponents();
        addButtonListeners();
    }

    private void initComponents() {
        eventIdField = new JTextField(20);
        eventNameField = new JTextField(20);
        eventDateField = new JTextField(20);
        addButton = new JButton("Add");
    }

    private void addComponents() {
        JPanel panel = new JPanel(new GridLayout(4,3));
        panel.add(new JLabel("Event ID:"));
        panel.add(eventIdField);
        panel.add(new JLabel("Event Name:"));
        panel.add(eventNameField);
        panel.add(new JLabel("Event Date:"));
        panel.add(eventDateField);
        panel.add(addButton);

        getContentPane().add(panel);
        setTitle("Add Events");
        setSize(300, 200);
        setResizable(false);
        setClosable(true);
        setMaximizable(true);
        setIconifiable(true);
    }

    private void addButtonListeners() {
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addEvent();
            }
        });
    }

    private void addEvent() {
        String eventId = eventIdField.getText();
        String eventName = eventNameField.getText();
        String eventDate = eventDateField.getText();

        if (isValid(eventId, eventName, eventDate)) {
            Event event = new Event(eventId, eventName, eventDate);
            client.sendAction("Add Event");
            client.sendEvent(event);
            JOptionPane.showMessageDialog(null, "Processing");
            client.receiveResponse();
            clearFields();
        } else {
            JOptionPane.showMessageDialog(null, "Invalid input. Please check your data.");
        }
    }

    private boolean isValid(String eventId, String eventName, String eventDate) {
        return !eventId.isEmpty() && !eventName.isEmpty() && !eventDate.isEmpty();
    }

    private void clearFields() {
        eventIdField.setText("");
        eventNameField.setText("");
        eventDateField.setText("");
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Add Events Form Driver");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        
        JDesktopPane desktopPane = new JDesktopPane();
        AddEventsForm addEventsForm = new AddEventsForm();
        desktopPane.add(addEventsForm);
        frame.setContentPane(desktopPane);
        addEventsForm.setVisible(true);
        frame.setVisible(true);
    }
}
