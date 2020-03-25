package br.com.solutions.carsFleet.controller.toFuel;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.solutions.carsFleet.controller.ControllerCommand;
import br.com.solutions.carsFleet.dao.ToFuelDao;

public class ReadToFuel implements ControllerCommand {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			PrintWriter out  = response.getWriter();
			ArrayList toFuels = ToFuelDao.read();
				out.println("{\"toFuels\":"+toFuels+"}");				
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
