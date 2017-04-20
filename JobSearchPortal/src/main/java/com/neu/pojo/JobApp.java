package com.neu.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "JobApp")
public class JobApp {
	@Id
	@GeneratedValue
	@Column(name = "jobApplicationID", unique = true, nullable = false)
	private int jobApplicationID;
	
	@ManyToOne
	@JoinColumn(name = "jobID")
	private Job job;
	
	@ManyToOne
	@JoinColumn(name = "userId")
	private Candidate candidate;
	
	@OneToMany(mappedBy = "jobApp")
	private Set<JobStatus> jobStatus = new HashSet<JobStatus>();
	
	@Column(name="currentJobStatus")
	private String currentJobStatus;
	
	public JobApp(){
		
	}
	
	public JobApp(Job job, Candidate candidate){
		this.job=job;
		this.candidate=candidate;
	}

	public int getJobApplicationID() {
		return jobApplicationID;
	}

	public void setJobApplicationID(int jobApplicationID) {
		this.jobApplicationID = jobApplicationID;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

	public Set<JobStatus> getJobStatus() {
		return jobStatus;
	}

	public void setJobStatus(Set<JobStatus> jobStatus) {
		this.jobStatus = jobStatus;
	}

	public String getCurrentJobStatus() {
		return currentJobStatus;
	}

	public void setCurrentJobStatus(String currentJobStatus) {
		this.currentJobStatus = currentJobStatus;
	}
	
	
	

}
