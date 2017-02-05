<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<div class="modal fade" id="myModal" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>
				<div class="modal-body">
					<form:form action="up_route.html" modelAttribute="uproute">
			<table class="table table-bordered table-hover">
				<tr style="background-color: black;color: white;">
					<th colspan="2" class="h3"><center>Update Route</center></th>
				</tr>
				<!-- <tr>
					<td>Route ID</td>
					<td><input class="form-control" path="uid"
							required="required" /></td>
				</tr> -->
				<tr>
					<td>Source</td>
					<td><form:input class="form-control" path="source"
							required="required" /></td>
				</tr>
				<tr>
					<td>Destination</td>
					<td><form:input class="form-control" path="destination"
							required="required" /></td>
				</tr>
				
				
				<tr>
					<td>Distance</td>
					<td><form:input class="form-control" path="distance"
							required="required" /></td>
				</tr>
				<tr>
					<td>Travel Duration</td>
					<td><form:input class="form-control" path="travelDuration"
							required="required" /></td>
				</tr>
				
				
				<tr style="background-color: black;
	color: white;">
					<td colspan="2" align="center"><input type="submit"
						value="Update" class="btn btn-primary"></td>
				</tr>
			</table>
		</form:form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>

		</div>
	</div>
	
<form:form id="yourForm" action="delete_route.html" method="get">
<table border="1px" bordercolor="black" width=80% align="center" class="table table-boarded">
                <tr style="background-color: black;color: white;" bordercolor="white">
                	<td>S</td>
                    <td>Route ID</td>
                    <td>Source</td>
                    <td>Destination</td>
                    <td>Distance</td>
                    <td>Travel Duration</td>
                </tr>
                <c:forEach items="${arr}" var="arr">

                    <tr>
                    <td><input type="checkbox" style="width: 20px;height: 20px;" id="c1" name="c1" value="${arr.routeID}"/></td>
                        <td><c:out value="${arr.routeID}" /></td>
                        <td><c:out value="${arr.source}" /></td>

                        <td><c:out value="${arr.destination}" /></td>
                         <td><c:out value="${arr.distance}" /></td>
                           <td><c:out value="${arr.travelDuration}" /></td>
                           <td><a class="btn btn-info btn-xs" data-toggle="modal"
							data-target="#myModal" href="#" value="${arr.routeID}">Edit</a></td>
                            
                        
                        
                    </tr>

                </c:forEach>
            </table>
            <center><input type="submit" class="btn btn-success" value="delete" /></center>
            </form:form>
</body>
</html>