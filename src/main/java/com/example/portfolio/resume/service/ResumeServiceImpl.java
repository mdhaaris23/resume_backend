package com.example.portfolio.resume.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.portfolio.resume.entity.ResumeData;
import com.example.portfolio.resume.repository.ResumeRepository;

@Service
public class ResumeServiceImpl implements ResumeService {

	@Autowired
	ResumeRepository resumeRepository;
	  
	@Override
	public String storeResume(MultipartFile resume,String emailId) throws Exception {
		ResumeData resumeDao = new ResumeData();
		resumeDao.setContent(resume.getBytes());
		resumeDao.setFileName(resume.getOriginalFilename());
		resumeDao.setEmailId(emailId);
		try {
			resumeRepository.save(resumeDao);
		}
		catch(Exception e) {
			return e.getMessage();
		}
		return "Resume saved successfully in DB!!";
	}

	@Override
	public byte[] fetchResume(String emailId) throws Exception {
		ResumeData data = resumeRepository.findByEmailId(emailId);
		if(data!=null) {
			return data.getContent();
		}
		else {
			throw new Exception("Resume does not exist for given email");
		}
	}

	
}
