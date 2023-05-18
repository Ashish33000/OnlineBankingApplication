package com.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bank.model.Users;
import com.bank.service.UsersService;

@RestController
public class UserController {
	@Autowired
	private UsersService userSer;
	@Autowired
	private PasswordEncoder ps;
	
	
	@PostMapping("/users")
	@ResponseStatus(code=HttpStatus.CREATED)
	public Users saveUserHandler(@RequestBody Users users) {
		users.setRole("ROLE_"+users.getRole().toUpperCase());
		users.setUserPassword(ps.encode(users.getUserPassword()));
		return userSer.registerUsers(users);
	}
	@GetMapping("/users/{email}")
	@ResponseStatus(code=HttpStatus.OK)
	public Users getCustomerByEmail(@PathVariable String email) {
		return userSer.getUsersDetailsByEmail(email);
	}
	@GetMapping("/users")
	@ResponseStatus(code=HttpStatus.OK)
	public List<Users> getAllUsersHandler(){
		return userSer.getAllUsersDetails();
	}
	
	

}
