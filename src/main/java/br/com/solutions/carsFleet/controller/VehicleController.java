package br.com.solutions.carsFleet.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.fabric.xmlrpc.base.Array;

import br.com.solutions.carsFleet.dao.VehicleDao;
import br.com.solutions.carsFleet.model.VehicleModel;

/**
 * Servlet implementation class VehicleController
 */
@WebServlet("/VehicleController")
public class VehicleController extends HttpServlet {
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
		VehicleModel vehicle = new VehicleModel();
		
		 String type = request.getParameter("type");
		 String plate = request.getParameter("plate");
	     String brand = request.getParameter("brand");
		 String price = request.getParameter("price");
		 String state = request.getParameter("state");
		 String color = request.getParameter("color");
		 String year = request.getParameter("year");
		 String licensingExpiration = request.getParameter("licensingExpiration");
		 
		 vehicle.setType(type);
		 vehicle.setPlate(plate);
		 vehicle.setBrand(brand);
		 vehicle.setPrice(price);
		 vehicle.setState(state);
		 vehicle.setColor(color);
		 vehicle.setYear(year);
		 vehicle.setLicensingExpiration(licensingExpiration);	
		 
		 VehicleDao.create(vehicle);
	}
	
	public void read(HttpServletResponse response) throws IOException {
		PrintWriter out  = response.getWriter();
		ArrayList vehicles = VehicleDao.read();
			out.println("{\"vehicles\":"+vehicles+"}");			
	}
	
	public void readUnit(HttpServletRequest request, HttpServletResponse response) throws IOException {
		VehicleModel vehicle = VehicleDao.readUnit(request.getParameter("id"));
		PrintWriter out  = response.getWriter();
		out.print("{\"type\":\""+vehicle.getType()+"\"");			
		out.print(",\"plate\":\""+vehicle.getPlate()+"\"");			
		out.print(",\"brand\":\""+vehicle.getBrand()+"\"");			
		out.print(",\"price\":\""+vehicle.getPrice()+"\"");			
		out.print(",\"state\":\""+vehicle.getState()+"\"");			
		out.print(",\"color\":\""+vehicle.getColor()+"\"");			
		out.print(",\"year\":\""+vehicle.getYear()+"\"");			
		out.print(",\"licensingExpiration\":\""+vehicle.getLicensingExpiration()+"\"}");			
	}
	
	public void update(HttpServletRequest request) {
		VehicleModel vehicle = new VehicleModel();
		
		 String id = request.getParameter("id");
		 String type = request.getParameter("type");
		 String plate = request.getParameter("plate");
	     String brand = request.getParameter("brand");
		 String price = request.getParameter("price");
		 String state = request.getParameter("state");
		 String color = request.getParameter("color");
		 String year = request.getParameter("year");
		 String licensingExpiration = request.getParameter("licensingExpiration");
		 
		 vehicle.setId(id);
		 vehicle.setType(type);
		 vehicle.setPlate(plate);
		 vehicle.setBrand(brand);
		 vehicle.setPrice(price);
		 vehicle.setState(state);
		 vehicle.setColor(color);
		 vehicle.setYear(year);
		 vehicle.setLicensingExpiration(licensingExpiration);	
		 
		 VehicleDao.update(vehicle);
	}
	
	public void delete(HttpServletRequest request) {
		String id = request.getParameter("id");
		VehicleDao.delete(id);
	}
}
