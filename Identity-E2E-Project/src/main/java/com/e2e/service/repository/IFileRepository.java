package com.e2e.service.repository;

import java.io.File;
import java.util.List;



public interface IFileRepository {
	
	List<File> getAllFiles();

	List<File> getFilesByMimeType(String mimeType);


}
