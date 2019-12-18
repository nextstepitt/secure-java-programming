package com.wonderfulwidgets.immutable_heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PasswordCheckerB implements PasswordChecker {
	
	public boolean check(InputStream in, byte[] target) {
		
		boolean result = false;
		byte[] input;
		
		try {
			
			BufferedReader inReader = new BufferedReader(new InputStreamReader(in));
			
			input = inReader.readLine().getBytes();
			result = Arrays.equals(input, target);
		}
		
		catch (IOException e) {
		}
		
		return result;
	}

}
