<%-- 
    Document   : AddEducation
    Created on : Apr 4, 2017, 11:08:23 PM
    Author     : Siddhant Chandiwal
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <title>Add Profile Details</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  
 <link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap.css" />">
<link rel="stylesheet"
	href="<c:url value="/resources/css/signup.css" />"> 
	
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" 
integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.min.js" integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
    crossorigin="anonymous"></script>
	
	<script type="text/javascript">
function call() {
		
		var flag = '';
		var errmsg="";
		
		letter = /^[A-Za-z]*$/;
		alletters = /^[0-9a-zA-Z ,. ]*$/;
		diffletter=/^[0-9.]*$/;
		anotherletter=/^[0-9]*$/;
		zipletter=/^[0-9]{5,7}$/;
		
	

		var educationLevel = document.getElementById("educationLevel").value;
		var major = document.getElementById("major").value;
		var gpa = document.getElementById("gpa").value;
		var startYear = document.getElementById("startYear").value;
		var expYearOfGraduation = document.getElementById("expYearOfGraduation").value;
		var universityName = document.getElementById("universityName").value;
		var universityAddress = document.getElementById("universityAddress").value;
		var companyName = document.getElementById("companyName").value;
		var companyType = document.getElementById("companyType").value;
		var jobTitle = document.getElementById("jobTitle").value;
		var annualStartPay = document.getElementById("annualStartPay").value;
		var annualEndPay = document.getElementById("annualEndPay").value;
		var companyCity = document.getElementById("companyCity").value;
		var companyState = document.getElementById("companyState").value;
		var companyCountry = document.getElementById("companyCountry").value;
		var companyZipCode = document.getElementById("companyZipCode").value;
		
		
		
		
		
		if (!letter.test(educationLevel)) {
			errmsg="*Education Level should contain only characters";  
			flag = false;
		}else if (!alletters.test(major)) {
			errmsg="*Please enter proper Major";  
			flag = false;
		}else if (parseInt(gpa) <= 0) {
			errmsg = "*The gpa  should not be negative or zero";
			flag = false;
		}else if (parseInt(gpa) > 4) {
			errmsg = "*The gpa  cannot be greater than 4";
			flag = false;
		}else if (parseInt(startYear) > 2018) {
			errmsg = "*Start Year cannot be greater than current year";
			flag = false;
		}else if (parseInt(startYear) < 1900) {
			errmsg = "*Please enter correct Start Year value";
			flag = false;
		}else if (!anotherletter.test(startYear)) {
			errmsg="*Please enter proper Start Year Value";  
			flag = false;
		}else if (!anotherletter.test(expYearOfGraduation)) {
			errmsg="*Please enter proper Year of Graduation";  
			flag = false;
		}else if (!letter.test(universityName)) {
			errmsg="*University Name should contain only characters";  
			flag = false;
		}else if (!alletters.test(universityAddress)) {
			errmsg="*Please enter proper Address";  
			flag = false;
		}else if (!alletters.test(companyName)) {
			errmsg="*Please correct Company Name";  
			flag = false;
		}else if (!letter.test(companyType)) {
			errmsg="*Please correct Company Type";  
			flag = false;
		}else if (!alletters.test(jobTitle)) {
			errmsg="*Job Title should contain only characters";  
			flag = false;
		}else if (!diffletter.test(annualStartPay)) {
			errmsg="*Please enter proper Start Pay";  
			flag = false;
		}else if (letter.test(annualStartPay)) {
			errmsg = "*Annual Package should not contain characters";
			flag = false;
		}else if (parseInt(annualStartPay) < 0) {
			errmsg = "*Annual Package should not be Less than zero";
			flag = false;
		}else if (parseInt(annualEndPay) < 0) {
			errmsg = "*Annual End Package should not be Less than zero";
			flag = false;
		}else if (!diffletter.test(annualEndPay)) {
			errmsg="*Please enter proper End Pay";  
			flag = false;
		}else if (!letter.test(companyCity)) {
			errmsg="*Please enter proper City Name";  
			flag = false;
		}else if (!letter.test(companyState)) {
			errmsg="*Please enter proper State Name";  
			flag = false;
		}else if (!letter.test(companyCountry)) {
			errmsg="*Please enter proper Country Name";  
			flag = false;
		}else if (parseInt(companyZipCode) <= 0) {
			errmsg = "*The Zip Number should not be negative or zero.";
			flag = false;
		}else if (!zipletter.test(companyZipCode)) {
			errmsg="*Please enter proper Zip code value";  
			flag = false;
		}

		else{
			errmsg="" ;
		}

			document.getElementById("ErrorMsgForm").innerHTML = errmsg;
		
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

					<form:form action="${contextPath}/Candidate/addAD.htm" commandName="profileDetails" data-toggle="validator" method="post" class="form-horizontal" role="form" onsubmit="return call()" >


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
								<form:input type="text" id="major" placeholder="Major" path="major" class="form-control" />
								<form:errors path="major" cssStyle="color:#ff0000"></form:errors>
							</div>
						</div>


						<div class="form-group">
							<label for="gpa" class="col-sm-3 control-label">GPA</label>
							<div class="col-sm-9">
								<form:input type="text" id="gpa" placeholder="Grade Point Average" path="gpa" pattern="[0-9]*\.?[0-9]*" class="form-control" />
								<form:errors path="gpa" cssStyle="color:#ff0000"></form:errors>
							</div>
						</div>


						<div class="form-group">
							<label for="startYear" class="col-sm-3 control-label">Start Year</label>
							<div class="col-sm-9">
								<form:input type="number" id="startYear" placeholder="Start Year" path="startYear" class="form-control" required = "true"/>
								<form:errors path="startYear" cssStyle="color:#ff0000"></form:errors>
							</div>
						</div>

						<div class="form-group">
							<label for="expYearOfGraduation" class="col-sm-3 control-label">Expected Year of Graduation</label>
							<div class="col-sm-9">
								<form:input type="number" id="expYearOfGraduation" placeholder="Year of Graduation" path="expYearOfGraduation" class="form-control" required = "true"/>
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
								<form:input type="number" id="companyZipCode" placeholder="Company Zip Code" path="companyZipCode" class="form-control" />
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
						<label id="ErrorMsgForm" class="control-label" style="color:red;" ></label>
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