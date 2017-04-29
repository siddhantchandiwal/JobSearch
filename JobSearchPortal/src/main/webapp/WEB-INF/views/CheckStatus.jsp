<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="en">
<head>
<title>Check Status</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="text/javascript">
	
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



<h4>List of Students applied for Jobs</h4>
<table border="1" cellpadding="5" cellspacing="5">
		<tr>
			<td><b>Number</b></td>
			<td><b>Job ID</b></td>
			<td><b>Job Title</b></td>
			<td><b>Applicant User Id</b></td>
			<td><b>First Name</b></td>
			<td><b>Last Name</b></td>
			<td><b>Email Id</b></td>
		</tr>
		
		<%!int count = 1;%>
		<c:forEach var="status" items="${List}">
		
			<tr>

							<td><%=count++%></td>
							
							<td>${status.job.jobID}</td>
							<td>${status.job.jobTitle}</td>
							<td>${status.candidate.userId}</td>
							<td>${status.candidate.firstName}</td>
							<td>${status.candidate.lastName}</td>
							<td>${status.candidate.emailId}</td>
							
						</tr>
			
		</c:forEach>
	</table>

	<%
}
%>



</body>
</html>