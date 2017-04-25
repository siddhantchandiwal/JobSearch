<%-- 
    Document   : View Employers
    Created on : Apr 22, 2017, 11:08:23 PM
    Author     : Siddhant Chandiwal
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>View Employers List</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  
  
</head>
<body>

<%@include file="AdminHeader.jsp" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<h1>Welcome Admin</h1>
<form:form action="${contextPath}/Admin/ViewEmployer.htm" commandName="ViewEmployer" method="post" class="form-horizontal" >
<h3>List of Employers</h3>
<table border="1" cellpadding="5" cellspacing="5">
		<tr>
			<td><b>User Name</b></td>
			<td><b>First Name</b></td>
			<td><b>Last Name</b></td>
			<td><b>Type</b></td>
			<td><b>Email Id</b></td>
		</tr>
		
		<c:forEach var="user" items="${users}">
		<c:if test="${user.userType=='Employer'}">
			<tr data-id="${user.userId}">
				<td>${user.userName}</td>
				<td>${user.firstName}</td>
				<td>${user.lastName}</td>
				<td>${user.userType}</td>
				<td>${user.emailId}</td>
				
			</tr>
			</c:if>
		</c:forEach>
	</table>

<hr/>

<div style="text-align:center">
 <div class="pagination">
   <a href="${contextPath}/Admin/ViewEmployer.htm?side=back">&laquo;</a>
   <a href="${contextPath}/Admin/ViewEmployer.htm?side=next">&raquo;</a>
 </div>
</div>

</form:form>
<a href="${contextPath}/Admin/ViewEmpListinPDF.pdf">View List in PDF</a>



</body>
</html>