package com.neu.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.neu.dao.OrgDAO;
import com.neu.pojo.Admin;
import com.neu.pojo.Organization;

@Controller
public class AdminController {
	
	@Autowired
	@Qualifier("orgDAO")
	OrgDAO orgDAO;

	@RequestMapping(value = "/AddOrg.htm", method = RequestMethod.GET)
	public ModelAndView initializeForm(@ModelAttribute("organization") Organization organization, BindingResult result,
			HttpServletRequest request) {

		Admin admin = (Admin) request.getSession().getAttribute("loggedUser");
		if (admin != null)
			return new ModelAndView("AddOrg","addneworg", "org");
		else
			return new ModelAndView("Main","error","user");
	}
	
	@RequestMapping(value = "/AddOrg.htm", method = RequestMethod.POST)
	protected ModelAndView doSubmitAction(@ModelAttribute("organization") Organization organization, BindingResult result)
			throws Exception {
		try {
			orgDAO.create(organization.getOrganizationName(), organization.getBusinessType());
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}

		return new ModelAndView("UserAdded","message","org");
	}
}
