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

		return "Main";
	}
	
	@RequestMapping(value = "/Main.htm", method = RequestMethod.GET)
	public String homePage(Locale locale, Model model) {

		return "Main";
	}
	
//	@RequestMapping(value = "/AddEducation.htm", method = RequestMethod.GET)
//	public String academicDetails(Locale locale, Model model) {
//
//		return "AddEducation";
//	}
	
	@RequestMapping(value="/Logout.htm", method=RequestMethod.GET)
	public String logout(HttpServletRequest request)
	
	{
		HttpSession session = request.getSession();
		session.invalidate();
		return "Main";
	}

}
