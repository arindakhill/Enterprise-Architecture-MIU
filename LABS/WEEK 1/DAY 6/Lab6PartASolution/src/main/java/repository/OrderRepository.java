package repository;

import domain.Customer;
import domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Customer> findAllBy();

    @Query("select o.ordernr from Order o where o.status='closed'")
    List<String> findOrdernrByStatusClosed ();
    @Query("select o.ordernr from Order o where o.customer.address.city= :name")
    List<String> findOrdernrByCity (@Param("name") String name);

}
