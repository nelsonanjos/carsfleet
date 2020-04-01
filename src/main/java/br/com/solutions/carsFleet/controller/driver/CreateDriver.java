package br.com.solutions.carsFleet.controller.driver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.solutions.carsFleet.controller.ControllerCommand;
import br.com.solutions.carsFleet.dao.DriverDao;
import br.com.solutions.carsFleet.model.DriverModel;

public class CreateDriver implements ControllerCommand{

	private DriverModel driver = null;
	private DriverDao driverDao;

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		driver = new DriverModel();
		
		 String name = request.getParameter("name");
		 String location = request.getParameter("location");
	     String phone = request.getParameter("phone");
		 String cpf = request.getParameter("cpf");
		 String habilitation = request.getParameter("habilitation");
		 String habilitationExpiration = request.getParameter("habilitationExpiration");
		 
		 driver.setName(name);
		 driver.setLocation(location);
		 driver.setPhone(phone);
		 driver.setCpf(cpf);
		 driver.setHabilitation(habilitation);
		 driver.setHabilitationExpiration(habilitationExpiration);
		 
		 driverDao.create(driver);
		
	}
	
}
