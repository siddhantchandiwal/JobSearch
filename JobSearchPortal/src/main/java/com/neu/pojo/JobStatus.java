package com.neu.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "JobStatus")
public class JobStatus {

	@Id
	@GeneratedValue
	@Column(name = "jobStatusId", unique = true, nullable = false)
	private int jobStatusId;
	
	@ManyToOne
	@JoinColumn(name = "jobAppID")
	private JobApp jobApp;
	
	@Column(name="status")
	private String status;

	public int getJobStatusId() {
		return jobStatusId;
	}

	public void setJobStatusId(int jobStatusId) {
		this.jobStatusId = jobStatusId;
	}

	public JobApp getJobApp() {
		return jobApp;
	}

	public void setJobApp(JobApp jobApp) {
		this.jobApp = jobApp;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
}
