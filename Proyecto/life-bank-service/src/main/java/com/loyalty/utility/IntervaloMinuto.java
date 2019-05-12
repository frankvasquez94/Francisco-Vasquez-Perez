package com.loyalty.utility;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class IntervaloMinuto {
	
	/*
	 * Devuelve la diferencia de minutos entre la fecha actual y una fecha dada
	 */
	private IntervaloMinuto() {
		//Utility
	}
	public static Integer getMinutosDiferencia(Date date,int numeroMinutos) {		
		Date fechaActual = new Date();
		DateFormat format = new SimpleDateFormat("mm");
		String min1 = format.format(date);
		String minActual = format.format(fechaActual);
		
		return Integer.parseInt(minActual) - Integer.parseInt(min1); 
	}

}
