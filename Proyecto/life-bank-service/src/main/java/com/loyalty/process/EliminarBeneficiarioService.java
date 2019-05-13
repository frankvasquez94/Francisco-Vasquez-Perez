package com.loyalty.process;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.loyalty.dao.BeneficiarioDao;
import com.loyalty.dao.TipoCuentaDao;
import com.loyalty.dao.UserDao;
import com.loyalty.model.entity.Beneficiario;

@Service
public class EliminarBeneficiarioService {
	private BeneficiarioDao beneficiarioDao;	
	private UserDao usuarioDao;
	private Logger log;
	private Environment env;	
	
	@Autowired
	public EliminarBeneficiarioService(BeneficiarioDao beneficiarioDao,UserDao usuarioDao,Environment env) {
		this.beneficiarioDao = beneficiarioDao;		
		this.usuarioDao = usuarioDao;
		this.env = env;
		this.log = LoggerFactory.getLogger(getClass());
	}
	
	public ResponseEntity<?> eliminarBeneficiario(Integer idUsuario, Integer idBeneficiario){
		Beneficiario beneficiario = beneficiarioDao.getPorUsuarioYIdBeneficiario(idBeneficiario,idUsuario);
		if(beneficiario == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		beneficiarioDao.delete(beneficiario);		
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
