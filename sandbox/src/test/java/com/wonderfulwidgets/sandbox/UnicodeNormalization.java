package com.wonderfulwidgets.sandbox;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.Normalizer;

import org.junit.Test;

public class UnicodeNormalization {

	@Test
	public void CompositionExample() throws IOException {

		String nya1 = "\u006E\u0303";
		String nya2 = "\u00F1";

//		String nya1 = "\u0065\u0301";
//		String nya2 = "\u00E9";
		
		displayString(nya1);
		displayString(nya2);
		
		System.out.println("NFC");
		
		displayString(Normalizer.normalize(nya1, Normalizer.Form.NFC));
		displayString(Normalizer.normalize(nya2, Normalizer.Form.NFC));
		
		System.out.println("NFD");
		
		displayString(Normalizer.normalize(nya1, Normalizer.Form.NFD));
		displayString(Normalizer.normalize(nya2, Normalizer.Form.NFD));
		
		System.out.println("NFKC");
		
		displayString(Normalizer.normalize(nya1, Normalizer.Form.NFKC));
		displayString(Normalizer.normalize(nya2, Normalizer.Form.NFKC));
		
		System.out.println("NFKD");
		
		displayString(Normalizer.normalize(nya1, Normalizer.Form.NFKD));
		displayString(Normalizer.normalize(nya2, Normalizer.Form.NFKD));
		
		FileOutputStream fos = new FileOutputStream("normalized.txt");
		
		fos.write(Normalizer.normalize(nya1, Normalizer.Form.NFKD).getBytes());
		fos.close();
		
		byte[] normalized = Normalizer.normalize(nya1, Normalizer.Form.NFKD).getBytes();
		
		for (int i = 0; i < normalized.length; i++) {
			
			System.out.println(normalized[i] & 0xFF);
		}
		
		FileOutputStream f = new FileOutputStream("sentences.txt");
		
		f.write("La contrase\u006E\u0303a es Unicode.\r\n".getBytes());
		f.write("La contrase\u00F1a es Unicode.\r\n".getBytes());
		f.close();
	}
	
	private void displayString(String s) {
		
		System.out.print(s);
		System.out.println(" (" + s.length() + ")");
	}
}
