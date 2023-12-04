package repository;

import domain.CD;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CDRepository extends JpaRepository<CD,Long> {
    List<CD> findCDByArtistAndPriceLessThan(String artist, double price);
    List<CD> findByArtitst(@Param("artist")String art);
   List<CD> findByArtitst();

    @Query("select c from CD c where c.artist = :artist and c.price > :amount")
    List<CD> findByArtitstAndPriceGreaterThan(@Param("artist") String artist, @Param("amount") double amount);


    @Query(value = "SELECT * FROM CD INNER JOIN Product ON CD.id = Product.id WHERE artist = 'U2'", nativeQuery = true)
    List<CD> findByArtistU2();


}
