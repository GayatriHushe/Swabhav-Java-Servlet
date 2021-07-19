package com.techlab.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.techlab.model.BeerExpert;

@WebServlet("/BeerSelect")
public class BeerSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//Version 1 
		//		response.setContentType("text/html");
		//		PrintWriter out=response.getWriter();
		//		out.println("Beer Selection Advice<br>");
		//		String c=request.getParameter("color");
		//		out.println("<br>Got beer color "+c);


		//Version 2 (With class file)
		//		String c=request.getParameter("color");
		//		BeerExpert be=new BeerExpert();
		//		List result=be.getBrands(c);
		//
		//		response.setContentType("text/html");
		//		PrintWriter out=response.getWriter();
		//		out.println("Beer Selection Advice<br>");
		//		
		//		Iterator it=result.iterator();
		//		while (it.hasNext()) {
		//			out.print("<br>try : "+it.next());
		//		}


		//Version 3 (With jsp file)

		String c=request.getParameter("color");
		BeerExpert be=new BeerExpert();
		List result=be.getBrands(c);

		request.setAttribute("styles", result);
		RequestDispatcher view=request.getRequestDispatcher("result.jsp");
		view.forward(request, response);

	}



}
