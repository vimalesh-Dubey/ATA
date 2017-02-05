<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://www.springframework.org/tags/form"
	prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Vehicle</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/bootstrap-theme.min.css">
<script src="js/jquery-2.1.4.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<style type="text/css">
.btn_color{
background-color: white;
color: black;

}

</style>
</head>
<body>
<br />
	<br />
	<div style="padding-left: 250px; padding-right: 250px;">
		<spring:form action="adddriver.html" modelAttribute="driverdata">
			<table class="table table-bordered table-hover">
				<tr style="background-color: black;color: white;">
					<th colspan="2" class="h3"><center>Add Driver</center></th>
				</tr>
				<!-- <tr>
					<td>Driver ID</td>
					<td><input class="form-control" path="uid"
							required="required" /></td>
				</tr> -->
				<tr>
					<td>Name</td>
					<td><spring:input class="form-control" path="name"
							required="required" /></td>
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
					<td>LicenseNumber</td>
					<td><spring:input class="form-control" path="licenseNumber"
							required="required" /></td>
				</tr>
				
				<tr style="background-color: black;
	color: white;">
					<td colspan="2" align="center"><input type="submit"
						value="Add" class="btn btn_color">&nbsp;&nbsp;&nbsp; <input
						class="btn btn_color" type="reset"></td>
				</tr>
			</table>
		</spring:form>
	</div>
</body>
</html>