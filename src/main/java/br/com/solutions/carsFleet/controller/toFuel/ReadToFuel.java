package br.com.solutions.carsFleet.controller.toFuel;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.solutions.carsFleet.controller.ControllerCommand;
import br.com.solutions.carsFleet.dao.ToFuelDao;
import br.com.solutions.carsFleet.model.ToFuelModel;

public class ReadToFuel implements ControllerCommand {
	
	private ArrayList<ToFuelModel> toFuels;
	private ToFuelDao toFuelDao;
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			PrintWriter out  = response.getWriter();
			toFuels = toFuelDao.read();
				out.println("{\"toFuels\":"+toFuels+"}");				
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
