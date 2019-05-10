package com.loyalty;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class Application {
	private static Logger log = LoggerFactory.getLogger(Application.class);
    
	public static void main(String[] args) {
		try {
			System.setProperty("hostname", InetAddress.getLocalHost().getHostName());
		    SpringApplication.run(Application.class, args);
		}catch(UnknownHostException e) {
			log.error("Error al levantar la aplicacion: {}",e);
		}
	}
}
