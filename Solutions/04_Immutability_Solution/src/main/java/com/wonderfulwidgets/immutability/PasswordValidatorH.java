// PasswordValidatorD.java
// Copyright © 2019 NextStep IT Training. All rights reserved.
//

package com.wonderfulwidgets.immutability;

import java.io.IOException;
import java.io.InputStream;

public class PasswordValidatorH implements IPasswordValidator {
	
	public boolean validate(InputStream in, byte[] target) {
		
		boolean result = false;
		
		try {

			StringBuffer pw = new StringBuffer();
			
			while (true) {
				
				int input = in.read();
				
				if (input == -1 || input == '\n' || input == '\r') {
					
					break;
				}
				
				pw.append(input);
			}
			
			if (pw.length() == target.length) {
				
				int i = 0;
				
				for (; i < target.length && i < pw.length(); i++) {
					
					if (pw.charAt(i) != target[i]) {
						
						break;
					}
				}
				
				if (i == target.length) {
					
					result = true;
				}
			}
			
			pw.delete(0,  pw.length());
		}
		
		catch (IOException e) {
		}
		
		return result;
	}
}
