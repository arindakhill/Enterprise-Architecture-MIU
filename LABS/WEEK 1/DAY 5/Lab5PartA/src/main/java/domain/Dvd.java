package domain;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
@DiscriminatorValue("DVD")

public class Dvd extends Product{
    private String genre;
    public Dvd(String name, String description, double price, String genre){
        super(name, description, price);
        this.genre = genre;
    }
    public Dvd(){

    }
}
