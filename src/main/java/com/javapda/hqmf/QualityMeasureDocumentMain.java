package com.javapda.hqmf;

import java.io.File;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.javapda.util.ZipUtil;

/**
 * To build an executable jar:
 * 
 *    mvn clean compile assembly:single
 * 
 * @author jkroub
 *
 */
public class QualityMeasureDocumentMain {
	private static final String SEP = "\n";
	protected static Logger log = Logger.getLogger(QualityMeasureDocumentMain.class);
	public static void main(String[] args) {
		if(args.length<2) {
			usage();
			return;
		}
		if ("--file".equals(args[0])) {
			System.out.println(QualityMeasureDocumentFactory.create(new File(args[1])).toString());
		} else if ("--emeasurezip".equals(args[0])) {
			emeasureZip(new File(args[1]));
		} else if ("--emeasurebundle".equals(args[0])) {
			emeasureBundle(new File(args[1]));
		} else {
			usage();
			System.out.println(String.format("do not know how to process command-line: %s",StringUtils.join(args,",")));
		}
	}

	private static void emeasureBundle(File zipFile) {
		System.out.println(String.format("emeasureBundle on %s",zipFile.getAbsolutePath()));
		if(!ZipUtil.isZipFile(zipFile)) {
			throw new IllegalArgumentException(String.format("File '%s' is NOT a zip file",zipFile.getAbsolutePath()));
		}
		for( Object obj : ZipUtil.getFileNameAndLengths(zipFile)) {
			System.out.println(obj);
		}
		
	}

	private static void emeasureZip(File zipFile) {
		System.out.println(String.format("emeasureZip on %s",zipFile.getAbsolutePath()));
		if(!ZipUtil.isZipFile(zipFile)) {
			throw new IllegalArgumentException(String.format("File '%s' is NOT a zip file",zipFile.getAbsolutePath()));
		}
		System.out.println(System.getProperty("java.io.tmpdir"));
		for( Object obj : ZipUtil.getFileNameAndLengths(zipFile)) {
			System.out.println(obj);
		}
		System.out.println(new QualityMeasureDocumentSingleMeasureZipFileProcessor(zipFile).process());
	}

	private static void usage() {
		StringBuilder sb = new StringBuilder();
		sb.append("Usage:").append(SEP);
		sb.append("  java -jar ... <command-line-").append(SEP);
		sb.append("Command-line options:").append(SEP);
		sb.append("  --file path/to/eMeasure.xml").append(SEP);
		sb.append("  --emeasurezip path/to/single/eMeasure/zipFile.xml").append(SEP);
		sb.append("  --emeasurebundle path/to/bundle/eMeasures/zipFile.xml").append(SEP);
		System.out.println(sb.toString());
		
	}
	
}
