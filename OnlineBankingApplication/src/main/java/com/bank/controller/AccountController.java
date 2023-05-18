package com.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bank.model.Account;
import com.bank.service.AccountService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
@CrossOrigin(value = "*")
public class AccountController {
	@Autowired
	private AccountService accser;
	@PostMapping("/account")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Account  addAccountHandler(@Valid   @RequestBody  Account account) {
		return accser.addAccount(account);
	}
	@GetMapping("/account/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	  public Account getAccountDetailsByIdHandler(@PathVariable Integer id) {
		  return accser.getAccountDetailsById(id) ;
	  }
	@DeleteMapping("/account/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	  public Account deleteAccountDetailsByIdHandler(@PathVariable Integer id) {
		  return accser.deleteAccount(id);
	  }
	@GetMapping("/accounts")
	@ResponseStatus(code = HttpStatus.OK)
	public List<Account> gellAllAcoountDetails(){
		return accser.gellAllAcoountDetails();
	}
	@PutMapping("/account/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public Account updateAccountDetailsById(@PathVariable  Integer id,@RequestBody  Account account) {
		return accser.updateAccountDetailsById(id, account);
	}
	
	

}
