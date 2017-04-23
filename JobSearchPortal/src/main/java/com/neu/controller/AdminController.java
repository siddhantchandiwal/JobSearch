package com.neu.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.neu.dao.OrgDAO;
import com.neu.dao.UserDAO;
import com.neu.exception.AdminException;
import com.neu.pojo.Admin;
import com.neu.pojo.Organization;
import com.neu.pojo.User;

@Controller
public class AdminController {
	
	@Autowired
	@Qualifier("orgDAO")
	OrgDAO orgDAO;
	
	@Autowired
	@Qualifier("userDAO")
	UserDAO userDAO;
	
	User user;
	List<User> users;

	@RequestMapping(value = "/AddOrg.htm", method = RequestMethod.GET)
	public ModelAndView initializeForm(@ModelAttribute("organization") Organization organization, BindingResult result,
			HttpServletRequest request) {

		Admin admin = (Admin) request.getSession().getAttribute("loggedUser");
		if (admin != null)
			return new ModelAndView("AddOrg","addneworg", "org");
		else
			return new ModelAndView("Main","error","user");
	}
	
	@RequestMapping(value="/ViewEmployer.htm", method=RequestMethod.GET)
	public ModelAndView viewSellersPage(HttpServletRequest request, User user, BindingResult result) throws AdminException{
		
		HttpSession session = (HttpSession) request.getSession();
		List<User> users =userDAO.listOfUsers();
		System.out.println("Printing the size of users List: "+users.size());
		session.setAttribute("users", users);
		
		
		return new ModelAndView("ViewEmployer","users",users);
	}
	
	
	@RequestMapping(value = "/ViewEmpListinPDF.pdf", method = RequestMethod.GET)
	public void showPdfReport(HttpServletRequest request, HttpServletResponse response) throws IOException, AdminException{
		System.out.println("*******Inside PDF Now*********");
		Admin admin = (Admin) request.getSession().getAttribute("loggedUser");
		
		List<User> users =userDAO.listOfEmpUsers();
		
		System.out.println("**********Size "+users.size());
		if (admin != null) {
			ServletContext context = request.getSession().getServletContext();
			
			System.out.println("*******Inside Admin object*****");
			
			MyPdfView pdfView = new MyPdfView();
			try {
				pdfView.buildPdfDocument(users);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}

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
