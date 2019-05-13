package com.loyalty.dto.afiliados.add;

import java.io.Serializable;

public class AgregarRequest implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String idUsuarioFuente;	
	private String nombre;	
	private String numeroCuenta;	
	private String tipoCuenta;	
	private String correo;
	
	
	public String getIdUsuarioFuente() {
		return idUsuarioFuente;
	}
	public void setIdUsuarioFuente(String idUsuarioFuente) {
		this.idUsuarioFuente = idUsuarioFuente;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNumeroCuenta() {
		return numeroCuenta;
	}
	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}
	public String getTipoCuenta() {
		return tipoCuenta;
	}
	public void setTipoCuenta(String tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}	

}
