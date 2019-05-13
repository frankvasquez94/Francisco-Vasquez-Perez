package com.loyalty.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.loyalty.model.entity.Beneficiario;

@Repository
public interface BeneficiarioDao extends CrudRepository<Beneficiario, Integer>{
	
	@Query("Select b from Beneficiario b inner join fetch b.usuario u where b.numeroCuenta = :numeroCuenta and u.id = :idUsuario")
	public Beneficiario getPorUsuario(@Param("numeroCuenta") String numeroCuenta,@Param("idUsuario") Integer idUsuario);
}
