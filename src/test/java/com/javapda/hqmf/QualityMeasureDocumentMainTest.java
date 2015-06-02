package com.javapda.hqmf;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

import com.javapda.hqmf.testsupport.TestData;

public class QualityMeasureDocumentMainTest {

	@Test
	public void testEmeasureBundleZipFile() {
		String[] args = new String[] {
				"--emeasurebundle",
				TestData.emeasureBundleZip().getAbsolutePath()
		};
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    PrintStream ps = new PrintStream(baos);
	    // IMPORTANT: Save the old System.out!
	    PrintStream originalSystemOut = System.out;
	    // Tell Java to use your special stream
	    System.setOut(ps);
	    // Print some output: goes to your special stream
	    QualityMeasureDocumentMain.main(args);
	    // Put things back
	    System.out.flush();
	    System.setOut(originalSystemOut);
	    // Show what happened
	    System.out.println("Here: " + baos.toString());		
		
	}	
	
	@Test
	public void testEmeasureZipFile() {
		String[] args = new String[] {
				"--emeasurezip",
				TestData.emeasureZipCms130v3().getAbsolutePath()
				
		};
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    PrintStream ps = new PrintStream(baos);
	    // IMPORTANT: Save the old System.out!
	    PrintStream originalSystemOut = System.out;
	    // Tell Java to use your special stream
	    System.setOut(ps);
	    // Print some output: goes to your special stream
	    QualityMeasureDocumentMain.main(args);
	    // Put things back
	    System.out.flush();
	    System.setOut(originalSystemOut);
	    // Show what happened
	    System.out.println("Here: " + baos.toString());		
		
	}		
	@Test
	public void testFile() {
		String[] args = new String[] {
				"--file",
				TestData.xmlFileCms129v4().getAbsolutePath()
				
		};
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    PrintStream ps = new PrintStream(baos);
	    // IMPORTANT: Save the old System.out!
	    PrintStream originalSystemOut = System.out;
	    // Tell Java to use your special stream
	    System.setOut(ps);
	    // Print some output: goes to your special stream
	    QualityMeasureDocumentMain.main(args);
	    // Put things back
	    System.out.flush();
	    System.setOut(originalSystemOut);
	    // Show what happened
//	    System.out.println("Here: " + baos.toString());		
		
	}

}
