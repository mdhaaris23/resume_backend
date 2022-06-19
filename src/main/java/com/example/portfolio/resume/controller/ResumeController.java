package com.example.portfolio.resume.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.portfolio.resume.service.ResumeService;

@RestController
@RequestMapping(value = "/resume")
public class ResumeController {

	@Autowired
	ResumeService resumeService;

	@PostMapping(value = "/upload")
	public ResponseEntity<String> uploadResume(@RequestParam("resume") MultipartFile resume,
			@RequestParam("emailId") String emailId) throws Exception {
		String response = resumeService.storeResume(resume, emailId);
		return new ResponseEntity<String>(response, HttpStatus.CREATED);
	}

	@GetMapping(value = "/fetch/{emailId:.+}")
	public Resource getResume(@PathVariable String emailId) throws Exception {
		System.out.print(emailId);
		byte[] response = resumeService.fetchResume(emailId);
		return new ByteArrayResource(response);
	}

}
