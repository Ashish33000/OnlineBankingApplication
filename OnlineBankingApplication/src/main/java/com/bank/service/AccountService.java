package com.bank.service;

import java.util.List;

import com.bank.Exception.AccountException;
import com.bank.model.Account;

public interface AccountService {
	
    public Account  addAccount(Account account);
    public Account getAccountDetailsById(Integer id)throws AccountException;
    public Account updateAccountDetailsById(Integer id,Account account)throws AccountException;
    public Account deleteAccount(Integer id)throws AccountException;
    public List<Account> gellAllAcoountDetails()throws AccountException;
	
	
	

}
