package com.loyalty.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.loyalty.model.entity.Usuario;

@Repository
public interface UserDao extends CrudRepository<Usuario, Integer>{

	@Query("Select u from Usuario u where u.username = :username and u.password = :password and u.bloqueado = false")
	public Usuario getUsuario(@Param("username") String username, @Param("password") String password);
	
	@Query("Select u from Usuario u where u.username = :username")
	public Usuario getUsuarioPorUsername(@Param("username") String username);
}
