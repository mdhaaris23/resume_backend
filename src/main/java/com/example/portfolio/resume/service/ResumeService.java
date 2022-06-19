package com.example.portfolio.resume.service;

import org.springframework.web.multipart.MultipartFile;

public interface ResumeService {

	public String storeResume(MultipartFile resume, String emailId) throws Exception;
	
	public byte[] fetchResume(String emailId) throws Exception;
	
}
