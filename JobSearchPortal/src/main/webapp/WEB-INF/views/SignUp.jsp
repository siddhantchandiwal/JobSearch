<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>

<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Online Job Search Portal</title>

<link rel="stylesheet" 	href="<c:url value="/resources/css/bootstrap.css" />">
<link rel="stylesheet" 	href="<c:url value="/resources/css/signup.css" />">


<script type="text/javascript">
	function validate() {
		
		var flag = '';
		var errmsg="";
		letter = /^[A-Za-z]*$/;
		emailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})*$/;
		

		var firstName = document.getElementById("firstName").value;
		var lastName = document.getElementById("lastName").value;	
		var userName = document.getElementById("userName").value;
		var password = document.getElementById("password").value;
		var email = document.getElementById("emailId").value;
		
		if (!letter.test(firstName)) {
			errmsg="*First Name must have valid alphabet characters";  
			flag = false;
		}else if (!letter.test(lastName)) {
			errmsg="*Last Name must have valid alphabet characters";  			
			flag = false;
		}else if (!emailformat.test(email)) {
			errmsg="*Please enter valid Email in the Generic Format";  			
			flag = false;
		}else if (userName == ""|| userName==null) {
			errmsg = "*UserName cannot be kept blank";
			flag = false;
		}else if (password == ""|| password==null) {
			errmsg = "*Password cannot be kept blank";
			flag = false;
		}else if (firstName == ""|| firstName==null) {
			errmsg = "*First Name cannot be kept blank";
			flag = false;
		}else if (lastName == ""|| lastName==null) {
			errmsg = "*Last Name cannot be kept blank";
			flag = false;
		}else{
			errmsg=true;
		}
		
			document.getElementById("ErrorMsgForm").innerHTML = errmsg;
		
		return flag;
	}
</script>


</head>
<body ng-controller="myCTRL">
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<%@include file="MainHeader.jsp"%>


	<hr>
	<div class="container">
		<div class="row">
			<div class="col-lg-9 col-md-12">
				<div class="row">

				<form:form action="${contextPath}/SignUp.htm" commandName="user" method="post" class="form-horizontal" role="form" onsubmit="return validate()">


						<h3 align="center">SignUp Form</h3>
						<div class="form-group">
							<label for="firstName" class="col-sm-3 control-label">First Name</label>
							<div class="col-sm-9">
								<form:input type="text" id="firstName" placeholder="First Name"
									path="firstName" class="form-control" />
								<form:errors path="firstName" cssStyle="color:#ff0000"></form:errors>
							</div>
						</div>
						
						<div class="form-group">
							<label for="firstName" class="col-sm-3 control-label">Last Name</label>
							<div class="col-sm-9">
								<form:input type="text" id="lastName" placeholder="Last Name"
									path="lastName" class="form-control" />
								<form:errors path="lastName" cssStyle="color:#ff0000"></form:errors>
							</div>
						</div>
						


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
							<label for="emailId" class="col-sm-3 control-label">Email</label>
							<div class="col-sm-9">
								<form:input type="text" id="emailId" placeholder="Email Id" path="emailId"
									class="form-control" />
								<form:errors path="emailId" cssStyle="color:#ff0000"></form:errors>
							</div>
						</div>
						
						
						<div class="form-group">
							<label for="email" class="col-sm-3 control-label">User Type</label>
							<div class="col-sm-9">
								<form:select id="userType" placeholder="userType" path="userType"  class="form-control" >
									<option>Candidate</option>
									<option>Employer</option>
									<option>Admin</option>
							 </form:select>
							</div>
						</div>
						
						
						
			
						<div class="form-group">
							<div class="col-sm-9 col-sm-offset-3">
								<button type="submit" class="btn btn-primary btn-block" onclick="return validate()">Register</button>
								
							</div>
						</div>
						
						
						<c:if test="${errormessage!=null}">
						<span class="control-label" style="color:red;">Email/UserName already exist. Please check details again</span>
						</c:if>
					</form:form>
				</div>
				<!-- /form -->
			</div>
			

</body>



</html>