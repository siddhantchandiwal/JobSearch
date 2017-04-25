package com.neu.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import com.neu.pojo.Employer;
import com.neu.pojo.Organization;
import com.neu.pojo.User;


@Component
public class EmpDAO extends DAO {
	
	
	public List<User> listPaginatedEmployersUsingCriteria(int firstResult, int maxResults) {
        
	      try {
	            begin();
	            Criteria criteria = getSession().createCriteria(User.class);
	            criteria.setFirstResult(firstResult);
	            criteria.setMaxResults(maxResults);
	            criteria.add(Restrictions.eq("userType", "Employer"));
	            List<User> users = criteria.list();
	            
	            commit();
	            close();
	            return users;

	      } catch (HibernateException e) {
	            e.printStackTrace();
	        }
	        return null;
	    }
	
	
		public int getTotalCount(){
    	try{
    		begin();
    		Query query=getSession().createQuery("from User u where u.userType = :type ");
    		query.setString("type", "Employer");
    		List<User> user = query.list();
    		int sizeTotal = user.size();
    		commit();
    		close();
    		return sizeTotal;
    		
    	}
    	catch(HibernateException e)
    	{
    		System.out.println("Could not fetch total size of user list");
    	}
		return 0;
    }
		
		
		

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
