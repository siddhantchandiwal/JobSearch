
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Results</title>
<!-- <script src="http://code.jquery.com/jquery-1.12.4.min.js"></script>
<script>
	
</script> -->
</head>
<body>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<%@include file="CandidateHeader.jsp" %>

 <c:choose>
            <c:when test="${empty requestScope.jobList}">
                <h3>No Jobs Found !! Please try something different</h3>                
        </c:when>
        
        <c:otherwise>
            <table border="1">
                <tr>
                    <th>Job Id</th>
                    <th>Company Name</th>
                    <th>Job Title</th>
                    <th>Description</th>
                    <th>Job Location</th>
                    <th>Action</th>

                </tr>
                
                <tbody>
                        <%! int count = 1; %>
                        <c:forEach var="job" items="${jobList}">
                        
                        <tr>
                       
                         
                        <td>${job.jobID} </td>
                        <td>${job.organization.organizationName}</td>
                        <td>${job.jobTitle}</td>
                        <td>${job.jobDescription}</td>
                        <td>${job.jobLocationCity}</td>
                        
						
						<td><a href="JobApply.htm?jobID=${job.jobID}">Quick Apply</a> </td>
                        </tr>
                       
                        </c:forEach>
						</tbody>
            </table>
        </c:otherwise>
       </c:choose>


</body>
</html>