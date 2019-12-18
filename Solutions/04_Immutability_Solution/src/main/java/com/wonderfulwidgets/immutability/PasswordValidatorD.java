// PasswordValidatorE.java
// Copyright © 2019 NextStep IT Training. All rights reserved.
//

package com.wonderfulwidgets.immutability;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PasswordValidatorD implements IPasswordValidator {
	
	public boolean validate(InputStream in, byte[] target) {
		
		boolean result = false;
		
		try {
			
			InputStreamReader inReader = new InputStreamReader(in);
			char[] input = new char[32];
			int i = 0;
			
			inReader.read(input, 0, input.length);
			
			for (; i < input.length; i++) {
				
				if (input[i] == '\n' || input[i] == '\r') {
					
					break;
				}
			}
			
			int j = 0;
			
			for (; j < target.length && j < i; j++) {
				
				if (input[j] != target[j]) {
					
					break;
				}
			}
			
			if (j == i) {
				
				result = true;
			}
			
			Arrays.fill(input, (char)0);
		}
		
		catch (IOException e) {
		}
		
		return result;
	}
}
