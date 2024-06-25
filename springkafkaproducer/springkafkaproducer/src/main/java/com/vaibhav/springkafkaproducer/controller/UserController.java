package com.vaibhav.springkafkaproducer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vaibhav.springkafkaproducer.bean.User;
import com.vaibhav.springkafkaproducer.repo.UserCRUD;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserCRUD userCRUD;
	
	
	@GetMapping("/all")
	public List<User> getUsers(){
		List<User> users=(List<User>) userCRUD.findAll();
		return users;
	}
	
	
	@PostMapping("/create")
	public User createUser(@RequestBody User user) {
		user=userCRUD.save(user);
		return user;
	}

}
