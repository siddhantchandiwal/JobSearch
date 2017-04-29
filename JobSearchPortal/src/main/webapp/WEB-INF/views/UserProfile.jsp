<%-- 
    Document   : User Profile Page
    Created on : Apr 12, 2017, 06:08:09 PM
    Author     : Siddhant Chandiwal
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Online Job Search Profile Page</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap.css" />">
<link rel="stylesheet"
	href="<c:url value="/resources/css/signup.css" />">

<script type="text/javascript">
	function validate() {
		
		var flag = '';
		var errmsg="";
		letter = /^[A-Za-z]*$/;
		emailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})*$/;
		anotherletter=/^[0-9]{1,10}$/;
		
		var firstName = document.getElementById("firstName").value;
		var lastName = document.getElementById("lastName").value;	
		var email = document.getElementById("emailId").value;
		var phone = document.getElementById("phone").value;
		
		
		if (!letter.test(firstName)) {
			errmsg="*First Name must have valid alphabet characters";  
			flag = false;
		}else if (!letter.test(lastName)) {
			errmsg="*Last Name must have valid alphabet characters";  			
			flag = false;
		}else if (!emailformat.test(email)) {
			errmsg="*Please enter valid Email in the Generic Format";  			
			flag = false;
		}else if (firstName == ""|| firstName==null) {
			errmsg = "*First Name cannot be kept blank";
			flag = false;
		}else if (lastName == ""|| lastName==null) {
			errmsg = "*Last Name cannot be kept blank";
			flag = false;
		}else if (!anotherletter.test(phone)) {
			errmsg="*Please enter Correct Phone Number";  
			flag = false;
		}else{
			errmsg=" ";
		}
			document.getElementById("Error").innerHTML = errmsg;
		
		return flag;
	}
</script>


</head>
<body ng-controller="myCTRL">

<%
            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); //HTTP 1.1
            response.setHeader("Pragma", "no-cache"); //HTTP 1.0
            response.setDateHeader("Expires", 0); //prevents caching at the proxy server
            String role = (String) session.getAttribute("role");
            if (role == "Candidate") {
    %>
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<%@include file="CandidateHeader.jsp"%>


	<hr>
	<div class="container">
		<div class="row">
			<div class="col-lg-9 col-md-12">
				<div class="row">

					<form:form action="${contextPath}/Candidate/UserProfile.htm"
						commandName="user" method="post" class="form-horizontal"
						role="form" onsubmit="return validate();">


						<h3 align="center">Update Personal Information</h3>
						<div class="form-group">
							<input type="hidden" name="ID" value="${user.userId}" /> <label
								for="firstName" class="col-sm-3 control-label">First
								Name</label>
							<div class="col-sm-9">
								<form:input type="text" id="firstName" placeholder="First Name"
									path="firstName" class="form-control" />
								<form:errors path="firstName" cssStyle="color:#ff0000"></form:errors>
							</div>
						</div>

						<div class="form-group">
							<label for="firstName" class="col-sm-3 control-label">Last
								Name</label>
							<div class="col-sm-9">
								<form:input type="text" id="lastName" placeholder="Last Name"
									path="lastName" class="form-control" />
								<form:errors path="lastName" cssStyle="color:#ff0000"></form:errors>
							</div>
						</div>




						<div class="form-group">
							<label for="emailId" class="col-sm-3 control-label">Email</label>
							<div class="col-sm-9">
								<form:input type="email" id="emailId" placeholder="Email Id"
									path="emailId" class="form-control" />
								<form:errors path="emailId" cssStyle="color:#ff0000"></form:errors>
							</div>
						</div>

						<div class="form-group">
							<label for="emailId" class="col-sm-3 control-label"><h4>
									<b>Address</b>
								</h4></label>
						</div>

						<div class="form-group">
							<label for="streetLine1" class="col-sm-3 control-label">Street
								Line 1</label>
							<div class="col-sm-9">
								<form:input type="text" id="streetLine1"
									placeholder="Address Street Line 1" path="streetLine1"
									class="form-control" />
								<form:errors path="streetLine1" cssStyle="color:#ff0000"></form:errors>
							</div>
						</div>


						<div class="form-group">
							<label for="streetLine2" class="col-sm-3 control-label">Street
								Line 2</label>
							<div class="col-sm-9">
								<form:input type="text" id="streetLine2"
									placeholder="Address Street Line 2" path="streetLine2"
									class="form-control" />
								<form:errors path="streetLine2" cssStyle="color:#ff0000"></form:errors>
							</div>
						</div>

						<div class="form-group">
							<label for="city" class="col-sm-3 control-label">City</label>
							<div class="col-sm-9">
								<form:input type="text" id="city" placeholder="City" path="city"
									class="form-control" />
								<form:errors path="city" cssStyle="color:#ff0000"></form:errors>
							</div>
						</div>

						<div class="form-group">
							<label for="state" class="col-sm-3 control-label">State</label>
							<div class="col-sm-9">
								<form:input type="text" id="state" placeholder="State"
									path="state" class="form-control" />
								<form:errors path="state" cssStyle="color:#ff0000"></form:errors>
							</div>
						</div>

						<div class="form-group">
							<label for="country" class="col-sm-3 control-label">Country</label>
							<div class="col-sm-9">
								<form:input type="text" id="country" placeholder="Country"
									path="country" class="form-control" />
								<form:errors path="country" cssStyle="color:#ff0000"></form:errors>
							</div>
						</div>

						<div class="form-group">
							<label for="phone" class="col-sm-3 control-label">Phone
								Number</label>
							<div class="col-sm-9">
								<form:input type="number" id="phone" placeholder="Phone Number"
									path="phone" class="form-control" required = "true"/>
								<form:errors path="phone" cssStyle="color:#ff0000"></form:errors>
							</div>
						</div>
						


						<div class="form-group">
							<div class="col-sm-9 col-sm-offset-3">
								<button type="submit" class="btn btn-primary btn-block">Submit</button>

							</div>
						</div>

						<p>
							<label id="Error" style="color: red;"></label>
						</p>


					</form:form>
				</div>
				<!-- /form -->
			</div>
			
			<%
}
%>
</body>
</html>

