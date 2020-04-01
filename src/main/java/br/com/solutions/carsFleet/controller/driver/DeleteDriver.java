package br.com.solutions.carsFleet.controller.driver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.solutions.carsFleet.controller.ControllerCommand;
import br.com.solutions.carsFleet.dao.DriverDao;

public class DeleteDriver implements 	ControllerCommand{
	
	private DriverDao driverDao; 
	private String id = "";
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		id = request.getParameter("id");
		driverDao.delete(id);
	}

}
