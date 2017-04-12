package com.neu.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import com.neu.dao.UserDAO;
import com.neu.pojo.AcademicProfile;
import com.neu.pojo.Candidate;
import com.neu.validator.AcademicValidator;

@Controller
public class AcademicController {
	
	@Autowired
	@Qualifier("userDAO")
	UserDAO userDAO;
	
	@Autowired
	@Qualifier("academicValidator")
	AcademicValidator academicValidator;
	
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(academicValidator);

	}

	@RequestMapping(value = "/EditAcademicDetails.htm", method = RequestMethod.GET)
	public ModelAndView editAcademicDetails(@RequestParam("adID") String academicDetailsID, HttpServletRequest request) {

		Candidate candidate = (Candidate) request.getSession().getAttribute("loggedUser");
		if (candidate != null) {
			AcademicProfile academicProfile = userDAO.getAcademicDetailsByID(academicDetailsID);

			ModelAndView mav = new ModelAndView();
			mav.addObject("academicDetails", academicProfile);
			mav.setViewName("EditAcademicDetails");
			return mav;
		} else {

			ModelAndView mav = new ModelAndView();

			mav.setViewName("Main");
			return mav;
		}
	}
	
	@RequestMapping(value = "/ViewAcadDetails.htm", method = RequestMethod.GET)
	public ModelAndView viewAcademicDetails(HttpServletRequest request) {

		Candidate candidate = (Candidate) request.getSession().getAttribute("loggedUser");

		if (candidate != null) {

			List list = userDAO.getAcademicProfile(candidate);
			ModelAndView mav = new ModelAndView();
			mav.addObject("academicDetailsList", list);
			mav.setViewName("ViewAcadDetails");
			return mav;
		} else {
			ModelAndView mv = new ModelAndView();
			mv.setViewName("Main");
			return mv;

		}
	}
	
	
	@RequestMapping(value = "/EditAD.htm", method = RequestMethod.GET)
	public String handlingCode3() {
		return "Main";
	}

	@RequestMapping(value = "/EditAD.htm", method = RequestMethod.POST)
	public ModelAndView editADintoDB(@ModelAttribute("academicDetails") AcademicProfile academicDetails,
			BindingResult result, @RequestParam("ID") String ID, HttpServletRequest request) {

		academicValidator.validate(academicDetails, result);
		if (result.hasErrors()) {
			ModelAndView mv = new ModelAndView();
			mv.addObject("academicDetails", academicDetails);
			mv.setViewName("AddEducation");
			return mv;

		}

		Candidate candidate = (Candidate) request.getSession().getAttribute("loggedUser");

		userDAO.editAcademicDetails(Integer.parseInt(ID), academicDetails.getEducationLevel(),academicDetails.getMajor(), academicDetails.getGpa(),
				academicDetails.getStartYear(), academicDetails.getExpYearOfGraduation(), academicDetails.getUniversityName(), academicDetails.getUniversityAddress());

		List list = userDAO.getAcademicDetails(candidate);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("academicDetailsList", list);
		mv.setViewName("ViewAcadDetails");
		return mv;

	}
	
	@RequestMapping(value = "/addMoreAcademicDetails.htm", method = RequestMethod.POST)
	public String addAcademicDetails(@ModelAttribute("academicDetails") AcademicProfile academicProfile, BindingResult result, HttpServletRequest request) {

		Candidate candidate = (Candidate) request.getSession().getAttribute("loggedUser");

		if (candidate != null) {
			return "AcademicDetails";
		} else {
			return "Main";
		}
	}
	
	@RequestMapping(value = "/addMoreAcademicDetails.htm", method = RequestMethod.GET)
	public ModelAndView handlingCode2() {
		return new ModelAndView("Main","main","user");

	}

	@RequestMapping(value = "/addAD.htm", method = RequestMethod.GET)
	public ModelAndView handlingCode1() {
		return new ModelAndView("Main","main","user");

	}
	
	@RequestMapping(value = "/addAD.htm", method = RequestMethod.POST)
	public ModelAndView addAcademicDetailstoDB(@ModelAttribute("academicDetails") AcademicProfile academicDetails, BindingResult result, HttpServletRequest request) {

		Candidate candidate = (Candidate) request.getSession().getAttribute("loggedUser");
		if (candidate != null) {
			academicValidator.validate(academicDetails, result);
			if (result.hasErrors()) {
				ModelAndView mv = new ModelAndView();
				mv.addObject("academicDetails", academicDetails);
				mv.setViewName("AddEducation");
				return mv;
			}
			userDAO.addAcademicDetails(academicDetails, candidate);
			List l = userDAO.getAcademicDetails(candidate);
			ModelAndView mav = new ModelAndView();
			mav.addObject("academicDetailsList", l);
			mav.setViewName("ViewAcadDetails");
			return mav;
		} else {
			ModelAndView mav = new ModelAndView();
			mav.setViewName("Main");
			return mav;
		}
	}
}
