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
		System.out.println("Sending control to SignUp Page");
		System.out.println("Object found for new user");
		return new ModelAndView("SignUp", "user", new User());
	}

	@RequestMapping(value = "/SignUp.htm", method = RequestMethod.POST)
	protected ModelAndView signUpUser(@ModelAttribute("user") User user, BindingResult result) throws Exception {

		try {
			// Checking Unique username and email from Database
			boolean checkIfUniqueExists = userDao.checkIfUniqueUserNameExist(user.getUserName());
			boolean checkIfUniqueEmail = userDao.checkIfUniqueEmail(user.getEmailId());
			System.out.println("Hello I am here");

			if ((checkIfUniqueExists) && (checkIfUniqueEmail)) // if Both turns
																// out to be
																// unique then
																// only create a
																// new user
			{
				System.out.println("Everything is unique");
				userDao.create(user.getUserName(), user.getPassword(), user.getFirstName(), user.getLastName(),
						user.getEmailId(), user.getUserType());
				UserDAO.sendMail(user, "Your Registration has been booked successfully");
				return new ModelAndView("UserRegistered", "user", user);
			}

		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}

		return new ModelAndView("SignUp", "errormessage", "error while signup");

	}

	@RequestMapping(value = "/Candidate/UserProfile.htm", method = RequestMethod.GET)
	public ModelAndView userProfile(HttpServletRequest request) {

		Candidate candidate = (Candidate) request.getSession().getAttribute("loggedUser");

		if (candidate != null) {
			ModelAndView mv = new ModelAndView();
			mv.addObject("user", candidate);
			mv.setViewName("UserProfile");
			return mv;
		} else {
			ModelAndView mv = new ModelAndView();
			mv.setViewName("Main");
			return mv;
		}
	}

	@RequestMapping(value = "/Candidate/UserProfile.htm", method = RequestMethod.POST)
	public ModelAndView updateUserProfile(@ModelAttribute("user") User user, BindingResult result,
			HttpServletRequest request) {
		System.out.println("**************Hi I am here****");
		Candidate candidate = (Candidate) request.getSession().getAttribute("loggedUser");

		System.out.println(candidate.getUserId());
		System.out.println(request.getSession().getAttribute("streetLine1"));
		System.out.println(user.getStreetLine1());

		System.out.println("******************" + candidate.getUserId());

		// System.out.println("Street Line1:**************" +
		// user.getStreetLine1());
		userDao.updatePersonalInfo(candidate.getUserId(), user.getStreetLine1(), user.getStreetLine2(), user.getCity(),
				user.getState(), user.getCountry(), user.getEmailId(), user.getPhone());
		return new ModelAndView("UserProfile", "userprofile", "Details saved Successfully");
	}

	@RequestMapping(value = "/Employer/emplogin.htm", method = RequestMethod.GET)
	protected ModelAndView authenticateEmpLogin(@ModelAttribute("user") User user, BindingResult result)
			throws Exception {

		return new ModelAndView("emplogin", "user", user);
	}

	@RequestMapping(value = "/Employer/emplogin.htm", method = RequestMethod.POST)
	protected ModelAndView authenticateEmpLogin(@ModelAttribute("user") User user, BindingResult result,
			HttpServletRequest request) throws Exception {

		HttpSession session = request.getSession();
		ModelAndView mv = new ModelAndView();

		try {
			System.out.print("test");
			User enteredUser = userDao.validate(user.getUserName(), user.getPassword());

			if (enteredUser == null) {
				System.out.println("UserName and Password don't match");
				return new ModelAndView("emplogin", "loginFailed", "UserName and Password don't match");
			}

			System.out.println("Entered user is " + enteredUser.getUserType());
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + enteredUser.getUserId());

			if (enteredUser.getUserType().equalsIgnoreCase("Employer")) {

				System.out.println("**********Inside Emp");
				Employer loggedUser = (Employer) enteredUser;
				session.setAttribute("loggedUser", loggedUser);
				session.setAttribute("user", loggedUser);
				session.setAttribute("role", "Employer");
				return new ModelAndView("EmployerMain", "emp page", "user");
			}

		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}

		return new ModelAndView("emplogin", "loginFailed", "UserName and Password does not Match");
	}

	@RequestMapping(value = "/Admin/adminlogin.htm", method = RequestMethod.GET)
	protected ModelAndView authenticateAdminLogin(@ModelAttribute("user") User user, BindingResult result)
			throws Exception {

		return new ModelAndView("adminlogin", "user", user);
	}

	@RequestMapping(value = "/Admin/adminlogin.htm", method = RequestMethod.POST)
	protected ModelAndView authenticateAdminLogin(@ModelAttribute("user") User user, BindingResult result,
			HttpServletRequest request) throws Exception {

		HttpSession session = request.getSession();
		ModelAndView mv = new ModelAndView();

		try {
			System.out.print("test");
			User enteredUser = userDao.validate(user.getUserName(), user.getPassword());
			if (enteredUser == null) {
				System.out.println("UserName and Password don't match");
				return new ModelAndView("adminlogin", "loginFailed", "UserName and Password don't match");
			}

			System.out.println("Entered user is " + enteredUser.getUserType());
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + enteredUser.getUserId());

			if (enteredUser.getUserType().equalsIgnoreCase("Admin")) {

				System.out.println("**********Inside Admin");
				Admin loggedUser = (Admin) enteredUser;
				session.setAttribute("loggedUser", loggedUser);
				session.setAttribute("user", loggedUser);
				session.setAttribute("startPage", 0);
				session.setAttribute("role", "Admin");
				return new ModelAndView("AdminMain", "admin", "user");
			}

		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}

		return new ModelAndView("adminlogin", "loginFailed", "UserName and Password does not Match");
	}

	@RequestMapping(value = "/Candidate/candidatelogin.htm", method = RequestMethod.GET)
	protected ModelAndView authenticateCandidateLogin(@ModelAttribute("user") User user, BindingResult result)
			throws Exception {

		return new ModelAndView("candidatelogin", "user", user);
	}

	@RequestMapping(value = "/Candidate/candidatelogin.htm", method = RequestMethod.POST)
	protected ModelAndView authenticateCandidateLogin(@ModelAttribute("user") User user, BindingResult result,
			HttpServletRequest request) throws Exception {

		HttpSession session = request.getSession();
		ModelAndView mv = new ModelAndView();

		try {
			System.out.print("test");
			User enteredUser = userDao.validate(user.getUserName(), user.getPassword());

			if (enteredUser == null) {
				System.out.println("UserName and Password don't match");
				return new ModelAndView("candidatelogin", "loginFailed", "UserName and Password don't match");
			}
			System.out.println("Entered user is " + enteredUser.getUserType());
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + enteredUser.getUserId());

			if (enteredUser.getUserType().equalsIgnoreCase("Candidate")) {

				System.out.println("**********Inside Candidate");
				Candidate loggedUser = (Candidate) enteredUser;
				session.setAttribute("loggedUser", loggedUser);
				session.setAttribute("role", "Candidate");
				return new ModelAndView("CandidateMain", "candidate", enteredUser.getFirstName());
			}

		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}

		return new ModelAndView("candidatelogin", "loginFailed", "UserName and Password does not Match");
	}

}
