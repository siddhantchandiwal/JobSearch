package com.neu.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String startForm(Locale locale, Model model) {

		return "Main";   //Return back to Main Landing Page
	}
	
	
//	@RequestMapping(value = "/AddEmpProfile.htm", method = RequestMethod.GET)
//	public String appEmpProfile(Locale locale, Model model) {
//		HttpSession session = request.getSession();
//	    session.setAttribute("main","user");
//		return "AddEmployer";
//	}
	
	@RequestMapping(value = "/Main.htm", method = RequestMethod.GET)
	public String homePage(Locale locale, Model model) {
		System.out.println("Inside Main Now");
		System.out.println("*************************");
		return "Main";    //Return back to Main Landing Page
	}
	
//	@RequestMapping(value = "/AddEducation.htm", method = RequestMethod.GET)
//	public String academicDetails(Locale locale, Model model) {
//
//		return "AddEducation";
//	}
	
	@RequestMapping(value="/Logout.htm", method=RequestMethod.GET)
	public String logout(HttpServletRequest request){
		//Actions to be performed on Logout button
		HttpSession session = request.getSession();
		request.getSession().setAttribute("role", null);
		System.out.println("Doing Logout from User");
		System.out.println("After logout*************" +request.getSession().getAttribute("role"));
		System.out.println("******Session Terminating****");
		System.out.println("Bye");
		session.invalidate();
		
		return "Main";
	}

}
