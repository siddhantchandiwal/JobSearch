<%-- 
    Document   : UserAdded
    Created on : Apr 4, 2017, 11:08:23 PM
    Author     : Siddhant Chandiwal
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <title>Online Job Search Home Page</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  
</head>
<body>
<%@include file="CandidateHeader.jsp" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<a href="${contextPath}/AddDocuments.htm" ></a> <br />


<form:form commandName="user" method="post" enctype="multipart/form-data">

Select Resume: <input type="file" name="resume"/><br/>
<input type="submit" value="Upload Button"/>
</form:form>
  		
  		
</body>
</html>