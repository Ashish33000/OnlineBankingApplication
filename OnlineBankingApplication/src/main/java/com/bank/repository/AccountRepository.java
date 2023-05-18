package com.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.model.Account;

public interface AccountRepository extends JpaRepository<Account, Integer>  {

}
