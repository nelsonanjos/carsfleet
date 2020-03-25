package br.com.solutions.carsFleet.controller.toFuel;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.solutions.carsFleet.controller.ControllerCommand;
import br.com.solutions.carsFleet.dao.ToFuelDao;
import br.com.solutions.carsFleet.model.ToFuelModel;

public class UpdateToFuel implements ControllerCommand{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		ToFuelModel toFuel = new ToFuelModel();
		
		 String id = request.getParameter("id");
		 String date = request.getParameter("date");
		 String vehicle = request.getParameter("vehicle");
		 String driver = request.getParameter("driver");
	     String fuelStation = request.getParameter("fuelStation");
		 String liters = request.getParameter("liters");
		 String price = request.getParameter("price");
		 String  vehicleKm = request.getParameter("vehicleKm");
		 
		 toFuel.setId(id);
		 toFuel.setDate(date);
		 toFuel.setVehicle(vehicle);
		 toFuel.setDriver(driver);
		 toFuel.setFuelStation(fuelStation);
		 toFuel.setLiters(liters);
		 toFuel.setPrice(price);
		 toFuel.setVehicleKm(vehicleKm);
		 
		 
		 ToFuelDao.update(toFuel);
	}
}
