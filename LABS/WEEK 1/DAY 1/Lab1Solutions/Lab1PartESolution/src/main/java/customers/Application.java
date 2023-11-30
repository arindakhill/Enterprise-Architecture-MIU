package customers;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(
				AppConfig.class);

		CustomerService customerService = context.getBean("customerServiceImpl",
				CustomerService.class);

		customerService.addCustomer("Frank Brown", "fbrown@acme.com",
				"mainstreet 5", "Chicago", "60613");
		
		System.out.println("\n" + "\n");
		
		ProductService productService = context.getBean("productServiceImpl", ProductService.class);
		
		productService.addProduct("Laptop Dell XPS 15\"", 1250.00, "johndoe@gmail.com");
		
	}
}

