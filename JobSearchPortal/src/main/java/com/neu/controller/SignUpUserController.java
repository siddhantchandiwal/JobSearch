package com.neu.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import com.neu.dao.UserDAO;
import com.neu.pojo.Admin;
import com.neu.pojo.Candidate;
import com.neu.pojo.Employer;
import com.neu.pojo.User;

@Controller
public class SignUpUserController {
	
	@Autowired
	@Qualifier("userDAO")
	UserDAO userDao;
	
	@RequestMapping(value = "/SignUp.htm", method = RequestMethod.GET)
	protected ModelAndView signUpUser() throws Exception {
		System.out.print("SignUpUser");
	
		return new ModelAndView("SignUp", "user", new User());
	}
	
	
	@RequestMapping(value = "/SignUp.htm", method = RequestMethod.POST)
	protected ModelAndView doSubmitAction(@ModelAttribute("user") User user, BindingResult result) throws Exception {

		try {
			boolean checkIfUniqueExists = userDao.checkIfUniqueUserNameExist(user.getUserName());
			System.out.println("Hello I am here");

			if (checkIfUniqueExists) {
				userDao.create(user.getUserName(), user.getPassword(), user.getFirstName(), user.getLastName(),	user.getUserType());
				return new ModelAndView("UserAdded", "user", "u");
			}

		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}

		return new ModelAndView("UserAlreadyExists","errormessage", "error while signup");

	}
	
	@RequestMapping(value = "/UserProfile.htm", method = RequestMethod.GET)
	public ModelAndView profile(HttpServletRequest request) {

		User user = (User) request.getSession().getAttribute("loggedUser");

		if (user != null) {
			ModelAndView mv = new ModelAndView();
			mv.addObject("user", user);
			mv.setViewName("UserProfile");
			return mv;
		} else {
			ModelAndView mv = new ModelAndView();
			mv.setViewName("Main");
			return mv;
		}
	}
	
	@RequestMapping(value = "/UserProfile.htm", method = RequestMethod.POST)
	public ModelAndView updateProfile(@ModelAttribute("user") User user, @RequestParam("ID") String userID, BindingResult result) {

		System.out.println("User id:" + userID);
		userDao.updatePersonalInfo(userID, user.getStreetLine1(), user.getStreetLine2(), user.getCity(), user.getState(), user.getCountry(), user.getEmailId(), user.getPhone(), user.getZipCode());
		return new ModelAndView("Welcome","userprofile", "user");
	}
	
	@RequestMapping(value = "/login.htm", method = RequestMethod.POST)
	protected ModelAndView authenticate(@ModelAttribute("user") User user, BindingResult result, HttpServletRequest request)
			throws Exception {

		HttpSession session = request.getSession();

		try {
			System.out.print("test");
			User enteredUser = userDao.validate(user.getUserName(), user.getPassword(), user.getUserType());
			if (enteredUser != null) {
				if (user.getUserType().equalsIgnoreCase("Employer")) {
					Employer emplogged = (Employer) enteredUser;
					session.setAttribute("loggedUser", emplogged);
					return new ModelAndView("EmployerMain","emp page","user");
				} else if (user.getUserType().equalsIgnoreCase("Candidate")) {
					Candidate canlogged = (Candidate) enteredUser;
					session.setAttribute("loggedUser", canlogged);
					return new ModelAndView("CandidateMain","candidate","user");
				} else if (user.getUserType().equalsIgnoreCase("Admin")) {
					Admin adminlogged = (Admin) enteredUser;
					session.setAttribute("loggedUser", adminlogged);
					return new ModelAndView("AdminMain","admin","user");
				}
			} else
				return new ModelAndView("InvalidUser","user","user");

		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}

		return new ModelAndView("InvalidUser","user","user");
	}
	
	@RequestMapping(value = "/login.htm", method = RequestMethod.GET)
	protected String authenticateForm(@ModelAttribute("user") User user, BindingResult result) throws Exception {

		return "login";
	}
	
	

}
