import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.Color;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;

/**
 * A dialog interface for displaying and editing customer data.
 * 
 * @author Samson James Ordonez
 * @version 1.0
 */

public class CustomerDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField_ID;
	private JTextField textField_firstName;
	private JTextField textField_lastName;
	private JTextField textField_street;
	private JTextField textField_city;
	private JTextField textField_postalCode;
	private JTextField textField_phone;
	private JTextField textField_email;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CustomerDialog dialog = new CustomerDialog(null, null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 *
	 * @param customerFrame  the customer frame
	 * @param randomCustomer the customer to display/edit, or null to create a new
	 *                       customer
	 */
	public CustomerDialog(CustomerFrame customerFrame, Customer randomCustomer) {
		setTitle("Customer Data");
		// setBounds(100, 100, 450, 300);
		setSize(450, 380);
		setMinimumSize(new java.awt.Dimension(450, 380));
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new MigLayout("", "[][grow]", "[][][][][][][][]"));

		EmptyBorder textFieldBorder = new EmptyBorder(3, 8, 3, 8);

		{
			JLabel customerID = new JLabel("ID");
			contentPanel.add(customerID, "cell 0 0,alignx trailing");
		}
		{
			textField_ID = new JTextField();
			textField_ID.setForeground(Color.WHITE);
			textField_ID.setBackground(SystemColor.inactiveCaption);
			textField_ID.setEditable(false);
			contentPanel.add(textField_ID, "cell 1 0,growx");
			textField_ID.setColumns(10);
			textField_ID.setBorder(textFieldBorder);
		}
		{
			JLabel customerFirstName = new JLabel("First Name");
			contentPanel.add(customerFirstName, "cell 0 1,alignx trailing");
		}
		{
			textField_firstName = new JTextField();
			contentPanel.add(textField_firstName, "cell 1 1,growx");
			textField_firstName.setColumns(10);
			textField_firstName.setBorder(textFieldBorder);
		}
		{
			JLabel customerLastName = new JLabel("Last Name");
			contentPanel.add(customerLastName, "cell 0 2,alignx trailing");
		}
		{
			textField_lastName = new JTextField();
			contentPanel.add(textField_lastName, "cell 1 2,growx");
			textField_lastName.setColumns(10);
			textField_lastName.setBorder(textFieldBorder);
		}
		{
			JLabel customerStreet = new JLabel("Street");
			contentPanel.add(customerStreet, "cell 0 3,alignx trailing");
		}
		{
			textField_street = new JTextField();
			contentPanel.add(textField_street, "cell 1 3,growx");
			textField_street.setColumns(10);
			textField_street.setBorder(textFieldBorder);
		}
		{
			JLabel customerCity = new JLabel("City");
			contentPanel.add(customerCity, "cell 0 4,alignx trailing");
		}
		{
			textField_city = new JTextField();
			contentPanel.add(textField_city, "cell 1 4,growx");
			textField_city.setColumns(10);
			textField_city.setBorder(textFieldBorder);
		}
		{
			JLabel customerPostalCode = new JLabel("Postal Code");
			contentPanel.add(customerPostalCode, "cell 0 5,alignx trailing");
		}
		{
			textField_postalCode = new JTextField();
			contentPanel.add(textField_postalCode, "cell 1 5,growx");
			textField_postalCode.setColumns(10);
			textField_postalCode.setBorder(textFieldBorder);
		}
		{
			JLabel customerPhone = new JLabel("Phone");
			contentPanel.add(customerPhone, "cell 0 6,alignx trailing");
		}
		{
			textField_phone = new JTextField();
			contentPanel.add(textField_phone, "cell 1 6,growx");
			textField_phone.setColumns(10);
			textField_phone.setBorder(textFieldBorder);
		}
		{
			JLabel customerEmail = new JLabel("Email");
			contentPanel.add(customerEmail, "cell 0 7,alignx trailing");
		}
		{
			textField_email = new JTextField();
			contentPanel.add(textField_email, "cell 1 7,growx");
			textField_email.setColumns(10);
			textField_email.setBorder(textFieldBorder);
		}
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			JButton okButton = new JButton("OK");
			okButton.setForeground(Color.WHITE);
			okButton.setBackground(UIManager.getColor("Button.light"));
			okButton.setMnemonic('O');
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			buttonPane.setLayout(new MigLayout("fillx, insets 25", "[75px]", "[29px]"));
			okButton.setActionCommand("OK");
			buttonPane.add(okButton, "alignx right,aligny center");
			getRootPane().setDefaultButton(okButton);
			buttonPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[] { okButton }));
		}

		if (randomCustomer != null) {
			textField_ID.setText(String.valueOf(randomCustomer.getId()));
			textField_firstName.setText(randomCustomer.getFirstName());
			textField_lastName.setText(randomCustomer.getLastName());
			textField_street.setText(randomCustomer.getStreet());
			textField_city.setText(randomCustomer.getCity());
			textField_postalCode.setText(randomCustomer.getPostalCode());
			textField_phone.setText(randomCustomer.getPhone());
			textField_email.setText(randomCustomer.getEmail());
		}
	}

}
