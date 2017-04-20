package com.neu.dao;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;

import org.codemonkey.simplejavamail.Email;
import org.codemonkey.simplejavamail.Mailer;
import org.codemonkey.simplejavamail.TransportStrategy;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

import org.springframework.stereotype.Component;


import com.neu.exception.UserException;
import com.neu.pojo.Profile;
import com.neu.pojo.Admin;
import com.neu.pojo.Candidate;
import com.neu.pojo.Employer;
import com.neu.pojo.User;


@Component
public class UserDAO extends DAO{
	
	
	
	public static void sendMail(User user, String message) throws MalformedURLException, IOException {
		
		   String fname = user.getFirstName();
		   String lname = user.getLastName();
		   String name = fname.concat(lname);
			Email email = new Email();

			email.setFromAddress("Online Job Search Portal", "donotreply.coalition@gmail.com");
			email.setSubject("Welcome Letter!");

			email.addRecipient(name,user.getEmailId(), Message.RecipientType.TO);
			StringBuffer sb=new StringBuffer();
			sb.append("Hello User,");
			sb.append("\n");
			sb.append("\n");
			sb.append("Thank you for taking out time and your interest in Online Job Search Portal");
			
			sb.append("\n");
			
			System.out.println("user id"+user.getEmailId());
			email.setText(sb.toString());
			new Mailer("smtp.gmail.com", 465, "donotreply.coalition@gmail.com", "Mh14eu7295",
					TransportStrategy.SMTP_SSL).sendMail(email);
			System.out.println("Sent message successfully....");
		}

	
	
	
	public User validate(String userName, String password) throws UserException {
		try {
			begin();
			Query query = getSession().createQuery(
					"from User u where u.userName = :userName and u.password = :password");

			query.setString("userName", userName);
			query.setString("password", password);
			

			User user = (User) query.uniqueResult();
			commit();
			close();
			return user;

		} catch (HibernateException e) {
			rollback();
			throw new UserException("Could not get user " + userName, e);
		}

	}
	
	public void deleteProfileDetails(Profile profileDetails) {
		// TODO Auto-generated method stub

		try {
			begin();

			getSession().delete(profileDetails);
			commit();
			close();

		} catch (HibernateException e) {
			System.out.println("Error occured");
		}

	}
	
	public User register(User u)
			throws UserException {
		try {
			begin();
			System.out.println("inside DAO");			
			getSession().save(u);
			commit();
			return u;

		} catch (HibernateException e) {
			rollback();
			throw new UserException("Exception while creating user: " + e.getMessage());
		}
	}
	
	
	public void create(String userName, String password, String firstName, String lastName, String emailId, String userType) {
		try {
			begin();
			if (userType.equalsIgnoreCase("employer")) {
				Employer employer = new Employer(firstName, lastName, userName, password, emailId,  userType);
				getSession().save(employer);

			} else if (userType.equalsIgnoreCase("candidate")) {
				Candidate candidate = new Candidate(firstName, lastName, userName, password, emailId, userType);
				getSession().save(candidate);

			} else if (userType.equalsIgnoreCase("Admin")) {
				Admin admin = new Admin(firstName, lastName, userName, password, emailId, userType);
				getSession().save(admin);

			}
			commit();
			close();
			return;

		} catch (HibernateException e) {
			rollback();

		}
	}
	
	public void addProfileDetails(Profile profileDetails, Candidate candidate) {
		// TODO Auto-generated method stub

		try {
			begin();
			// System.out.println("inside DAO");

			System.out.println("Hello I am here");
			profileDetails.setCandidate(candidate);
			candidate.getProfile().add(profileDetails);
			getSession().save(profileDetails);
			
			System.out.println("I have reached ******************");
			
			commit();
			close();
			return;

		} catch (HibernateException e) {
			e.printStackTrace();
			rollback();

		}

	}
	
	public void editProfileDetails(int profileID, String educationLevel, String major, double gpa, int startYear, int expYearOfGraduation, 
			String universityName, String universityAddress, String companyName, String companyType, String jobTitle, String annualStartPay, String annualEndPay, 
			String companyCity, String companyState, String companyCountry, String companyZipCode) {
		// TODO Auto-generated method stub

		try {

			begin();
			Query query = getSession().createQuery("update Profile set educationLevel = :educationLevel, major = :major, gpa = :gpa, startYear = :startYear, "
					+ "expYearOfGraduation = :expYearOfGraduation, universityName = :universityName, universityAddress = :universityAddress, companyName = :companyName, "
					+ "companyType = :companyType, jobTitle = :jobTitle, annualStartPay = :annualStartPay, annualEndPay = :annualEndPay, companyCity = :companyCity ,"
					+ "companyState = :companyState, companyCountry = :companyCountry, companyZipCode = :companyZipCode where  profileID = :profileID");
			
			query.setString("educationLevel", educationLevel);
			query.setString("major", major);
			query.setDouble("gpa", gpa);
			query.setInteger("startYear", startYear);
			query.setInteger("expYearOfGraduation", expYearOfGraduation);
			query.setString("universityName", universityName);
			query.setString("universityAddress", universityAddress);
			query.setString("companyName", companyName);
			query.setString("companyType", companyType);
			query.setString("jobTitle", jobTitle);
			query.setString("annualStartPay", annualStartPay);
			query.setString("annualEndPay", annualEndPay);
			query.setString("companyCity", companyCity);
			query.setString("companyState", companyState);
			query.setString("companyCountry", companyCountry);
			query.setString("companyZipCode", companyZipCode);
			
			
			
			query.executeUpdate();
			commit();
			close();
			return;

		} catch (HibernateException e) {
			e.printStackTrace();
			rollback();
		}

	}
	
	public List<Profile> getProfileDetails(Candidate candidate) {
		try {

			begin();
			Query query = getSession().createQuery("from Profile where candidate = :candidateID");
			query.setInteger("candidateID", candidate.getUserId());
			List<Profile> profileDetailsList = query.list();
			
			

			commit();
			close();
			return profileDetailsList;

		} catch (HibernateException e) {
			rollback();

		}
		return null;

	}
	
	public Profile getProfileDetailsByID(String profileDetailsID) {
		// TODO Auto-generated method stub

		try {
			begin();
			Query query = getSession().createQuery("from Profile academicprofile where academicprofile.profileID = :profileID");

			query.setInteger("profileDetailsID", Integer.parseInt(profileDetailsID));

			Profile profile = (Profile) query.uniqueResult();
			return profile;

		} catch (HibernateException e) {
			System.out.println("Error catched");
		}

		return null;

	}
	
	
	public List<Profile> getProfile(Candidate candidate) {
		try {

			begin();
			Query query = getSession().createQuery("from Profile where candidate = :candidateID");
			query.setInteger("candidateID", candidate.getUserId());
			List<Profile> profileList = query.list();

			commit();
			close();
			return profileList;

		} catch (HibernateException e) {
			rollback();

		}
		return null;

	}
	
	public boolean checkIfUniqueUserNameExist(String userName) {
		// TODO Auto-generated method stub
		try {
			begin();
			Query query = getSession().createQuery("from User u where u.userName = :userName");
			query.setString("userName", userName);
			User user = (User) query.uniqueResult();
			if (user == null)
				return true;
			else
				return false;

		} catch (HibernateException e) {
			//System.out.println("Error occured");
		}

		return false;

	}

	public boolean checkIfUniqueEmail(String emailId){
		try{
			begin();
			System.out.println("Inside email unique part********************");
			Query query = getSession().createQuery("from User u where u.emailId like :emailId");
			
			query.setString("emailId", emailId);
			User user = (User) query.uniqueResult();
			System.out.println("Query is executed now/////////////////////////////////////////");
			if(user == null)
				return true;
			else
				return false;
		}catch (HibernateException e){
			//System.out.println("Error occured");
		}
		return false;
	}
	
	
	
	
	public void updatePersonalInfo(User user) {
		// TODO Auto-generated method stub

		try {
			begin();
			getSession().saveOrUpdate(user);
			commit();
			close();
			return;

		} catch (HibernateException e) {
			rollback();
			e.printStackTrace();

		}

	}
	
	public void updatePersonalInfo(int userID, String streetLine1, String streetLine2, String city, String state, String country, String emailId, long phone, long zipCode) {
		// TODO Auto-generated method stub

		try {
			begin();
			Query u = getSession().createQuery("update User set streetLine1 = :streetLine1,streetLine2=:streetLine2,"
					+ "city=:city,state=:state,country=:country,emailId=:emailId,phone=:phone,zipCode=:zipCode where userId = :userId");
			System.out.println("??????????????????????????"+userID);
			u.setInteger("userId", userID);
			u.setString("streetLine1",streetLine1);
			u.setString("streetLine2",streetLine2);
			u.setString("city",city);
			u.setString("state",state);
			u.setString("country",country);
			u.setString("emailId",emailId);
			u.setLong("phone",phone);
			u.setLong("zipCode",zipCode);
			u.executeUpdate();
			commit();
			close();
			return;

		} catch (HibernateException e) {
			e.printStackTrace();
			rollback();
		}
	}
	
	

	
	public void updateFile(int userID, String fileName){
		try{
			begin();
			System.out.println("********************************************Update file");
			Query query = getSession().createQuery("update User set fileName = :fileName where userId = :userID");
			System.out.println("??????????????????????????"+userID);
			query.setInteger("userID", userID);
			System.out.println("------------------------"+fileName);
			query.setString("fileName", fileName);
			int r=query.executeUpdate();
			
			System.out.println("Count:"+r);
			
			commit();
			close();
			return;

		} catch (HibernateException e) {
			e.printStackTrace();
			rollback();

		}

			
			
		
	}
	
	
	
	public Candidate getCandidateID(String candidateID) {
		// TODO Auto-generated method stub

		Criteria criteria = getSession().createCriteria(Candidate.class);
		criteria.add(Restrictions.eq("userId", Integer.parseInt(candidateID)));
		Candidate candidate = (Candidate) criteria.uniqueResult();
		return candidate;

	}
	
	

}
