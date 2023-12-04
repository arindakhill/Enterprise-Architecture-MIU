package repository;

import domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long> {
    @Query(value="SELECT * FROM Address WHERE city = 'Amsterdam'", nativeQuery = true)
    List<Address> findAllInAmsterdam();
}
