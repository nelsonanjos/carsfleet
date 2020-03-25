package br.com.solutions.carsFleet.controller.driver;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.solutions.carsFleet.controller.ControllerCommand;
import br.com.solutions.carsFleet.dao.DriverDao;

public class ReadDriver implements ControllerCommand {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			PrintWriter out  = response.getWriter();
			ArrayList drivers = DriverDao.read();
			out.println("{\"drivers\":"+drivers+"}");			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
