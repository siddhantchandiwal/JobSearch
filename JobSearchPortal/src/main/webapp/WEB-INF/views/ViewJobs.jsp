<%-- 
    Document   : ViewJobs
    Created on : Apr 4, 2017, 11:08:23 PM
    Author     : Siddhant Chandiwal
--%>

<!DOCTYPE html>
<html lang="en">
<head>
  <title>Online Job Search Home Page</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  
</head>
<body>
<%@include file="CandidateHeader.jsp" %>
  		<h2>View Jobs Page</h2>
  		
  		<form action="ViewJobs.htm" method="post">
            
         <div class="form-group">
				<label class="col-sm-2 control-label">Job Title</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="jobTitle"
						name="jobTitle" />
				</div>
			</div>
			
			
			<div class="form-group">

				<label class="col-sm-2 control-label">Job Location</label>

				<div class="col-sm-10">

					<input type="text" class="form-control" id="jobLocationCity"
						name="jobLocationCity" />

				</div>
			</div>
			<br>
			<div class="form-group">
				<div class="col-sm-2"></div>
				<div class="container,col-sm-10">
					<div class="container">
						<input type="submit" class="btn btn-info" value="Submit">
						<input type="reset" class="btn btn-info" value="Refresh">

					</div>
				</div>
			</div>


</form>
  		

 

</body>
</html>