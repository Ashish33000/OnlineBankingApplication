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

import com.bank.model.Customer;
import com.bank.service.CustomerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
@CrossOrigin(value = "*")
public class CustomerController {
	@Autowired
	private CustomerService custSer;
	@PostMapping("/customer")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Customer  addCustomerHandler(@Valid @RequestBody  Customer customer) {
		return custSer.addCustomer(customer);
	}
	
	@GetMapping("/customer/{id}")
	@ResponseStatus(code = HttpStatus.OK)
    public Customer getCustomerDetailsByIdHandler(@PathVariable Integer id) {
    	return custSer.getCustomerDetailsById(id);
    }
	@PutMapping("/customer/{id}")
	@ResponseStatus(code = HttpStatus.OK)
    public Customer updateCustomerDetailsByIdHandler(@PathVariable Integer id,@RequestBody Customer customer) {
    	return custSer.updateCustomerDetailsById(id, customer);
    }
    @DeleteMapping("/customer/{id}")
	@ResponseStatus(code = HttpStatus.OK)
    public Customer deleteCustomerHandler(@PathVariable Integer id) {
    	return custSer.deleteCustomer(id);
    }
    @GetMapping("/customers")
	@ResponseStatus(code = HttpStatus.OK)
    public List<Customer> gellAllCustomerDetailsHandler(){
    	return custSer.gellAllCustomerDetails();
    }

}
