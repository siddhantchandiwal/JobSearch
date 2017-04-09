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
  
</head>

<body>
<%@include file="employerheader.jsp" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<div class="container">
  <h2>Create New Jobs</h2>
  <form:form action="${contextPath}/AddNewJob.htm" commandName="job" method="post" class="form-horizontal" >
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
        <form:input type="text" class="form-control" id="vacancies" path="vacancies" name="vacancies"/>
      </div>
      </div>
      
    
    
    <div class="form-group">
   <div class="col-sm-2"></div>
            <div class="container,col-sm-10">
      <div class="container">
          <input type="submit" class="btn btn-info" value="Submit">
          <input type="reset" class="btn btn-info" value="Refresh">
          
      </div>
    </div>
    </div>
     </form:form>
</div>




</body>
</html>