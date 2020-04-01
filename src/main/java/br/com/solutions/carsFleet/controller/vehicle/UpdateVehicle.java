package br.com.solutions.carsFleet.controller.vehicle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.solutions.carsFleet.controller.ControllerCommand;
import br.com.solutions.carsFleet.dao.VehicleDao;
import br.com.solutions.carsFleet.model.VehicleModel;

public class UpdateVehicle implements ControllerCommand{
	
	private VehicleModel vehicle = null;
	private VehicleDao vehicleDao;
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		vehicle = new VehicleModel();
		
		 String id = request.getParameter("id");
		 String type = request.getParameter("type");
		 String plate = request.getParameter("plate");
	     String brand = request.getParameter("brand");
		 String price = request.getParameter("price");
		 String state = request.getParameter("state");
		 String color = request.getParameter("color");
		 String year = request.getParameter("year");
		 String licensingExpiration = request.getParameter("licensingExpiration");
		 
		 vehicle.setId(id);
		 vehicle.setType(type);
		 vehicle.setPlate(plate);
		 vehicle.setBrand(brand);
		 vehicle.setPrice(price);
		 vehicle.setState(state);
		 vehicle.setColor(color);
		 vehicle.setYear(year);
		 vehicle.setLicensingExpiration(licensingExpiration);	
		 
		 vehicleDao.update(vehicle);
	}
}
