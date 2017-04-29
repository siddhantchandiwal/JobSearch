<%-- 
    Document   : Job Added
    Created on : Apr 7, 2017, 11:08:23 PM
    Author     : Siddhant Chandiwal
--%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Job Successfully Added</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
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
 <div class="container">
 	<div class="form-group">
  		
  		<h3>A New Job has been Successfully Posted on Job Search Portal</h3>
  		<br/>
  		
  		
  	</div>
 </div>

<%
}
%>

</body>
</html>
