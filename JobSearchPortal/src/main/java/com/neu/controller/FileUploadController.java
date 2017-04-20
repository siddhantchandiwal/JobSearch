package com.neu.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.neu.dao.UserDAO;
import com.neu.exception.UserException;
import com.neu.pojo.Candidate;
import com.neu.pojo.User;


@Controller
public class FileUploadController {
	
	@Autowired
	@Qualifier("userDAO")
	UserDAO userDAO;
	
	@Autowired
	ServletContext servletContext;
	

	@RequestMapping(value = "/AddDocuments.htm", method = RequestMethod.GET)
	public ModelAndView handleUploadIncoming(HttpServletRequest request) {
	Candidate candidate = (Candidate) request.getSession().getAttribute("loggedUser");
	System.out.println("CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC"+candidate.getUserId());
	return new ModelAndView("AddDocuments");
	}
	
	@RequestMapping(value = "/AddDocuments.htm", method = RequestMethod.POST)
	public String handleUpload(@ModelAttribute("user") User user,HttpServletRequest request) {
		try{
			HttpSession session=request.getSession();
			Candidate u = (Candidate)session.getAttribute("loggedUser");
			CommonsMultipartFile documentInMemory = user.getDocument();
			String fileName = documentInMemory.getOriginalFilename();
			userDAO.updateFile(u.getUserId(), fileName);
			File localFile = new File("C:/documents", fileName);
			documentInMemory.transferTo(localFile);
			user.setFileName(fileName);
			
			
			System.out.println("File is stored at "+localFile.getPath());
			System.out.println("Congratulations all your documents have been successfully saved in the database");
			return "UploadSuccess";
			
			
			
		} catch (IllegalStateException e) {
			System.out.println("*** IllegalStateException: " + e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("*** IOException: " + e.getMessage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "AddDocuments";
	}
}
