package com.neu.dao;

import java.util.List;

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
	
	
	
	public User validate(String userName, String password, String userType) {
		try {
			begin();
			Query query = getSession().createQuery(
					"from User u where u.userName = :userName and u.password = :password and u.userType = :userType");

			query.setString("userName", userName);
			query.setString("password", password);
			query.setString("userType", userType);

			User user = (User) query.uniqueResult();
			return user;

		} catch (HibernateException e) {
			System.out.println("Error occured");
		}

		return null;

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
	
	public void updatePersonalInfo(String userID, String streetLine1, String streetLine2, String city, String state, String country, String emailId, int phone, int zipCode) {
		// TODO Auto-generated method stub

		try {
			begin();
			Query query = getSession().createQuery("from User u where u.userId = :userID");
			query.setInteger("userID", Integer.parseInt(userID));
			User u = (User) query.uniqueResult();
			u.setStreetLine1(streetLine1);
			u.setStreetLine2(streetLine2);
			u.setCity(city);
			u.setState(state);
			u.setCountry(country);
			u.setEmailId(emailId);
			u.setPhone(phone);
			u.setZipCode(zipCode);
			getSession().update(u);
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
