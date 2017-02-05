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
</head>
<body>
<br />
	<br />
	<div style="padding-left: 250px; padding-right: 250px;">
		<spring:form action="payment.html" modelAttribute="paymentdata">
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
					<td>Card Number</td>
					<td><spring:input class="form-control" path="CreditCardNumber"
							required="required" /></td>
				</tr>
				<tr>
					<td>Valid from</td>
					<td><spring:input class="form-control" path="ValidFrom"
							required="required" /></td>
				</tr>
				
				<tr>
					<td>ValidTo</td>
					<td><spring:input class="form-control" path="ValidTo"
							required="required" /></td>
				</tr>

				
				
				<tr style="background-color: black;
	color: white;">
					<td colspan="2" align="center"><input type="submit"
						value="Register" class="btn btn-primary">&nbsp;&nbsp;&nbsp; <input
						class="btn btn-primary" type="reset"></td>
				</tr>
			</table>
		</spring:form>
	</div>
</body>
</html>