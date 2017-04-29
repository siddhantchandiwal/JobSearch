<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en" ng-app="myApp">
<head>
<meta charset="utf-8">
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
		alletters = /^[0-9a-zA-Z,. ]*$/;
		diffletter=/^[0-9.]*$/;
		anotherletter=/^[0-9]*$/;
		userletter=/^[0-9a-zA-Z]*$/;
		

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
		}else if (!userletter.test(userName)) {
			errmsg="*Please enter Proper UserName";  			
			flag = false;
		}else{
			errmsg	= ""
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
								<form:input type="text" id="firstName" placeholder="First Name" required = "true"
									path="firstName" class="form-control" />
								<form:errors path="firstName" cssStyle="color:#ff0000"></form:errors>
							</div>
						</div>
						
						<div class="form-group">
							<label for="firstName" class="col-sm-3 control-label">Last Name</label>
							<div class="col-sm-9">
								<form:input type="text" id="lastName" placeholder="Last Name" required = "true"
									path="lastName" class="form-control" />
								<form:errors path="lastName" cssStyle="color:#ff0000"></form:errors>
							</div>
						</div>
						


						<div class="form-group">
							<label for="userName" class="col-sm-3 control-label">UserName</label>
							<div class="col-sm-9">
								<form:input type="text" id="userName" placeholder="User Name" required = "true"
									path="userName" class="form-control" />
								<form:errors path="userName" cssStyle="color:#ff0000"></form:errors>
								
							</div>
						</div>
						<div class="form-group">
							<label for="password" class="col-sm-3 control-label">Password</label>
							<div class="col-sm-9">
								<form:input type="password" id="password" placeholder="Password" required = "true"
									path="password" class="form-control" />
								<form:errors path="password" cssStyle="color:#ff0000"></form:errors>
							</div>
						</div>
						
						
						<div class="form-group">
							<label for="emailId" class="col-sm-3 control-label">Email</label>
							<div class="col-sm-9">
								<form:input type="text" id="emailId" placeholder="Email Id" path="emailId" required = "true"
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
								<button type="submit" class="btn btn-primary btn-block" >Register</button>
								
							</div>
						</div>
						
						<c:if test="${errormessage!=null}">
						<span class="control-label" style="color:red;">Email/UserName already exist. Please check details again</span>
						</c:if>
						
						
						<p>
							<label id="ErrorMsgForm" class="control-label" style="color:red;"></label>
						</p>
					</form:form>
				</div>
				<!-- /form -->
			</div>
			</div>
			</div>
			
			

</body>

<script>
	<%--var myApp = angular.module("myApp", []);
	myApp.controller("myCTRL", function($scope, $http) {
		$scope.searchusername = function() {
			$http.get('checkusername', {
				params : {
					"userName" : $scope.userName
				}
			}).success(function(data, status, headers, config, response) {
				if (data.avail == true) {
					$scope.usernameStyle = {
						'background-color' : 'blue'
					};
					$scope.UserSpan = "User Name Available";
				} else {
					$scope.usernameStyle = {
						'background-color' : 'red'
					};
					$scope.UserSpan = "User Name not Available. Please choose something different";
				}
			}).error(function(data, status, header, config) {
				alert('getfail');
				$scope.ResponseDetails = "Data: " + data;
			});
		};

		$scope.searchemail = function() {
			$http.get('checkemail', {
				params : {
					"emailId" : $scope.emailId
				}
			}).success(function(data, status, headers, config, response) {
				if (data.avail == true) {
					$scope.emailStyle = {
						'background-color' : 'blue'
					};
					$scope.emailSpan = "Email Available";
				} else {
					$scope.emailStyle = {
						'background-color' : 'red'
					};
					$scope.emailSpan = "Email not Available";
				}
			}).error(function(data, status, header, config) {
				alert('getfail');
				$scope.ResponseDetails = "Data: " + data;
			});
		};

	}); --%>
</script>



</html>