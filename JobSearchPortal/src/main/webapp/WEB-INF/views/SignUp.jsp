<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Online Job Search Registration</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <script type="text/javascript">
  function validate()
  {
	  var firstName =document.getElementsByTagName("input")[0].value;
	  var lastName = document.getElementsByTagName("input")[1].value;
	  var userName = document.getElementsByTagName("input")[2].value;
	  var password = document.getElementsByTagName("input")[3].value;
	  
	  var regex = /^[a-zA-Z]{1,30}$/;
	  
	  if (!firstName.match(regex)|| firstName == null || firstName == "") {
	        alert("Not a valid First Name");
	        return false;
	    }
	  
	  
	  if (!lastName.match(regex)|| lastName == null || lastName == "") {
	        alert("Not a valid Last Name");
	        return false;
	    }
	  
	  if (!userName.match(regex)|| userName == null || userName == "") {
	        alert("Not a valid User Name");
	        return false;
	    }
	  
	  if (!password.match(regex)|| password == null || password == "") {
	        alert("Not a valid Password");
	        return false;
	    }  
	  
  }
  
  </script>
  
</head>
<body>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<%@include file="MainHeader.jsp" %>
<div class="container">
  <div class="col-sm-2"></div>
      <div class="col-sm-10">
       <h3>  Sign Up Page </h3>
       <c:out value="${contextPath}" /> 
      </div>
  <form:form action="${contextPath}/SignUp.htm" commandName="user" method="post" class="form-horizontal" >
  
  <div>
      
     <label class="col-sm-2">First Name:</label>
      <div class="col-sm-10">
        <form:input type="text" id="first" path="firstName"/><form:errors path="firstName"/></font>
      </div>
     </div>
    <div>
      
     <label class="col-sm-2 ">Last name:</label>
      <div class="col-sm-10">
        <form:input type="text"  id="last" path="lastName"/><form:errors path="lastName"/></font>
      </div>
     </div>
     <div>
      
     <label class="col-sm-2">User Name:</label>
      <div class="col-sm-10">
        <form:input type="text"  id="userName" path="userName"/><form:errors path="userName"/></font>
      </div>
     </div>
      <div>
     <label class="col-sm-2">Password:</label>
      <div class="col-sm-10">
        <form:input type="password" id="password" path="password"/><form:errors path="password"/></font>
      </div>
    </div>
      <div>
      
      <div>
     <label class="col-sm-2">Email Id:</label>
      <div class="col-sm-10">
        <form:input type="text" id="emailid" path="emailId"/><form:errors path="emailId"/></font>
      </div>
    </div>
      <div>
      
      
      
     <label class="col-sm-2">User Type:</label>
     
      <div class="col-sm-10">
      
      <form:select  id="sel1" path="userType">
        <option>Candidate</option>
        <option>Employer</option>
        <option>Admin</option>
        
      </form:select>
    
      </div>
   </div>
   <div>
   <div class="col-sm-2"></div>
            <div class="container,col-sm-10">
          <input type="submit" class="btn btn-info" value="Submit" onclick="return validate()">
          <input type="reset" class="btn btn-info" value="Refresh">
          
      </div>
      </div>
      
  </form:form>
</div>

</body>
</html>