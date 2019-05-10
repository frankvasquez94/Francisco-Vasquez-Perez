package com.loyalty;

import java.net.InetAddress;
import java.net.UnknownHostException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Initialize {
	private static Logger log = LoggerFactory.getLogger(Initialize.class);
	
	private Initialize() {
		//Clase no instanciable.
	}
	
	public static void initializeVariables(){
		try {
			System.setProperty("hostname", InetAddress.getLocalHost().getHostName());
		} catch (UnknownHostException e) {
			log.error("Host name para el archivo de log");
		}
	}
	
}