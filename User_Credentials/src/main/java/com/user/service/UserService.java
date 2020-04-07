package com.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.dao.UserDao;
import com.user.entity.Person;

/**
 * @author saluri
 *
 */
@Service
public class UserService {

	@Autowired
	UserDao userDao;
	
	public int createUser(Person person) {
		return userDao.createUser(person);
	}
}
