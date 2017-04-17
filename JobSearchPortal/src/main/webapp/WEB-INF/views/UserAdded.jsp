<%-- 
    Document   : UserAdded
    Created on : Apr 4, 2017, 11:08:23 PM
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
<body ng-controller="myCTRL">
	<%@include file="MainHeader.jsp"%>
	<div class="container">
		<div class="row">
			<div class="col-lg-9 col-md-12">
				<div class="row">

					<h3 class="text-center">User Added Successfully</h3>

					<h4 class="text-center">
						<a href="login.htm">Click here to Login </a>
					</h4>

				</div>
			</div>
		</div>
	</div>


</body>
</html>