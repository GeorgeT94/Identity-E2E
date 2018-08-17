package com.e2e.service.repository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.e2e.domain.File;

public class FileLocalStorageTest {
	private FileLocalStorage localStorage;
	
	@Before
	public void setup() {
		localStorage = new FileLocalStorage();
	}
	
	@Test
	public void getAllReturnsCorrectSizeArray() {
		Assert.assertEquals(Constants.TEST_FILE_SIZE, localStorage.getAllFiles().size());
	}
	

	public void getAllContainsName(String name) {
		File testFile = new File();
		testFile.setName(name);
		Assert.assertTrue(localStorage.getAllFiles().contains(testFile));
	}
	
	@Test
	public void getContainsSampleCSV() {
		getAllContainsName(Constants.TEST_FILENAMES[0]);
	}
}
