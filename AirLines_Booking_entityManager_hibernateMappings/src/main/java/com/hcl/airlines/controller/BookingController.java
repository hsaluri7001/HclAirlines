package com.hcl.airlines.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.airlines.entity.BookingRecord;
import com.hcl.airlines.service.BookingService;

/**
 * @author saluri
 *
 */
@RestController
@RequestMapping("/booking")
public class BookingController {

	@Autowired
	BookingService bookingService;
	
	@GetMapping("/get/{id}")
	public BookingRecord getBookingRecord(@PathVariable int id) {
		System.out.println(id);
		return bookingService.getBookingRecord(id);
	}

	@RequestMapping(value="/create", method=RequestMethod.POST)
	public long book(@RequestBody BookingRecord record) {
		return bookingService.book(record);
	}
}
