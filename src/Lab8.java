import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Lab8 {

    public static void main(final String[] args) {

        // Set up the frame
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CustomerFrame frame = new CustomerFrame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    public static ArrayList<Customer> loadCustomers(String filePath) {
        ArrayList<Customer> customers = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\|");
                int id = Integer.parseInt(data[0]);
                String firstName = data[1];
                String lastName = data[2];
                String street = data[3];
                String city = data[4];
                String postalCode = data[5];
                String phone = data[6];
                String email = data[7];
                customers.add(new Customer(id, firstName, lastName, street, city, postalCode, phone, email));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customers;
    }
}
