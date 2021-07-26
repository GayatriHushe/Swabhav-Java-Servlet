package com.techlab.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ConnectionController")
public class ConnectionController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ConnectionController() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/swabhav?" +"user=root&password=root");
			System.out.println("Class: "+con.getClass());
			String database=con.getCatalog();
			PrintWriter out=response.getWriter();
			out.println("<h1>Connected successfully to "+database+"</h1>");
		} catch (ClassNotFoundException e) {
			PrintWriter out=response.getWriter();
			out.println("<h1>Error in Connecting</h1>");
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
