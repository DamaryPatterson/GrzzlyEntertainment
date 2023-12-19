package view;

import javax.swing.*;

import client.com.Client;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class ParentWindow extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JDesktopPane desktopPane;
	private Client client= new Client();

    public ParentWindow() {
        setTitle("Parent Window");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);

        createMenuBar(); // Create the menu bar
        createButtons(); // Create buttons for internal frames

        desktopPane = new JDesktopPane(); // Create desktop pane to contain internal frames
        add(desktopPane); // Add desktop pane to the frame
    }

    private void createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.setMnemonic(KeyEvent.VK_X); // Setting mnemonic key to Alt+X
        exitItem.addActionListener(e -> System.exit(0));
        fileMenu.add(exitItem);
        menuBar.add(fileMenu);

        JMenu createMenu = new JMenu("Create");
        createMenu.setMnemonic(KeyEvent.VK_C); // Setting mnemonic key to Alt+C

        JMenuItem createInvoiceItem = new JMenuItem("Create Invoice");
        createInvoiceItem.setMnemonic(KeyEvent.VK_I); // Setting mnemonic key to Alt+I
        createInvoiceItem.addActionListener(e -> openInternalFrame(new CreateInvoice(), "Create Invoice"));
        createMenu.add(createInvoiceItem);

        JMenuItem createQuotationItem = new JMenuItem("Create Quotation");
        createQuotationItem.setMnemonic(KeyEvent.VK_Q); // Setting mnemonic key to Alt+Q
        createQuotationItem.addActionListener(e -> openInternalFrame(new CreateQuotation(), "Create Quotation"));
        createMenu.add(createQuotationItem);

        JMenuItem createReceiptItem = new JMenuItem("Create Receipt");
        createReceiptItem.setMnemonic(KeyEvent.VK_R); // Setting mnemonic key to Alt+R
        createReceiptItem.addActionListener(e -> openInternalFrame(new CreateReceipt(), "Create Receipt"));
        createMenu.add(createReceiptItem);

        menuBar.add(createMenu);

        setJMenuBar(menuBar);
    }


    private void createButtons() {
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        JButton respondToMessageButton = new JButton("Respond to Message");
        respondToMessageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openInternalFrame(new RespondToMessage(), "Respond to Message");
            }
        });
        buttonPanel.add(respondToMessageButton);

        JButton viewRentalRequestButton = new JButton("View Rental Request");
        viewRentalRequestButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openInternalFrame(new ViewRentalRequest(), "View Rental Request");
            }
        });
        buttonPanel.add(viewRentalRequestButton);

        JButton addEquipmentToEventButton = new JButton("Add Equipment to Event");
        addEquipmentToEventButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openInternalFrame(new EventScheduleFrame(client), "Add Equipment to Event");
            }
        });
        buttonPanel.add(addEquipmentToEventButton);

        JButton viewEquipmentStockButton = new JButton("View Equipment Stock");
        viewEquipmentStockButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openInternalFrame(new ViewInventory(), "View Equipment Stock");
            }
        });
        buttonPanel.add(viewEquipmentStockButton);

        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void openInternalFrame(JInternalFrame internalFrame, String title) {
        internalFrame.setTitle(title);
        internalFrame.setClosable(true);
        internalFrame.setMaximizable(true);
        internalFrame.setIconifiable(true);
        internalFrame.setResizable(true);
        internalFrame.setVisible(true);
        desktopPane.add(internalFrame);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ParentWindow parentWindow = new ParentWindow();
            parentWindow.setVisible(true); // Make the parent window visible
        });
    }
}
