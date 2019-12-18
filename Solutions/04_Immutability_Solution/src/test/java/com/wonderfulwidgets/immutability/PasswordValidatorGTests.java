// PasswordValidatorGTests.java
// Copyright © 2019 NextStep IT Training. All rights reserved.
//

package com.wonderfulwidgets.immutability;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.io.Console;
import java.io.IOException;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.wonderfulwidgets.__shared__.PasswordReader;
import com.wonderfulwidgets.__shared__.MemoryScanner;

@RunWith(MockitoJUnitRunner.class)
public class PasswordValidatorGTests {
	
	@Mock
	Console console;

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
		
		char[] passwordTarget = passwordReader.getPasswordTargetChars();
		
		// Mock System.console.readPassword() to return the password and to spy on it, and System.console.readLine()
		// just to spy on it; we are just checking to make sure the code under test actually called readPassword to
		// do the work and not readLine!

		doReturn(passwordTarget).when(console).readPassword();
		
		// Get the password and password reader and call the class method to check it.
		
		PasswordValidatorG validator = new PasswordValidatorG();
		
		validator.validate(console, passwordTarget);
		
		// Now it is safe to dump memory after we clear our target array.
				 
		Arrays.fill(passwordTarget, (char)0);
		memoryScanner.dumpMemory();
		
		// Clear the target to make sure it is out of memory, then assert checker.check left memory clean.
		
		verify(console, never()).readLine();
		verify(console, times(1)).readPassword();		
		assertFalse(memoryScanner.scanForTarget(passwordReader.getPasswordTarget()));
	}
}