package com.bank.service;

import java.util.List;

import com.bank.Exception.CustomerException;
import com.bank.model.Account;
import com.bank.model.Customer;

public interface CustomerService {
	public Customer  addCustomer(Customer customer);
    public Customer getCustomerDetailsById(Integer id)throws CustomerException;
    public Customer updateCustomerDetailsById(Integer id,Customer customer)throws CustomerException;
    public Customer deleteCustomer(Integer id)throws CustomerException;
    public List<Customer> gellAllCustomerDetails()throws CustomerException;

}
