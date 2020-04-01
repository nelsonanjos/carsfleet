	package br.com.solutions.carsFleet.controller.toFuel;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.solutions.carsFleet.controller.ControllerCommand;
import br.com.solutions.carsFleet.dao.ToFuelDao;
import br.com.solutions.carsFleet.model.ToFuelModel;

public class CreateToFuel implements ControllerCommand{
	
	private ToFuelModel toFuel = null;
	private ToFuelDao toFuelDao;

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		toFuel = new ToFuelModel();
		
		 String date = request.getParameter("date");
		 String vehicle = request.getParameter("vehicle");
		 String driver = request.getParameter("driver");
	     String fuelStation = request.getParameter("fuelStation");
		 String liters = request.getParameter("liters");
		 String price = request.getParameter("price");
		 String vehicleKm = request.getParameter("vehicleKm");
		 
		 toFuel.setDate(date);
		 toFuel.setVehicle(vehicle);
		 toFuel.setDriver(driver);
		 toFuel.setFuelStation(fuelStation);
		 toFuel.setLiters(liters);
		 toFuel.setPrice(price);
		 toFuel.setVehicleKm(vehicleKm);
		 
		 toFuelDao.create(toFuel);
		
	}
	
}
