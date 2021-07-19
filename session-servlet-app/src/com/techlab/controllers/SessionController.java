package com.techlab.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/session-home")
public class SessionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SessionController() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		PrintWriter out=response.getWriter();
		Integer newCount = (Integer)session.getAttribute("sessionCounter");
        Integer oldCount;
        if( newCount ==null || newCount == 0 ) {
           oldCount=0;
           newCount = 1;
          
        } else {
           oldCount=newCount;
           newCount += 1;
        }
        session.setAttribute("sessionCounter", newCount);
        out.println("<h1>Old Count : "+oldCount+"</h1>");
        out.println("<h1>New Count : "+newCount+"</h1>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
