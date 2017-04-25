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
import org.springframework.web.servlet.View;

import com.neu.dao.EmpDAO;
import com.neu.dao.OrgDAO;
import com.neu.dao.UserDAO;
import com.neu.exception.AdminException;
import com.neu.pojo.Admin;
import com.neu.pojo.Organization;
import com.neu.pojo.User;


@Controller
@RequestMapping("/Admin/*")

public class AdminController {
	
	@Autowired
	@Qualifier("orgDAO")
	OrgDAO orgDAO;
	
	@Autowired
	@Qualifier("userDAO")
	UserDAO userDAO;
	
	@Autowired
	@Qualifier("empDAO")
	EmpDAO empDAO;
	
	User user;
	List<User> users;

	@RequestMapping(value = "/Admin/AddOrg.htm", method = RequestMethod.GET)
	public ModelAndView initializeForm(@ModelAttribute("organization") Organization organization, BindingResult result,
			HttpServletRequest request) {

		Admin admin = (Admin) request.getSession().getAttribute("loggedUser");
		if (admin != null)
			return new ModelAndView("AddOrg","addneworg", "org");
		else
			return new ModelAndView("Main","error","user");
	}
	
	@RequestMapping(value = "/Admin/AddOrg.htm", method = RequestMethod.POST)
	protected ModelAndView doSubmitAction(@ModelAttribute("organization") Organization organization, BindingResult result)
			throws Exception {
		try {
			orgDAO.create(organization.getOrganizationName(), organization.getBusinessType());
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}

		return new ModelAndView("OrganizationAdded","message","org");
	}
	
	@RequestMapping(value="/Admin/ViewEmployer.htm", method=RequestMethod.GET)
	public ModelAndView viewEmployersPage(HttpServletRequest request, User user, BindingResult result) throws AdminException{
		ModelAndView mv=new ModelAndView();
		HttpSession session = (HttpSession) request.getSession();
		//List<User> users =userDAO.listOfUsers();
		
		int startPage = (Integer)session.getAttribute("startPage");
        System.out.println("Start Page: "+startPage);
        String type=request.getParameter("side");
        if(type==null || type.equals("next"))
        {
        	System.out.println("Inside the If condition");
        int endPage = startPage+2;
        
        int totalSize = empDAO.getTotalCount();
        System.out.println("Total Count "+totalSize);
        
        System.out.println("************Total Count found**************");
        
        if(endPage>totalSize){
        	endPage=totalSize-2;
            System.out.println("If gt , startPage = "+endPage);
            mv.addObject("users", empDAO.listPaginatedEmployersUsingCriteria(endPage, 2));
        }else{
        	System.out.println("{{{{{{{{{{Inside else condition}}}}}}}}}}}");
        	mv.addObject("users", empDAO.listPaginatedEmployersUsingCriteria(startPage, 2));
        }
        mv.setViewName("ViewEmployer");
        session.setAttribute("startPage",endPage);
        }
        else if(type.equals("back")){
        	int endPage = startPage-2;
            if(endPage<0){
            	mv.addObject("users", empDAO.listPaginatedEmployersUsingCriteria(0, 2));
            	mv.setViewName("ViewEmployer");
            	session.setAttribute("startPage", 0);
            	return mv;
            }
            startPage=endPage;
            mv.addObject("users", empDAO.listPaginatedEmployersUsingCriteria(startPage, 2));
            mv.setViewName("ViewEmployer");
            session.setAttribute("startPage",endPage);
        }
        return mv;
	}
	
	
	@RequestMapping(value = "/Admin/ViewEmpListinPDF.pdf", method = RequestMethod.GET)
	public ModelAndView showPdfReport(HttpServletRequest request) throws IOException, AdminException{
		System.out.println("*******Inside PDF Now*********");
		
		
		Admin admin = (Admin) request.getSession().getAttribute("loggedUser");
		View pdfView = new MyPdfView();
		List<User> users =userDAO.listOfEmpUsers();
		
		System.out.println("**********Size "+users.size());
		if (admin != null) {
			ServletContext context = request.getSession().getServletContext();
			
			System.out.println("*******Inside Admin object*****");
			

		}
		return new ModelAndView(pdfView, "users", users);

	}
	
	
	
	
}
