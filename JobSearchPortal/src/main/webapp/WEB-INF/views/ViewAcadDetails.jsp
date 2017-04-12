<%-- 
    Document   : UserAdded
    Created on : Apr 4, 2017, 11:08:23 PM
    Author     : Siddhant Chandiwal
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>View Academic Details Page</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  
</head>
<body>
<%@include file="CandidateHeader.jsp" %>
  		  		
  		<div class="container">
		<form action="addMoreAcademicDetails.htm" method="post" class="form-horizontal">
		<div class="form-group">
  		<table id="myTable" class ="table">
  			<thead>
  
  
                        <tr>
							<th>#</th>
							
							<th> Academic Details</th>
                            <th>Select Action</th>
                            
                        </tr></thead>
                        <tbody>
                        <%! int count = 1; %>
                        <c:forEach var="academicDetails" items="${academicDetailsList}">
                        
                        <tr>
                       
                        <td>	<%= count++ %> </td> 
                        <td> 
                        
                        <b>Education Level:</b> ${academicDetails.educationLevel}<br/>
                        <b>Major:</b> ${academicDetails.major} <br/>
                        <b>GPA: </b>${academicDetails.gpa}<br/>
                       <b>Start Year:</b>${academicDetails.startYear}<br/>
                       <b> Expected Graduation Year:</b> ${academicDetails.expYearOfGraduation}<br/>
                        <b>University Name:</b> ${academicDetails.universityName}<br>
                       <b> University Address:</b>${academicDetails.universityAddress}<br/>
                                      

                        </td>
                        	
                        	<td><a href="EditEducationDetails.htm?adID=${academicDetails.academicDetailsID }">Edit</a></td>
                        </tr>
                       
                        </c:forEach>
                       
						</tbody>

</table>
</div>
<div class="container">
						<input type="submit" class="btn btn-info" value="Add more">
						</div>
</form>

</div>
  		
</body>
</html>