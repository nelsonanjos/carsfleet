package br.com.solutions.carsFleet.controller.vehicle;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.solutions.carsFleet.controller.ControllerCommand;
import br.com.solutions.carsFleet.dao.VehicleDao;
import br.com.solutions.carsFleet.model.VehicleModel;

public class ReadUnitVehicle implements ControllerCommand{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			VehicleModel vehicle = VehicleDao.readUnit(request.getParameter("id"));
			PrintWriter out  = response.getWriter();
			out.print("{\"type\":\""+vehicle.getType()+"\"");			
			out.print(",\"plate\":\""+vehicle.getPlate()+"\"");			
			out.print(",\"brand\":\""+vehicle.getBrand()+"\"");			
			out.print(",\"price\":\""+vehicle.getPrice()+"\"");			
			out.print(",\"state\":\""+vehicle.getState()+"\"");			
			out.print(",\"color\":\""+vehicle.getColor()+"\"");			
			out.print(",\"year\":\""+vehicle.getYear()+"\"");			
			out.print(",\"licensingExpiration\":\""+vehicle.getLicensingExpiration()+"\"}");						
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
