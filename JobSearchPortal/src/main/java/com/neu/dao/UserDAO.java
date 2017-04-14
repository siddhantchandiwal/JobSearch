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
import com.neu.pojo.AcademicProfile;
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

			email.setFromAddress("Coalition Job Search Portal", "donotreply.coalition@gmail.com");
			email.setSubject("Welcome Letter!");

			email.addRecipient(name,user.getEmailId(), Message.RecipientType.TO);
			StringBuffer sb=new StringBuffer();
			sb.append("Hello Aadesh Randeria,");
			sb.append("\n");
			sb.append("\n");
			sb.append("Thank you for taking out time and your interest in Coalition");
			sb.append("\n");
			sb.append("On the basis of the assessment, our Recruiting team is impressed and we would like to move ahead with further hiring process ");
			sb.append("\n");
			sb.append("We would like to have a Skype video call with you. Please provide your availability for the next 2 days");
			sb.append("\n");
			sb.append("\n");
			sb.append("Thank you again for your interest in Coalition");
			sb.append("\n");
			sb.append("\n");
			sb.append("- Coalition Recruitment Team");
			sb.append("\n");
			
			System.out.println("user id"+user.getEmailId());
			email.setText(sb.toString());
			new Mailer("smtp.gmail.com", 465, "donotreply.coalition@gmail.com", "Mh14eu7295",
					TransportStrategy.SMTP_SSL).sendMail(email);
			System.out.println("Sent message successfully....");
		}

	
	
	
	public User validate(String userName, String password) {
		try {
			begin();
			Query query = getSession().createQuery(
					"from User u where u.userName = :userName and u.password = :password");

			query.setString("userName", userName);
			query.setString("password", password);
			

			User user = (User) query.uniqueResult();
			return user;

		} catch (HibernateException e) {
			System.out.println("Error occured");
		}

		return null;

	}
	
	public void deleteAcademicDetails(AcademicProfile academicDetails) {
		// TODO Auto-generated method stub

		try {
			begin();

			getSession().delete(academicDetails);
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
	
	public void addAcademicDetails(AcademicProfile academicDetails, Candidate candidate) {
		// TODO Auto-generated method stub

		try {
			begin();
			// System.out.println("inside DAO");

			academicDetails.setCandidate(candidate);
			candidate.getAcademicProfile().add(academicDetails);
			getSession().save(academicDetails);
			commit();
			close();
			return;

		} catch (HibernateException e) {
			e.printStackTrace();
			rollback();

		}

	}
	
	public void editAcademicDetails(int academicDetailsID, String educationLevel, String major, double gpa, int startYear, int expYearOfGraduation, 
			String universityName, String universityAddress) {
		// TODO Auto-generated method stub

		try {

			begin();
			Query query = getSession().createQuery("from AcademicProfile academicprofile where academicprofile.academicDetailsID = :academicDetailsID");

			query.setInteger("academicDetailsID", academicDetailsID);

			AcademicProfile databasePD = (AcademicProfile) query.uniqueResult();
			databasePD.setEducationLevel(educationLevel);
			databasePD.setMajor(major);
			databasePD.setGpa(gpa);
			databasePD.setStartYear(startYear);
			databasePD.setExpYearOfGraduation(expYearOfGraduation);
			databasePD.setUniversityName(universityName);
			databasePD.setUniversityAddress(universityAddress);
			

		//	System.out.println("inside DAO");
			getSession().update(databasePD);
			commit();
			close();
			return;

		} catch (HibernateException e) {
			e.printStackTrace();
			rollback();

		}

	}
	
	public List<AcademicProfile> getAcademicDetails(Candidate candidate) {
		try {

			begin();
			Query query = getSession().createQuery("from AcademicProfile where candidate = :candidateID");
			query.setInteger("candidateID", candidate.getUserId());
			List<AcademicProfile> academicDetailsList = query.list();

			commit();
			close();
			return academicDetailsList;

		} catch (HibernateException e) {
			rollback();

		}
		return null;

	}
	
	public AcademicProfile getAcademicDetailsByID(String academicDetailsID) {
		// TODO Auto-generated method stub

		try {
			begin();
			Query query = getSession().createQuery("from AcademicProfile academicprofile where academicprofile.academicDetailsID = :academicDetailsID");

			query.setInteger("academicDetailsID", Integer.parseInt(academicDetailsID));

			AcademicProfile academicprofile = (AcademicProfile) query.uniqueResult();
			return academicprofile;

		} catch (HibernateException e) {
			System.out.println("Error catched");
		}

		return null;

	}
	
	
	public List<AcademicProfile> getAcademicProfile(Candidate candidate) {
		try {

			begin();
			Query query = getSession().createQuery("from AcademicProfile where candidate = :candidateID");
			query.setInteger("candidateID", candidate.getUserId());
			List<AcademicProfile> academicprofileList = query.list();

			commit();
			close();
			return academicprofileList;

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
			System.out.println("Error occured");
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
	
	public void updatePersonalInfo(int userID, String streetLine1, String streetLine2, String city, String state, String country, String emailId, int phone, int zipCode) {
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
			u.setInteger("phone",phone);
			u.setInteger("zipCode",zipCode);
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
			System.out.println("********************************************");
			Query query = getSession().createQuery("update User set filename = :filename where userId = :userID");
			System.out.println("??????????????????????????"+userID);
			query.setInteger("userID", userID);
			System.out.println("------------------------"+fileName);
			query.setString("filename", fileName);
			query.executeUpdate();
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
