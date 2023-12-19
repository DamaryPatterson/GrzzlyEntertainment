package view;


import javax.swing.*;

import client.com.Client;
import models.com.EventSchedule;

import java.awt.*;

public class EventScheduleFrame extends JInternalFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField eventScheduleIDField;
    private JTextField eventIDField;
    private JTextField employeeIDField;
    private JTextField equipmentIDField;
    private JTextField eventDateField;

    private Client client; // Assuming you have a Client class instance

    public EventScheduleFrame(Client client) {
        super("Add EventSchedule", true, true, true, true);
        this.client = client;

        createComponents();
        setupPanel();
        pack(); // Adjusts the size of the frame based on its contents
    }

    private void createComponents() {
        eventScheduleIDField = new JTextField(20);
        eventIDField = new JTextField(20);
        employeeIDField = new JTextField(20);
        equipmentIDField = new JTextField(20);
        eventDateField = new JTextField(20);

        // Other component creations...

        // Add necessary components...
        // ...
    }

    private void setupPanel() {
        JPanel panel = new JPanel(new GridLayout(6, 2)); // Adjust rows and columns as needed

        addLabelAndField(panel, "Event Schedule ID:", eventScheduleIDField);
        addLabelAndField(panel, "Event ID:", eventIDField);
        addLabelAndField(panel, "Employee ID:", employeeIDField);
        addLabelAndField(panel, "Equipment ID:", equipmentIDField);
        addLabelAndField(panel, "Event Date (yyyy-MM-dd):", eventDateField);

        JButton submitButton = createSubmitButton();
        panel.add(new JLabel()); // Placeholder for alignment
        panel.add(submitButton);

        getContentPane().add(panel);
    }

    private void addLabelAndField(JPanel panel, String labelText, JTextField field) {
        JLabel label = new JLabel(labelText);
        panel.add(label);
        panel.add(field);
    }

    private JButton createSubmitButton() {
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(e -> addEventSchedule());
        return submitButton;
    }

    private void addEventSchedule() {
        String eventScheduleID = eventScheduleIDField.getText();
        String eventID = eventIDField.getText();
        String employeeID = employeeIDField.getText();
        String equipmentID = equipmentIDField.getText();
        String eventDateString = eventDateField.getText();

        EventSchedule newEventSch = new EventSchedule();
        newEventSch.setEventScheduleID(eventScheduleID);
        newEventSch.setEventID(eventID);
        newEventSch.setEmployeeID(employeeID);
        newEventSch.setEquipmentID(equipmentID);
        newEventSch.setEventDate(eventDateString);

        client.sendAction("Add EventSchedule");
        System.out.println("Message sent to server");
        client.sendEventSchedule(newEventSch);
        System.out.println("Record sent to server");
    }

    public static void main(String[] args) {
        Client client = new Client(); // Instantiate your Client class here

        EventQueue.invokeLater(() -> {
            JFrame frame = new JFrame("Event Schedule Management");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JDesktopPane desktopPane = new JDesktopPane();
            frame.setContentPane(desktopPane);

            EventScheduleFrame eventScheduleFrame = new EventScheduleFrame(client);
            desktopPane.add(eventScheduleFrame);
            eventScheduleFrame.setVisible(true);

            frame.setSize(400, 300);
            frame.setVisible(true);
        });
    }
}

