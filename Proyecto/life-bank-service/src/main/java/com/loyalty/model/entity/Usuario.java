package com.loyalty.model.entity;

import java.util.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
	@Column(name="usr_id")	
	private int id;
	
	@Column(name="usr_username",unique=true)	
	@NotNull(message="The username must not be null.")
	@Size(max=20, message="The max length for username is 20.")
	private String username;
	
	@Column(name="usr_password")	
	@NotNull(message="The password must not be null.")
	private String password;
	
	@Column(name="usr_token")
	private String token;	
	
	@Column(name="usr_bloqueado")
	private boolean bloqueado;
	
	@Column(name="usr_intentos")
	private int intentos;
	
	@Column(name="usr_lastintento")	
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedDate;
	
	@OneToMany(mappedBy="usuario")
	private Set<Beneficiario> beneficiarios;
}
