package com.techlab.controllers;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.techlab.model.Student;
import com.techlab.service.IStudentService;
import com.techlab.service.StudentDbService;

@WebServlet("/edit")
public class EditController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EditController() {
		System.out.println("edit controller created");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		System.out.println("From doGet"+session.getAttribute("studentToEdit"));
		
		RequestDispatcher view = request.getRequestDispatcher("edit.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("inside doPost");
		HttpSession session = request.getSession();
		
		Student s = (Student) session.getAttribute("studentToEdit");
		String id = s.getId();
		int rollNo =Integer.parseInt(request.getParameter("rollNo"));
		String name =request.getParameter("name");
		double cgpa =Double.parseDouble(request.getParameter("cgpa"));
		String location =request.getParameter("location");
		
		IStudentService service= new StudentDbService(); 
		Student student=new Student(rollNo, name, cgpa, location);
		student.setId(id);
		
		service.updateStudent(student);
        
        
		response.sendRedirect("http://localhost:8080/student-mvc-app/home"); 
	}

}
