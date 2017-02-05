<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Logout</title>


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
		<a href="login.html" class="nav_logout">Home</a>
	</div>
	<div id="line"></div>
	<div id="logout_image"><img alt="logout" src="images/loggedout.png"></div>

		<div id="footer">Copyright @ 2016 Wipro Technologies. All rights
		reserved</div>



	
</body>
</html>