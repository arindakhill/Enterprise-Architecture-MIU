package domain;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jdk.jfr.DataAmount;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Entity
@Data
@Getter
@Setter
@DiscriminatorValue("Book")
public class Book extends Product {


    private String isbn;
    public Book(String name, String description, double price, String isbn){
        super(name, description, price);
        this.isbn = isbn;
    }
    public Book(){

    }
}
