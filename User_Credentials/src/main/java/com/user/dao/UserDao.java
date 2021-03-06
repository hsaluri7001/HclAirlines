package com.user.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.user.entity.Person;

/**
 * @author saluri
 *
 */
@Repository
@Transactional
public class UserDao {

	@PersistenceContext 
	private EntityManager em;
	
	public int createUser(Person person) {
		em.persist(person);
		em.flush();
		return person.getId();
	}
}
