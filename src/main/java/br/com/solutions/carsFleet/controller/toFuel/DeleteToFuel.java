package br.com.solutions.carsFleet.controller.toFuel;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.solutions.carsFleet.controller.ControllerCommand;
import br.com.solutions.carsFleet.dao.ToFuelDao;

public class DeleteToFuel implements 	ControllerCommand{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		ToFuelDao.delete(id);
	}

}
