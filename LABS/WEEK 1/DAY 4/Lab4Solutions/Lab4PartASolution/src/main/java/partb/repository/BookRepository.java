package partb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import partb.domain.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}
