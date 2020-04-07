package com.airlines.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airlines.entity.BookingRecord;

/**
 * @author saluri
 *
 */
public interface BookingRepository  extends JpaRepository<BookingRecord,Integer>{

}
