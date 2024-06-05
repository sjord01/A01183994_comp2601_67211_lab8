import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;
import java.awt.event.InputEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * This class represents the main frame of the customer application. It displays
 * a menu bar with options to show a random customer, exit the application, and
 * view information about the application.
 * 
 * @author Samson James Ordonez
 * @version 1.0
 */
public class CustomerFrame extends JFrame {

	private JPanel contentPane;
	private ArrayList<Customer> customers;

	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ArrayList<Customer> customers = new ArrayList<>();
					Lab8 lab = new Lab8();
					lab.init();
					customers = lab.getCustomers();
					CustomerFrame frame = new CustomerFrame(customers);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Constructs the customer frame.
	 * 
	 * @param customers The list of customers to display.
	 */
	public CustomerFrame(ArrayList<Customer> customers) {
		this.customers = customers;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// setBounds(100, 100, 450, 300);
		setSize(450, 300);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("File");
		mnNewMenu.setMnemonic('F');
		menuBar.add(mnNewMenu);

		JMenuItem showRandomCustomer = new JMenuItem("Customer");
		showRandomCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showRandomCustomerDialog();
			}
		});
		showRandomCustomer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.ALT_DOWN_MASK));
		mnNewMenu.add(showRandomCustomer);

		mnNewMenu.addSeparator();

		JMenuItem exitCustomerApp = new JMenuItem("Exit");
		exitCustomerApp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		exitCustomerApp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.ALT_DOWN_MASK));
		mnNewMenu.add(exitCustomerApp);

		JMenu mnNewMenu_1 = new JMenu("Help");
		mnNewMenu_1.setMnemonic('H');
		menuBar.add(mnNewMenu_1);

		JMenuItem showAboutApp = new JMenuItem("About");
		showAboutApp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(CustomerFrame.this, "Lab 8\nBy Samson James D. Ordonez\nA01183994",
						"About", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		showAboutApp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
		mnNewMenu_1.add(showAboutApp);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[]", "[]"));

	}

	/**
	 * Displays a dialog showing information about a randomly selected customer.
	 */
	private void showRandomCustomerDialog() {
		if (customers != null && !customers.isEmpty()) {
			Random random = new Random();
			Customer randomCustomer = customers.get(random.nextInt(customers.size()));
			CustomerDialog dialog = new CustomerDialog(this, randomCustomer);
			dialog.setVisible(true);
		} else {
			JOptionPane.showMessageDialog(this, "No customers available", "Error", JOptionPane.ERROR_MESSAGE);
		}

	}
}
