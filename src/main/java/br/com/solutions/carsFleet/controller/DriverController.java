package br.com.solutions.carsFleet.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.solutions.carsFleet.model.DriverModel;

/**
 * Servlet implementation class DriverController
 */
@WebServlet("/DriverController")
public class DriverController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void service( HttpServletRequest request, HttpServletResponse response) {
			
		DriverModel driver = new DriverModel();
		
		 String name = request.getParameter("name");
		 String location = request.getParameter("location");
	     String phone = request.getParameter("phone");
		 String cpf = request.getParameter("cpf");
		 String habilitation = request.getParameter("habilitation");
		 String expirationHabilitation = request.getParameter("expirationHabilitation");
		
		 driver.setName(name);
		 driver.setLocation(location);
		 driver.setPhone(phone);
		 driver.setCpf(cpf);
		 driver.setHabilitation(habilitation);	
		 driver.setExpirationHabilitation(expirationHabilitation);
		
		 
		 System.out.println(driver);
	}
}
