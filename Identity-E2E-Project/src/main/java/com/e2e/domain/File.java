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

	public void setName(String name) {
		this.name = name;
	}

	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}


}
