package com.bank.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.model.Users;

public interface UserRepository extends JpaRepository<Users, Integer> {
	public Optional<Users> findByUserEmail(String email);

}
