// PasswordReader.java
// Copyright © 2019 NextStep IT Training. All rights reserved.
//

package com.wonderfulwidgets.__shared__;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.Arrays;

public class PasswordReader {
	
	private static final String PASSWORDFILE = "password.txt";			// The file containing the password
	
	private File targetFile;
	
	public PasswordReader() {
		
		targetFile = new File(PASSWORDFILE);
	}
	
	public byte[] getPasswordTarget() throws IOException {
		
		return Files.readAllBytes(targetFile.toPath());
	}
	
	public char[] getPasswordTargetChars() throws IOException {
		
		byte[] pwBytes = getPasswordTarget();
		char[] pwChars = new char[pwBytes.length];
		
		for (int i = 0; i < pwBytes.length; i++) {
			
			pwChars[i] = (char)pwBytes[i];
		}
		
		Arrays.fill(pwBytes, (byte)0);
		
		return pwChars;
	}
	
	public FileInputStream getPasswordStream() throws IOException {
		
		return new FileInputStream(targetFile);
	}
}
