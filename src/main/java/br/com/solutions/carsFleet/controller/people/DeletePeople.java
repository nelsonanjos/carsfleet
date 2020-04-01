package br.com.solutions.carsFleet.controller.people;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.solutions.carsFleet.controller.ControllerCommand;
import br.com.solutions.carsFleet.dao.PeopleDao;

public class DeletePeople implements 	ControllerCommand{

	private PeopleDao peopleDao;
	private String id;
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		id = request.getParameter("id");
		peopleDao.delete(id);
	}

}
