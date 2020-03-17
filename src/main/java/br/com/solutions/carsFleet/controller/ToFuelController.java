package br.com.solutions.carsFleet.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.solutions.carsFleet.dao.ToFuelDao;
import br.com.solutions.carsFleet.model.ToFuelModel;

/**
 * Servlet implementation class ToFuelController
 */
@WebServlet("/ToFuelController")
public class ToFuelController extends HttpServlet {
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
		ToFuelModel toFuel = new ToFuelModel();
		
		 String date = request.getParameter("date");
		 String vehicle = request.getParameter("vehicle");
		 String driver = request.getParameter("driver");
	     String fuelStation = request.getParameter("fuelStation");
		 String liters = request.getParameter("liters");
		 String price = request.getParameter("price");
		 String vehicleKm = request.getParameter("vehicleKm");
		 
		 toFuel.setDate(date);
		 toFuel.setVehicle(vehicle);
		 toFuel.setDriver(driver);
		 toFuel.setFuelStation(fuelStation);
		 toFuel.setLiters(liters);
		 toFuel.setPrice(price);
		 toFuel.setVehicleKm(vehicleKm);
		 
		 ToFuelDao.create(toFuel);
	}
	
	public void read(HttpServletResponse response) throws IOException {
		PrintWriter out  = response.getWriter();
		ArrayList toFuels = ToFuelDao.read();
			out.println("{\"toFuels\":"+toFuels+"}");			
	}
	
	public void readUnit(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ToFuelModel toFuel = ToFuelDao.readUnit(request.getParameter("id"));
		PrintWriter out  = response.getWriter();
		out.print("{\"date\":\""+toFuel.getDate()+"\"");			
		out.print(",\"vehicle\":\""+toFuel.getVehicle()+"\"");			
		out.print(",\"driver\":\""+toFuel.getDriver()+"\"");			
		out.print(",\"fuelStation\":\""+toFuel.getFuelStation()+"\"");			
		out.print(",\"liters\":\""+toFuel.getLiters()+"\"");			
		out.print(",\"price\":\""+toFuel.getPrice()+"\"");			
		out.print(",\"vehicleKm\":\""+toFuel.getVehicleKm()+"\"}");			
	}
	
	public void update(HttpServletRequest request) {
		 ToFuelModel toFuel = new ToFuelModel();
		
		 String id = request.getParameter("id");
		 String date = request.getParameter("date");
		 String vehicle = request.getParameter("vehicle");
		 String driver = request.getParameter("driver");
	     String fuelStation = request.getParameter("fuelStation");
		 String liters = request.getParameter("liters");
		 String price = request.getParameter("price");
		 String  vehicleKm = request.getParameter("vehicleKm");
		 
		 toFuel.setId(id);
		 toFuel.setDate(date);
		 toFuel.setVehicle(vehicle);
		 toFuel.setDriver(driver);
		 toFuel.setFuelStation(fuelStation);
		 toFuel.setLiters(liters);
		 toFuel.setPrice(price);
		 toFuel.setVehicleKm(vehicleKm);
		 
		 
		 ToFuelDao.update(toFuel);
	}
	
	public void delete(HttpServletRequest request) {
		String id = request.getParameter("id");
		ToFuelDao.delete(id);
	}
       
}
