// MemoryScanner.java
// Copyright © 2019 NextStep IT Training. All rights reserved.
//

package com.wonderfulwidgets.__shared__;

import java.io.File;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.nio.file.Files;

import javax.management.MBeanServer;

import com.sun.management.HotSpotDiagnosticMXBean;

public class MemoryScanner {
	
	private static final String MEMORYDUMPFILE = "memorydump.hprof";	// The filename for the memory dump
	
	private File memoryDumpFile;
	
	public MemoryScanner() {
		
		memoryDumpFile = new File(MEMORYDUMPFILE);
	}
	
	public void dumpMemory() throws IOException {
		
		// Get a HotSpotDiagnosticMXBean to reach the JVM memory.
		
		MBeanServer server = ManagementFactory.getPlatformMBeanServer();
		HotSpotDiagnosticMXBean hotSpot = ManagementFactory.newPlatformMXBeanProxy(
	      server, "com.sun.management:type=HotSpotDiagnostic", HotSpotDiagnosticMXBean.class);
		
		// Remove the dump file if it already exists because the hotSpot will not do it.
	    
	    Files.deleteIfExists(memoryDumpFile.toPath());
	    
	    // Dump the whole heap, the false flag includes unlinked objects.
	    
	    hotSpot.dumpHeap(memoryDumpFile.getPath(), false);
	}
	
	public boolean scanForTarget(byte[] target) throws IOException {

		// Assume failure, the target is never found.
		
		boolean result = false;
	    
	    // Read the file back in and scan it for the target (this is potentially big, but not as much so for unit tests).
		
		byte[] fileData = Files.readAllBytes(memoryDumpFile.toPath());
		
		// Walk every byte looking for a match to the first target byte.
		
		for (int i = 0; i < fileData.length - target.length; i++) {
			
			if (fileData[i] == target[0]) {
				
				// Look at the following bytes, abort if they do not match the target.
				
				int j = i + 1;
				int k = 1;
				
				for (; k < target.length; j++, k++) {
					
					if (fileData[j] != target[k]) {
						
						break;
					}
				}
				
				// If all the way through, we found the byte sequence in memory we targeted.
				
				if (k == target.length) {
					
					result = true;
					break;
				}
			}
		}
		
		// Return what was found, failure is assumed and only changed if the target is found above.
		
		return result;
	}
	
	public boolean scanForTarget(char[] target) throws IOException {

		// Assume failure, the target is never found.
		
		boolean result = false;
	    
	    // Read the file back in and scan it for the target (this is potentially big, but not as much so for unit tests).
		
		byte[] fileData = Files.readAllBytes(memoryDumpFile.toPath());
		
		// Walk every byte looking for a match to the first target byte.
		
		for (int i = 0; i < fileData.length - target.length; i++) {
			
			if (fileData[i] == target[0]) {
				
				// Look at the following bytes, abort if they do not match the target.
				
				int j = i + 1;
				int k = 1;
				
				for (; k < target.length; j++, k++) {
					
					if (fileData[j] != target[k]) {
						
						break;
					}
				}
				
				// If all the way through, we found the byte sequence in memory we targeted.
				
				if (k == target.length) {
					
					result = true;
					break;
				}
			}
		}
		
		// Return what was found, failure is assumed and only changed if the target is found above.
		
		return result;
	}
}
