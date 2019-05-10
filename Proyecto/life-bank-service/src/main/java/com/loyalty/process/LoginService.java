package com.loyalty.process;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.loyalty.dao.UserDao;
import com.loyalty.dto.login.LoginRequest;
import com.loyalty.dto.login.LoginResponse;
import com.loyalty.model.entity.Usuario;

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
	
	public LoginResponse getLogin(LoginRequest request){
		LoginResponse loginResponse = new LoginResponse();
		Usuario usuario = userDao.getUsuario(request.getUsername(), request.getPassword());
		if(usuario != null) {
			String token = "kjkjjkbvdjbcjhbcjhvjcvxvjh";
			loginResponse.setTkn(token);
		}
		return loginResponse;
	}


}
