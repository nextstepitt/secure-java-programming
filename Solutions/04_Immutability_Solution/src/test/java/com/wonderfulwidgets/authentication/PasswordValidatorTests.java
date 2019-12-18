package com.wonderfulwidgets.authentication;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Arrays;

import org.junit.Test;

import com.wonderfulwidgets.__shared__.MemoryScanner;
import com.wonderfulwidgets.__shared__.PasswordReader;

public class PasswordValidatorTests {

	@Test
	public void NoPasswordLeftBehind() throws IOException {
		
		PasswordReader pr = new PasswordReader();
		char[] pwd = pr.getPasswordTargetChars();
		
		PasswordValidator pv = new PasswordValidator();
		
		pv.validate(pwd);
		
		Arrays.fill(pwd, (char)0);
		
		MemoryScanner ms = new MemoryScanner();
		
		ms.dumpMemory();
		
		byte[] pwd2 = pr.getPasswordTarget();
		
		assertFalse(ms.scanForTarget(pwd2));
	}

}
