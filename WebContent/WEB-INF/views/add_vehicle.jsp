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
<!--http://t4t5.github.io/sweetalert/-->
<script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert-dev.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.css" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.css" />
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
		<spring:form action="addVehicle.html" modelAttribute="vehicledata" >
			<table class="table table-bordered table-hover">
				<tr style="background-color: black;color: white;">
					<th colspan="2" class="h3"><center>Add Vehicle</center></th>
				</tr>
				<!-- <tr>
					<td>Vehicle ID</td>
					<td><input class="form-control" path="uid"
							required="required" /></td>
				</tr> -->
				<tr>
					<td>Name</td>
					<td><spring:input class="form-control" path="name"
							required="required" /></td>
				</tr>
				<tr>
					<td>Type</td>
					<td><spring:input class="form-control" path="type"
							required="required" /></td>
				</tr>
				
				<tr>
					<td>Registration Number</td>
					<td><spring:input class="form-control" path="registrationNumber"
							required="required" /></td>
				</tr>
				<tr>
					<td>Seat capacity</td>
					<td><spring:input class="form-control" path="seatingCapacity"
							required="required" /></td>
				</tr>
				<tr>
					<td>Fare per KM</td>
					<td><spring:input class="form-control" path="farePerKM"
							required="required" /></td>
				</tr>
				
				
				<tr style="background-color: black;
	color: white;">
					<td colspan="2" align="center"><input type="submit"
						value="Add" class="btn btn_color">&nbsp;&nbsp;&nbsp; <input
						class="btn btn_color" type="reset"></td>
				</tr>
			</table>
			<span id ="res" value=${res}></span>
		</spring:form>
	</div>
</body>
</html>