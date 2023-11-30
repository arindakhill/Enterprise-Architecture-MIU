package customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	EmailSender emailSender;
	
	@Override
	public void addProduct(String description, Double price, String email) {
		
		Product product = new Product(description, price);
		productRepository.save(product);
		emailSender.sendEmail("Dear " + email,
				"we have a new product that may interest you with this description: " + description + 
				"  with final price of $" + price);

	}

}
