package com.neu.pojo;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "Candidate")
@PrimaryKeyJoinColumn(name = "userId")
public class Candidate extends User{
	
	public Candidate() {

	}

	public Candidate(String firstName, String lastName, String userName, String password, String userType) {
		super(firstName, lastName, userName, password, userType);

	}

}
