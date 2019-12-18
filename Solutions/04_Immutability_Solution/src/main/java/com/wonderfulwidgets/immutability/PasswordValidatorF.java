// PasswordValidatorD.java
// Copyright © 2019 NextStep IT Training. All rights reserved.
//

package com.wonderfulwidgets.immutability;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class PasswordValidatorF implements IPasswordValidator {
	
	public boolean validate(InputStream in, byte[] target) {
		
		boolean result = false;
		
		try {

			byte[] input = new byte[32];
			int i = 0;
			
			for (; i < input.length; i++) {
				
				input[i] = (byte)(in.read());
				
				if (input[i] == -1 || input[i] == '\n' || input[i] == '\r') {
					
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
			
			Arrays.fill(input, (byte)0);
		}
		
		catch (IOException e) {
		}
		
		return result;
	}
}
