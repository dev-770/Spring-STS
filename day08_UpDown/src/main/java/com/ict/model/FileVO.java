package com.ict.model;

import org.springframework.web.multipart.MultipartFile;

public class FileVO {
	// index에서 넘어온 file_name은 MultipartFile file_name에 저장
	// f_name은 나중에 DB에 저장할 때 사용
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
