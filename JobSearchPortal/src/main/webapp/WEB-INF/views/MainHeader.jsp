<%-- 
    Document   : MainHeader
    Created on : Apr 4, 2017, 11:08:23 PM
    Author     : Siddhant Chandiwal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Job Search Home Page</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">


    <ul class="nav navbar-nav navbar-right">
      <li class="active"><a href="${pageContext.request.contextPath}/SignUp.htm"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li class="active"><a href="${pageContext.request.contextPath}/Admin/adminlogin.htm"><span class="glyphicon glyphicon-log-in"></span> Admin Login</a></li>
      <li class="active"><a href="${pageContext.request.contextPath}/Employer/emplogin.htm"><span class="glyphicon glyphicon-log-in"></span> Employer Login</a></li>
      <li class="active"><a href="${pageContext.request.contextPath}/Candidate/candidatelogin.htm"><span class="glyphicon glyphicon-log-in"></span> Candidate Login</a></li>
    </ul>
  </div>
</nav>
  


</body>
</html>

