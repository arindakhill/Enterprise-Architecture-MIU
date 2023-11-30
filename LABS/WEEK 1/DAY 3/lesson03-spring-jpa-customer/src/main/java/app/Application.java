package app;

import domain.Book;
import domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import repository.BookRepository;
import repository.CustomerRepository;

import java.sql.SQLOutput;
import java.util.Optional;

@SpringBootApplication
@EnableJpaRepositories("repository")
@EntityScan("domain") 
public class Application implements CommandLineRunner{


	@Autowired
	BookRepository bookRepository;
	
	@Autowired
	CustomerRepository customerRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		customerRepository.save(new Customer("Jack", "Bauer", "jack@acme.com"));
		customerRepository.save(new Customer("Chloe", "O'Brian", "chloe@acme.com"));
		customerRepository.save(new Customer("Kim", "Bauer", "kim@acme.com"));
		customerRepository.save(new Customer("David", "Palmer", "dpalmer@gmail.com"));
		customerRepository.save(new Customer("Michelle", "Dessler", "mich@hotmail.com"));


		// fetch all customers
		System.out.println("Customers found with findAll():");
		System.out.println("-------------------------------");
		for (Customer customer : customerRepository.findAll()) {
			System.out.println(customer);
		}
		System.out.println();

		// fetch an individual customer by ID
		Optional<Customer> custOpt = customerRepository.findById(1L);
		Customer customer = custOpt.get();
		System.out.println("Customer found with findOne(1L):");
		System.out.println("--------------------------------");
		System.out.println(customer);
		System.out.println();


		bookRepository.save(new Book("Street Lawyer","1243254","John Grisham",1244));
		bookRepository.save(new Book("harry Porter","354356","Some babe",1000));
		bookRepository.save(new Book("Tom Sawyer","578798","Charles Dickens",5000));

//fetch all books and show them on console
		System.out.println("Books retrieved with findAll:");
		System.out.println("--------------------------------");
		bookRepository.findAll().forEach(System.out::println);
//		for (Book book : bookRepository.findAll()){
//			System.out.println(book);
//		}

		System.out.println("****************************************************");
		System.out.println("Updating book 2 price.....");
		Book book1 = bookRepository.findById(2).get();
		book1.setPrice(20000);
		bookRepository.save(book1);


		System.out.println("*****************************************************");
		System.out.println("Deleting the first book");
		bookRepository.deleteById(1);


		System.out.println("*****************************************************");
		System.out.println("Retrieving all books again");
		bookRepository.findAll().forEach(b->System.out.println(b));






	}

}
