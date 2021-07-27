package com.techlab.controllers;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.techlab.model.Student;
import com.techlab.service.IStudentService;
import com.techlab.service.StudentDbService;


@WebServlet("/add")
public class AddController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddController()
	{
		System.out.println("add controller created");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view = request.getRequestDispatcher("add.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		System.out.println("inside doPost");
		int rollNo =Integer.parseInt(request.getParameter("rollNo"));
		String name =request.getParameter("name");
		double cgpa =Double.parseDouble(request.getParameter("cgpa"));
		String location =request.getParameter("location");
		
		IStudentService service= new StudentDbService(); 
		service.addStudent(new Student(rollNo, name, cgpa, location));

		response.sendRedirect("http://localhost:8080/student-mvc-app-with-jdbc/home"); 
	}

}
