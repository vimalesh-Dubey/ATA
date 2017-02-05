<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home page</title>


<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/bootstrap-theme.min.css">
<link rel="stylesheet" href="css/style1.css">
<script src="js/jquery-2.1.4.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<style>
#fid {
	position: relative;
	-webkit-animation: mymove 5s infinite; /* Chrome, Safari, Opera */
	animation: mymove 5s infinite;
}

/* Chrome, Safari, Opera */
@
-webkit-keyframes mymove {
	from {left: 0px;
}

to {
	left: 150px;
}

}
@
keyframes mymove {
	from {left: 0px;
}

to {
	left: 150px;
}
}
</style>
</head>
<body>
	<div id="header">
		<img alt="logo" class="logo" align="left" src="images/wipro_logo.png">
		<img alt="title" class="title_img" align="right"
			src="images/title_1.png">
	</div>
	<div id="line"></div>

	<div id="nav_h">
		&nbsp;&nbsp;&nbsp;Hello!<span id="uname"> ${usrname}&nbsp;&nbsp;&nbsp;</span>
		<a
			href="login.html" class="nav_l1">Home</a>&nbsp;&nbsp;&nbsp;<a href="reset_pwd.html">Change password</a>
			&nbsp;&nbsp;&nbsp;<a href="logout.html">Logout</a>
	</div>
	<div id="line"></div>
	<div id="section" >
		<div id="nav_links">
			<table class="table tab_adj table-bordered table-hover">
				<tr>
					<th ><a href="viewusr_vehicle.html" style="margin-left: 100px;" target="content">View Vehicles</a></th>
				</tr>
				<tr>
					<th><a href="viewusr_route.html" style="margin-left: 100px;" target="content">View Routes</a></th>
				</tr>
				<tr>
					<th><a href="book_vehicle.html" style="margin-left: 100px;" target="content">Book Vehicle</a></th>
				</tr>
				<tr>
					<th><a href="cancel_booking.jsp" style="margin-left: 100px;" target="content">Cancel Booking</a></th>
				</tr>
				<tr>
					<th><a href="view_booking.html" style="margin-left: 100px;" target="content">View Booking Details</a></th>
				</tr>
			</table>
		</div>
		<div id="content">
			<iframe width=100% height=100% name="content"></iframe>
		</div>
		<div id="footer">Copyright @ 2016 Wipro Technologies. All rights
		reserved</div>
	</div>



	
</body>
</html>