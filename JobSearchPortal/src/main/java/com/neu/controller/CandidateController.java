package com.neu.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import com.neu.dao.JobDAO;
import com.neu.dao.OrgDAO;
import com.neu.dao.UserDAO;
import com.neu.exception.UserException;
import com.neu.pojo.Candidate;
import com.neu.pojo.Job;

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
	
	@RequestMapping(value = "/ViewJobs.htm", method = RequestMethod.GET)
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
	
	@RequestMapping(value = "/ViewJobs.htm", method = RequestMethod.POST)
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

}
