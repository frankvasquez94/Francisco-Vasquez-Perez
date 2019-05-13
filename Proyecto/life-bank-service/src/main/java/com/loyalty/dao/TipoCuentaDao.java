package com.loyalty.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.loyalty.model.entity.TipoCuenta;

@Repository
public interface TipoCuentaDao extends CrudRepository<TipoCuenta, Integer>{

	@Query("Select tc from TipoCuenta tc where tc.nombre = :nombre")
	public TipoCuenta getPorNombre(@Param("nombre") String nombre);
}
