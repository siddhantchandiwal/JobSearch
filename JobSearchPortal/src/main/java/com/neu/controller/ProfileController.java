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
import com.neu.pojo.Profile;
import com.neu.pojo.Candidate;
import com.neu.validator.ProfileValidator;

@Controller
public class ProfileController {
	
	@Autowired
	@Qualifier("userDAO")
	UserDAO userDAO;
	
	@Autowired
	@Qualifier("profileValidator")
	ProfileValidator profileValidator;
	
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(profileValidator);

	}

	@RequestMapping(value = "/Candidate/EditProfileDetails.htm", method = RequestMethod.GET)
	public ModelAndView editUserProfileDetails(@RequestParam("adID") String profileID, HttpServletRequest request) {

		Candidate candidate = (Candidate) request.getSession().getAttribute("loggedUser");
		if (candidate != null) {
			System.out.println("if candidate object is not null then get details from userDAO's method");
			Profile profile = userDAO.getProfileDetailsByID(profileID);
			System.out.println("********I am Here*********");
			ModelAndView mav = new ModelAndView();
			System.out.println(profile.getEducationLevel());
			mav.addObject("profileDetails", profile);
			mav.setViewName("EditProfileDetails");
			return mav;
		} else {
			System.out.println("Not working inside");
			ModelAndView mav = new ModelAndView();
			System.out.println("Re-directing to Main Page");
			mav.setViewName("Main");
			return mav;
		}
	}
	
	
	@RequestMapping(value = "/Candidate/DeleteProfileDetails.htm", method = RequestMethod.GET)
	public ModelAndView deleteUserProfile(@RequestParam("adID") String profileID, HttpServletRequest request) {

		Candidate candidate = (Candidate) request.getSession().getAttribute("loggedUser");

		if (candidate != null) {
			Profile profile = userDAO.getProfileDetailsByID(profileID);
			userDAO.deleteProfileDetails(profile); //Calling Hibernate delete methos
			
			System.out.println("Now inside delete profile Dao method");

			List list = userDAO.getProfileDetails(candidate);
			// return list;
			ModelAndView mv = new ModelAndView();
			mv.addObject("profileDetailsList", list);
			mv.setViewName("ViewProfDetails");
			return mv;
		} else {
			ModelAndView mv = new ModelAndView();
			// mv.addObject("academicDetailsList", list);
			mv.setViewName("Main");
			return mv;

		}
	}
	
	@RequestMapping(value = "/Candidate/EditAD.htm", method = RequestMethod.GET)
	public String handlingCode3() {
		return "Main";
	}

	@RequestMapping(value = "/Candidate/EditAD.htm", method = RequestMethod.POST)
	public ModelAndView editADintoDB(@ModelAttribute("profileDetails") Profile profileDetails,
			BindingResult result, @RequestParam("ID") String ID, HttpServletRequest request) throws Exception {

		
		profileValidator.validate(profileDetails, result);
		if (result.hasErrors()) {
			ModelAndView mv = new ModelAndView();
			mv.addObject("profileDetailsList", profileDetails);
			mv.setViewName("AddProfile");
			return mv;

		}

		Candidate candidate = (Candidate) request.getSession().getAttribute("loggedUser");

		userDAO.editProfileDetails(Integer.parseInt(ID), profileDetails.getEducationLevel(),profileDetails.getMajor(), profileDetails.getGpa(),
				profileDetails.getStartYear(), profileDetails.getExpYearOfGraduation(), profileDetails.getUniversityName(), profileDetails.getUniversityAddress(), 
				profileDetails.getCompanyName(), profileDetails.getCompanyType(), profileDetails.getJobTitle(), profileDetails.getAnnualStartPay(), profileDetails.getAnnualEndPay(),
				profileDetails.getCompanyCity(), profileDetails.getCompanyState(), profileDetails.getCompanyCountry(), profileDetails.getCompanyZipCode());

		System.out.println("Profile Detail are : ********" +profileDetails.getCompanyCountry());
		List list = userDAO.getProfileDetails(candidate);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("profileDetailsList", list);
		mv.setViewName("ViewProfDetails");
		return mv;
		

	}
	
	@RequestMapping(value = "/Candidate/ViewProfDetails.htm", method = RequestMethod.GET)
	public ModelAndView viewUserProfileDetails(HttpServletRequest request) {

		Candidate candidate = (Candidate) request.getSession().getAttribute("loggedUser");

		if (candidate != null) {

			List list = userDAO.getProfile(candidate);
			ModelAndView mav = new ModelAndView();
//			int count=0;
//			for (Profile p:userDAO.getProfile(candidate)){
//				if(p.getGpa()!=0.0){
//					count++;
//				}
//			}
			mav.addObject("count", 10);
			mav.addObject("profileDetailsList", list);
			mav.setViewName("ViewProfDetails");
			return mav;
		} else {
			ModelAndView mv = new ModelAndView();
			System.out.println("Inside Else part now");
			mv.setViewName("Main");
			return mv;

		}
	}
	
	@RequestMapping(value = "/Candidate/addMoreProfileDetails.htm", method = RequestMethod.GET)
	public String handler() {
		return "Main";

	}
	
	
	@RequestMapping(value = "/Candidate/addMoreProfileDetails.htm", method = RequestMethod.POST)
	public String addAcademicDetails(@ModelAttribute("profileDetails") Profile profile, BindingResult result, HttpServletRequest request) {

		Candidate candidate = (Candidate) request.getSession().getAttribute("loggedUser");

		if (candidate != null) {
			return "AddProfile";
		} else {
			return "Main";
		}
	}
	
	

	@RequestMapping(value = "/Candidate/addAD.htm", method = RequestMethod.GET)
	public String handlingCode1() {
		return "Main";

	}
	
	@RequestMapping(value = "/Candidate/addAD.htm", method = RequestMethod.POST)
	public ModelAndView addAcademicDetailstoDB(Model model, @ModelAttribute("profileDetails") Profile profileDetails, BindingResult result, HttpServletRequest request) {
		
		
		 
			profileValidator.validate(profileDetails, result);
			if (result.hasErrors()) {
				ModelAndView mv = new ModelAndView();
				mv.addObject("profileDetails", profileDetails);
				model.addAttribute("task", "failure");
				mv.setViewName("AddProfile");
				return mv;
			}
			
			Candidate candidate = (Candidate) request.getSession().getAttribute("loggedUser");
			//Calling add UserProfile method from userDAO
			userDAO.addProfileDetails(profileDetails, candidate);
			
			

			List l = userDAO.getProfileDetails(candidate);
			ModelAndView mav = new ModelAndView();
			mav.addObject("profileDetailsList", l);
			//Setting identifiers to access error label
			System.out.println("Setting label fields");
			model.addAttribute("task", "success");
			model.addAttribute("message", "Profile Saved Successfully");
			mav.setViewName("ProfileSaved");
			return mav;
		} 
	
}
