package domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@NoArgsConstructor

public class Address {
@Id
@GeneratedValue
private Long id;
	private String street;

	private String city;

	private String zip;

	
	public Address(String street, String city, String zip) {
		super();
		this.street = street;
		this.city = city;
		this.zip = zip;
	}


}
