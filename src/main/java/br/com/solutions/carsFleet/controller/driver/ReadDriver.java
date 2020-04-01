package br.com.solutions.carsFleet.controller.driver;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.solutions.carsFleet.controller.ControllerCommand;
import br.com.solutions.carsFleet.dao.DriverDao;
import br.com.solutions.carsFleet.model.DriverModel;

public class ReadDriver implements ControllerCommand {
	
	private ArrayList<DriverModel> drivers = null;
	private DriverDao driverDao;
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			PrintWriter out  = response.getWriter();
			drivers = driverDao.read();
			out.println("{\"drivers\":"+drivers+"}");			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
