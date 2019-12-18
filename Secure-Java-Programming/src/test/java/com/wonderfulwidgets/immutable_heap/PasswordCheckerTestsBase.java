package com.wonderfulwidgets.immutable_heap;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.lang.management.ManagementFactory;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.stream.Stream;

import javax.management.MBeanServer;

import com.sun.management.HotSpotDiagnosticMXBean;

public class PasswordCheckerTestsBase {
	
	private static final boolean CLEANUP = false;						// Set to true to remove the memory dump
	private static final String MEMORYDUMPFILE = "memorydump.hprof";	// The filename for the memory dump
	private static final String PASSWORDFILE = "password.txt";			// The file containing the password
	
	private File targetFile;
	private File memoryDumpFile;
	
	public PasswordCheckerTestsBase() {
		
		targetFile = new File(PASSWORDFILE);
		memoryDumpFile = new File(MEMORYDUMPFILE);
	}
	
	public void dumpMemory() throws IOException {
		
		// Get a HotSpotDiagnosticMXBean to dump the whole heap, including unlinked objects.
		
		MBeanServer server = ManagementFactory.getPlatformMBeanServer();
		HotSpotDiagnosticMXBean hotSpot = ManagementFactory.newPlatformMXBeanProxy(
	      server, "com.sun.management:type=HotSpotDiagnostic", HotSpotDiagnosticMXBean.class);
	    
	    Files.deleteIfExists(memoryDumpFile.toPath());
	    hotSpot.dumpHeap(memoryDumpFile.getPath(), false);
	}
	
	public byte[] getPasswordTarget() throws IOException {
		
		return Files.readAllBytes(targetFile.toPath());
	}
	
	public InputStream getPasswordStream() throws IOException {
		
		return new FileInputStream(targetFile);
	}
	
	public Reader getPasswordFileReader() throws IOException {
		
		return new FileReader(targetFile);
	}
	
	public BufferedReader getPasswordReader() throws IOException {
		
		return new BufferedReader(new FileReader(targetFile));
	}
	
	public boolean scanForTarget(byte[] target) throws IOException {
	    
	    // Read the file back in and scan it for the target.
		
		boolean result = false;
		byte[] fileData = Files.readAllBytes(memoryDumpFile.toPath());
		
		for (int i = 0; i < fileData.length - target.length; i++) {
			
			if (fileData[i] == target[0]) {
				
				int j = i + 1;
				int k = 1;
				
				for (; k < target.length; j++, k++) {
					
					if (fileData[j] != target[k]) {
						
						break;
					}
				}
				
				if (k == target.length) {
					
					result = true;
					break;
				}
			}
		}
		
		// Clean up.
		
	    if (CLEANUP) {
		
	    	Files.deleteIfExists(memoryDumpFile.toPath());
	    }
		
		return result;
	}
}
