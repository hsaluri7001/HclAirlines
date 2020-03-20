package com.hcl.airlines.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.airlines.entity.BookingRecord;

/**
 * @author saluri
 *
 */
public interface BookingRepository extends JpaRepository<BookingRecord, Integer> {

}
