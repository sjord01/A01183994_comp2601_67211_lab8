import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * This class represents the main class for the customer management application.
 * It reads customer data from a file, initializes a list of customers, and
 * loads the main GUI frame.
 * 
 * @author Samson James Ordonez
 * @version 1.0
 */
public class Lab8 {

	private static ArrayList<Customer> customers;

	private static final String FILEPATH_CUSTOMERS = "src//customers.txt";
	private static final String DELIMETER_CUSTOMERS = "\\|";

	private static final int POSITION_INT = 0;
	private static final int POSITION_FIRSTNAME = 1;
	private static final int POSITION_LASTNAME = 2;
	private static final int POSITION_STREET = 3;
	private static final int POSITION_CITY = 4;
	private static final int POSITION_POSTALCODE = 5;
	private static final int POSITION_PHONE = 6;
	private static final int POSITION_EMAIL = 7;

	public static void main(final String[] args) {

		Lab8 lab = new Lab8();
		lab.init();
		lab.loadFrame();
	}

	/**
	 * Initializes the list of customers by reading data from the customers file.
	 */
	public void init() {
		customers = new ArrayList<>();
		String filePath = FILEPATH_CUSTOMERS;
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] data = line.split(DELIMETER_CUSTOMERS);
				int id = Integer.parseInt(data[POSITION_INT]);
				String firstName = data[POSITION_FIRSTNAME];
				String lastName = data[POSITION_LASTNAME];
				String street = data[POSITION_STREET];
				String city = data[POSITION_CITY];
				String postalCode = data[POSITION_POSTALCODE];
				String phone = data[POSITION_PHONE];
				String email = data[POSITION_EMAIL];
				customers.add(new Customer(id, firstName, lastName, street, city, postalCode, phone, email));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Loads the main GUI frame of the application.
	 */
	public void loadFrame() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerFrame frame = new CustomerFrame(customers);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Returns the list of customers.
	 * 
	 * @return The list of customers.
	 */
	public ArrayList<Customer> getCustomers() {
		return customers;
	}
}
