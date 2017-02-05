<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form"
	prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New User Registration</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/bootstrap-theme.min.css">
<script src="js/jquery-2.1.4.min.js"></script>
<script src="js/bootstrap.min.js"></script>

<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body>



<br />
	<br />
	<div style="padding-left: 250px; padding-right: 250px;">
		<spring:form action="RegisterUser.html" modelAttribute="usrprofile">
			<table class="table table-bordered table-hover">
				<tr style="background-color: black;color: white;">
					<th colspan="2" class="h3"><center>User Registration</center></th>
				</tr>
				<%-- <tr>
					<td>User ID</td>
					<td><spring:input type="text" class="form-control" path="userID"
							required="required" /></td>
				</tr> --%>
				<tr>
					<td>First Name</td>
					<td><spring:input class="form-control" path="firstName"
							required="required" /></td>
				</tr>
				<tr>
					<td>Last Name</td>
					<td><spring:input class="form-control" path="lastName"
							required="required" /></td>
				</tr>
				<tr>
					<td>Date of Birth</td>
					<td><spring:input type="text" class="form-control" path="dateOfBirth"
							required="required" /></td>
				</tr>
				<tr>
					<td>Gender</td>
					<td><spring:input type="radio" path="gender" name="gender" value="Male"  />&nbsp;&nbsp;Male
							<spring:input type="radio" path="gender" name="gender" value="Female"/>&nbsp;&nbsp;Female</td>
				</tr>
				<tr>
					<td>Street</td>
					<td><spring:input class="form-control" path="street"
							required="required" /></td>
				</tr>
				<tr>
					<td>Location</td>
					<td><spring:input class="form-control" path="location"
							required="required" /></td>
				</tr>
				<tr>
					<td>City</td>
					<td><spring:input class="form-control" path="city"
							required="required" /></td>
				</tr>
				<tr>
					<td>State</td>
					<td><spring:input class="form-control" path="state"
							required="required" /></td>
				</tr>
				<tr>
					<td>Pincode</td>
					<td><spring:input class="form-control" path="pincode"
							required="required" /></td>
				</tr>
				<tr>
					<td>Mobile Number</td>
					<td><spring:input class="form-control" path="mobileNo"
							required="required" /></td>
				</tr>
				<tr>
					<td>Email ID</td>
					<td><spring:input class="form-control" path="emailID"
							required="required" /></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><spring:input class="form-control" path="password"
							required="required" /></td>
				</tr>
				
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Register" class="btn btn-primary">&nbsp;&nbsp;&nbsp; <input
						class="btn btn-primary" type="reset"></td>
				</tr>
			</table>
		</spring:form>
	</div>
</body>
</html>