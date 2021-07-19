package com.techlab.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GetCookie")
public class GetCookie extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out = response.getWriter();
		Cookie cookies[] = request.getCookies();
        if (cookies == null || !(cookies[cookies.length - 1].getName().equals("color")))
        {
            out.print("<h1> Sorry no cookie present :( </h1>");
        }
        else
        {
            out.print("<h1 id = 'color'>" + cookies[cookies.length - 1].getValue() + "</h1>");
            out.print("<script>document.body.style.backgroundColor = document.getElementById('color').innerHTML;</script>");
        }
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
