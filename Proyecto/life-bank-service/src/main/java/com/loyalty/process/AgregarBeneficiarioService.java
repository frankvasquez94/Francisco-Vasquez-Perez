package com.loyalty.process;

import java.util.Optional;

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
import com.loyalty.dto.afiliados.add.AgregarRequest;
import com.loyalty.model.entity.Beneficiario;
import com.loyalty.model.entity.TipoCuenta;
import com.loyalty.model.entity.Usuario;
import com.loyalty.utility.Validador;

@Service
public class AgregarBeneficiarioService {
	private BeneficiarioDao beneficiarioDao;
	private TipoCuentaDao tipoCuentaDao;
	private UserDao usuarioDao;
	private Logger log;
	private Environment env;	
	
	@Autowired
	public AgregarBeneficiarioService(BeneficiarioDao beneficiarioDao,TipoCuentaDao tipoCuentaDao,UserDao usuarioDao,Environment env) {
		this.beneficiarioDao = beneficiarioDao;
		this.tipoCuentaDao = tipoCuentaDao;
		this.usuarioDao = usuarioDao;
		this.env = env;
		this.log = LoggerFactory.getLogger(getClass());
	}
	
	public ResponseEntity<?> agregarBeneficiario(AgregarRequest request){
		//400 si el correo no es valido.
		if(!Validador.email(request.getCorreo())) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		TipoCuenta tCuenta = tipoCuentaDao.getPorNombre(request.getTipoCuenta());
		if(tCuenta == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Optional<Usuario> usuarioO = usuarioDao.findById(Integer.parseInt(request.getIdUsuarioFuente()));
		
		if(!usuarioO.isPresent()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		if(beneficiarioDao.getPorUsuario(request.getNumeroCuenta(), Integer.parseInt(request.getIdUsuarioFuente())) != null) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		
		Beneficiario beneficiario = new Beneficiario();
		beneficiario.setUsuario(usuarioO.get());
		beneficiario.setTipoCuenta(tCuenta);
		beneficiario.setNombre(request.getNombre());
		beneficiario.setCorreo(request.getCorreo());
		beneficiario.setNumeroCuenta(request.getNumeroCuenta());
		
		beneficiarioDao.save(beneficiario);
		
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

}
