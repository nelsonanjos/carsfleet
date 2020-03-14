package br.com.solutions.carsFleet.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.solutions.carsFleet.model.ToFuelModel;

/**
 * Servlet implementation class ToFuelController
 */
@WebServlet("/ToFuelController")
public class ToFuelController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void service(HttpServletRequest request, HttpServletResponse response){
       
	ToFuelModel toFuel = new ToFuelModel();
	
	 String fuelStation = request.getParameter("fuelStation");
	 String date = request.getParameter("date");
	 String liters = request.getParameter("liters");
	 String price = request.getParameter("price");
	 String km = request.getParameter("km");
	
	 toFuel.setFuelStation(fuelStation);
	 toFuel.setDate(date);
	 toFuel.setLiters(liters);
	 toFuel.setPrice(price);
	 toFuel.setVehicleKm(km);
	 
	 System.out.println(toFuel);
	}
}
