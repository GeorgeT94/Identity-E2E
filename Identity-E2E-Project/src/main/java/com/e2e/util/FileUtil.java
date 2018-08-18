package com.e2e.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class FileUtil {

	public String getMimeType(File file) {
		String mimeType;
		try {
			mimeType= Files.probeContentType(file.toPath());
		}
		catch (IOException ex){
			mimeType = null;
		}
		return mimeType;
	}
	
	public String getName(File file) {
		return file.getName();
	}
	
	public String getSize(File file) {
		String size = "" + file.length() + "bytes";
		return size;
	}
	
	public String getExtension(File file) {
		String extension = "";

		int i = file.getName().lastIndexOf('.');
		if (i > 0) {
		    extension = file.getName().substring(i+1);
		}
		return extension;
	}
	
	public String getAllInfo(File file) {
		String name = getName(file);
		String extension = getExtension(file);
		String size = getSize(file);
		String mimeType = getMimeType(file);
		
		return "FILE: name: '"+ name + "' exntension: '" + extension + "' size: '" + size + "' mime-type: '" + mimeType + "'" ; 
	}
	
	public String fileListToString(List<File> files){
		String filesAsString = "";
		
		for(File file: files) {
			filesAsString += getAllInfo(file) + "\n";
		}
		
		return filesAsString;
	}
}
