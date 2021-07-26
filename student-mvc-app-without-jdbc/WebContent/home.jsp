<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@ page import="com.techlab.model.Student"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>
<body style="background-color: pink">
	<h1 align="center">Student List</h1>
	<% ArrayList<Student> studentList = (ArrayList<Student>)request.getAttribute("studentList");%>
		
	<h2 align="left">Student Count : <%=studentList.size()%> </h2>
	<a href="add"><button  style="background-color: lightblue" >Add Student</button></a>
		
	<table  width="800" align="center">
		<tr bgcolor="orange" align="center">
			<th><b>Id</b></th>
			<th><b>Roll No</b></th>
			<th><b>Name</b></th>
			<th><b>Cgpa</b></th>
			<th><b>Location</b></th>
		</tr>
		
        <%for(Student student:studentList){%>
		<tr bgcolor="lightblue" align="center">
			<td><%=student.getId()%></td>
			<td><%=student.getRollNo()%></td>
			<td><%=student.getName()%></td>
			<td><%=student.getCgpa()%></td>
			<td><%=student.getLocation()%></td>
		</tr>
		<%}%>

	</table>

</body>