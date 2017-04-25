<%-- 
    Document   : EmpProfile
    Created on : Apr 4, 2017, 11:08:23 PM
    Author     : Siddhant Chandiwal
--%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
//get the category list
       /* com.me.onlinejobsearch.dao.OrganizationDAO orgD = new com.me.onlinejobsearch.dao.OrganizationDAO();
        java.util.List orgList = orgD.list();
        pageContext.setAttribute("orgList", orgList);*/
%>

<!DOCTYPE html>
<html lang="en">
<head>
  <title>Employer Profile Page</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  
</head>
<body>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%@include file="employerheader.jsp" %>


<div class="container">
  <h2>Please fill the details</h2>
  <form:form action="${contextPath}/Employer/EmpProfile.htm" commandName="employer" method="post" class="form-horizontal" >
    <div class="form-group">
      
     <label class="col-sm-2 control-label">FirstName</label>
      <div class="col-sm-10">
        <form:input type="text" class="form-control" id="orgName" path="firstName"/>
      </div>
     </div>
      <div class="form-group">
     <label class="col-sm-2 control-label">Last Name:</label>
      <div class="col-sm-10">
        <form:input type="text" class="form-control" id="orgType" path="lastName"/>
      </div>
      </div>
      
       <div class="form-group">     
 <label class="col-sm-2 control-label">Organization Name:</label>
     
      <div class="col-sm-10">
  
    
      <form:select path="orgName" class="form-control">
                            <c:forEach var="org" items="${orgList}">
                                <form:option value="${org.organizationName}"/>
                            </c:forEach>
    </form:select>
     </div>  
   </div> 
        
     

  
  <div class="form-group">
				<div class="col-sm-2"></div>
				<div class="container,col-sm-10">
					<div class="container">
						<input type="submit" class="btn btn-info" value="Submit">
						<input type="reset" class="btn btn-info" value="Refresh">

					</div>
				</div>
				</div>
     </form:form>
</div>




</body>
</html>
