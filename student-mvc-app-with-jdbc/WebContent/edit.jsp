<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@ page import="com.techlab.model.Student"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Page</title>
</head>
<body style="background-color: pink">
<%Student student = (Student)session.getAttribute("studentToEdit"); %>
	<h1 align="center">Edit Page</h1>
	<form style="align-items: center;" method="POST">
	
		<div class="form-group" hidden="true">
			<label class="control-label col-md-2">ID</label>
			<div class="col-md-4">
				<input type="text" name="id" class="form-control" value=<%=student.getId() %> >
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-md-2">Roll No</label>
			<div class="col-md-4">
				<input type="text" name="rollNo" class="form-control" value=<%=student.getRollNo() %> >
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-md-2">Name</label>
			<div class="col-md-4">
				<input type="text" name="name" class="form-control" value=<%=student.getName() %>>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-md-2">Cgpa</label>
			<div class="col-md-4">
				<input type="text" name="cgpa" class="form-control" value=<%=student.getCgpa() %>> 
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-md-2">Location</label>
			<div class="col-md-4">
				<input type="text" name="location" class="form-control" value=<%=student.getLocation() %>>
			</div>
		</div>
		<br>
		
		<input type="submit" value="Save Changes" style="background-color: lightblue">
	</form>

</body>