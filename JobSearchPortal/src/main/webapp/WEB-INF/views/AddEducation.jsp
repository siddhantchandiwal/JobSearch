<%-- 
    Document   : AddEducation
    Created on : Apr 4, 2017, 11:08:23 PM
    Author     : Siddhant Chandiwal
--%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Add Education Details</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  
</head>
<body>
<%@include file="CandidateHeader.jsp" %>

<div class="container">
  <h2>Please update your Education Detail</h2>
  <form:form class="form-horizontal" commandName="academicDetails" method="post" action="addAD.htm" >
   
    <div class="form-group">      
     <label class="col-sm-2 control-label">Education Level:</label>
      <div class="col-sm-10">
        <form:input type="text" class="form-control" name="eduLevel" path="educationLevel"/>
        <font color="red"><form:errors path="educationLevel"/></font>
      </div>
     </div>
      <div class="form-group">
     <label class="col-sm-2 control-label">Major:</label>
      <div class="col-sm-10">
        <form:input type="text" class="form-control" name="major" path="major"/>
        <font color="red"><form:errors path="major"/></font>
      </div>
    
      
     <label class="col-sm-2 control-label">GPA:</label>
      <div class="col-sm-10">
        <form:input type="text" class="form-control" name="gpa" path="gpa"/>
        <font color="red"><form:errors path="gpa"/></font>
      </div>
    
          
     <label class="col-sm-2 control-label">Start Year:</label>
      <div class="col-sm-10">
        <form:input type="text" class="form-control" path="startYear" name="startYear"/>
        <font color="red"><form:errors path="startYear"/></font>
      </div>
      
     <label class="col-sm-2 control-label">Expected Year of Graduation:</label>
      <div class="col-sm-10">
        <form:input type="text" class="form-control" path="expYearOfGraduation" name="expYearOfGraduation"/>
        <font color="red"><form:errors path="expYearOfGraduation"/></font>
      </div>
      
       <label class="col-sm-2 control-label">University Name:</label>
      <div class="col-sm-10">
        <form:input type="text" class="form-control" path="universityName" name="universityName"/><br/>
        <font color="red"><form:errors path="universityName"/></font>
      </div>
      
       <label class="col-sm-2 control-label">University Address:</label>
      <div class="col-sm-10">
        <form:input type="text" class="form-control" path="universityAddress" name="universityAddress"/>
        <font color="red"><form:errors path="universityAddress"/></font>
      </div>
             
       </div>
     
        
      <div class="container">
          <input type="submit" class="btn btn-info" value="Submit" >
          <input type="reset" class="btn btn-info" value="Refresh">
          
      </div>
      
  </form:form>
</div>
  		
  		

 

</body>
</html>