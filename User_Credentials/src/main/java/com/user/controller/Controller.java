package com.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.entity.Person;
import com.user.service.UserService;

/**
 * @author saluri
 *
 */
@RestController
@RequestMapping("/User")
public class Controller {
	
	@Autowired
	UserService userService;
	@PostMapping("/create")
	public int createUser(@RequestBody Person person) {
		return userService.createUser(person);
	}

}
