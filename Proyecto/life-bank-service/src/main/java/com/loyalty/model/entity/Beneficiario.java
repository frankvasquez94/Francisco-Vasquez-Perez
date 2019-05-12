package com.loyalty.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="beneficiarios", schema="lifebank_products")
public class Beneficiario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="bnf_id")	
	private int id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="bnf_id_user")
	private Usuario usuario;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="bnf_id_tipo_cuenta")
	private TipoCuenta tipoCuenta;
	
	@Column(name="bnf_num_cuenta")	
	@NotNull(message="The numero cuenta must not be null.")
	@Size(max=20, message="The max length for numero cuenta is 20.")
	private String numeroCuenta;
	
	@Column(name="bnf_nombre")	
	@NotNull(message="The numero cuenta must not be null.")
	@Size(max=80, message="The max length for nombre cuenta is 80.")
	private String nombre;
	
	@Column(name="bnf_correo")	
	@NotNull(message="The numero cuenta must not be null.")
	@Size(max=50, message="The max length for nombre cuenta is 50.")
	private String correo;
	
}
