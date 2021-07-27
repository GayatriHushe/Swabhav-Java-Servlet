package com.techlab.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.techlab.model.Admin;
import com.techlab.service.AdminService;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	RequestDispatcher view = request.getRequestDispatcher("login.jsp");
		view.forward(request, response);
		
//    	HttpSession session=request.getSession();
//    	if( session.getAttribute("AdminToCheck")!=null)
//    	{
//    		response.sendRedirect("http://localhost:8080/student-mvc-app-with-jdbc/"+session.getAttribute("operation")); 
//    	}
//    	else
//    	{
//    	
//    	RequestDispatcher view = request.getRequestDispatcher("login.jsp");
//		view.forward(request, response);
//    	}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		System.out.println("inside doPost of login");
		String adminName =request.getParameter("adminName");
		String adminPassword =request.getParameter("adminPassword");
		HttpSession session = request.getSession();	
		
		AdminService adminService=new AdminService();
		Admin admin=new Admin(adminName,adminPassword);
		
		session.setAttribute("AdminToCheck", admin);
		System.out.println(admin);
		boolean a=adminService.isAdmin(admin);
		if(a)
		{
			response.sendRedirect("http://localhost:8080/student-mvc-app-with-jdbc/"+session.getAttribute("operation")); 
		}
		else
		{
			out.println("Invalid credentials");
		}
	}

}
