package com.neu.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Organziation")
public class Organization {
	
	@Id
	@GeneratedValue
	@Column(name = "organizationID", unique = true, nullable = false)
	private int organizationID;

	@Column(name = "organizationName")
	private String organizationName;
	
	@Column(name = "businessType")
	private String businessType;
	
	public int getOrganizationID() {
		return organizationID;
	}

	public void setOrganizationID(int organizationID) {
		this.organizationID = organizationID;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public String getBusinessType() {
		return businessType;
	}

	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}
	
	public Organization() {

	}
	
	public Organization(String orgName, String orgType) {
		this.organizationName = orgName;
		this.businessType = orgType;
	}
	
	
}
