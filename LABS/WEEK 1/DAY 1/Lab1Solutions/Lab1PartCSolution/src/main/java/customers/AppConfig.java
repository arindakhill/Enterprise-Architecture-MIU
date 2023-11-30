package customers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

	@Bean
	public LoggerImpl logger() {
		return new LoggerImpl();
	}
	
	@Bean
	public CustomerRepository customerRepository() {
		CustomerRepository customerRepository = new CustomerRepositoryImpl();
		customerRepository.setLogger(logger());
		return customerRepository;
	}
	
	@Bean
	public CustomerService customerService() {
		CustomerService customerService = new CustomerServiceImpl();
		customerService.setCustomerRepository(customerRepository());
		customerService.setEmailSender(emailSender());
		return customerService;
	}
	
	@Bean
	public EmailSender emailSender() {
		EmailSender emailSender = new EmailSenderImpl();
		emailSender.setLogger(logger());
		return emailSender;
	}

}
