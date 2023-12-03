package view;

import javax.swing.*;
import client.com.Client;
import models.com.Equipment;
import java.awt.*;

public class AddEquipmentForm extends JInternalFrame {

    private static final long serialVersionUID = 1L;
    private Client client;
    private JTextField equipmentIdField;
    private JTextField equipmentNameField;
    private JTextField priceField;
    private JComboBox<String> categoryComboBox;
    private JButton addButton;

    public AddEquipmentForm(Client client) {
        super("Add Equipment", true, true, true, true);
        this.client = client;
        initializeComponents();
        setupFormPanel();
        setupLayoutAndVisibility();
    }

    private void initializeComponents() {
        equipmentIdField = new JTextField(10);
        equipmentNameField = new JTextField(20);
        priceField = new JTextField(10);
        categoryComboBox = new JComboBox<>(new String[]{"Lighting",
        		"Staging", "Sound", "Power"});
        addButton = new JButton("Add Equipment");
        addButton.addActionListener(e -> addEquipment());
    }

    private void setupFormPanel() {
        JPanel panel = new JPanel(new GridLayout(5, 2));
        panel.add(new JLabel("Equipment ID:"));
        panel.add(equipmentIdField);
        panel.add(new JLabel("Equipment Name:"));
        panel.add(equipmentNameField);
        panel.add(new JLabel("price:"));
        panel.add(priceField);
        panel.add(new JLabel("Category:"));
        panel.add(categoryComboBox);
        panel.add(new JLabel());
        panel.add(addButton);
        setLayout(new BorderLayout());
        add(panel, BorderLayout.CENTER);
    }

    private void setupLayoutAndVisibility() {
        setSize(300, 200);
        setLocation(100, 100);
        setVisible(true);
    }

    private void addEquipment() {
        String equipmentId = equipmentIdField.getText();
        String equipmentName = equipmentNameField.getText();
        double price = Double.parseDouble(priceField.getText());
        String category = (String) categoryComboBox.getSelectedItem();

        Equipment newEquipment = new Equipment();
        newEquipment.setEquipmentID(equipmentId);
        newEquipment.setEquipmentName(equipmentName);
        newEquipment.setEquipmentCategory(category);
        newEquipment.setPrice(price);
        newEquipment.setAvailabilityStatus(true);

        client.sendAction("Add Equipment");
        client.sendEquipment(newEquipment);

        clearFormFields();
    }

    private void clearFormFields() {
        equipmentIdField.setText("");
        equipmentNameField.setText("");
        priceField.setText("");
        categoryComboBox.setSelectedIndex(0);
    }

    public static void main(String[] args) {
        Client client = new Client();
        AddEquipmentForm addEquipmentForm = new AddEquipmentForm(client);
        JFrame frame = new JFrame("Equipment Management App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.getContentPane().add(addEquipmentForm);
        frame.setVisible(true);
    }
}
