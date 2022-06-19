package com.example.portfolio.resume.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.portfolio.resume.entity.ResumeData;

public interface ResumeRepository extends CrudRepository<ResumeData,Integer> {

	public ResumeData findByEmailId(String emailId);
	
}
