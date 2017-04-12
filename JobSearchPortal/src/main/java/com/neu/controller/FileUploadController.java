package com.neu.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

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
	public ModelAndView handleUploadIncoming() {
	return new ModelAndView("AddDocuments","user",new User());
	}
	
	@RequestMapping(value = "/AddDocuments.htm", method = RequestMethod.POST)
	public String handleUpload(@ModelAttribute("candidate") Candidate candidate, BindingResult result,@RequestParam CommonsMultipartFile[] fileUpload,HttpServletRequest hsr) {
		
		if (result.hasErrors()) {
			hsr.setAttribute("candiadateFormHasError", "true");
			return "AddDocuments";
		}

		try {

			String resumeName = null;
			byte[] resume = null;
			 if (fileUpload != null && fileUpload.length > 0) {
	    	        for (CommonsMultipartFile reumeFile : fileUpload){
	    	              
	    	            System.out.println("Saving file: " + reumeFile.getOriginalFilename());
	    	             
	    	            //Candidate uploadFile = new Candidate();
	    	           
	    	            resumeName = reumeFile.getOriginalFilename();
	    	            resume = reumeFile.getBytes();
	    	                           
	    	        }
	    	 }
			

			UserDAO userDAO = new UserDAO();
			
//			candidateDAO.create(candidate.getEmailID(), candidate.getPassword(), candidate.getConfirmPassword(), 
//					candidate.getFirstName(), candidate.getLastName(), resumeName, resume);

			// DAO.close();
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}

		return "UploadSuccess";
	}

}
