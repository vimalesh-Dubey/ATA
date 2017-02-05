<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home page</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/bootstrap-theme.min.css">
<link rel="stylesheet" href="css/style.css">
<script src="js/jquery-2.1.4.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
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
			src="images/title_5.png">
	</div>
	<div id="line"></div>

	<div id="nav">
		<a href="#">About Us</a>&nbsp;&nbsp;&nbsp;<a href="#">Contact Us</a>
	</div>
	<div id="line"></div>
	<div style="height: 520px; width: 100%;">
		<div style="height: 520px; width: 59%; float: left;">
			<div>
				<i class="ci fa fa-check-circle-o fa-3x"></i>&nbsp;&nbsp;<span
					class="h2"><b>Convenience</b></span><br />
				<table style="margin-left: 100px;">
					<tr>
						<td><i class="fa fa-share">&nbsp;&nbsp;</i></td>
						<td>Book within seconds and get instant confirmations.</td>
					</tr>
					<tr>
						<td><i class="fa fa-share"></i>&nbsp;&nbsp;</td>
						<td>Easy online payments or cash on delivery.</td>
					</tr>
					<tr>
						<td><i class="fa fa-share"></i>&nbsp;&nbsp;</td>
						<td>Booking car rentals will never be a headache again!</td>
					</tr>
				</table>

			</div>
			<div>
				<i class="ci fa fa-check-circle-o fa-3x"></i>&nbsp;&nbsp;<span
					class="h2"><b>Quality</b></span><br />
				<table style="margin-left: 100px;">
					<tr>
						<td><i class="fa fa-share">&nbsp;&nbsp;</i></td>
						<td>Our cars are audited for cleanliness, safety and comfort.</td>
					</tr>
					<tr>
						<td><i class="fa fa-share"></i>&nbsp;&nbsp;</td>
						<td>Our drivers are well trained and reliable. </td>
					</tr>
					<tr>
						<td><i class="fa fa-share"></i>&nbsp;&nbsp;</td>
						<td>Sit back and enjoy the Ola experience!</td>
					</tr>
				</table>

			</div>
			<div>
				<i class="ci fa fa-check-circle-o fa-3x"></i>&nbsp;&nbsp;<span
					class="h2"><b>Control</b></span><br />
				<table style="margin-left: 100px;">
					<tr>
						<td><i class="fa fa-share"></i>&nbsp;&nbsp;</td>
						<td>We have clear and transparent pricing listed online. </td>
					</tr>
					<tr>
						<td><i class="fa fa-share"></i>&nbsp;&nbsp;</td>
						<td>Never haggle with drivers again on payments.</td>
					</tr>
					<tr>
						<td><i class="fa fa-share"></i>&nbsp;&nbsp;</td>
						<td>We can be confident and assured of what you are being charged for!</td>
					</tr>
				</table>

			</div>
			<img alt="buses_and_cars" style="padding-left: 70px;padding-top: 20px;" src="images/vehicles.png">



		</div>
		<div style="background-color: black;height: 520px;width: 2px;float: left;"></div>
		<div style="height: 520px; width: 40%; float: left;">
			<img alt="" src="images/user.png"
				style="margin-top: 30px; margin-left: 38%; height: 120px; height: 120px;">
			<div style="margin-left: 30px; margin-right: 30px;">
				<spring:form action="usrlogn.html" modelAttribute="LoginData"
					method="post">
					<table class="table table-bordered table-hover">
						<tr>
							<th class="h3 login_header">Login</th>
						</tr>
						<tr>
							<td><spring:input type="text" placeholder="Username"
									class="inp form-control input-lg" path="userID"
									required="required" /></td>
						</tr>
						<tr>
							<td><spring:input type="text" placeholder="Password"
									class="inp form-control input-lg" path="password"
									required="required" /></td>
						</tr>
						<tr>
							<td><input type="checkbox">&nbsp;&nbsp;<span>Remember
									me on this computer</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
								type="submit" class="btn login_btn" value="login"></td>
						</tr>
					</table>
				</spring:form>

			</div>
			<center>
				Forgot your password?&nbsp;&nbsp;<b><a href="reset_pwd.html">Click
						here to reset it.</a></b><br /> <br /> <b><a href="register.html" class="h4">New
						User?</a></b>&nbsp;&nbsp; Register Here
			</center>
		</div>
	</div>


	<div id="footer">Copyright @ 2016 Wipro Technologies. All rights
		reserved</div>
</body>
</html>