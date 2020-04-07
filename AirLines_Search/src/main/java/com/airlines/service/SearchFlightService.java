package com.airlines.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airlines.beans.SearchQuery;
import com.airlines.entity.Flight;
import com.airlines.entity.Inventory;
import com.airlines.exception.FlightNotFound;
import com.airlines.repository.FlightRepository;

/**
 * @author saluri
 *
 */
@Service
public class SearchFlightService {
	@Autowired
	private FlightRepository frepo;

	public List<Flight> searchFlights(SearchQuery search) {
	/*	System.out.println(search.getOrigin());
		System.out.println(search.getDestination());
		System.out.println(search.getFlightDate());*/
		List<Flight> flights = frepo.findByOriginAndDestinationAndFlightDate(search.getOrigin(),
				search.getDestination(), search.getFlightDate());
		return flights;
	}

	public void updateInventory(String flightNumber, String flightDate, int inventory) {
		Flight flight = frepo.findByFlightNumberAndFlightDate(flightNumber, flightDate);
		if (flight != null) {
			Inventory invent = flight.getInventory();
			invent.setCount(inventory);
			frepo.save(flight);
		} else {
			throw new FlightNotFound("Unable to fetch the flights ! please try after sometime....") ;
		}
	}

}
