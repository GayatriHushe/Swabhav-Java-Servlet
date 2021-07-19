package com.techlab.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SetCookie")
public class SetCookie extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
        String color = request.getParameter("color");
        PrintWriter out = response.getWriter();
        Cookie colorCookie = new Cookie("color", color);
        colorCookie.setMaxAge(60*60*24*7);
        response.addCookie(colorCookie);
        out.print("<h1> Color set to " + color + "</h1>");
        out.print("<a href = 'http://localhost:8080/cookie-servlet-app/'>Back</a>");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
