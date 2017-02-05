<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form"
	prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reset Password</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/bootstrap-theme.min.css">
<script src="js/jquery-2.1.4.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</head>
<body>
<br />
	<br />
	<div style="padding-left: 300px; padding-right: 300px;">
		<spring:form action="Reset_pass.html" modelAttribute="respwd">
			<table class="table table-bordered table-hover">
				<tr>
					<th colspan="2" class="h3" style="background-color: black;color: white;"><center>Reset Password</center></th>
				</tr>
				<tr>
					<td>User Id</td>
					<td><spring:input class="form-control" path="emailID"
							required="required" /></td>
				</tr>
				<tr>
					<td>New Password</td>
					<td><spring:input class="form-control" path="password"
							required="required" /></td>
				</tr>
				
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Reset" class="btn btn-primary"></td>
				</tr>
			</table>
		</spring:form>
	</div>
</body>
</html>