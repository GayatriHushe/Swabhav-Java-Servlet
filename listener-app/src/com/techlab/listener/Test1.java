package com.techlab.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class Test1 implements ServletContextListener {

    public void contextDestroyed(ServletContextEvent sce)  { 
    	System.out.println("context destroy");
    }

    public void contextInitialized(ServletContextEvent sce)  { 
    	System.out.println("context init");
    }
	
}
