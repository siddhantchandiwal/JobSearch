package com.neu.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.neu.pojo.Organization;

public class OrgDAO extends DAO{
	
	public void create(String organizationName, String businessType) {
		try {
			begin();
			Organization org = new Organization(organizationName, businessType);
			getSession().save(org);

			commit();
			close();
			return;

		} catch (HibernateException e) {
			rollback();

		}
	}
	
	public Organization get(String orgName) {
		try {
			begin();
			Query query = getSession().createQuery("from Organization where organizationName = :orgName");
			query.setString("orgName", orgName);
			Organization org = (Organization) query.uniqueResult();
			commit();
			return org;
		} catch (HibernateException e) {
			rollback();

		}
		return null;
	}
	
	public List list() {
		try {
			begin();
			Query q = getSession().createQuery("from Organization");
			List list = q.list();
			commit();
			return list;
		} catch (HibernateException e) {
			rollback();
			return null;

		}
	}

}
