package com.techlab.controllers;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.techlab.repository.StudentRepository;

@WebServlet("/delete")
public class DeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		System.out.println("From doGet "+session.getAttribute("studentToDelete"));

		RequestDispatcher view = request.getRequestDispatcher("delete.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("inside doPost of login");

		String isDelete;
		if(request.getParameter("Yes")!=null)
			isDelete="Yes";
		else
			isDelete="No";
		
		HttpSession session=request.getSession();

		
		System.out.println("Id to delete : "+session.getAttribute("studentToDelete"));

		if( isDelete.equals("Yes"))
		{
			String id=(String) session.getAttribute("studentToDelete");

			try {
				StudentRepository repo=new StudentRepository();
				repo.deleteStudentFromDb(id);
				response.sendRedirect("http://localhost:8080/student-mvc-app-with-jdbc/home");
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
				System.out.println("Delete not done..");
			}
		}
		else
		{
			System.out.println("No");
			System.out.println("Delete not done..");
			response.sendRedirect("http://localhost:8080/student-mvc-app-with-jdbc/home");
		}
	}

}
