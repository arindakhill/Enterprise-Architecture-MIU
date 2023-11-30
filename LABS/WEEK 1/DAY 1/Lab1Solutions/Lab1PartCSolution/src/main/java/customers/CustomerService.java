package customers;

public interface CustomerService {

	void addCustomer(String name, String email, String street,String city, String zip);

	void setCustomerRepository(CustomerRepository customerDAO);

	void setEmailSender(EmailSender emailSender);

}
