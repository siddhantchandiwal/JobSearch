package com.neu.pojo;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="Admin")
@PrimaryKeyJoinColumn(name="userId")
public class Admin extends User {

	public Admin()
	{
		
	}
	
	public Admin(String firstName, String lastName, String userName, String password,String userType)
	{
		
		super(firstName,lastName,userName,password,userType);
	}
}
