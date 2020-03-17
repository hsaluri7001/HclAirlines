package com.hcl.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.user.dao.UserDao;
import com.hcl.user.entity.Person;

@Service
public class UserService {

	@Autowired
	UserDao userDao;
	
	public int createUser(Person person) {
		return userDao.createUser(person);
	}
}
