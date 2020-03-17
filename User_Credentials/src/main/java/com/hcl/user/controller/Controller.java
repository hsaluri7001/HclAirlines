package com.hcl.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.user.entity.Person;
import com.hcl.user.service.UserService;

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
