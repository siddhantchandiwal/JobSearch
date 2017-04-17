<%-- 
    Document   : Main
    Created on : Apr 4, 2016, 11:08:23 PM
    Author     : Siddhant Chandiwal
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Online Job Search Portal</title>

<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap.css" />">



</head>
<body>

	<%@include file="MainHeader.jsp"%>

	<div class="container" style="">
		<div class="row">
			<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 hidden-xs">
				<div id="carousel-299058" class="carousel slide">
					<ol class="carousel-indicators">
						<li data-target="#carousel-299058" data-slide-to="0"
							class="active"></li>
						<li data-target="#carousel-299058" data-slide-to="1" class="">
						</li>
						<li data-target="#carousel-299058" data-slide-to="2" class="">
						</li>
					</ol>
					<div class="carousel-inner" style="width: 100%;">
						<div class="item">
							<img class="img-responsive"
								src="<c:url value="/resources/images/Front1.jpg"/>" alt="thumb">
							<div class="carousel-caption">Online Job Search Portal</div>
						</div>
						<div class="item active">
							<img class="img-responsive"
								src="<c:url value="/resources/images/Front2.jpg"/>" alt="thumb">
							<div class="carousel-caption">Online Job Search Portal</div>
						</div>
						<div class="item">
							<img class="img-responsive"
								src="<c:url value="/resources/images/Front3.jpg"/>" alt="thumb">
							<div class="carousel-caption">Online Job Search Portal</div>
						</div>
					</div>
					<a class="left carousel-control" href="#carousel-299058" data-slide="prev"><span class="icon-prev"></span></a>
					 <a class="right carousel-control" href="#carousel-299058" data-slide="next"><span class="icon-next"></span></a>
				</div>
			</div>
		</div>
		<hr>
	</div>


</body>
</html>