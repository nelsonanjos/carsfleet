package br.com.solutions.carsFleet.controller.toFuel;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.solutions.carsFleet.controller.ControllerCommand;
import br.com.solutions.carsFleet.dao.ToFuelDao;
import br.com.solutions.carsFleet.model.ToFuelModel;

public class ReadUnitToFuel implements ControllerCommand{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			ToFuelModel toFuel = ToFuelDao.readUnit(request.getParameter("id"));
			PrintWriter out  = response.getWriter();
			out.print("{\"date\":\""+toFuel.getDate()+"\"");			
			out.print(",\"vehicle\":\""+toFuel.getVehicle()+"\"");			
			out.print(",\"driver\":\""+toFuel.getDriver()+"\"");			
			out.print(",\"fuelStation\":\""+toFuel.getFuelStation()+"\"");			
			out.print(",\"liters\":\""+toFuel.getLiters()+"\"");			
			out.print(",\"price\":\""+toFuel.getPrice()+"\"");			
			out.print(",\"vehicleKm\":\""+toFuel.getVehicleKm()+"\"}");		
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
