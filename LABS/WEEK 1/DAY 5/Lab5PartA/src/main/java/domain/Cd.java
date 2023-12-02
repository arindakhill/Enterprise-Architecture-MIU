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
@DiscriminatorValue("CD")
public class Cd extends Product{

    private String artist;
    public Cd(String name, String description, double price, String artist){
        super(name, description, price);
        this.artist = artist;
    }
    public Cd(){

    }

}
