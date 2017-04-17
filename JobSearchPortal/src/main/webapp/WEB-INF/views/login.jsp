<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>

<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Online Job Search Portal</title>

<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap.css" />">
<link rel="stylesheet"
	href="<c:url value="/resources/css/signup.css" />">


</head>
<body ng-controller="myCTRL">
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<%@include file="MainHeader.jsp"%>


	<hr>
	<div class="container">
		<div class="row">
			<div class="col-lg-9 col-md-12">
				<div class="row">

				<form:form action="${contextPath}/login.htm" commandName="user" method="post" class="form-horizontal" role="form" onsubmit="return validate()">

						<h3 class="text-center">Sign In To Continue</h3>


						<div class="form-group">
							<label for="userName" class="col-sm-3 control-label">UserName</label>
							<div class="col-sm-9">
								<form:input type="text" id="userName" placeholder="User Name"
									path="userName" class="form-control" />
								<form:errors path="userName" cssStyle="color:#ff0000"></form:errors>
								
							</div>
						</div>
						<div class="form-group">
							<label for="password" class="col-sm-3 control-label">Password</label>
							<div class="col-sm-9">
								<form:input type="password" id="password" placeholder="Password"
									path="password" class="form-control" />
								<form:errors path="password" cssStyle="color:#ff0000"></form:errors>
							</div>
						</div>
						

						<div class="form-group">
							<div class="col-sm-9 col-sm-offset-3">
								<button type="submit" class="btn btn-primary btn-block">Login</button>
								
							</div>
						</div>
						
						<p class="col-sm-5 control-label" ><a href="SignUp.htm" >Register here</a></p>
						<p>
							<label id="ErrorMsgForm"  style="color:red;"></label>
						</p>
						

						<div>
					<h4 class="col-sm-9 control-label" style="color: red;">${requestScope.loginFailed}</h4>
					</div>
					</form:form>
				</div>
			
			</div>
			

</body>



</html>