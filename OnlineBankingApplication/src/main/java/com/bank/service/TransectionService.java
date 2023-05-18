package com.bank.service;

import com.bank.Exception.TransactionException;
import com.bank.model.Transaction;

public interface TransectionService {
	
    
	
	public Transaction save(Transaction transaction) throws TransactionException;
	
	public Transaction getById(Integer id)throws TransactionException;
	
	public Transaction update(Integer id,Transaction transaction)throws TransactionException;
	
	public Transaction deleteById(Integer id)throws TransactionException;

}
