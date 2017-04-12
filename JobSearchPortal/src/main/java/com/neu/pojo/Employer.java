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
	
	@Transient
	private String orgName;

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "organizationID")
	private Organization organization;

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}
	
	
	
	public Employer() {
		
	}

	public Employer(String firstName, String lastName, String userName, String password,String emailId, String userType) {

		super(firstName, lastName, userName, password, emailId, userType);
	}

}
