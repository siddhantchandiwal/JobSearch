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
		<div class="row">
			<div class="col-lg-9 col-md-12">
				<div class="row">
				
				
				
		<h2 >Welcome ${candidate} to Online Job Search Portal</h2><br>
  		<p class="col-sm-9 control-label">Find jobs using this Portal, the most comprehensive search engine for jobs</p>
  		<p class="col-sm-9 control-label">In a single search, it offers free access to millions of jobs from thousands of companies </p>
  		<p class="col-sm-9 control-label">From search to apply, this Job Search Portal helps you through the entire process of finding a Great and Successful job.</p>
  		
  		</div>
  		</div>
  		</div>
  		</div>
  		
</body>
</html>