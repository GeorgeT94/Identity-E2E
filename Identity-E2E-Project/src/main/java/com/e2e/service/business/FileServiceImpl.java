package com.e2e.service.business;

import org.apache.log4j.Logger;

public class FileServiceImpl implements IFileService {

	private static final Logger LOGGER = Logger.getLogger(IFileService.class);


	public String getAllFiles(){
		return "0";
	}
	
	public String getFileByMimeType(String mimeType) {
		return "0";
	}

}
