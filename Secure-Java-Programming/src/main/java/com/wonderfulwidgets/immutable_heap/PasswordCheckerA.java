package com.wonderfulwidgets.immutable_heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class PasswordCheckerA implements PasswordChecker {
	
	public boolean check(InputStream in, byte[] target) {
		
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
