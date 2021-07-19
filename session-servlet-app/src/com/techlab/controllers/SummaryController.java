package com.techlab.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/summary-home")
public class SummaryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SummaryController() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		ServletContext application=getServletContext();
		PrintWriter out=response.getWriter();
		
		Integer sessionCounter=(Integer)session.getAttribute("sessionCounter");
	    Integer applicationCounter=(Integer)application.getAttribute("applicationCounter");
	    
	    out.println("<h1>Session Counter : "+sessionCounter+"</h1>");
	    out.println("<h1>Application Counter : "+applicationCounter+"</h1>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}
}
