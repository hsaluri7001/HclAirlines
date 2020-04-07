package com.airlines.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author saluri
 *
 */
@Entity
@Table(name = "INVENTORY")
public class Inventory{

	@Id
	@SequenceGenerator(name = "INVENTORY_SEQ", sequenceName = "INVENTORY_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "INVENTORY_SEQ")
	private int id;
	@Column(name="FLIGHT_NUMBER")
	private String flightNumber;
	@Column(name="FLIGHT_DATE")
	private String flightDate;
	private int available;
	
	public Inventory() {
		
	}
	
	public Inventory(int id, String flightNumber, String flightDate, int available) {
		super();
		this.id = id;
		this.flightNumber = flightNumber;
		this.flightDate = flightDate;
		this.available = available;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getFlightDate() {
		return flightDate;
	}

	public void setFlightDate(String flightDate) {
		this.flightDate = flightDate;
	}

	public int getAvailable() {
		return available;
	}

	public void setAvailable(int available) {
		this.available = available;
	}

	public boolean isAvailable(int count) {

		return (available >= count);
	}
}
