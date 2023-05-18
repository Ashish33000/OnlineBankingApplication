package com.bank.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
@Data
@Entity
public class Transaction {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Integer id;
	 @Column(nullable = false)
	 private BigDecimal amount;    
	 @Column(nullable = false)
	 private String transactionType;    
	 @Column(nullable = false)
	 private LocalDateTime transactionDate;
	 @ManyToOne
	 @JoinColumn(nullable = false)
	 private Account account;  
   
    
   

}
