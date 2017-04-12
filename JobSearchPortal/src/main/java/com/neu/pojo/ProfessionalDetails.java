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
@Table(name = "ProfessionalDetails")
public class ProfessionalDetails {
	
	@Id
	@GeneratedValue
	@Column(name = "professionalDetailsID", unique = true, nullable = false)
	int professionalDetailsID;
	
	@Column(name = "companyName")
	String companyName;
	
	@Column(name = "companyType")
	String companyType;
	
	@Column(name = "jobTitle")
	String jobTitle;
	
	@Column(name = "annualStartPay")
	String annualStartPay;
	
	@Column(name = "annualEndPay")
	String annualEndPay;
	
	@Column(name = "companyCity")
	String companyCity;
	
	@Column(name = "companyState")
	String companyState;
	
	@Column(name = "companyCountry")
	String companyCountry;
	
	@Column(name = "companyZipCode")
	String companyZipCode;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "candidate", nullable = false)
	Candidate candidate;

	public int getProfessionalDetailsID() {
		return professionalDetailsID;
	}

	public void setProfessionalDetailsID(int professionalDetailsID) {
		this.professionalDetailsID = professionalDetailsID;
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

	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}
	
}
