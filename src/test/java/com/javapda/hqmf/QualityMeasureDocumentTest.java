package com.javapda.hqmf;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.javapda.hqmf.testsupport.TestData;

public class QualityMeasureDocumentTest {

	private QualityMeasureDocument qualityMeasureDocument;
	@Before public void setup() {
		initializeVariables();
	}
	

	@Test
	public void test() {
		System.out.println(qualityMeasureDocument);
	}

	private void initializeVariables() {
		qualityMeasureDocument = QualityMeasureDocumentFactory.create(TestData.xmlFileCms129v4());
		assertNotNull(qualityMeasureDocument);
		
	}
	
}
