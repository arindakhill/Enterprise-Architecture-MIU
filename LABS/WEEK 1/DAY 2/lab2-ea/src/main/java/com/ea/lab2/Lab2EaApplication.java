package com.ea.lab2;

import com.ea.lab2.customers.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class Lab2EaApplication implements CommandLineRunner {
	@Autowired
	CustomerService customerService;

	public static void main(String[] args) {
		SpringApplication.run(Lab2EaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		customerService.addCustomer("Frank Brown", "fbrown@acme.com",
				"mainstreet 5", "Chicago", "60613");
	}
}
