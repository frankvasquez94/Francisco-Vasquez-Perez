package com.loyalty.process;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.loyalty.dao.UserDao;
import com.loyalty.dto.login.LoginRequest;
import com.loyalty.dto.login.LoginResponse;
import com.loyalty.model.entity.Usuario;
import com.loyalty.utility.IntervaloMinuto;

@Service
public class LoginService {
	private UserDao userDao;
	private Logger log;
	private Environment env;
	@Autowired
	public LoginService(UserDao userDao,Environment env) {
		this.userDao = userDao;
		this.env = env;
		this.log = LoggerFactory.getLogger(getClass());
	}

	public ResponseEntity<?> getLogin(LoginRequest request){
		LoginResponse loginResponse = new LoginResponse();
		
		
		Usuario usuario = userDao.getUsuario(request.getUsername(), request.getPassword());
		if(usuario != null) {
			String token = "kjkjjkbvdjbcjhbcjhvjcvxvjh";
			loginResponse.setTkn(token);
			return new ResponseEntity<>(loginResponse,HttpStatus.OK);
		}
		
		
		
		usuario = userDao.getUsuarioPorUsername(request.getUsername());	
		
		
		if(usuario != null) {
			//Se verfica si el usuario esta bloqueado
			if(usuario.isBloqueado()) {
				return new ResponseEntity<>(loginResponse,HttpStatus.BAD_REQUEST);
			}
			
			//Bloque el usuario despues de 5 intentos en 5 en minutos. 
		
			if(IntervaloMinuto.getMinutosDiferencia(usuario.getModifiedDate(), 5) > 5) {
				usuario.setModifiedDate(new Date());
				usuario.setIntentos(0);
			}
			
			usuario.setIntentos(usuario.getIntentos() + 1);
			if(usuario.getIntentos() == 5) {
				usuario.setBloqueado(true);
				return new ResponseEntity<>(loginResponse,HttpStatus.BAD_REQUEST);
			}
			
			userDao.save(usuario);
			return new ResponseEntity<>(loginResponse,HttpStatus.UNAUTHORIZED);
		}else {
			//No encontro el usuario
			return new ResponseEntity<>(loginResponse,HttpStatus.UNAUTHORIZED);
		}
	}


}
