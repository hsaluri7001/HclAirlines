package com.hcl.airlines.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "FARE")
public class Fare {
	
	@Id
	@SequenceGenerator(name = "FARE_ID_SEQ", sequenceName = "FARE_SEQ",allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FARE_ID_SEQ")
	@Column(name = "FARE_ID")
	private int fareId;
	
	

	@Column(name = "CURRENCY")
	private String currency;
	
	@Column(name = "PRICE")
	private String fare;

	public int getFareId() {
		return fareId;
	}

	public void setFareId(int fareId) {
		this.fareId = fareId;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getFare() {
		return fare;
	}

	public void setFare(String fare) {
		this.fare = fare;
	}

	@Override
	public String toString() {
		return "Fare [fareId=" + fareId + ", currency=" + currency + ", fare=" + fare + "]";
	}

}
