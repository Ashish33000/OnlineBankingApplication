package com.bank.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.Exception.TransactionException;
import com.bank.model.Transaction;
import com.bank.repository.TransictionRepository;

import jakarta.transaction.TransactionalException;
@Service
public class TransectionServiceImpl implements TransectionService {
	@Autowired
	private TransictionRepository transRepo;

	@Override
	public Transaction save(Transaction transaction) throws TransactionException {
		// TODO Auto-generated method stub
		return transRepo.save(transaction);
	}

	@Override
	public Transaction getById(Integer id) throws TransactionException {
		// TODO Auto-generated method stub
		return transRepo.findById(id).orElseThrow(()->new TransactionException("No Transection found "));
	}

	@Override
	public Transaction update(Integer id,Transaction transaction) throws TransactionException {
		Optional<Transaction> opt=transRepo.findById(id);
		if(opt.isEmpty()) {
			throw new TransactionException("No Transection found ");
		}else {
			Transaction t1=opt.get();
			t1.setTransactionDate(transaction.getTransactionDate());
			t1.setTransactionType(transaction.getTransactionType());
			t1.setAmount(transaction.getAmount());
			
			transRepo.save(t1);
			return t1;
		}
	
	}

	@Override
	public Transaction deleteById(Integer id) throws TransactionException {
		Optional<Transaction> opt=transRepo.findById(id);
		if(opt.isEmpty()) {
			throw new TransactionException("No Transection found ");
		}else {
			Transaction t1=opt.get();
			
			
			transRepo.delete(t1);
			return t1;
		}
	}

	



	

}
