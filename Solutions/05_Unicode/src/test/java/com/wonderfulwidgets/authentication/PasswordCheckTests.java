package com.wonderfulwidgets.authentication;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.Normalizer;

import org.junit.Test;

public class PasswordCheckTests {

	@Test
	public void checksString() throws IOException {
		
		FileInputStream fis = new FileInputStream("sentences.txt");
		InputStreamReader r = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(r);
		
		String password1 = br.readLine();
		String password2 = br.readLine();
		br.close();
		
		password1 = Normalizer.normalize(password1, Normalizer.Form.NFKC);
		password2 = Normalizer.normalize(password2, Normalizer.Form.NFKC);
		
		PasswordCheck pc = new PasswordCheck();
		
		assertTrue(pc.check(password1, password2));
	}

}
