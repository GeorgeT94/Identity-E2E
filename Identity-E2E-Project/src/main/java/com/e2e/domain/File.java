package com.e2e.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class File {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	
	private String name;
	private String mimeType;
	private String extension;
	
	public File() {
		
	}
	
	public String getName() {
		return name;
	}

	public String getMimeType() {
		return mimeType;
	}

	public String getExtension() {
		return extension;
	}



}
