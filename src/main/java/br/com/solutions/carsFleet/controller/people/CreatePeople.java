package br.com.solutions.carsFleet.controller.people;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.solutions.carsFleet.controller.ControllerCommand;
import br.com.solutions.carsFleet.dao.PeopleDao;
import br.com.solutions.carsFleet.model.PeopleModel;

public class CreatePeople implements ControllerCommand{
	
	private PeopleModel people;
	private PeopleDao peopleDao; 

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		people = new PeopleModel();
		
		 String name = request.getParameter("name");
		 String register = request.getParameter("register");
		 String cpf = request.getParameter("cpf");
	     String user = request.getParameter("user");
		 String password = request.getParameter("password");
		 String group = request.getParameter("group");
		 
		 
		 people.setName(name);
		 people.setRegister(register);
		 people.setCpf(cpf);
		 people.setUser(user);
		 people.setPassword(password);
		 people.setGroup(group);
		 
		 peopleDao.create(people);
	}
	
}
