<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View vehicles</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/bootstrap-theme.min.css">
<script src="js/jquery-2.1.4.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</head>
<body>
<div style="padding-left: 10px;padding-right: 10px;padding-top: 10px;">
<%-- <form:form id="yourForm" action="delete_vehicle.html" method="get"> --%>
<table border="1px" bordercolor="black" class="table table-borded"  align="center">
                <tr style="background-color: black;color: white;" bordercolor="white">
                	
                    <td>Vehicle ID</td>
                    <td>Name</td>
                    <td>Type</td>
                    <td>Registration Number</td>
                    <td>Seating Capacity</td>
                    <td>Fare Per KM</td>
                    
                </tr>
                <c:forEach items="${arr}" var="arr">

                    <tr>
                  <%--   <td><input type="checkbox" style="width: 20px;height: 20px;" id="c1" name="c1" value="${arr.vehicleID}"/></td> --%>
                        <td><c:out value="${arr.vehicleID}" /></td>
                        <td><c:out value="${arr.name}" /></td>

                        <td><c:out value="${arr.type}" /></td>
                         <td><c:out value="${arr.registrationNumber}" /></td>
                          <td><c:out value="${arr.seatingCapacity}" /></td>
                           <td><c:out value="${arr.farePerKM}" /></td>
                           <%-- <td><a href="#" value="${arr.vehicleID}">Edit</a></td>
                           <td><a href="#" value="${arr.vehicleID}">Delete</a></td> --%>
                            
                        
                        
                    </tr>

                </c:forEach>
            </table>
           <%--  <center><input type="submit" class="btn btn-success" value="delete" /></center> --%>
            <%-- </form:form> --%>
            </div>
</body>
</html>