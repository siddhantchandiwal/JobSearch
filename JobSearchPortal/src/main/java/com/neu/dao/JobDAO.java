package com.neu.dao;

import org.hibernate.HibernateException;

import com.neu.pojo.Job;
import com.neu.pojo.Organization;

public class JobDAO extends DAO{
	
	public void create(Job job, Organization org) {
		try {
			begin();
		//	System.out.println("inside DAO");

			job.setOrganization(org);
			getSession().save(job);

			commit();
			close();
			return;

		} catch (HibernateException e) {
			rollback();

		}
	}

}
