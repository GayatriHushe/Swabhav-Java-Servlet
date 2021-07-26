package com.techlab.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter("/login")
public class IdFilter implements Filter {

    public IdFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("In filter1");
		HttpServletRequest req=(HttpServletRequest)request;
		PrintWriter out=response.getWriter();
		
		int userid=Integer.parseInt(request.getParameter("userid"));
		if (userid>1)
			chain.doFilter(request, response);
		else
			out.println("Invalid id");
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
