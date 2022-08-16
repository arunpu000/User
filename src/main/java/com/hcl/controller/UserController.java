package com.hcl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.entity.User;
import com.hcl.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/user")
	public List<User> getAllUser(){
		return this.userService.getAllUser();
		
	}
	
	@GetMapping("/user/{userId}")
	public List<User> getUserById(@PathVariable String userId){
		return this.userService.getUser(Long.parseLong(userId));
		
	}
	
	@PostMapping("/addUser")
	public User addUser(@RequestBody User user){
		return this.userService.addUser(user);
		
	}

	@PutMapping("/updateUser")
	public User updateUser(@RequestBody User user){
		return this.userService.updateUser(user);
	}
	
	@DeleteMapping("/user/{userId}")
	 public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String userId){
		 
	   try{
		 this.userService.deleteUser(Long.parseLong((userId)));
		 return new ResponseEntity<>(HttpStatus.OK);
	 }
	   catch(Exception e){
	   return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	 }
}
