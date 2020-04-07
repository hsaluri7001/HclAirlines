package com.airlines.exception;


/**
 * @author saluri
 *
 */
public class FlightNotFound extends RuntimeException{
	
	public FlightNotFound(String message) {
		super(message);
	}

}
