<%-- 
    Document   : UserProfile
    Created on : Apr 2, 2017, 06:08:09 PM
    Author     : Siddhant Chandiwal
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Online Job Search Profile Page</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  
</head>
<body>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%@include file="CandidateHeader.jsp" %>
  		<h2>User Profile Page</h2>
  		
  		
  <div class="container">
  
  
  
  
  <form:form action="${contextPath}/UserProfile.htm" commandName="user" method="post" class="form-horizontal" >
   <div class="form-group">
	<input type="hidden" name="ID" value="${user.userId}"/>      
     <div class="col-sm-2 control-label"></div>
      <div class="col-sm-10">
       <h3>  Please enter your profile information: </h3>
      </div>
  
  </div>
    <div class="form-group">
      
     <label class="col-sm-2 control-label">First Name:</label>
      <div class="col-sm-10">
        <form:input type="text" class="form-control" id="firstName" path="firstName"/>
        
      </div>
     </div>
      <div class="form-group">
     <label class="col-sm-2 control-label">Last Name:</label>
      <div class="col-sm-10">
        <form:input type="text" class="form-control" id="lastName" path="lastName"/>
       
      </div>
    </div>
      <div class="form-group">
     <label class="col-sm-2 control-label">Email address:</label>
      <div class="col-sm-10">
        <form:input type="email" class="form-control" id="emailId" path="emailId"/>
       
      </div>
    </div>
    
    <div class="form-group">
     <label class="col-sm-2 control-label"><h4>ADDRESS</h4></label>
      <div class="col-sm-10">
        
      </div>
      </div>
    
      <div class="form-group">
          
     <label class="col-sm-2 control-label">Address Street Line1:</label>
      <div class="col-sm-10">
        <form:input type="text" class="form-control" id="streetLine1" name="streetLine1" path="streetLine1"/>
       
      </div>
     <label class="col-sm-2 control-label">Address Street Line2:</label>
      <div class="col-sm-10">
        <form:input type="text" class="form-control" id="streetLine2" path="streetLine2"/>
      </div>
      <label class="col-sm-2 control-label">City:</label>
      
      <div class="col-sm-10">
        <form:input type="text" class="form-control" id="city" path="city"/>
       
      </div>
      
      <label class="col-sm-2 control-label">State:</label>
      
      <div class="col-sm-10">
        <form:input type="text" class="form-control" id="state" path="state"/>
       
      </div>
      
      <label class="col-sm-2 control-label">Country:</label>
      
      <div class="col-sm-10">
        <form:input type="text" class="form-control" id="country" path="country"/>
       
      </div>
      <label class="col-sm-2 control-label">Zip Code</label>
      <div class="col-sm-10">
        <form:input type="text" class="form-control" id="zipcode" path="zipCode"/> 
      
      </div>
    
    

    <label class="col-sm-2 control-label">Phone Number</label>
    <div class="col-sm-10">
        <form:input type="text" class="form-control" id="phone" path="phone"/>
       
      </div>
    
    </div>
    
      
      <div class="container">
          <input type="submit" class="btn btn-info" value="Submit">
          <input type="reset" class="btn btn-info" value="Refresh">
          
      </div>
      
  </form:form>
</div>
  
  		

 

</body>
</html>