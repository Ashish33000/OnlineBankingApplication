package com.bank.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.Exception.CustomerException;
import com.bank.model.Customer;
import com.bank.repository.CustomerRepository;
@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerRepository custRepo;

	@Override
	public Customer addCustomer(Customer customer) {
		
		// TODO Auto-generated method stub
		return custRepo.save(customer);
	}

	@Override
	public Customer getCustomerDetailsById(Integer id) throws CustomerException {
		// TODO Auto-generated method stub
		return custRepo.findById(id).orElseThrow(()->new CustomerException("No Customer found With This Id: "+id));
	}

	@Override
	public Customer updateCustomerDetailsById(Integer id, Customer customer) throws CustomerException {
		Optional<Customer> opt=custRepo.findById(id);
		if(opt.isEmpty()) {
			throw new CustomerException("No Customer found With This Id: "+id);
		}else {
			Customer c1=opt.get();
			c1.setName(customer.getName());
			c1.setAddress(customer.getAddress());
			c1.setDate_of_birth(customer.getDate_of_birth());
			c1.setCity(customer.getCity());
			custRepo.save(c1);
			return c1;
		}
		
	}

	@Override
	public Customer deleteCustomer(Integer id) throws CustomerException {
		Optional<Customer> opt=custRepo.findById(id);
		if(opt.isEmpty()) {
			throw new CustomerException("No Customer found With This Id: "+id);
		}else {
			Customer c1=opt.get();
			
			custRepo.delete(c1);
			return c1;
		}
	}

	@Override
	public List<Customer> gellAllCustomerDetails() throws CustomerException {
		List<Customer> list=custRepo.findAll();
		if(list.isEmpty())throw new CustomerException("No Customer found: ");
		return list;
	}

}
