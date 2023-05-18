package com.bank.controller;

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

import com.bank.model.Transaction;
import com.bank.service.TransectionService;

import jakarta.validation.Valid;
@RestController
@RequestMapping("/users")
@CrossOrigin(value = "*")
public class TransectionController {
	@Autowired
	private TransectionService trser;
	@PostMapping("/Transsection")
	@ResponseStatus(code = HttpStatus.CREATED)
    public Transaction save(@Valid @RequestBody  Transaction transaction){
    	return trser.save(transaction);
    }
	@GetMapping("/Transsection/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public Transaction getById(@PathVariable  Integer id) {
		return trser.getById(id);
	}
	@PutMapping("/Transsection/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public Transaction update(@PathVariable  Integer id,@RequestBody  Transaction transaction) {
		return trser.update(id, transaction);
	}
	@DeleteMapping("/Transsection/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public Transaction deleteById(@PathVariable  Integer id) {
		return trser.deleteById(id);
	}

}
