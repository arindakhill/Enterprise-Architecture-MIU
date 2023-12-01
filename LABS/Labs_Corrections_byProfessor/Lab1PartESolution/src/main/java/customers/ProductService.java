package customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {

	@Autowired
	IProductDAO productDAO;
	
	@Autowired
	IEmailSender emailSender;
	
	@Override
	public void addProduct(String description, Double price, String email) {
		
		Product product = new Product(description, price);
		productDAO.save(product);
		emailSender.sendEmail("Dear " + email,
				"we have a new product that may interest you with this description: " + description + 
				"  with final price of $" + price);

	}

}
