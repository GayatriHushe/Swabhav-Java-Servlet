<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
	<%
	ArrayList<Student> studentList = (ArrayList<Student>) request.getAttribute("studentList");
	%>

	<h2 align="left">
		Student Count :
		<%=studentList.size()%>
	</h2>
	<a href="add"><button style="background-color: lightblue">Add
			Student</button></a>

	<table width="1000" align="center">
		<tr bgcolor="orange" align="center">
			<th><b>ID</b></th>
			<th><b>ROLL NO</b></th>
			<th><b>NAME</b></th>
			<th><b>CGPA</b></th>
			<th><b>LOCATION</b></th>
			<th><b>EDIT</b></th>
			<th><b>DELETE</b></th>
		</tr>
		<%
		for (Student student : studentList) {
		%>
		<tr bgcolor="lightblue" align="center">
			<td><%=student.getId()%></td>
			<td><%=student.getRollNo()%></td>
			<td><%=student.getName()%></td>
			<td><%=student.getCgpa()%></td>
			<td><%=student.getLocation()%></td>
			<td><%
			
			out.print("<form method = 'POST'>");
			out.print("<input type = 'hidden' name = 'operation' value = 'edit'>");
			out.print("<input type = 'hidden' name = 'id' value = '" + student.getId() + "'>");
			out.print("<input type = 'hidden' name = 'name' value = '" + student.getName() + "'>");
			out.print("<input type = 'hidden' name = 'rollNo' value = '" + student.getRollNo() + "'>");
			out.print("<input type = 'hidden' name = 'cgpa' value = '" + student.getCgpa() + "'>");
			out.print("<input type = 'hidden' name = 'location' value = '" + student.getLocation() + "'>");
			out.print("<button type = 'submit' class = 'btn btn-warning' > Edit </button>");
			out.print("</form>");
			%></td>
			<td>
			<%
			out.print("<form method = 'POST'>");
			out.print("<input type = 'hidden' name = 'operation' value = 'delete'>");
			out.print("<input type = 'hidden' name = 'id' value = '" + student.getId() + "'>");
			out.print("<button type = 'submit' class = 'btn btn-warning' > Delete </button>");
			out.print("</form>");
			%>
			</td>
			

		</tr>
		<%
		}
		%>

	</table>
	
</body>