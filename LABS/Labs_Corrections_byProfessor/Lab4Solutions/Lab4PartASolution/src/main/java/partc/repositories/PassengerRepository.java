package partc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import partc.domain.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {
}
