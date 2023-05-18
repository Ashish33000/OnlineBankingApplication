package com.bank.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.Exception.AccountException;
import com.bank.model.Account;
import com.bank.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	private AccountRepository accountRepo;

	@Override
	public Account addAccount(Account account) {
		// TODO Auto-generated method stub
		return accountRepo.save(account);
	}

	@Override
	public Account getAccountDetailsById(Integer id) throws AccountException {
		// TODO Auto-generated method stub
		return accountRepo.findById(id).orElseThrow(()->new AccountException("No Account is Associated with this id: "+id));
	}

	@Override
	public Account updateAccountDetailsById(Integer id, Account account) throws AccountException {
		Optional<Account> opt=accountRepo.findById(id);
		if(opt.isEmpty()) {
			throw new AccountException("No Account is Associated with this id: "+id);
		}else {
			Account acc1=opt.get();			
			acc1.setAccountType(account.getAccountType());
			accountRepo.save(acc1);
			return acc1;
		}
		
	}

	@Override
	public Account deleteAccount(Integer id) throws AccountException {
		Optional<Account> opt=accountRepo.findById(id);
		if(opt.isEmpty()) {
			throw new AccountException("No Account is Associated with this id: "+id);
		}else {
			Account acc1=opt.get();			
			
			accountRepo.delete(acc1);
			return acc1;
		}
	}

	@Override
	public List<Account> gellAllAcoountDetails() throws AccountException {
		List<Account> list=accountRepo.findAll();
		if(list.isEmpty())throw new AccountException("No Account is Available: ");
		return list;
	}

}
