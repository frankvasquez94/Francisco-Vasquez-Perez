package com.loyalty.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.loyalty.dto.login.LoginRequest;
import com.loyalty.dto.login.LoginResponse;
import com.loyalty.process.LoginService;

@PropertySource("classpath:configuration.properties")
@RequestMapping("${service.url}")
@RestController
public class LifeBankController {
	private Environment env;	
	private LoginService loginService;

	@Autowired
	public LifeBankController(Environment env,LoginService loginService) {		
		this.env = env;
		this.loginService = loginService;
	}
	

	@PostMapping("${service.url.endpoint.lifebank.login}")
	public LoginResponse getLogin(@Valid @RequestBody LoginRequest request){		
			return loginService.getLogin(request);
	}
	
	

}
