package com.neu.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.stereotype.Component;

import com.neu.pojo.Employer;
import com.neu.pojo.Organization;


@Component
public class EmpDAO extends DAO {
	
	

	public void updateEmployerProfile(Employer employer) {
		try {
			begin();
			getSession().update(employer);
			commit();
			close();
			return;

		} catch (HibernateException e) {
			e.printStackTrace();
			rollback();

		}

	}

	public Organization getOrganization(Employer employer) {
		try {
			begin();
			Query q = getSession().createQuery("from Organization where organizationID = :orgID");
			q.setString("orgID", (String.valueOf(employer.getOrganization().getOrganizationID())));
			Organization org = (Organization) q.uniqueResult();
			commit();
			return org;
		} catch (HibernateException e) {
			rollback();

		}
		return null;
	}

}
