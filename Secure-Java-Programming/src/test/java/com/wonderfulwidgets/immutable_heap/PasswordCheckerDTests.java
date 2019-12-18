package com.wonderfulwidgets.immutable_heap;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

import org.junit.Test;

import com.wonderfulwidgets.immutable_heap.PasswordChecker;
import com.wonderfulwidgets.immutable_heap.PasswordCheckerD;

public class PasswordCheckerDTests extends PasswordCheckerTestsBase {
	
	public PasswordCheckerDTests() throws IOException {
	}
	
	@Test
	public void PasswordCheckerComplaintSucceeds() throws IOException {
		
		// Order is critically important here. The password must be checked and the target password
		// cleared before the memory dumped. Otherwise the target password will corrupt the memory
		// being dumped. The target password must be read a second time to do the scan in memory.
		// We have to follow the secure rules ourselves!
		
		InputStream passwordIn = getPasswordStream();
		byte[] passwordTarget = getPasswordTarget();
		
		// Get the password and password reader and call the class method to check it.
		
		PasswordChecker checker = new PasswordCheckerD();
		
		checker.check(passwordIn,  passwordTarget);
		
		// Now it is safe to dump memory.
				 
		Arrays.fill(passwordTarget, (byte)0);
		dumpMemory();
		
		// Clear the target to make sure it is out of memory, then assert checker.check left memory clean.
		
		assertFalse(scanForTarget(getPasswordTarget()));
	}
}