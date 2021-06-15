package com.ict.model;

import org.springframework.web.multipart.MultipartFile;

public class FileVO {
	private String name;
	private MultipartFile file_name;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public MultipartFile getFile_name() {
		return file_name;
	}
	public void setFile_name(MultipartFile file_name) {
		this.file_name = file_name;
	}
}
