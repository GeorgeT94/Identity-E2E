package com.e2e.service.business;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.e2e.domain.File;

public class FileServiceImpl implements IFileService {

	private static final Logger LOGGER = Logger.getLogger(IFileService.class);


	public List<File> getAllFiles(){
		List<File> files = new ArrayList<>();
		return files;
	}
	


}
