package com.neu.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "Candidate")
@PrimaryKeyJoinColumn(name = "userId")
public class Candidate extends User{
	
	public Candidate() {

	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "candidate")
	private Set<ProfessionalDetails> professionalDetails = new HashSet<ProfessionalDetails>();

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "candidate")
	private Set<AcademicProfile> academicProfile = new HashSet<AcademicProfile>();

	public Candidate(String firstName, String lastName, String userName, String password, String emailId, String userType) {
		super(firstName, lastName, userName, password, emailId, userType);

	}

	public Set<ProfessionalDetails> getProfessionalDetails() {
		return professionalDetails;
	}

	public void setProfessionalDetails(Set<ProfessionalDetails> professionalDetails) {
		this.professionalDetails = professionalDetails;
	}

	public Set<AcademicProfile> getAcademicProfile() {
		return academicProfile;
	}

	
	public void setAcademicDetails(Set<AcademicProfile> academicProfile) {
		this.academicProfile = academicProfile;
	}
	
	

}
