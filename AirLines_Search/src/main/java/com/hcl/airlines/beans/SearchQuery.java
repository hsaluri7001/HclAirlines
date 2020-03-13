package com.hcl.airlines.beans;

public class SearchQuery {

	private String origin;
	private String destination;
	private String flightDate;

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

	public String getFlightDate() {
		return flightDate;
	}

	public void setFlightDate(String flightDate) {
		this.flightDate = flightDate;
	}

	@Override
	public String toString() {
		return "SearchQuery [origin=" + origin + ", destination=" + destination + ", flightDate=" + flightDate + "]";
	}

}
