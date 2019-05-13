package com.loyalty.utility;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validador {
	
	private Validador() {
		// Utility
	}
	
	public static boolean email(String email) {
		String emailPattern = "^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@" +
			      "[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,4})$";
		Pattern pattern = Pattern.compile(emailPattern);
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
		
		
	}

}
