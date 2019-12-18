package com.wonderfulwidgets.authentication;

import java.io.Console;
import java.util.Arrays;

public class PasswordReader {

	public boolean getAndValidate(Console console, PasswordValidator validator) {
		
		boolean result = false;
		
		char[] password = console.readPassword();
		
		result = validator.validate(password);
		
		Arrays.fill(password, (char)0);
		
		return result;
	}
}
