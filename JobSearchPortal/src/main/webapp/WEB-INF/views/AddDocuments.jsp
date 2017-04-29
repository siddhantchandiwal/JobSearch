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
  
   <link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap.css" />">
<link rel="stylesheet"
	href="<c:url value="/resources/css/signup.css" />"> 
	
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" 
integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.min.js" integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
    crossorigin="anonymous"></script>
  
  <script type="text/javascript">
  
  <%--function validate(){
	  
	  var document = document.getElementById("document").value;
	  
	  if (document=="" || document==null) {
	        alert("Please browse Document first");
	        return false;
	    }else	 {
	 alert("Your document has been successfully uploaded");
	  return true;
	    }
  } --%>
  
  $(document).ready(function(event){
	 $(document).on("click","#submit",function(){
		var text = $("#document").val();
		if(text==""){
			alert('PLEASE CHOOSE YOUR DOCUMENT FIRST!!');
			event.preventDefault();
		}else{	 
		 alert('Successfully Uploaded!!');
		}
	 });	  
  });
   
  </script>
  
  
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

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<a href="AddDocuments.htm" ></a> <br />


<form:form commandName="user" method="post" enctype="multipart/form-data">
Select Document: <input type="file" id="document" name="document"/><br/>
<input type="submit" id="submit" value="Upload Button"/>
</form:form>


<%
}
%>  		
  		
</body>
</html>

