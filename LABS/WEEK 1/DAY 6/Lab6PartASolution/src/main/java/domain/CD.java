package domain;

import jakarta.persistence.Entity;
import jakarta.persistence.NamedQuery;

@Entity
@NamedQuery(name="CD.findByArtitst",query="select c from CD c where c.artist = :artist")
//@NamedQuery(name="CD.findByArtitst",query="select c from CD c where c.artist = 'U2'")
public class CD extends Product{
	private String artist;

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	@Override
	public String toString() {
		return "CD{" +
				"name='" + name + '\'' +
				", description='" + description + '\'' +
				", price=" + price +
				"artist='" + artist + '\'' +
				'}';
	}
}
