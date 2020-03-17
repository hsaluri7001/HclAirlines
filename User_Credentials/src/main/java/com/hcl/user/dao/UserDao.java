package com.hcl.user.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.hcl.user.entity.Person;

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
