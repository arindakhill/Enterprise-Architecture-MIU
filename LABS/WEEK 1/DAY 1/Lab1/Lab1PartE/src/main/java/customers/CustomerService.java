package customers;

import org.springframework.stereotype.Component;

public interface CustomerService {

	void addCustomer(String name, String email, String street,String city, String zip);

}
