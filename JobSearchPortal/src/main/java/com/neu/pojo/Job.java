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
@Table(name = "Job")
public class Job {
	
	@Id
	@GeneratedValue
	@Column(name = "jobID", unique = true, nullable = false)
	private int jobID;

	@Column(name = "jobTitle")
	private String jobTitle;
	
	@Column(name = "jobDescription")
	private String jobDescription;
	
	@Column(name = "qualification")
	private String qualification;
	
	@Column(name = "jobLocationCity")
	private String jobLocationCity;
	
	@Column(name = "jobLocationState")
	private String jobLocationState;
	
	@Column(name = "jobLocationCountry")
	private String jobLocationCountry;
		
	@Column(name = "vacancies")
	private String vacancies;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "organizationID")
	private Organization organization;
	
	public Job(){
		
	}
	
	public Job(String jobTitle, String jobDescription, String qualification, String jobLocationCity, String jobLocationState,
			String jobLocationCountry, String vacancies, Organization org){
		this.jobTitle=jobTitle;
		this.jobDescription=jobDescription;
		this.qualification=qualification;
		this.jobLocationCity=jobLocationCity;
		this.jobLocationState=jobLocationState;
		this.jobLocationCountry=jobLocationCountry;
		this.vacancies=vacancies;
		this.organization=org;		
	}

	public int getJobID() {
		return jobID;
	}

	public void setJobID(int jobID) {
		this.jobID = jobID;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getJobLocationCity() {
		return jobLocationCity;
	}

	public void setJobLocationCity(String jobLocationCity) {
		this.jobLocationCity = jobLocationCity;
	}

	public String getJobLocationState() {
		return jobLocationState;
	}

	public void setJobLocationState(String jobLocationState) {
		this.jobLocationState = jobLocationState;
	}

	public String getJobLocationCountry() {
		return jobLocationCountry;
	}

	public void setJobLocationCountry(String jobLocationCountry) {
		this.jobLocationCountry = jobLocationCountry;
	}

	public String getVacancies() {
		return vacancies;
	}

	public void setVacancies(String vacancies) {
		this.vacancies = vacancies;
	}

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}
	
	
}
