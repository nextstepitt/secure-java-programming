// PasswordValidatorD.java
// Copyright © 2019 NextStep IT Training. All rights reserved.
//

package com.wonderfulwidgets.immutability;

import java.io.Console;
import java.util.Arrays;

public class PasswordValidatorG {
	
	public boolean validate(Console console, char[] target) {
		
		boolean result = false;
		
		char[] input = console.readPassword();
		int i = 0;
		
		if (input.length == target.length) {
			
			for (; i < target.length; i++) {
				
				if (input[i] != target[i]) {
					
					break;
				}
			}
		
			if (i == target.length) {
				
				result = true;
			}
		}
		
		Arrays.fill(input, (char)0);
		
		return result;
	}
}
