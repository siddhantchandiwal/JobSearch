<%-- 
    Document   : ProfileSavedSuccessfully
    Created on : Apr 4, 2017, 11:08:23 PM
    Author     : Siddhant Chandiwal
--%>

<!DOCTYPE html>
<html lang="en">
<head>
  <title>Online Job Search Home Page</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  
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
  		<h2>Employer Profile Saved Successfully</h2>
  	
  	
  	<%
}
%>	
</body>
</html>