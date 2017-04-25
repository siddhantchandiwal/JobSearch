package com.neu.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


import com.neu.dao.JobDAO;
import com.neu.dao.OrgDAO;
import com.neu.dao.UserDAO;
import com.neu.exception.CandidateException;
import com.neu.exception.UserException;
import com.neu.pojo.Candidate;
import com.neu.pojo.Job;
import com.neu.pojo.JobApp;
import com.neu.pojo.User;

@Controller
public class CandidateController {
	
	@Autowired
	@Qualifier("orgDAO")
	OrgDAO orgDAO;

	@Autowired
	@Qualifier("jobDAO")
	JobDAO jobDAO;

	@Autowired
	@Qualifier("userDAO")
	UserDAO userDAO;
	
	Candidate candidate;
	List<Job> jobList;
	
	@RequestMapping(value = "/Candidate/ViewJobs.htm", method = RequestMethod.GET)
	public ModelAndView initializeForm(HttpServletRequest request) {
		Candidate candidate = (Candidate) request.getSession().getAttribute("loggedUser");

		if (candidate != null) {
			List orgList = orgDAO.list();
			ModelAndView mv = new ModelAndView();
			mv.setViewName("ViewJobs");
			mv.addObject("orgList", orgList);

			return mv;
		} else {
			ModelAndView mv = new ModelAndView();

			mv.setViewName("Main");
			return mv;

		}
	}
	
	@RequestMapping(value="/Candidate/JobApply.htm", method = RequestMethod.GET)
	public ModelAndView jobApply(@RequestParam("jobID") String jobID, User user, HttpServletRequest req) throws MalformedURLException, IOException{
		HttpSession session = req.getSession();
		Candidate u = (Candidate) session.getAttribute("loggedUser"); 
		System.out.println("********"+u.getFileName());
		Candidate candidate = (Candidate) req.getSession().getAttribute("loggedUser");
		
		if(candidate!=null){
			int appID = jobDAO.checkApplicationExists(candidate, jobID);
			
			if(appID!=0){
				ModelAndView mav = new ModelAndView();
				mav.addObject("jobApplicationID", appID);
				mav.setViewName("JobAlreadyApplied");
				return mav;
			}else{
				jobDAO.addJobApp(jobID, candidate);
				ModelAndView mav = new ModelAndView();
				mav.addObject("jobID", jobID);
				mav.setViewName("JobApplied");
				//userDao.create(user.getUserName(), user.getPassword(), user.getFirstName(), user.getLastName(), user.getEmailId(),	user.getUserType());
				userDAO.sendSuccessfulMail(u, "Thanks for Applying");
				//UserDAO.sendMail(jobId, "Your Registration has been booked successfully");
				return mav;
			}
		} else {
			ModelAndView mv = new ModelAndView();
			mv.setViewName("Main");
			return mv;
		}
	}
	
	@RequestMapping(value = "/Candidate/ViewJobs.htm", method = RequestMethod.POST)
	public ModelAndView submitForm(@RequestParam("jobTitle") String jobTitle,@RequestParam("jobLocationCity") String jobLocationCity, HttpServletRequest request) {

		Candidate candidate = (Candidate) request.getSession().getAttribute("loggedUser");

		if (candidate != null) {
			jobList = jobDAO.searchJobs(jobTitle, jobLocationCity);

			ModelAndView mv = new ModelAndView();
			mv.addObject("jobList", jobList);
			mv.setViewName("search-result");
			return mv;
		} else {
			ModelAndView mv = new ModelAndView();

			mv.setViewName("Main");
			return mv;

		}
	}
	
	@RequestMapping(value = "/Candidate/ApplicationStatus.htm", method = RequestMethod.GET)
	public ModelAndView jobApplicationStatus(HttpServletRequest request){
		Candidate candidate = (Candidate) request.getSession().getAttribute("loggedUser");
		
		if(candidate!=null){
			List<JobApp> jobStatusList = jobDAO.getJobStatus(candidate);
			ModelAndView mav = new ModelAndView();
			mav.addObject("jobStatusList", jobStatusList);
			mav.setViewName("ApplicationStatus");
			return mav;
		}else{
			ModelAndView mav = new ModelAndView();
			mav.setViewName("Main");
			return mav;
		}
	}
	
	

}
