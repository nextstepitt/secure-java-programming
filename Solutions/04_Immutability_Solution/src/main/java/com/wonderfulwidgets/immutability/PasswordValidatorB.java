// PasswordValidatorB.java
// Copyright © 2019 NextStep IT Training. All rights reserved.
//

package com.wonderfulwidgets.immutability;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PasswordValidatorB implements IPasswordValidator {
	
	public boolean validate(InputStream in, byte[] target) {
		
		boolean result = false;
		byte[] input;
		
		try {
			
			BufferedReader inReader = new BufferedReader(new InputStreamReader(in));
			
			input = inReader.readLine().getBytes();
			result = Arrays.equals(input, target);
			
			Arrays.fill(input, (byte)0);
		}
		
		catch (IOException e) {
		}
		
		return result;
	}

}
