package repository;

import domain.Book;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BookRepository extends JpaRepository<Book, Long> {
    @Modifying
    @Transactional
    @Query("delete Book s  where s.publicationYear < ?1")
     void removeBookByPublicationYearBefore(int publicationYear);



    @Modifying
    @Transactional
    @Query("update Book s set s.locationCode = CONCAT('BB', s.locationCode)")
    void setLocationCode();

}
