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
public class NameFilter implements Filter {

    public NameFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("In filter2");
		HttpServletRequest req=(HttpServletRequest)request;
		PrintWriter out=response.getWriter();
		
		String username=request.getParameter("username");
		if (username.length()>1)
			chain.doFilter(request, response);
		else
			out.println("Invalid name");
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
