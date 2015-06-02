package com.javapda.hqmf;

import org.junit.Test;

import com.javapda.hqmf.testsupport.TestData;

public class QualityMeasureDocumentRendererTest {

	@Test
	public void test() {
		System.out.println(QualityMeasureDocumentRenderer.renderHeader());
		System.out.println(new QualityMeasureDocumentRenderer(TestData.qualityMeasureDocument()).render());
	}

}
