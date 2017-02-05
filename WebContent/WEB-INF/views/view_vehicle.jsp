<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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

<!-- Dialog Form begins -->
	<div class="modal fade" id="myModal" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>
				<div class="modal-body">
				<!-- Update Vehicle Form starts -->
					<form:form action="update_vehicle.html" modelAttribute="upvehicle">
						<table class="table table-bordered table-hover">
							<tr style="background-color: black; color: white;">
								<th colspan="2" class="h3"><center>Update Vehicle</center></th>
							</tr>
							<tr>
								<td>vehicleID</td>
								<td><form:input class="form-control" path="vehicleID"
										required="required" value=""  /></td>
							</tr>
							<tr>
								<td>Name</td>
								<td><form:input class="form-control" path="name"
										required="required" /></td>
							</tr>
							<tr>
								<td>Type</td>
								<td><form:input class="form-control" path="type"
										required="required" /></td>
							</tr>

							<tr>
								<td>Registration Number</td>
								<td><form:input class="form-control"
										path="registrationNumber" required="required" /></td>
							</tr>
							<tr>
								<td>Seat capacity</td>
								<td><form:input class="form-control" path="seatingCapacity"
										required="required" /></td>
							</tr>
							<tr>
								<td>Fare per KM</td>
								<td><form:input class="form-control" path="farePerKM"
										required="required" /></td>
							</tr>


							<tr style="background-color: black; color: white;">
								<td colspan="2" align="center"><input type="submit"
									value="Update" class="btn btn-primary "></td>
							</tr>
						</table>
						<span id="res" value=${res}></span>
					</form:form>
		<!-- Update Vehicle Form ends -->
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>

		</div>
	</div>
	
	<!-- Dialog Form Ends -->
	<div
		style="padding-left: 10px; padding-right: 10px; padding-top: 10px;">
		<form:form id="yourForm" action="delete_vehicle.html" method="get">
			<table border="1px" bordercolor="black" class="table table-borded"
				align="center">
				<tr style="background-color: black; color: white;"
					bordercolor="white">
					<td>S</td>
					<td>Vehicle ID</td>
					<td>Name</td>
					<td>Type</td>
					<td>Registration Number</td>
					<td>Seating Capacity</td>
					<td>Fare Per KM</td>

				</tr>
				<c:forEach items="${arr}" var="arr">

					<tr>
						<td><input type="checkbox" style="width: 20px; height: 20px;"
							id="c1" name="c1" value="${arr.vehicleID}" /></td>
						<td><c:out value="${arr.vehicleID}" /></td>
						<td><c:out value="${arr.name}" /></td>

						<td><c:out value="${arr.type}" /></td>
						<td><c:out value="${arr.registrationNumber}" /></td>
						<td><c:out value="${arr.seatingCapacity}" /></td>
						<td><c:out value="${arr.farePerKM}" /></td>
						<td><a name="edit" class="btn btn-info btn-xs" data-toggle="modal"
							data-target="#myModal" href="#" id="edit" value="${arr.vehicleID}">Edit</a></td>



					</tr>

				</c:forEach>
			</table>

			<center>
				<input type="submit" class="btn btn-success" value="delete" />
			</center>
		</form:form>
	</div>
</body>
</html>