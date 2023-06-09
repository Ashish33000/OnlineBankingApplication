package com.bank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.Exception.UserException;
import com.bank.model.Users;
import com.bank.repository.UserRepository;
@Service
public class UsersServiceImpl implements UsersService {
	@Autowired
	private UserRepository userRepo;

	@Override
	public Users registerUsers(Users users) {
		
		return userRepo.save(users);
	}

	@Override
	public Users getUsersDetailsByEmail(String email) throws UserException {
		// TODO Auto-generated method stub
		return userRepo.findByUserEmail(email).orElseThrow(()->new UserException("Users not found with this Email"+email));
	}

	@Override
	public List<Users> getAllUsersDetails() throws UserException {
		List<Users> list=userRepo.findAll();
		if(list.isEmpty())throw new UserException("No user found");
		return list;
	}

}
