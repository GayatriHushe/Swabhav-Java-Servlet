<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@ page import="com.techlab.model.Student"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Page</title>
</head>
<body style="background-color: pink">
	<h1 align="center">Add Page</h1>
	<form style="align-items: center;" method="POST">
		<div class="form-group">
			<label class="control-label col-md-2">Roll No</label>
			<div class="col-md-4">
				<input type="text" name="rollNo" class="form-control" />
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-md-2">Name</label>
			<div class="col-md-4">
				<input type="text" name="name" class="form-control" />
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-md-2">Cgpa</label>
			<div class="col-md-4">
				<input type="text" name="cgpa" class="form-control" />
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-md-2">Location</label>
			<div class="col-md-4">
				<input type="text" name="location" class="form-control" />
			</div>
		</div>
		<br>
		
		<input type="submit" value="Add" style="background-color: lightblue">
	</form>

	<script>
		function goToHomePage() {
			window.location.href="http://localhost:8080/student-mvc-app/home";
		}
	</script>

</body>