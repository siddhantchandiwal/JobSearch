package com.neu.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.neu.exception.UserException;
import com.neu.pojo.Job;
import com.neu.pojo.Organization;

public class JobDAO extends DAO{
	
	
	public List<Job> searchJobs(String jobTitle, String jobLocationCity) {

		Criteria c = getSession().createCriteria(Job.class);


		if (!jobTitle.equalsIgnoreCase(""))
			c.add(Restrictions.ilike("jobTitle", jobTitle, MatchMode.ANYWHERE));


		if (!jobLocationCity.equalsIgnoreCase("ANY"))
			c.add(Restrictions.ilike("jobLocationCity", jobLocationCity, MatchMode.ANYWHERE));

		

		List<Job> jobList = c.list();

		return jobList;

	}
	
	
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
	
	public Job getJobByID(String jobID) {

		int jobid = Integer.parseInt(jobID);

		try {
			begin();
			Query q = getSession().createQuery("from Job where jobID = :jobid");
			q.setInteger("jid", jobid);
			Job job = (Job) q.uniqueResult();
			commit();
			close();
			return job;
		} catch (HibernateException e) {
			rollback();

		}
		return null;

	}

}
