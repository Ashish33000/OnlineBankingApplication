package com.bank.model;



import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
@Data
@Entity
public  class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;	
	@Email	
	@Column(unique =true )
	private String userEmail;
	@NotNull
	//@Pattern(regexp = "[0-9]", message = "password should be 8 digit")
	@JsonProperty(access = Access.WRITE_ONLY)
	private String userPassword;
	

	private String role;
	
	
	

}
