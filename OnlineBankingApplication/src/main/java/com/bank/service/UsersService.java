package com.bank.service;

import java.util.List;

import com.bank.Exception.UserException;
import com.bank.model.Users;

public interface UsersService {
	
	public Users registerUsers(Users users);
	public Users getUsersDetailsByEmail(String email) throws UserException;
	public List<Users> getAllUsersDetails()throws UserException;

}
