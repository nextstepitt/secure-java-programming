// PasswordValidatorTests.java
// Copyright © 2019 NextStep IT Training. All rights reserved.
//

package com.wonderfulwidgets.authentication;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PasswordValidatorTests {
	
	IPasswordValidator passwordValidator;
	
	@Before
	public void setup() {
		
		passwordValidator = new PasswordValidator();
	}

	@Test
	public void validPasswordSucceeds() {
		
		assertTrue(passwordValidator.validate("abcdefghiJ9%".getBytes()));
	}
	
	@Test
	public void passwordTooSmallFails() {
		
		assertFalse(passwordValidator.validate("abcdefghiJ9".getBytes()));
	}

	@Test
	public void passwordTooBigFails() {
		
		assertFalse(passwordValidator.validate("abcdefghiJ9%klmnopqrst".getBytes()));
	}
	
	@Test
	public void noUppercaseCharacterFails() {
		
		assertFalse(passwordValidator.validate("abcdefghij9%".getBytes()));
	}
	
	@Test
	public void noLowercaseCharacterFails() {
		
		assertFalse(passwordValidator.validate("ABCDEFGHIJ9%".getBytes()));
	}
	
	@Test
	public void noDigitFails() {
		
		assertFalse(passwordValidator.validate("abcdefghiJk%".getBytes()));
	}
	
	@Test
	public void noSymbolFails() {
		
		assertFalse(passwordValidator.validate("abcdefghiJ9p".getBytes()));
	}
}
