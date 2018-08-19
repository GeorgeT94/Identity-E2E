package com.e2e.service.repository;

import java.io.File;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class FileLocalStorageTest {
	private FileLocalStorage localStorage;
	
	public static final int TEST_FILE_SIZE = 10;
	public static final String[] TEST_FILENAMES = {"SampleCSVFile_199kb.csv"};
	public static final int TEXT_PLAIN_COUNT = 3;
	public static final String TEXT_PLAIN_MIME = "text/plain";
	
	@Before
	public void setup() {
		localStorage = new FileLocalStorage();
	}  
	
	@Test
	public void getAllReturnsCorrectSizeArray() {
		Assert.assertEquals(TEST_FILE_SIZE, localStorage.getAllFiles().size());
	}
	 

	public void getAllContainsName(String name) {
		File testFile = new File("C:\\TestFiles\\SampleCSVFile_119kb.csv");
		Assert.assertTrue(localStorage.getAllFiles().contains(testFile));
	}
	  
	@Test
	public void getContainsSampleCSV() {
		getAllContainsName(TEST_FILENAMES[0]);
	}
	
	@Test
	public void getFilesByMimeTypeReturnsCorrectSize() {
		List<File> filesWithMimeType = localStorage.getByMimeType(TEXT_PLAIN_MIME);
		Assert.assertEquals(TEXT_PLAIN_COUNT, filesWithMimeType.size());
	}
	
	
}
