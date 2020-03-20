package com.hcl.airlines.service;

import java.util.Date;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.hcl.airlines.beans.BookingStatus;
import com.hcl.airlines.entity.BookingRecord;
import com.hcl.airlines.entity.Inventory;
import com.hcl.airlines.entity.Passenger;
import com.hcl.airlines.exception.BookingException;
import com.hcl.airlines.repository.BookingRepo;
import com.hcl.airlines.repository.InventoryRepository;

/**
 * @author saluri
 *
 */
@Service
public class BookingService {

	@Autowired
	BookingRepo bookingRepository;
	
	@Autowired
	InventoryRepository inventoryRepository;

	public BookingRecord getBookingRecord(int bookingId) {
		// TODO Auto-generated method stub
		return bookingRepository.getOne(
				bookingId);
	}
	
	public Long book(BookingRecord record) {
		
		Inventory inventory = inventoryRepository.findByFlightNumberAndFlightDate(record.getFlightNumber(),
				record.getFlightDate());
		if (!inventory.isAvailable(record.getPassengers().size())) {
			throw new BookingException("No more seats avaialble");
		}
		System.out.println("successfully checked inventory" + inventory);
		System.out.println("calling inventory to update inventory");
		// update inventory

		inventory.setAvailable(inventory.getAvailable() - record.getPassengers().size());
		inventoryRepository.saveAndFlush(inventory);
		System.out.println("sucessfully updated inventory");
		// save booking
		record.setStatus(BookingStatus.BOOKING_CONFIRMED);
		Set<Passenger> passengers = record.getPassengers();
		passengers.forEach(passenger -> passenger.setBookingRecord(record));
		record.setBookingDate(new Date());
		long id = bookingRepository.create(record);
		System.out.println("Successfully saved booking");
		return id;
	
	}
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		// Do any additional configuration here
		return builder.build();
	}
}
