package com.neu.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "AcademicProfile")
public class AcademicProfile {
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "candidate", nullable = false)
	Candidate candidate;
	
	@Id
	@GeneratedValue
	@Column(name = "academicDetailsID", unique = true, nullable = false)
	int academicDetailsID;
	
	@Column(name = "educationLevel")
	private String educationLevel; 
	
	@Column(name = "major")
	private String major;
	
	@Column(name = "gpa")
	private double gpa;
	
	@Column(name = "startYear")
	private int startYear;

	@Column(name = "expYearOfGraduation")
	private int expYearOfGraduation;
	
	@Column(name = "universityName")
	private String universityName;
	
	@Column(name = "universityAddress")
	private String universityAddress;

	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

	public int getAcademicDetailsID() {
		return academicDetailsID;
	}

	public void setAcademicDetailsID(int academicDetailsID) {
		this.academicDetailsID = academicDetailsID;
	}

	public String getEducationLevel() {
		return educationLevel;
	}

	public void setEducationLevel(String educationLevel) {
		this.educationLevel = educationLevel;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	public int getStartYear() {
		return startYear;
	}

	public void setStartYear(int startYear) {
		this.startYear = startYear;
	}

	

	public int getExpYearOfGraduation() {
		return expYearOfGraduation;
	}

	public void setExpYearOfGraduation(int expYearOfGraduation) {
		this.expYearOfGraduation = expYearOfGraduation;
	}

	public String getUniversityName() {
		return universityName;
	}

	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}

	public String getUniversityAddress() {
		return universityAddress;
	}

	public void setUniversityAddress(String universityAddress) {
		this.universityAddress = universityAddress;
	}
	
	

}
