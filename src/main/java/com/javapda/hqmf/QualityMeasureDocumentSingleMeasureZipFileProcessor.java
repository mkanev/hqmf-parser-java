package com.javapda.hqmf;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

import com.javapda.util.ZipUtil;

public class QualityMeasureDocumentSingleMeasureZipFileProcessor {
	protected static Logger log = Logger.getLogger(QualityMeasureDocumentSingleMeasureZipFileProcessor.class);
	private File zipFile;
	public QualityMeasureDocumentSingleMeasureZipFileProcessor(File zipFile2) {
		this.zipFile = zipFile2;
		validate();
	}
	private void validate() {
		if(zipFile==null) {
			throw new IllegalArgumentException(String.format("Null not accepted for ZipFile"));
		}
		if(!ZipUtil.isZipFile(zipFile)) {
			throw new IllegalArgumentException(String.format("File '%s' is NOT a zip file",zipFile.getAbsolutePath()));
		}
		
	}
	public QualityMeasureDocument process() {
		String filename = extracted();
		File temporaryLocationOfEmeasureXmlFileDirectory = generateTempEmeasureXmlFileDirectory();
		temporaryLocationOfEmeasureXmlFileDirectory.mkdirs();
		File destinationFile= new File(temporaryLocationOfEmeasureXmlFileDirectory,filename);
		ZipUtil.getFileFromZip(zipFile, filename,destinationFile);
		if(log.isDebugEnabled()) {
			log.debug("destinationFile: " + destinationFile);
		}
		QualityMeasureDocument qualityMeasureDocument = QualityMeasureDocumentFactory.create(destinationFile);
		deleteDirectory(temporaryLocationOfEmeasureXmlFileDirectory);
		return qualityMeasureDocument;
	}
	private void deleteDirectory(
			File temporaryLocationOfEmeasureXmlFileDirectory) {
		try {
			FileUtils.deleteDirectory(temporaryLocationOfEmeasureXmlFileDirectory);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private String extracted() {
		List<String> filenamesInZip = ZipUtil.getFileNames(zipFile);
		List<String> filenames = new ArrayList<>();
		for (String candidate : filenamesInZip) {
			if (candidate.endsWith(".xml")) {
				filenames.add(candidate);
			}
		}
		if(filenames.size()!=1) {
			throw new IllegalStateException(String.format("File '%s' had %d .xml files, expected only 1",zipFile.getAbsolutePath(),filenames.size()));
		}
		return filenames.iterator().next();
	}
	private File generateTempEmeasureXmlFileDirectory() {
		File temporaryLocationOfEmeasureXmlFiles = new File(FileUtils.getTempDirectory(),
				String.format("_zipTemp-%d-%s",System.currentTimeMillis(),fmtdatenow()));
		return temporaryLocationOfEmeasureXmlFiles;
	}
	private String fmtdatenow() {
		return new SimpleDateFormat("yyyyMMdd-HHmm-ss.SSS").format(new Date());
	}
}
