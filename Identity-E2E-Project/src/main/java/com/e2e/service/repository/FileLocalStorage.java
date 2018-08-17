package com.e2e.service.repository;

import java.util.ArrayList;
import java.util.List;

import com.e2e.domain.File;

public class FileLocalStorage implements IFileRepository{

	public List<File> getAllFiles(){
		List<File> files = new ArrayList<>();
		return files;
	}
	
	public File getFileByMimeType(String mimeType) {
		File file = new File();
		return file;
	}
}
