package customers;

import org.springframework.context.ApplicationContext;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

	public static void main(String[] args) {
		ApplicationContext context = new
				AnnotationConfigApplicationContext(AppConfig.class);

		/*ApplicationContext context = new ClassPathXmlApplicationContext(
				"springconfig.xml");*/

		CustomerServiceImpl customerService = context.getBean("customerService",
				CustomerServiceImpl.class);

		customerService.addCustomer("Frank Brown", "fbrown@acme.com",
				"mainstreet 5", "Chicago", "60613");

	}
}

