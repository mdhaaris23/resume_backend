package com.example.portfolio.resume.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "resume_data")
public class ResumeData {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;

	String emailId;
	String fileName;

	@Lob
	byte[] content;

	public ResumeData() {

	}

	public ResumeData(Integer id, String emailId, String fileName, byte[] content) {
		super();
		this.id = id;
		this.emailId = emailId;
		this.content = content;
		this.fileName = fileName;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}

}
