package com.airlines.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airlines.entity.Flight;

/**
 * @author saluri
 *
 */
public interface FlightRepository extends JpaRepository<Flight,Integer>{

	List<Flight> findByOriginAndDestinationAndFlightDate(String origin,String destination, String flightDate);
	Flight findByFlightNumberAndFlightDate(String flightNumber,String flightDate);
}
