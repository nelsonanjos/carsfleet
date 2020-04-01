package br.com.solutions.carsFleet.controller.people;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.solutions.carsFleet.controller.ControllerCommand;
import br.com.solutions.carsFleet.dao.PeopleDao;
import br.com.solutions.carsFleet.model.PeopleModel;

public class ReadPeople implements ControllerCommand {
	
	private ArrayList<PeopleModel> peoples = null;
	private PeopleDao peopleDao;
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			PrintWriter out  = response.getWriter();
			peoples = peopleDao.read();
			out.println("{\"peoples\":"+peoples+"}");			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
