package com.neu.dao;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;


import com.neu.pojo.Admin;
import com.neu.pojo.Candidate;
import com.neu.pojo.Employer;
import com.neu.pojo.User;

@Component
public class UserDAO extends DAO{
	
	public void create(String userName, String password, String firstName, String lastName, String userType) {
		try {
			begin();
			if (userType.equalsIgnoreCase("employer")) {
				Employer employer = new Employer(firstName, lastName, userName, password, userType);
				getSession().save(employer);

			} else if (userType.equalsIgnoreCase("candidate")) {
				Candidate candidate = new Candidate(firstName, lastName, userName, password, userType);
				getSession().save(candidate);

			} else if (userType.equalsIgnoreCase("Admin")) {
				Admin admin = new Admin(firstName, lastName, userName, password, userType);
				getSession().save(admin);

			}
			commit();
			close();
			return;

		} catch (HibernateException e) {
			rollback();

		}
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
	
	public Candidate getCandidateID(String candidateID) {
		// TODO Auto-generated method stub

		Criteria criteria = getSession().createCriteria(Candidate.class);
		criteria.add(Restrictions.eq("userId", Integer.parseInt(candidateID)));
		Candidate candidate = (Candidate) criteria.uniqueResult();
		return candidate;

	}

}
