<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>view routes</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/bootstrap-theme.min.css">
<script src="js/jquery-2.1.4.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</head>
<body>


<table border="1px" bordercolor="black" width=80% align="center" class="table table-boarded">
                <tr style="background-color: black;color: white;" bordercolor="white">
                	
                    <td>Route ID</td>
                    <td>Source</td>
                    <td>Destination</td>
                    <td>Distance</td>
                    <td>Travel Duration</td>
                </tr>
                <c:forEach items="${arr}" var="arr">

                    <tr>
                    
                        <td><c:out value="${arr.routeID}" /></td>
                        <td><c:out value="${arr.source}" /></td>

                        <td><c:out value="${arr.destination}" /></td>
                         <td><c:out value="${arr.distance}" /></td>
                           <td><c:out value="${arr.travelDuration}" /></td>
                          
                            
                        
                        
                    </tr>

                </c:forEach>
            </table>
          
           
</body>
</html>