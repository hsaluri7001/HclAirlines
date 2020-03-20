package com.hcl.airlines.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author saluri
 *
 */
@Entity
@Table
public class Flight {
	
	@Id
	@Column(name = "ID")
	@SequenceGenerator(name = "FLIGHT_SEQ_GENERATOR", sequenceName = "FLIGHT_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FLIGHT_SEQ_GENERATOR")
	private int id;

	@Column(name = "DESTINATION")
	private String destination;

	@Column(name = "FLIGHT_DATE")
	private String flightDate;

	@Column(name = "FLIGHT_NUMBER")
	private String flightNumber;

	@Column(name = "ORIGIN")
	private String origin;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "FARE_ID")
	private Fare fares;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "INV_ID")
	private Inventory inventory;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getFlightDate() {
		return flightDate;
	}

	public void setFlightDate(String flightDate) {
		this.flightDate = flightDate;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public Fare getFares() {
		return fares;
	}

	public void setFares(Fare fares) {
		this.fares = fares;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	@Override
	public String toString() {
		return "Flight [id=" + id + ", destination=" + destination + ", flightDate=" + flightDate + ", flightNumber="
				+ flightNumber + ", origin=" + origin + ", fares=" + fares + ", inventory=" + inventory + "]";
	}


}
