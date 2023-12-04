package view;

import javax.swing.*;

public class ViewInventory extends JInternalFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextArea equipmentStockTextArea;

    public ViewInventory() {
        super("View Equipment Stock", true, true, true, true);
        initializeComponents();
        setupLayout();
    }

    private void initializeComponents() {
        equipmentStockTextArea = new JTextArea(20, 40);
        equipmentStockTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(equipmentStockTextArea);
        getContentPane().add(scrollPane);
    }

    private void setupLayout() {
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            createAndShowGUI();
        });
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JDesktopPane desktopPane = new JDesktopPane();
        frame.add(desktopPane);

        ViewInventory internalFrame = new ViewInventory();
        desktopPane.add(internalFrame);

        internalFrame.setSize(400, 300);
        internalFrame.setVisible(true);

        frame.setSize(800, 600);
        frame.setVisible(true);
    }
}

