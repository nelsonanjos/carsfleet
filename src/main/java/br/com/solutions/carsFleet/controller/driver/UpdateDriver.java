package br.com.solutions.carsFleet.controller.driver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.solutions.carsFleet.controller.ControllerCommand;
import br.com.solutions.carsFleet.dao.DriverDao;
import br.com.solutions.carsFleet.model.DriverModel;

public class UpdateDriver implements ControllerCommand{
	
	private DriverModel driver = null;
	private DriverDao driverDao;
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		driver = new DriverModel();
		
		 String id = request.getParameter("id");
		 String name = request.getParameter("name");
		 String location = request.getParameter("location");
	     String phone = request.getParameter("phone");
		 String cpf = request.getParameter("cpf");
		 String habilitation = request.getParameter("habilitation");
		 String expirationHabilitation = request.getParameter("habilitationExpiration");
		 
		 driver.setId(id);
		 driver.setName(name);
		 driver.setLocation(location);
		 driver.setPhone(phone);
		 driver.setCpf(cpf);
		 driver.setHabilitation(habilitation);
		 driver.setHabilitationExpiration(expirationHabilitation);
		 
		 
		 driverDao.update(driver);
	}
}
