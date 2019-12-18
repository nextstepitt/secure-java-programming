package com.wonderfulwidgets.immutable_heap;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PasswordCheckerE implements PasswordChecker {
	
	public boolean check(InputStream in, byte[] target) {
		
		boolean result = false;
		byte[] input = new byte[32];
		int i = 0;
		
		try {
			
			InputStreamReader inReader = new InputStreamReader(in);
			
			for (; i < input.length; i++) {
				
				input[i] = (byte)(inReader.read());
				
				if (input[i] == '\n' || input[i] == '\r') {
					
					break;
				}
			}
			
			int j = 0;
			
			for (; j < i; j++) {
				
				if (input[j] != target[j]) {
					
					break;
				}
			}
			
			if (j == i) {
				
				result = true;
			}
			
			Arrays.fill(input, (byte)0);
			inReader.close();
		}
		
		catch (IOException e) {
		}
		
		return result;
	}
}
