package com.neu.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import com.neu.pojo.Candidate;
import com.neu.pojo.Job;
import com.neu.pojo.JobApp;
import com.neu.pojo.JobStatus;
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
	
	
	
	
	public int checkApplicationExists(Candidate candidate, String jobID) {
		// TODO Auto-generated method stub

		// organization = employer.getOrganization();
		Criteria criteria = getSession().createCriteria(JobApp.class);
		Criteria jobCriteria = criteria.createCriteria("job");
		Criteria candidateCriteria = criteria.createCriteria("candidate");
		jobCriteria.add(Restrictions.eq("jobID", Integer.parseInt(jobID)));
		candidateCriteria.add(Restrictions.eq("userId", candidate.getUserId()));

		JobApp jobApp = (JobApp) criteria.uniqueResult();

		if (jobApp != null)
			return jobApp.getJobApplicationID();
		else
			return 0;

	}
	
	public void addJobApp(String jobID, Candidate candidate) {
		try {
			Job job = getJobByID(jobID);
			begin();

			JobApp jobApp = new JobApp(job, candidate);
			jobApp.setCurrentJobStatus("New");

			JobStatus jobStatus = new JobStatus();
			jobStatus.setStatus("New");

			jobApp.getJobStatus().add(jobStatus);
			getSession().save(jobApp);
			jobStatus.setJobApp(jobApp);

			getSession().save(jobStatus);
			commit();
			close();
			return;
		} catch (HibernateException e) {
			e.printStackTrace();
			rollback();
		}
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
			q.setInteger("jobid", jobid);
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
