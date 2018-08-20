package com.e2e.service.repository;

import java.io.File;
import java.util.List;

public interface IFileStorage {

	List<File> getAllFiles();

	List<File> getByMimeType(String mimeType);

	List<File> getExcelFiles();

	List<File> getByExtension(String extension);

}