package com.loyalty.dto.login;

import java.io.Serializable;

public class LoginResponse implements Serializable{
		
	private static final long serialVersionUID = 1L;
	
	private String tkn;

	public String getTkn() {
		return tkn;
	}

	public void setTkn(String tkn) {
		this.tkn = tkn;
	}
	
	

}
