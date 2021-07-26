package com.techlab.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class Test2 implements HttpSessionListener {

    public void sessionCreated(HttpSessionEvent hse)  { 
         System.out.println("On session creation");
    }

    public void sessionDestroyed(HttpSessionEvent hse)  { 
    	System.out.println("On session invalidate");
    }
	
}
