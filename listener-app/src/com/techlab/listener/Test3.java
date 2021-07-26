package com.techlab.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class Test3 implements ServletRequestListener {
    public void requestDestroyed(ServletRequestEvent arg0)  { 
    	 System.out.println("for request destroy");
    }

    public void requestInitialized(ServletRequestEvent arg0)  { 
         System.out.println("for request initialization");
    }
	
}
