package br.com.solutions.carsFleet.controller.people;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.solutions.carsFleet.controller.ControllerCommand;
import br.com.solutions.carsFleet.dao.PeopleDao;
import br.com.solutions.carsFleet.model.PeopleModel;

public class UpdatePeople implements ControllerCommand{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		PeopleModel people = new PeopleModel();
		
		 String id = request.getParameter("id");
		 String name = request.getParameter("name");
		 String register = request.getParameter("register");
		 String cpf = request.getParameter("cpf");
	     String user = request.getParameter("user");
		 String password = request.getParameter("password");
		 String group = request.getParameter("group");
		 
		 people.setId(id);
		 people.setName(name);
		 people.setRegister(register);
		 people.setCpf(cpf);
		 people.setUser(user);
		 people.setPassword(password);
		 people.setGroup(group);
		 
		 
		 PeopleDao.update(people);
	}
}
