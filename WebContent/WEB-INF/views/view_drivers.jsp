<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Drivers</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/bootstrap-theme.min.css">
<script src="js/jquery-2.1.4.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
	<script type="text/javascript">
	$('input[type="checkbox"].style1').checkbox({
		buttonStyleChecked: 'btn-success',
	    checkedClass: 'icon-check',
	    uncheckedClass: 'icon-check-empty'
	});
	
	
	</script>
</head>
<body>
<form:form id="yourForm" action="delete_driver.html" method="get">
		<table border="1px" bordercolor="black" width=80% align="center" class="table table-boarded">
			<tr style="background-color: black;color: white;" bordercolor="white">
				<th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
				<th>Driver ID</th>
				<th>Name&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
				<th>Street&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
				<th>Location</th>
				<th>City</th>
				<th>State</th>
				<th>Pincode</th>                                 
				<th>Mobile Number</th>
				<th>LicenseNumber</th>
			</tr>
			<c:forEach items="${arr}" var="arr">

					<tr>
						<td><input type="checkbox" style="width: 20px; height: 20px;"
							id="c1" name="c1" value="${arr.driverID}" /></td>
						<td><c:out value="${arr.driverID}" /></td>
						<td><c:out value="${arr.name}" /></td>

						<td><c:out value="${arr.street}" /></td>
						<td><c:out value="${arr.location}" /></td>
						<td><c:out value="${arr.city}" /></td>
						<td><c:out value="${arr.state}" /></td>
						<td><c:out value="${arr.pincode}" /></td>
						<td><c:out value="${arr.mobileNo}" /></td>
						<td><c:out value="${arr.licenseNumber}" /></td>
						<td><a class="btn btn-info btn-xs" data-toggle="modal"
							data-target="#myModal" href="#" value="${arr.driverID}">Edit</a></td>



					</tr>

				</c:forEach>
		</table>
		<center><input type="submit" class="btn btn-success" value="delete" /></center>
	</form:form>
</body>
</html>