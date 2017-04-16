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
@Table(name = "Profile")
public class Profile {
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "candidate", nullable = false)
	private Candidate candidate;
	
	@Id
	@GeneratedValue
	@Column(name = "profileID", unique = true, nullable = false)
	int profileID;
	
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
	
	@Column(name = "companyName")
	private String companyName;
	
	@Column(name = "companyType")
	private String companyType;
	
	@Column(name = "jobTitle")
	private String jobTitle;
	
	@Column(name = "annualStartPay")
	private String annualStartPay;
	
	@Column(name = "annualEndPay")
	private String annualEndPay;
	
	@Column(name = "companyCity")
	private String companyCity;
	
	@Column(name = "companyState")
	private String companyState;
	
	@Column(name = "companyCountry")
	private String companyCountry;
	
	@Column(name = "companyZipCode")
	private String companyZipCode;
	

	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
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

	public int getProfileID() {
		return profileID;
	}

	public void setProfileID(int profileID) {
		this.profileID = profileID;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyType() {
		return companyType;
	}

	public void setCompanyType(String companyType) {
		this.companyType = companyType;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getAnnualStartPay() {
		return annualStartPay;
	}

	public void setAnnualStartPay(String annualStartPay) {
		this.annualStartPay = annualStartPay;
	}

	public String getAnnualEndPay() {
		return annualEndPay;
	}

	public void setAnnualEndPay(String annualEndPay) {
		this.annualEndPay = annualEndPay;
	}

	public String getCompanyCity() {
		return companyCity;
	}

	public void setCompanyCity(String companyCity) {
		this.companyCity = companyCity;
	}

	public String getCompanyState() {
		return companyState;
	}

	public void setCompanyState(String companyState) {
		this.companyState = companyState;
	}

	public String getCompanyCountry() {
		return companyCountry;
	}

	public void setCompanyCountry(String companyCountry) {
		this.companyCountry = companyCountry;
	}

	public String getCompanyZipCode() {
		return companyZipCode;
	}

	public void setCompanyZipCode(String companyZipCode) {
		this.companyZipCode = companyZipCode;
	}
	
	
	
	

}
