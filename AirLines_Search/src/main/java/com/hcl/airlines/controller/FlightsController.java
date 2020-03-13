package com.hcl.airlines.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.airlines.beans.SearchQuery;
import com.hcl.airlines.entity.Flight;
import com.hcl.airlines.service.SearchFlightService;

@RestController
@RequestMapping("/search")
public class FlightsController {

	@Autowired
	SearchFlightService searchComponent;
	
	
	@PostMapping("/get")
	public List<Flight> searchFlight(@RequestBody SearchQuery query){
		return searchComponent.searchFlights(query);
	}
	
}
