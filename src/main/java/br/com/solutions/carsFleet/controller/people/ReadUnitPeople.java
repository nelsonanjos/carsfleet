package br.com.solutions.carsFleet.controller.people;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.solutions.carsFleet.controller.ControllerCommand;
import br.com.solutions.carsFleet.dao.PeopleDao;
import br.com.solutions.carsFleet.model.PeopleModel;

public class ReadUnitPeople implements ControllerCommand{
	
	private PeopleModel people = null;
	private PeopleDao peopleDao;
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			people = peopleDao.readUnit(request.getParameter("id"));
			PrintWriter out  = response.getWriter();
			out.print("{\"name\":\""+people.getName()+"\"");			
			out.print(",\"register\":\""+people.getRegister()+"\"");			
			out.print(",\"cpf\":\""+people.getCpf()+"\"");			
			out.print(",\"user\":\""+people.getUser()+"\"");			
			out.print(",\"password\":\""+people.getPassword()+"\"");			
			out.print(",\"group\":\""+people.getGroup()+"\"}");					
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
