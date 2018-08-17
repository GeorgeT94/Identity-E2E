package com.e2e.service.repository;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;

public class FileLocalStorage implements IFileRepository{
	
	final static Logger logger = Logger.getLogger(FileLocalStorage.class);
	
	private enum Paths {
	    TEST_FILES("C:\\TestFiles");
		
		private final String name;

		private Paths(String s) {
		        name = s;
		}
	    public String toString() {
	        return this.name;
	    }
	}
	
	private File folder;
	private List<File> listOfFiles;
	

	public List<File> getAllFiles(){
		String path = Paths.TEST_FILES.toString();
		
		if(logger.isDebugEnabled()){
		    logger.debug("In getAllFiles attempting to load from " + path);
		}
		folder = new File(path);
		
		listOfFiles = Arrays.asList(folder.listFiles());
		
		return listOfFiles;
	}
	
	
	public List<File> getFilesByMimeType(String mimeType) {
		getAllFiles();
		
		List<File> filesWithType;
		
		filesWithType = listOfFiles.stream()
			    .filter(file -> mimeType.equals(file.getName()))
			    .collect(Collectors.toList());
		
		return filesWithType;
	}
}
