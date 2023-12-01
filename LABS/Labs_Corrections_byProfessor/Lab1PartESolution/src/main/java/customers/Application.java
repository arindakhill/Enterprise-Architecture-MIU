package customers;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(
				AppConfig.class);
		ICustomerService customerService = context.getBean("customerService",
				ICustomerService.class);

		customerService.addCustomer("Frank Brown", "fbrown@acme.com",
				"mainstreet 5", "Chicago", "60613");
		
		System.out.println("\n" + "\n");
		
		IProductService productService = context.getBean("productService", IProductService.class);
		
		productService.addProduct("Laptop Dell XPS 15\"", 1250.00, "johndoe@gmail.com");
		
	}
}

