<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body style="background-color: pink">

	<h1 align="center">Admin Login Page</h1>
	<form method="post">
		
		<div class="form-group" >
			<label class="control-label col-md-2">Name</label>
			<div class="col-md-4">
				<input type="text" name="adminName" class="form-control"  >
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-md-2">Password</label>
			<div class="col-md-4">
				<input type="password" name="adminPassword" class="form-control" >
			</div>
		</div><br>
		<input type="submit" value="Login" style="background-color: lightblue">
	</form>
</body>
</html>