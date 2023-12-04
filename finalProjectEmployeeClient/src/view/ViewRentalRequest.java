package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import client.com.Client;
import models.com.RentalRequest;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ViewRentalRequest extends JInternalFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
    private JTable table;
    private JButton btnClear;
    private JButton btnShow;
    private DefaultTableModel tableModel;
    private List<RentalRequest> requestList;
    private Client client= new Client();
    
    
    public ViewRentalRequest() {
    	super("View Request", true, true, true, true);
        initializeFrame();
        initializeComponents();
    }

    private void initializeFrame() {
        setTitle("Rental Requests");
        setResizable(true);
        setMaximizable(true);
        setIconifiable(true);
        setClosable(true);
        setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
    }

    private void initializeComponents() {
        initializeTable();
        initializeButtons();
    }

    private void initializeTable() {
        table = new JTable();
        tableModel= (DefaultTableModel) table.getModel();
        table.setBounds(20, 20, 400, 150); // Adjust the bounds as needed
        contentPane.add(table);
    }

    private void initializeButtons() {
        btnClear = new JButton("Clear");
        btnClear.setBounds(50, 200, 100, 30); // Adjust the bounds as needed
        btnClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Add logic to clear data in the table
                table.setModel(new DefaultTableModel());
            }
        });
        contentPane.add(btnClear);

        btnShow = new JButton("Show");
        btnShow.setBounds(200, 200, 100, 30); // Adjust the bounds as needed
        btnShow.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Add logic to show data in the table
            	client.sendAction("Read All Request");
            	requestList = client.viewAllRequest();
            	client.receiveResponse();
                loadTableData();
            }
        });
        contentPane.add(btnShow);
    }

    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Rental Request Viewer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);

        ViewRentalRequest rentalRequestFrame = new ViewRentalRequest();
        frame.getContentPane().add(rentalRequestFrame);

        rentalRequestFrame.setVisible(true);
        frame.setVisible(true);
    }
    // Additional methods for loading data into the table or other functionalities can be added here
    private void loadTableData() {
    	if(requestList!=null) {
    		String []colName= {"requestID","customerID","equipmentID",
    				"rentalDate","quotationCost","rentalStatus"};
    		tableModel.setColumnIdentifiers(colName);
    		
    		for(RentalRequest request : requestList) {
    			tableModel.addRow(new String[] {
    					String.valueOf(request.getRequestID()),
    					String.valueOf(request.getCustomerID()),
    					String.valueOf(request.getEquipmentID()),
    					String.valueOf(request.getRentalDate()),
    					String.valueOf(request.getQuotationCost()),
    					String.valueOf(request.isRentalStatus())
    			});
    		}
    	}
    }
}
