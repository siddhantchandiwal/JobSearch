<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>GetEmployed login Page</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
 
</head>
<body>
<%@include file="MainHeader.jsp" %>
<div class="container">
  <div class="col-sm-2 control-label"></div>
      <div class="col-sm-10">
       <h3>  Login Page </h3>
      </div>
  <form:form action="login.htm" commandName="user" method="post" class="form-horizontal" >
  
  <div class="form-group">
      
    
     <div class="form-group">
      
     <label class="col-sm-2 control-label">User Name:</label>
      <div class="col-sm-10">
        <form:input type="text" class="form-control" id="userName" path="userName"/>
      </div>
     </div>
      <div class="form-group">
     <label class="col-sm-2 control-label">Password:</label>
      <div class="col-sm-10">
        <form:input type="password" class="form-control" id="password" path="password"/>
      </div>
    </div>
      <br/><br/>
   <div class="container">
  <div class="col-sm-2 control-label"></div>
       <div class= "col-sm-10" >  <input type="submit" class="btn btn-info" value="Submit">
          <input type="reset" class="btn btn-info" value="Refresh">
       </div>   
      </div>
    </div>  
  </form:form>
</div>

</body>
</html>