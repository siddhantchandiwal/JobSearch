package com.neu.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name = "Employer")
@PrimaryKeyJoinColumn(name = "userId")
public class Employer extends User{
	
	
	
	public Employer() {

	}

	public Employer(String firstName, String lastName, String userName, String password, String userType) {

		super(firstName, lastName, userName, password, userType);
	}

}
