package com.wonderfulwidgets.authentication;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.io.Console;
import java.io.IOException;
import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.wonderfulwidgets.__shared__.MemoryScanner;

@RunWith(MockitoJUnitRunner.class)
public class PasswordReaderTests {
	
	@Mock
	Console console;

	@Test
	public void NoPasswordLeftBehind() throws IOException {
		
		PasswordReader pr = new PasswordReader();
		MemoryScanner ms = new MemoryScanner();

		char[] pwd2 = { 'P', '@', 's', 's', 'W', '0', 'r', 'd' };
		
		doReturn(pwd2).when(console).readPassword();
		
		PasswordValidator validator = new PasswordValidator();
		pr.getAndValidate(console, validator);
		
		Arrays.fill(pwd2, (char)0);
		ms.dumpMemory();

		char[] pwd3 = { 'P', '@', 's', 's', 'W', '0', 'r', 'd' };
		
		verify(console, times(0)).readLine();
		verify(console, times(1)).readPassword();
		
		assertFalse(ms.scanForTarget(pwd3));
	}

}
