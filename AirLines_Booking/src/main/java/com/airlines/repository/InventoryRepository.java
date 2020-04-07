package com.airlines.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airlines.entity.Inventory;

/**
 * @author saluri
 *
 */
public interface InventoryRepository extends JpaRepository<Inventory, Integer> {
	public Inventory findByFlightNumberAndFlightDate(String flightNumber, String flightDate);

}
