package com.techlab.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/app-home")
public class ApplicationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ApplicationController() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext application=getServletContext();
		PrintWriter out=response.getWriter();
		Integer newCount = (Integer)application.getAttribute("applicationCounter");
        Integer oldCount;
        if( newCount ==null || newCount == 0 ) {
           oldCount=0;
           newCount = 1;
          
        } else {
           oldCount=newCount;
           newCount += 1;
        }
        application.setAttribute("applicationCounter", newCount);
        out.println("<h1>Old Count : "+oldCount+"</h1>");
        out.println("<h1>New Count : "+newCount+"</h1>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
