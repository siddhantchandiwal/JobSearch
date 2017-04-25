package com.neu.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.neu.pojo.User;

public class AdminInterceptor extends HandlerInterceptorAdapter {
	
	String errorPage;

	public String getErrorPage() {
		return errorPage;
	}

	public void setErrorPage(String errorPage) {
		this.errorPage = errorPage;
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
		
		 System.out.println("----------------------");
	        HttpSession session = (HttpSession) request.getSession();
	        User u = (User)session.getAttribute("loggedUser");
	        
	        if(u == null){
//	            if((request.getRequestURI().contains("Admin"))||
//	                    (request.getRequestURI().contains("Candidate"))||(request.getRequestURI().contains("Employer")))
//	            {
//	                System.out.println("in interceptor");
//	                System.out.println("1 -false");
//	                return false;
//	            }
	            System.out.println("Inside interceptor");
	            
	            System.out.println("Context path is ************" + request.getContextPath());
	            response.sendRedirect(request.getContextPath());
	            
	            return false;
	        }

	        if(u != null){
	            System.out.println("Inside Admin interceptor");
	            if((!u.getUserType().equalsIgnoreCase("Admin")))
	            {
	            	 System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&" + request.getContextPath());
	            	response.sendRedirect(request.getContextPath());
	                return false;
	            }else{
	            	return true;
	            }
	        }
	        return false;
	    }

}
