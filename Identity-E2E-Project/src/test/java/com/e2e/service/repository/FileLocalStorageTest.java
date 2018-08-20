package com.e2e.service.repository;

import java.io.File;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class FileLocalStorageTest {
	private FileLocalStorage localStorage;
	final static Logger logger = Logger.getLogger(FileLocalStorageTest.class);

	
	public static final int TEST_FILE_SIZE = 15;
	public static final String[] TEST_FILENAMES = {"SampleCSVFile_119kb.csv"};
	public static final int EXCEL_COUNT = 3;
	public static final String TEXT_PLAIN_MIME = "text/plain";
	
	@Before
	public void setup() {
		localStorage = new FileLocalStorage();
	}  
	
	@Test
	public void getAllReturnsCorrectSizeArray() {
		Assert.assertEquals(TEST_FILE_SIZE, localStorage.getAllFiles().size());
	}
	 

	private boolean getAllContainsName(String name) {
		List<File> fileList = localStorage.getLoadedFiles();
		for(File file : fileList) {
			
			logger.debug("expected name: " + name);
			logger.debug("actual name: " + file.getName());
			if(file.getName().equals(name)) {
				return true;  
			} 
		}  
		return false;
	}
	  
	@Test
	public void getContainsSampleCSV() {
		localStorage.getAllFiles();
		Assert.assertTrue(getAllContainsName(TEST_FILENAMES[0]));
	}
	
	@Test
	public void getFilesByMimeTypeReturnsCorrectSize() {
		localStorage.getAllFiles();
		List<File> filesWithMimeType = localStorage.getByMimeType("application/vnd.ms-excel");
		Assert.assertEquals(EXCEL_COUNT, filesWithMimeType.size());
	}
	
	
}
