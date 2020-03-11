package br.com.solutions.carsFleet.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.solutions.carsFleet.model.MaintenanceModel;

/**
 * Servlet implementation class MaintenanceController
 */
@WebServlet("/MaintenanceController")
public class MaintenanceController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void service( HttpServletRequest request, HttpServletResponse response) {
			
		MaintenanceModel maintenance = new MaintenanceModel();
		
		 String description = request.getParameter("description");
		 String type = request.getParameter("type");
	     String price = request.getParameter("price");
		 String date = request.getParameter("date");
		
		 maintenance.setDescription(description);
		 maintenance.setType(type);
		 maintenance.setPrice(price);
		 maintenance.setDate(date);
		 
		 System.out.println(maintenance);	
		 
	}
}
