package com.neu.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.neu.dao.EmpDAO;
import com.neu.dao.JobDAO;
import com.neu.dao.OrgDAO;
import com.neu.dao.UserDAO;
import com.neu.pojo.Candidate;
import com.neu.pojo.Employer;
import com.neu.pojo.Job;
import com.neu.pojo.Organization;

@Controller
public class EmployerController {
	
	@Autowired
	@Qualifier("orgDAO")
	OrgDAO orgDAO;

	@Autowired
	@Qualifier("empDAO")
	EmpDAO empDAO;

	@Autowired
	@Qualifier("jobDAO")
	JobDAO jobDAO;

	@Autowired
	@Qualifier("userDAO")
	UserDAO userDAO;

	Employer employer;
	
	@ModelAttribute("employer")
	public Employer populateEmployer(HttpServletRequest request) {
		employer = (Employer) request.getSession().getAttribute("loggedUser");
		return employer;
	}
	
	@RequestMapping(value = "/EmpProfile.htm", method = RequestMethod.GET)
	public ModelAndView initializeForm(@ModelAttribute("employer") Employer employer) {
		if (employer != null) {
			List orgList = orgDAO.list();
			ModelAndView mv = new ModelAndView();
			mv.setViewName("EmpProfile");
			mv.addObject("orgList", orgList);
			return mv;
			
		} else {
			ModelAndView mav = new ModelAndView();
			mav.setViewName("Main");

			return mav;
		}
	}
	
	@RequestMapping(value = "/EmpProfile.htm", method = RequestMethod.POST)
	public ModelAndView submitForm(@ModelAttribute("employer") Employer employer) {

		String orgName = employer.getOrgName();
		if (!orgName.equals("")) {
			Organization org = orgDAO.get(orgName);
			employer.setOrganization(org);
		}
		empDAO.updateEmployerProfile(employer);
		return new ModelAndView("ProfileSave","save", "user");
	}
	
	@RequestMapping(value = "/AddNewJob.htm", method = RequestMethod.GET)
	public ModelAndView submitAddJobsForm(@ModelAttribute("job") Job job) {

		return new ModelAndView("AddNewJob","addjob","user");
	}

	@RequestMapping(value = "/AddNewJob.htm", method = RequestMethod.POST)
	public ModelAndView AddJobsForm(@ModelAttribute("job") Job job) {

		Organization org = empDAO.getOrganization(employer);

		jobDAO.create(job, org);

		return new ModelAndView("JobAdded","jobadded", "user");
	}

	@RequestMapping(value = "/CompleteProfile.htm", method = RequestMethod.GET)
	public ModelAndView viewCompleteProfile(@RequestParam("applicantID") String candidateID) {

		System.out.println("Profile to view " + candidateID);
		Candidate candidate = userDAO.getCandidateID(candidateID);

		ModelAndView mv = new ModelAndView();
		mv.addObject("candidate", candidate);
		mv.setViewName("CompleteProfile");
		return mv;
	}

}
