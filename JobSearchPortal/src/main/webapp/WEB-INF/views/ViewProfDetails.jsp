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
  <title>Profile Details Page</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  
</head>
<body>

<%
            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); //HTTP 1.1
            response.setHeader("Pragma", "no-cache"); //HTTP 1.0
            response.setDateHeader("Expires", 0); //prevents caching at the proxy server
            String role = (String) session.getAttribute("role");
            if (role == "Candidate") {
    %>
<%@include file="CandidateHeader.jsp" %>
  		  		
  		<div class="container">
		<form action="${pageContext.request.contextPath}/Candidate/addMoreProfileDetails.htm" method="post" class="form-horizontal">
		<div class="form-group">
  		<table id="myTable" class ="table">
  			<thead>
  
  
                        <tr>
							<th>#</th>
							
							<th>Profile Details</th>
                            <th>Select Action</th>
                            
                        </tr></thead>
                        <tbody>
                        <%! int count = 1; %>
                        <c:forEach var="profileDetails" items="${profileDetailsList}">
                        
                        <tr>
                       
                        <td>	<%= count++ %> </td> 
                        <td> 
                        <c:if test="${not empty profileDetails.educationLevel}" >
                       <b> Education Level:</b> ${profileDetails.educationLevel}<br/>
                       </c:if>
                       
                       <c:if test="${not empty profileDetails.major}" >
                       <b> Major:</b> ${profileDetails.major} <br/>
                       </c:if>
                       
                       <c:if test="${profileDetails.gpa!=0.0}" >
                       <b> GPA: </b>${profileDetails.gpa}<br/>
                       </c:if>
                       
                       <c:if test="${profileDetails.startYear!=0}" >
                       <b> Start Year:</b>${profileDetails.startYear}<br/>
                       </c:if>
                       
                       <c:if test="${profileDetails.expYearOfGraduation!=0}" >
                       <b> Expected Graduation Year:</b> ${profileDetails.expYearOfGraduation}<br/>
                       </c:if>
                       
                       <c:if test="${not empty profileDetails.universityName}" >
                       <b> University Name:</b> ${profileDetails.universityName}<br>
                       </c:if>
                       
                       <c:if test="${not empty profileDetails.universityAddress}" >
                       <b> University Address:</b>${profileDetails.universityAddress}<br/>
                       </c:if>
                       
                       <c:if test="${not empty profileDetails.companyName}" >
                       <b> Company Name:</b>${profileDetails.companyName}<br/>
                       </c:if>
                       
                       <c:if test="${not empty profileDetails.companyType}" >
                       <b> Company Type:</b>${profileDetails.companyType}<br/>
                       </c:if>
                       
                       <c:if test="${not empty profileDetails.jobTitle}" >
                       <b> Job Title:</b>${profileDetails.jobTitle}<br/>
                       </c:if>
                       
                       <c:if test="${not empty profileDetails.annualStartPay}" >
                       <b> Start Pay:</b>${profileDetails.annualStartPay}<br/>
                       </c:if>
                       
                       <c:if test="${not empty profileDetails.annualEndPay}" >
                       <b> End Pay:</b>${profileDetails.annualEndPay}<br/>
                       </c:if>
                       
                       <c:if test="${not empty profileDetails.companyCity}" >
                       <b> City:</b>${profileDetails.companyCity}<br/>
                       </c:if>
                       
                       <c:if test="${not empty profileDetails.companyState}" >
                       <b> State:</b>${profileDetails.companyState}<br/>
                       </c:if>
                       
                       <c:if test="${not empty profileDetails.companyCountry}" >
                       <b> Country:</b>${profileDetails.companyCountry}<br/>
                       </c:if>
                       
                       <c:if test="${not empty profileDetails.companyZipCode}" >
                       <b> Zip Code:</b>${profileDetails.companyZipCode}<br/>
                       </c:if>
                                      

                        </td>
                        	
                        	<td><a href="EditProfileDetails.htm?adID=${profileDetails.profileID }">Update</a> OR <a href="DeleteProfileDetails.htm?adID=${profileDetails.profileID }">Delete</a></td>
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

<%
}
%>
  		
</body>
</html>