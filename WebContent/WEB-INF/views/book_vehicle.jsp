<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://www.springframework.org/tags/form"
	prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book Vehicle</title>
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
		<spring:form action="BookVehicle.html" modelAttribute="BookingData">		
			<table class="table table-bordered table-hover">
				<tr style="background-color: black;color: white;">
					<th colspan="2" class="h3"><center>Book Vehicle</center></th>
				</tr>
				<tr>
					<td>Source</td>
					<td><spring:input class="form-control" path="boardingPoint"
							required="required" /></td>
				</tr>
				<tr>
					<td>Destination</td>
					<td><spring:input class="form-control" path="dropPoint"
							required="required" /></td>
				</tr>
				<tr>
					<td>Journey Date</td>
					<td><spring:input class="form-control" path="journeyDate"
							required="required" /></td>
				</tr>
				
				<tr>
					<td>Vehicle Type</td>
					<td><spring:input class="form-control" path="vehicleBean.type"
							required="required" /></td>
				</tr>
				<tr>
					<td>No. of Seats</td>
					<td><spring:input class="form-control" path="vehicleBean.seatingCapacity"
							required="required" /></td>
				</tr>
				
				
				<tr style="background-color: black;
	color: white;">
					<td colspan="2" align="center"><input type="submit"
						value="Book" class="btn btn_color">&nbsp;&nbsp;&nbsp; <input
						class="btn btn_color" type="reset"></td>
				</tr>
			</table>
		</spring:form>
	</div>
</body>
</html>