// PasswordValidatorA.java
// Copyright © 2019 NextStep IT Training. All rights reserved.
//

package com.wonderfulwidgets.immutability;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class PasswordValidatorA implements IPasswordValidator {
	
	public boolean validate(InputStream in, byte[] target) {
		
		boolean result = false;
		String input;
		
		try {
			
			BufferedReader inReader = new BufferedReader(new InputStreamReader(in));
			
			input = inReader.readLine();
			result = input.equals(new String(target));
		}
		
		catch (IOException e) {
		}
		
		return result;
	}

}
