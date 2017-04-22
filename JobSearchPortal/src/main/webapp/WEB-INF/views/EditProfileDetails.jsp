<%-- 
    Document   : AddEducation
    Created on : Apr 4, 2017, 11:08:23 PM
    Author     : Siddhant Chandiwal
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Edit Profile Details</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  
  <link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap.css" />">
<link rel="stylesheet"
	href="<c:url value="/resources/css/signup.css" />">
  
</head>
<body ng-controller="myCTRL">
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<%@include file="CandidateHeader.jsp"%>


	<hr>
	<div class="container">
		<div class="row">
			<div class="col-lg-9 col-md-12">
				<div class="row">

					<form:form action="${contextPath}/EditAD.htm" commandName="profileDetails" method="post" class="form-horizontal" role="form" >
					
					<input type="hidden" name="ID" value="${profileDetails.profileID}"/>


						<h3 align="center">Please fill below details</h3>
	

						<div class="form-group">
							<label for="educationLevel" class="col-sm-3 control-label">Education Level</label>
							<div class="col-sm-9">
								<form:input type="text" id="educationLevel" placeholder="Education Level" path="educationLevel" class="form-control" />
								<form:errors path="educationLevel" cssStyle="color:#ff0000"></form:errors>
							</div>
						</div>




						<div class="form-group">
							<label for="major" class="col-sm-3 control-label">Major</label>
							<div class="col-sm-9">
								<form:input type="text" id="major" placeholder="Major"
									path="major" class="form-control" />
								<form:errors path="major" cssStyle="color:#ff0000"></form:errors>
							</div>
						</div>


						<div class="form-group">
							<label for="gpa" class="col-sm-3 control-label">GPA</label>
							<div class="col-sm-9">
								<form:input type="text" id="gpa" placeholder="Grade Point Average" path="gpa" class="form-control" />
								<form:errors path="gpa" cssStyle="color:#ff0000"></form:errors>
							</div>
						</div>


						<div class="form-group">
							<label for="startYear" class="col-sm-3 control-label">Start Year</label>
							<div class="col-sm-9">
								<form:input type="text" id="startYear" placeholder="Start Year" path="startYear" class="form-control" />
								<form:errors path="startYear" cssStyle="color:#ff0000"></form:errors>
							</div>
						</div>

						<div class="form-group">
							<label for="expYearOfGraduation" class="col-sm-3 control-label">Expected Year of Graduation</label>
							<div class="col-sm-9">
								<form:input type="text" id="expYearOfGraduation" placeholder="Year of Graduation" path="expYearOfGraduation" class="form-control" />
								<form:errors path="expYearOfGraduation" cssStyle="color:#ff0000"></form:errors>
							</div>
						</div>

						<div class="form-group">
							<label for="universityName" class="col-sm-3 control-label">University Name</label>
							<div class="col-sm-9">
								<form:input type="text" id="universityName" placeholder="University Name" path="universityName" class="form-control" />
								<form:errors path="universityName" cssStyle="color:#ff0000"></form:errors>
							</div>
						</div>

						<div class="form-group">
							<label for="universityAddress" class="col-sm-3 control-label">University Address</label>
							<div class="col-sm-9">
								<form:input type="text" id="universityAddress" placeholder="University Address" path="universityAddress" class="form-control" />
								<form:errors path="universityAddress" cssStyle="color:#ff0000"></form:errors>
							</div>
						</div>
						
						
						<div class="form-group">
							<label for="companyName" class="col-sm-3 control-label">Company Name</label>
							<div class="col-sm-9">
								<form:input type="text" id="companyName" placeholder="Company Name" path="companyName" class="form-control" />
								<form:errors path="companyName" cssStyle="color:#ff0000"></form:errors>
							</div>
						</div>
						
						
						<div class="form-group">
							<label for="companyType" class="col-sm-3 control-label">Company Type</label>
							<div class="col-sm-9">
								<form:input type="text" id="companyType" placeholder="Company Type" path="companyType" class="form-control" />
								<form:errors path="companyType" cssStyle="color:#ff0000"></form:errors>
							</div>
						</div>

						<div class="form-group">
							<label for="jobTitle" class="col-sm-3 control-label">Job Title</label>
							<div class="col-sm-9">
								<form:input type="text" id="jobTitle" placeholder="Job Title" path="jobTitle" class="form-control" />
								<form:errors path="jobTitle" cssStyle="color:#ff0000"></form:errors>
							</div>
						</div>	

						<div class="form-group">
							<label for="annualStartPay" class="col-sm-3 control-label">Start Pay</label>
							<div class="col-sm-9">
								<form:input type="text" id="annualStartPay" placeholder="Annual Start Pay" path="annualStartPay" class="form-control" />
								<form:errors path="annualStartPay" cssStyle="color:#ff0000"></form:errors>
							</div>
						</div>
						
						<div class="form-group">
							<label for="annualEndPay" class="col-sm-3 control-label">End Pay</label>
							<div class="col-sm-9">
								<form:input type="text" id="annualEndPay" placeholder="Annual End Pay" path="annualEndPay" class="form-control" />
								<form:errors path="annualEndPay" cssStyle="color:#ff0000"></form:errors>
							</div>
						</div>
						
						<div class="form-group">
							<label for="companyCity" class="col-sm-3 control-label">City</label>
							<div class="col-sm-9">
								<form:input type="text" id="companyCity" placeholder="Company City" path="companyCity" class="form-control" />
								<form:errors path="companyCity" cssStyle="color:#ff0000"></form:errors>
							</div>
						</div>
						
						<div class="form-group">
							<label for="companyState" class="col-sm-3 control-label">State</label>
							<div class="col-sm-9">
								<form:input type="text" id="companyState" placeholder="Company State" path="companyState" class="form-control" />
								<form:errors path="companyState" cssStyle="color:#ff0000"></form:errors>
							</div>
						</div>
						
						<div class="form-group">
							<label for="companyCountry" class="col-sm-3 control-label">Country</label>
							<div class="col-sm-9">
								<form:input type="text" id="companyCountry" placeholder="Company Country" path="companyCountry" class="form-control" />
								<form:errors path="companyCountry" cssStyle="color:#ff0000"></form:errors>
							</div>
						</div>
						
						<div class="form-group">
							<label for="companyZipCode" class="col-sm-3 control-label">Zip Code</label>
							<div class="col-sm-9">
								<form:input type="text" id="companyZipCode" placeholder="Company Zip Code" path="companyZipCode" class="form-control" />
								<form:errors path="companyZipCode" cssStyle="color:#ff0000"></form:errors>
							</div>
						</div>


						<div class="form-group">
							<div class="col-sm-9 col-sm-offset-3">
								<button type="submit" class="btn btn-primary btn-block">Submit</button>

							</div>
						</div>
						
						<div class="form-group">
							<div class="col-sm-9 col-sm-offset-3">
								<button type="reset" class="btn btn-primary btn-block">Refresh</button>

							</div>
						</div>

						<p>
							<label id="Error" style="color: red;"></label>
						</p>


					</form:form>
				</div>
				<!-- /form -->
			</div>
</body>
</html>