package br.com.solutions.carsFleet.controller.driver;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.solutions.carsFleet.controller.ControllerCommand;
import br.com.solutions.carsFleet.dao.DriverDao;
import br.com.solutions.carsFleet.model.DriverModel;

public class ReadUnitDriver implements ControllerCommand{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			DriverModel driver = DriverDao.readUnit(request.getParameter("id"));
			PrintWriter out  = response.getWriter();
			out.print("{\"name\":\""+driver.getName()+"\"");			
			out.print(",\"phone\":\""+driver.getPhone()+"\"");			
			out.print(",\"location\":\""+driver.getLocation()+"\"");			
			out.print(",\"cpf\":\""+driver.getCpf()+"\"");			
			out.print(",\"habilitation\":\""+driver.getHabilitation()+"\"");			
			out.print(",\"habilitationExpiration\":\""+driver.getHabilitationExpiration()+"\"}");				
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
