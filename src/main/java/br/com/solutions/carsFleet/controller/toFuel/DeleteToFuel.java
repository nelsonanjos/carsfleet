package br.com.solutions.carsFleet.controller.toFuel;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.solutions.carsFleet.controller.ControllerCommand;
import br.com.solutions.carsFleet.dao.ToFuelDao;

public class DeleteToFuel implements 	ControllerCommand{
	
	private ToFuelDao toFuelDao;
	private String id;

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		id = request.getParameter("id");
		toFuelDao.delete(id);
	}

}
