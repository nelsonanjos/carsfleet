package br.com.solutions.carsFleet.controller.vehicle;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.solutions.carsFleet.controller.ControllerCommand;
import br.com.solutions.carsFleet.dao.VehicleDao;

public class ReadVehicle implements ControllerCommand {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			PrintWriter out  = response.getWriter();
			ArrayList vehicles = VehicleDao.read();
				out.println("{\"vehicles\":"+vehicles+"}");	
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
