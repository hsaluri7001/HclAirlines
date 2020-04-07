package com.airlines.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.airlines.entity.BookingRecord;

/**
 * @author saluri
 *
 */
@Repository
@Transactional
public class BookingRepo {
	
	@PersistenceContext
	private EntityManager em;
	
	
	public int create(BookingRecord record) {
		// TODO Auto-generated method stub
		em.persist(record);
		em.flush();
		return record.getId();
	}
	
	public BookingRecord getOne(int id) {
		return em.find(BookingRecord.class, id);
	}
	
	

}
