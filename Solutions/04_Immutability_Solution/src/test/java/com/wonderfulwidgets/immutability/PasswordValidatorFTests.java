// PasswordValidatorATests.java
// Copyright © 2019 NextStep IT Training. All rights reserved.
//

package com.wonderfulwidgets.immutability;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import com.wonderfulwidgets.__shared__.PasswordReader;
import com.wonderfulwidgets.__shared__.MemoryScanner;

public class PasswordValidatorFTests {

	private MemoryScanner memoryScanner;
	private PasswordReader passwordReader;
	
	@Before
	public void setup() {
		
		memoryScanner = new MemoryScanner();
		passwordReader = new PasswordReader();
	}
	
	@Test
	public void PasswordCheckerComplaintSucceeds() throws IOException {
		
		// Order is critically important here. The password must be checked and the target password
		// cleared before the memory dumped. Otherwise the target password will corrupt the memory
		// being dumped. The target password must be read a second time to do the scan in memory.
		// We have to follow the secure rules ourselves!
		
		InputStream passwordIn = passwordReader.getPasswordStream();
		byte[] passwordTarget = passwordReader.getPasswordTarget();
		
		// Get the password and password reader and call the class method to check it.
		
		IPasswordValidator validator = new PasswordValidatorF();
		
		validator.validate(passwordIn,  passwordTarget);
		
		// Now it is safe to dump memory after we clear our target array.
				 
		Arrays.fill(passwordTarget, (byte)0);
		memoryScanner.dumpMemory();
		
		// Clear the target to make sure it is out of memory, then assert checker.check left memory clean.
		
		assertFalse(memoryScanner.scanForTarget(passwordReader.getPasswordTarget()));
	}
}