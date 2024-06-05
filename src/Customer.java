/**
 * The Customer class represents a customer with detailed information including
 * ID, name, address, and contact information.
 * 
 * @author Samson James Ordonez
 * @version 1.0
 */

public class Customer {
	private int id;
	private String firstName;
	private String lastName;
	private String street;
	private String city;
	private String postalCode;
	private String phone;
	private String email;

	public Customer() {
		super();
	}

	/**
	 * Constructs a new Customer with the specified details.
	 *
	 * @param id         the unique identifier for the customer
	 * @param firstName  the first name of the customer
	 * @param lastName   the last name of the customer
	 * @param street     the street address of the customer
	 * @param city       the city of the customer
	 * @param postalCode the postal code of the customer's address
	 * @param phone      the phone number of the customer
	 * @param email      the email address of the customer
	 */
	public Customer(final int id, final String firstName, final String lastName, final String street, final String city,
			final String postalCode, final String phone, final String email) {
		validateInt(id);
		validateString(firstName);
		validateString(lastName);
		validateString(street);
		validateString(city);
		validateString(postalCode);
		validateString(phone);
		validateString(email);
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.street = street;
		this.city = city;
		this.postalCode = postalCode;
		this.phone = phone;
		this.email = email;
	}

	/**
	 * Validates any generic String.
	 * 
	 * @param value The String value.
	 */
	protected final void validateString(final String value) {
		if (value == null || value.isEmpty()) {
			throw new IllegalArgumentException("Invalid String: " + value);
		}
	}

	/**
	 * Validates any generic integer.
	 * 
	 * @param value The integer value.
	 */
	protected final void validateInt(final int value) {
		if (value < 0) {
			throw new IllegalArgumentException("Invalid String: " + value);
		}
	}

	/**
	 * Returns the unique identifier of the customer.
	 * 
	 * @return the customer ID
	 */
	public int getId() {
		return id;
	}

	/**
	 * Returns the first name of the customer.
	 *
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Returns the last name of the customer.
	 * 
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Returns the street address of the customer.
	 * 
	 * @return the street address
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * Returns the city of the customer.
	 * 
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Returns the postal code of the customer's address.
	 * 
	 * @return the postal code
	 */
	public String getPostalCode() {
		return postalCode;
	}

	/**
	 * Returns the phone number of the customer.
	 * 
	 * @return the phone number
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * Returns the email address of the customer.
	 * 
	 * @return the email address
	 */
	public String getEmail() {
		return email;
	}
}
