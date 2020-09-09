package com.cisco.prj.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.cisco.prj.entity.User;
 
@WebListener
public class ContextListener implements ServletContextListener {
 
    public void contextDestroyed(ServletContextEvent sce)  { 
    }

	 
    public void contextInitialized(ServletContextEvent sce)  { 
    	System.out.println("context initialized!!");
    	List<User> users = new ArrayList<User>();
    	users.add(new User("gavin", "king"));
    	users.add(new User("smith","secret123"));
    	
    	sce.getServletContext().setAttribute("users", users);
    }
	
}
