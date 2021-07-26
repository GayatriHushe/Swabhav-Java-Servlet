package com.techlab.controllers;


import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.techlab.model.Student;
import com.techlab.repository.StudentRepository;
import com.techlab.service.IStudentService;
import com.techlab.service.StudentDbService;

@WebServlet("/home")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public HomeController() {
		super();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		showStudents(request, response);
	}

	private void showStudents(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IStudentService service= new StudentDbService();
		ArrayList<Student> students=service.getStudents();
		request.setAttribute("studentList", students); 
		RequestDispatcher view=request.getRequestDispatcher("home.jsp");
		view.forward(request, response);
	}


	private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException {
		String id = request.getParameter("id");
        StudentRepository.deleteStudentFromDb(id);
        response.sendRedirect("http://localhost:8080/student-mvc-app/home");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("do post called");
		String action = request.getParameter("operation");
		System.out.println(action);
		switch(action)
		{
			case "edit":
			{
					String id = request.getParameter("id");
					System.out.println("home post id : " + id);
					String name = request.getParameter("name");
					int rollNo = Integer.parseInt(request.getParameter("rollNo"));
					double cgpa = Double.parseDouble(request.getParameter("cgpa"));
					String location = request.getParameter("location");
					Student student = new Student(rollNo, name, cgpa, location);
					student.setId(id);
					
					HttpSession session = request.getSession();
					session.setAttribute("studentToEdit", student);
					response.sendRedirect("http://localhost:8080/student-mvc-app/edit");
				
			
			break;}
	
			case "delete": try {
					deleteStudent(request,response);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			break;
	
			default: showStudents(request,response);
			break;
		}
		
		
		
		
		
	}

}
