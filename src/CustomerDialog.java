import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

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
			CustomerDialog dialog = new CustomerDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CustomerDialog() {
		setTitle("Customer Data");
		//setBounds(100, 100, 450, 300);
		setSize(450, 350);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new MigLayout("", "[][grow]", "[][][][][][][][]"));
		{
			JLabel customerID = new JLabel("ID");
			contentPanel.add(customerID, "cell 0 0,alignx trailing");
		}
		{
			textField_ID = new JTextField();
			textField_ID.setEditable(false);
			contentPanel.add(textField_ID, "cell 1 0,growx");
			textField_ID.setColumns(10);
		}
		{
			JLabel customerFirstName = new JLabel("First Name");
			contentPanel.add(customerFirstName, "cell 0 1,alignx trailing");
		}
		{
			textField_firstName = new JTextField();
			contentPanel.add(textField_firstName, "cell 1 1,growx");
			textField_firstName.setColumns(10);
		}
		{
			JLabel customerLastName = new JLabel("Last Name");
			contentPanel.add(customerLastName, "cell 0 2,alignx trailing");
		}
		{
			textField_lastName = new JTextField();
			contentPanel.add(textField_lastName, "cell 1 2,growx");
			textField_lastName.setColumns(10);
		}
		{
			JLabel customerStreet = new JLabel("Street");
			contentPanel.add(customerStreet, "cell 0 3,alignx trailing");
		}
		{
			textField_street = new JTextField();
			contentPanel.add(textField_street, "cell 1 3,growx");
			textField_street.setColumns(10);
		}
		{
			JLabel customerCity = new JLabel("City");
			contentPanel.add(customerCity, "cell 0 4,alignx trailing");
		}
		{
			textField_city = new JTextField();
			contentPanel.add(textField_city, "cell 1 4,growx");
			textField_city.setColumns(10);
		}
		{
			JLabel customerPostalCode = new JLabel("Postal Code");
			contentPanel.add(customerPostalCode, "cell 0 5,alignx trailing");
		}
		{
			textField_postalCode = new JTextField();
			contentPanel.add(textField_postalCode, "cell 1 5,growx");
			textField_postalCode.setColumns(10);
		}
		{
			JLabel customerPhone = new JLabel("Phone");
			contentPanel.add(customerPhone, "cell 0 6,alignx trailing");
		}
		{
			textField_phone = new JTextField();
			contentPanel.add(textField_phone, "cell 1 6,growx");
			textField_phone.setColumns(10);
		}
		{
			JLabel customerEmail = new JLabel("Email");
			contentPanel.add(customerEmail, "cell 0 7,alignx trailing");
		}
		{
			textField_email = new JTextField();
			contentPanel.add(textField_email, "cell 1 7,growx");
			textField_email.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(new MigLayout("", "[75px][86px][][][][][][][]", "[29px]"));
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton, "cell 8 0,alignx left,aligny top");
				getRootPane().setDefaultButton(okButton);
			}
		}
	}

}
