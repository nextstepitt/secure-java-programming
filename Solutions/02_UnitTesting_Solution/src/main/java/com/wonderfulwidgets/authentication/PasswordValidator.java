// PasswordValidator.java
// Copyright © 2019 NextStep IT Training. All rights reserved.
//

package com.wonderfulwidgets.authentication;

public class PasswordValidator implements IPasswordValidator {

	public boolean validate(byte[] target) {
		
		String password = new String(target);
		
		return password.matches("(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%]).{12,20}");
	}
}
