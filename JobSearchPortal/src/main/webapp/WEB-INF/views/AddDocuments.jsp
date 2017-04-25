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
  
  <script type="text/javascript">
  
  function validate(){
	  
	 alert("Your document has been successfully uploaded");
	  return true;
	 
  }
  
  
  </script>
  
  
</head>
<body>
<%@include file="CandidateHeader.jsp" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<a href="AddDocuments.htm" ></a> <br />


<form:form commandName="user" method="post" enctype="multipart/form-data">
Select Document 1: <input type="file" name="document" required/><br/>
<input type="submit" value="Upload Button" onclick="return validate()"/>
</form:form>
  		
  		
</body>
</html>