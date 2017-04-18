package com.neu.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;



@Entity
@Table(name = "Candidate")
@PrimaryKeyJoinColumn(name = "userId")
public class Candidate extends User{
	
	public Candidate() {

	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "candidate")
	private Set<Profile> profile = new HashSet<Profile>();

	public Candidate(String firstName, String lastName, String userName, String password, String emailId, String userType) {
		super(firstName, lastName, userName, password, emailId, userType);

	}


	public Set<Profile> getProfile() {
		return profile;
	}

	public void setProfile(Set<Profile> profile) {
		this.profile = profile;
	}


	
	

}
