package com.e2e.service.repository;

import java.util.List;

import com.e2e.domain.File;

public interface IFileRepository {
	
	List<File> getAllFiles();

	File getFileByMimeType(String mimeType);


}
