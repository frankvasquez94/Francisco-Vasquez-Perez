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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="tipo_cuenta", schema="lifebank_products")
public class TipoCuenta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="tcn_id")	
	private int id;
	
	@Column(name="tcn_nombre",unique=true)	
	@NotNull(message="The nombre must not be null.")
	@Size(max=50, message="The max length for nombre is 50.")
	private String nombre;
	
	@OneToMany(mappedBy="tipoCuenta")
	private Set<Beneficiario> beneficiarios;

}
