package com.neu.pojo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Table(name = "User")
@Inheritance(strategy = InheritanceType.JOINED)
public class User{
	
	@Id
	@GeneratedValue
	@Column(name = "userId", unique = true, nullable = false)
	private int userId;
	
	
	@Transient
	private List<CommonsMultipartFile> document;   //for DataBinder to bind <input type="file".../>
	  //will not be mapped for Hibernate as we store the file in the FileSystem
	  //file will be placed into this field by DataBinder
	  //file is in the memory. needs to be transferred to the FileSystem using java.io.file
	@Column(name = "filename")
	private String filename;  
	
	
	
	public List<CommonsMultipartFile> getDocument() {
		return document;
	}

	public void setDocument(List<CommonsMultipartFile> document) {
		this.document = document;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	@Column(name = "userName")
	private String userName;

	@Column(name = "password")
	private String password;
	
	@Column(name = "userType")
	private String userType;
	
	@Column(name = "firstName")
	private String firstName;

	@Column(name = "lastName")
	private String lastName;
	
	@Column(name = "emailId")
	private String emailId;
	
	@Column(name = "streetLine1")
	private String streetLine1;
	
	@Column(name = "streetLine2")
	private String streetLine2;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "state")
	private String state;
	
	@Column(name = "country")
	private String country;
	
	@Column(name = "zipCode")
	private int zipCode;
	
	@Column(name = "phone")
	private int phone;
	
	public User() {
	}

	public User(String firstName, String lastName, String userName, String password, String emailId, String userType) {

		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.emailId = emailId;
		this.userType = userType;

	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getStreetLine1() {
		return streetLine1;
	}

	public void setStreetLine1(String streetLine1) {
		this.streetLine1 = streetLine1;
	}

	public String getStreetLine2() {
		return streetLine2;
	}

	public void setStreetLine2(String streetLine2) {
		this.streetLine2 = streetLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	

	
	

}
