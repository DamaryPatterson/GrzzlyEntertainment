package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerDashboard extends JFrame {

    private static final long serialVersionUID = 1L;
    private JDesktopPane desktopPane;
    private JMenuBar menuBar;
    private JMenu menuViewEquipments;
    private JMenu menuLeaveMessage;
    private JMenu viewTransactonsMenu;

    public CustomerDashboard() {
        initializeComponents();
        setLayout();
        addMenusToMenu();
        addMenusToMenuBar();
        setWindowsProperty();
    }

    private void initializeComponents() {
        desktopPane = new JDesktopPane();
        menuBar = new JMenuBar();
        menuViewEquipments = new JMenu("View Equipments");
        menuViewEquipments.setMnemonic('A');
        menuLeaveMessage = new JMenu("Leave Message");
        menuLeaveMessage.setMnemonic('B');
        viewTransactonsMenu = new JMenu("View Transaction");
        viewTransactonsMenu.setMnemonic('C');
    }

    private void setLayout() {
        setLayout(new BorderLayout());
        add(desktopPane, BorderLayout.CENTER);
    }

    private void addMenusToMenuBar() {
        menuBar.add(menuViewEquipments);
        menuBar.add(menuLeaveMessage);
        menuBar.add(viewTransactonsMenu);
        setJMenuBar(menuBar);
    }

    private void addMenusToMenu() {
    	
    	
        JMenuItem viewEquipmentsMenuItem = new JMenuItem("View Equipments");
        viewEquipmentsMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewEquipments viewEquipments = new ViewEquipments();
                desktopPane.add(viewEquipments);
                viewEquipments.setVisible(true);
            }
        });
        menuViewEquipments.add(viewEquipmentsMenuItem);
        
        
        
        JMenuItem leaveMessageMenuItem = new JMenuItem("Leave a Message");
        leaveMessageMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               new LeaveAMessage();
            }
        });
        menuLeaveMessage.add(leaveMessageMenuItem);
        
        
        
        JMenuItem viewTransactonsMenuItem = new JMenuItem("View Transactions");
        viewTransactonsMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewListOfPastTransactions viewTransaction = new ViewListOfPastTransactions();
                desktopPane.add(viewTransaction);
                viewTransaction.setVisible(true);
            }
        });
        viewTransactonsMenu.add(viewTransactonsMenuItem);
    }

    private void setWindowsProperty() {
        setTitle("Customer Dashboard");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new CustomerDashboard();
        });
    }
}
