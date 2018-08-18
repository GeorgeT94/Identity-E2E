package com.e2e.service.repository;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.log4j.Logger;

import com.e2e.util.FileUtil;

public class FileLocalStorage implements IFileRepository{
	
	final static Logger logger = Logger.getLogger(FileLocalStorage.class);
	private FileUtil fileUtil = new FileUtil();
	
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
	
	private List<File> loadedFiles;

	public List<File> getAllFiles(){
		String path = Paths.TEST_FILES.toString();
	
		if(logger.isDebugEnabled()){
		    logger.debug("In getAllFiles attempting to load from " + path);
		}
		
		File folder = new File(path);
		
		loadedFiles = Arrays.asList(folder.listFiles());

		if(logger.isDebugEnabled()){
		    logger.debug("In getAllFiles loaded files: " + fileUtil.fileListToString(loadedFiles));
		}
		return loadedFiles;
	}
	
	public List<File> getLoadedFiles(){
		return loadedFiles;
	}
	
	public List<File> getByMimeType(String mimeType){

		List<File> allFiles = getLoadedFiles();
		
		logger.debug("files loaded are: " + fileUtil.fileListToString(allFiles));  
		List<File> filesWithMimeType = new ArrayList<File>();
		
		for(File file: allFiles) {
			String fileMimeType = "null";
			
			if(fileUtil.getMimeType(file) != null) fileMimeType  = fileUtil.getMimeType(file);
			if(fileMimeType.equals(mimeType))
			filesWithMimeType.add(file);
		}
		
		return filesWithMimeType;
	}
	
	public List<File> getByExtension(String extension){
		List<File> allFiles;
		allFiles = getAllFiles(); 
		 
		List<File> filesWithExtension = new ArrayList<File>();
		
		for(File file: allFiles) {
			if(fileUtil.getExtension(file).equals(extension)) {
				filesWithExtension.add(file);
			}	
		}
		
		return filesWithExtension;
	}
	

}
