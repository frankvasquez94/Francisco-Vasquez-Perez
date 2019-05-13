package com.loyalty.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loyalty.dto.afiliados.add.AgregarRequest;
import com.loyalty.dto.login.LoginRequest;
import com.loyalty.process.AgregarBeneficiarioService;
import com.loyalty.process.EliminarBeneficiarioService;
import com.loyalty.process.LoginService;

@PropertySource("classpath:configuration.properties")
@RequestMapping("${service.url}")
@RestController
public class BeneficiarioController {
	private Environment env;
	private AgregarBeneficiarioService agregarBeneficiarioService;	
	private EliminarBeneficiarioService eliminarBeneficiarioService;
	
	@Autowired
	public BeneficiarioController(Environment env,AgregarBeneficiarioService agregarBeneficiarioService,EliminarBeneficiarioService eliminarBeneficiarioService) {	
		this.agregarBeneficiarioService = agregarBeneficiarioService;
		this.eliminarBeneficiarioService = eliminarBeneficiarioService;
		this.env = env;		
	}	
	
	@PostMapping("${service.url.endpoint.lifebank.add.beneficiario}")
	public ResponseEntity<?> agregarBeneficiario(@Valid @RequestBody AgregarRequest request, @RequestHeader(value="authorization") String authorization){		
			return agregarBeneficiarioService.agregarBeneficiario(request);
	}
	
	@DeleteMapping("${service.url.endpoint.lifebank.delete.beneficiario}")
	public ResponseEntity<?> eliminarBeneficiario(@PathVariable Integer userId,@PathVariable Integer beneficiarioId, @RequestHeader(value="authorization") String authorization){		
			return eliminarBeneficiarioService.eliminarBeneficiario(userId, beneficiarioId);
	}
	
	

}
