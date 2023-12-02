package domain;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
		name="product_name",
		discriminatorType=DiscriminatorType.STRING
)
public class Product {

	@Id
	@GeneratedValue
	private long id;
    private String name;
    private String description;
    private double price;
    
    public Product(){}

    public Product(String name, String description, double price){
    	this.name=name;
    	this.description=description;
    	this.price=price;
    }

	public void setDescription(String description) {
		this.description = description;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
