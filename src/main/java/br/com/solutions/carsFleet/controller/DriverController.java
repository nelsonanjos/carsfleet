package br.com.solutions.carsFleet.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.solutions.carsFleet.dao.DriverDao;
import br.com.solutions.carsFleet.model.DriverModel;

/**
 * Servlet implementation class DriverController
 */
@WebServlet("/DriverController")
public class DriverController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void service( HttpServletRequest request, HttpServletResponse response) {
		try {
			switch (request.getParameter("action")) {
			case "create":
				create(request);
				break;
			case "read":
				read(response);
				break;
			case "readUnit":
				readUnit(request, response);
				break;
			case "update":
				update(request);
				break;
			case "delete":
				delete(request);
				break;
			default:
				break;
			}
		} catch (Exception e) {
			System.err.println(e);
		}
		
	}
	
	public void create(HttpServletRequest request) {
		DriverModel driver = new DriverModel();
		
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
		 
		 DriverDao.create(driver);
	}
	
	public void read(HttpServletResponse response) throws IOException {
		PrintWriter out  = response.getWriter();
		ArrayList drivers = DriverDao.read();
			out.println("{\"drivers\":"+drivers+"}");		
	}
	
	public void readUnit(HttpServletRequest request, HttpServletResponse response) throws IOException {
		DriverModel driver = DriverDao.readUnit(request.getParameter("id"));
		PrintWriter out  = response.getWriter();
		out.print("{\"name\":\""+driver.getName()+"\"");			
		out.print(",\"phone\":\""+driver.getPhone()+"\"");			
		out.print(",\"location\":\""+driver.getLocation()+"\"");			
		out.print(",\"cpf\":\""+driver.getCpf()+"\"");			
		out.print(",\"habilitation\":\""+driver.getHabilitation()+"\"");			
		out.print(",\"habilitationExpiration\":\""+driver.getHabilitationExpiration()+"\"}");			
	}
	
	public void update(HttpServletRequest request) {
		 DriverModel driver = new DriverModel();
		
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
		 
		 
		 DriverDao.update(driver);
	}
	
	public void delete(HttpServletRequest request) {
		String id = request.getParameter("id");
		DriverDao.delete(id);
	}
       
}
