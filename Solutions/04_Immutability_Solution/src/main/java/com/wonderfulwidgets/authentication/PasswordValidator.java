// PasswordValidator.java
// Copyright © 2019 NextStep IT Training. All rights reserved.
//

package com.wonderfulwidgets.authentication;

import java.util.regex.Pattern;

public class PasswordValidator implements IPasswordValidator {

	public boolean validate(char[] target) {
		
		boolean result = false;
		
		StringBuilder password = new StringBuilder();
		
		for (int i = 0; i < target.length; i++) {
			
			password.append(target[i]);
		}
		
		result = Pattern.matches("(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%]).{12,20}", password);
		
//		for (int i = password.length() - 1; i >= 0; --i) {
//			
//			password.deleteCharAt(i);
//		}
		
//		while (password.length() > 0) {
//			
//			password.deleteCharAt(0);
//		}
		
		password.replace(0, password.length(), " ");
		
		return result;
	}
}
