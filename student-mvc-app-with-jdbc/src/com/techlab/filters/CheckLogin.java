package com.techlab.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(urlPatterns = {"/edit", "/add", "/delete"})
public class CheckLogin implements Filter {

	public CheckLogin() {
		System.out.println("In filter constructor");
	}
	
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("Filter init");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		System.out.println("In doFilter");
		HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        HttpSession session = req.getSession();
        Object admin = session.getAttribute("AdminToCheck");
		System.out.println("admin : "+admin);
        
    	if(admin == null)
			res.sendRedirect("http://localhost:8080/student-mvc-app-with-jdbc/login");
		else
			chain.doFilter(request, response);
	}

	public void destroy() {
		System.out.println("Filter destroy");
	}
}
