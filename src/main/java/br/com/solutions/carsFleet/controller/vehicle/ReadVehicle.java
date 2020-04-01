package br.com.solutions.carsFleet.controller.vehicle;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.solutions.carsFleet.controller.ControllerCommand;
import br.com.solutions.carsFleet.dao.VehicleDao;
import br.com.solutions.carsFleet.model.VehicleModel;

public class ReadVehicle implements ControllerCommand {
	
	private ArrayList<VehicleModel> vehicles;
	private VehicleDao vehicleDao;
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			PrintWriter out  = response.getWriter();
			vehicles = vehicleDao.read();
			out.println("{\"vehicles\":"+vehicles+"}");	
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
