<%-- 
    Document   : Candidate Main Page
    Created on : Apr 14, 2017, 01:08:23 PM
    Author     : Siddhant Chandiwal
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Online Job Search</title>
<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap.css" />">
<link rel="stylesheet"
	href="<c:url value="/resources/css/signup.css" />">


</head>
<body>


	<%@include file="CandidateHeader.jsp"%>


	<div class="container">
		<div class="form-group">
			<table border="1" cellpadding="5" cellspacing="5">
		<tr>
			<td><b>Number</b></td>
			<td><b>Application ID</b></td>
			<td><b>Company Name</b></td>
			<td><b>Job Title</b></td>
			<td><b>Qualification</b></td>
			<td><b>City</b></td>
			<td><b>State</b></td>
			<td><b>Country</b></td>
			<td><b>Application Status</b></td>
			
		</tr>
		
		<tbody>
					<%!int count = 1;%>
					<c:forEach var="jobApp" items="${jobStatusList}">

						<tr>

							<td><%=count++%></td>
							<td>${jobApp.jobApplicationID}
							<td>${jobApp.job.organization.organizationName}
							<td>${jobApp.job.jobTitle}
							<td>${jobApp.job.qualification}
							<td>${jobApp.job.jobLocationCity}
							<td>${jobApp.job.jobLocationState}
							<td>${jobApp.job.jobLocationCountry}
							<td>${jobApp.currentJobStatus}
							</td>
													</tr>

					</c:forEach>
				</tbody>
	</table>
		</div>
	</div>
	
	

</body>
</html>






