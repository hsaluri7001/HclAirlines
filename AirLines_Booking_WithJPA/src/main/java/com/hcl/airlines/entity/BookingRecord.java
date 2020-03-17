package com.hcl.airlines.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "BOOKING_RECORD")
public class BookingRecord {

		@Id
		@SequenceGenerator(name = "BOOKING_SEQ", sequenceName = "BOOKING_SEQ", allocationSize = 1)
		@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BOOKING_SEQ")
		private int id;
		@Column(name="BOOKING_DATE")
		private Date bookingDate;
		@Column(name="ORIGIN")
		private String origin;
		@Column(name="DESTINATION")
		private String destination;
		@Column(name = "PRICE")
		private String fare;
		@Column(name="FLIGHT_DATE")
		private String flightDate;
		@Column(name="FLIGHT_NUMBER")
		private String flightNumber;
		private String status;
		@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "bookingRecord")
		private Set<Passenger> passengers;
		public BookingRecord() {	
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public Date getBookingDate() {
			return bookingDate;
		}

		public void setBookingDate(Date bookingDate) {
			this.bookingDate = bookingDate;
		}

		public String getOrigin() {
			return origin;
		}

		public void setOrigin(String origin) {
			this.origin = origin;
		}

		public String getDestination() {
			return destination;
		}

		public void setDestination(String destination) {
			this.destination = destination;
		}

		public String getFare() {
			return fare;
		}

		public void setFare(String fare) {
			this.fare = fare;
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

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public Set<Passenger> getPassengers() {
			return passengers;
		}

		public void setPassengers(Set<Passenger> passengers) {
			this.passengers = passengers;
		}
}
