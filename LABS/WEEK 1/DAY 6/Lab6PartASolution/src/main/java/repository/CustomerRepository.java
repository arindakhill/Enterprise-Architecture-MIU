package repository;

import domain.Customer;
import domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findAllBy();
    List<Customer> findByCountry(String country);

    @Query("select c.firstname, c.lastname from Customer c where c.address.city ='Amsterdam' ")
    List<String> findCustomerLastAndFirstNamesByCityAmsterdam();
}
