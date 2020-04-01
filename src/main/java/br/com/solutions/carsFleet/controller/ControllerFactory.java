package br.com.solutions.carsFleet.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ControllerFactory")
public class ControllerFactory extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ControllerCommand actionCommand;
	private Class<?> actionClass;
	 public ControllerFactory() {
		 super();
	 }

	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		try {
			String packageClass = "br.com.solutions.carsFleet.controller.";
			String actionParameter = request.getParameter("action");
			String className = packageClass + actionParameter;
			
			actionClass = Class.forName(className);
			actionCommand = (ControllerCommand) actionClass.newInstance(); 
			actionCommand.execute(request, response);
		} catch (Exception e) {
			System.out.println("Error: "+e);
		}
	}

}
