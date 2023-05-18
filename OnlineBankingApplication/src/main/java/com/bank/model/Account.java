package com.bank.model;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
@Entity
@Data
public class Account {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer accId;   
	    private String accountNumber;    
	    private BigDecimal balance;
	    @Enumerated(EnumType.STRING)
	    private AccountType accountType;	    
	    @ManyToOne(cascade = CascadeType.ALL)	
	    @JsonIgnore
	    private Customer customer;
	    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "account")
	    @JsonIgnore
	    private List<Transaction> transactionList;
	   
	     

}
