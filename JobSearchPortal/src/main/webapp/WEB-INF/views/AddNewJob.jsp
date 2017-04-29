<%-- 
    Document   : AddNewJob
    Created on : Apr 7, 2017, 11:08:23 PM
    Author     : Siddhant Chandiwal
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
  <title>Add New Jobs Page</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  
   <script type="text/javascript">
 	function validate(){
 		var jobDescription = document.getElementsByTagName("input")[0].value;
 		var vacancies = document.getElementsByTagName("input")[1].value;
 		
 		var regex = /^[a-zA-Z]{1,300}$/;
 		
 		if (parseInt(vacancies) <= 0) {
			errmsg = "*Vacancies should not be negative or zero.";
			flag = false;
		}else{
			errmsg="" ;
			flag=true;
		}

			document.getElementById("ErrorMsgForm").innerHTML = errmsg;
		
		return flag;
		
 			 
 		 
 	}
  
 </script>
  
</head>

<body>

<%
            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); //HTTP 1.1
            response.setHeader("Pragma", "no-cache"); //HTTP 1.0
            response.setDateHeader("Expires", 0); //prevents caching at the proxy server
            String role = (String) session.getAttribute("role");
            if (role == "Employer") {
    %>
<%@include file="employerheader.jsp" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<div class="container">
  <h2>Create New Job</h2>
  <form:form action="${contextPath}/Employer/AddNewJob.htm" commandName="job" method="post" class="form-horizontal" >
  <div class="form-group">
    <label class="col-sm-2 control-label">Job Title:</label>
     
      <div class="col-sm-10">
      
      <form:select class="form-control" id="jobTitle" path="jobTitle">
        <option>Software Engineer</option>
        <option>Software Developer</option>
        <option>Data Analyst</option>
        <option>Data Scientist</option>
        <option>Business Analyst</option>
        <option>Program Manager</option>
        <option>Software Engineer Intern</option>
        <option>Software Developer Intern</option>
        <option>Data Analyst Intern</option>
        <option>Business Analyst Intern</option>
        <option>Program Manager Intern</option>     
      </form:select>
    
      </div>  
      </div>
    <div class="form-group">
     <label class="col-sm-2 control-label">Job Description:</label>
      <div class="col-sm-10">
        <form:input type="text" class="form-control" id="jobDescription" path="jobDescription"/>
      </div>
      </div>
     
  
     
   
    <div class="form-group">
    <label class="col-sm-2 control-label">Qualification:</label>
     
      <div class="col-sm-10">
      
      <form:select class="form-control" id="qualification" path="qualification">
        
        <option>High School</option>       
        <option>Bachelor's Degree</option>
        <option>Master's Degree</option>
       	<option>PhD</option>
      </form:select>
    
      </div>
      </div>
      
        <div class="form-group">
    <label class="col-sm-2 control-label">City:</label>
     
      <div class="col-sm-10">
      
      <form:select class="form-control" id="jobLocationCity" path="jobLocationCity">
        
        <option>Boston</option>       
        <option>New York</option>
        <option>Chicago</option>
       	<option>Austin</option>
       	<option>Dallas</option>
       	<option>New Jersey</option>
      </form:select>
    
      </div>
      </div>
      
       <div class="form-group">
    <label class="col-sm-2 control-label">State:</label>
     
      <div class="col-sm-10">
      
      <form:select class="form-control" id="jobLocationState" path="jobLocationState">
        
        <option>MA</option>       
        <option>NY</option>
        <option>IL</option>
       	<option>TX</option>
       	<option>NJ</option>
      </form:select>
    
      </div>
      </div>
      
            <div class="form-group">
    <label class="col-sm-2 control-label">Country:</label>
     
      <div class="col-sm-10">
      
      <form:select class="form-control" id="jobLocationCountry" path="jobLocationCountry">
        
        <option>USA</option>       
        <option>India</option>
        <option>China</option>
       	<option>Japan</option>
       	<option>Australia</option>
      </form:select>
    
      </div>
      </div>

      
      <div class="form-group">
     <label class="col-sm-2 control-label">No of Vacancies</label>
      <div class="col-sm-10">
        <form:input type="number" class="form-control" id="vacancies" path="vacancies" name="vacancies" required = "true"/>
      </div>
      </div>
      
    
    
    <div class="form-group">
   <div class="col-sm-2"></div>
            <div class="container,col-sm-10">
      <div class="container">
          <input type="submit" class="btn btn-info" value="Submit" onclick="return validate()">
          <input type="reset" class="btn btn-info" value="Refresh">
          
      </div>
    </div>
    </div>
    
                        <p>
						<label id="ErrorMsgForm" class="control-label" style="color:red;" ></label>
						</p>
     </form:form>
</div>

<%
}
%>


</body>
</html>