package com.loyalty.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="lb_users", schema="lifebank_products")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")	
	private int id;
	
	@Column(name="username",unique=true)	
	@NotNull(message="The username must not be null.")
	@Size(max=15, message="The max length for username is 20.")
	private String username;
	
	@Column(name="password")	
	@NotNull(message="The password must not be null.")
	private String password;
	
	@Column(name="token")
	private String token;	

}
