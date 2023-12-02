package partc.domain;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Flight {

	@Id
	private long flightNumber;
	@Column(name = "origin")
	private String from;
	@Column(name = "destination")
	private String to;
	private Date date;

	public Flight() {
	}

	public Flight(long flightNumber, String from, String to, Date date) {
		this.flightNumber = flightNumber;
		this.from = from;
		this.to = to;
		this.date = date;
	}

	public long getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(long flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Flight{" +
				"flightNumber=" + flightNumber +
				", from='" + from + '\'' +
				", to='" + to + '\'' +
				", date=" + date +
				'}';
	}
}
