package br.com.solutions.carsFleet.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.solutions.carsFleet.model.TimelineModel;

/**
 * Servlet implementation class ToFuelController
 */
@WebServlet("/TimelineController")
public class TimelineController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void service(HttpServletRequest request, HttpServletResponse response){
       
	TimelineModel timeline = new TimelineModel();
	
	 String date = request.getParameter("date");
	 String vehicle = request.getParameter("vehilce");
	 String driver = request.getParameter("driver");
	 String startKm = request.getParameter("startKm");
	 String finishKm = request.getParameter("finishKm");
	 String fail = request.getParameter("fail");
	 String maintenance = request.getParameter("maintenance");
	
	 timeline.setDateTimeline(date);
	 timeline.setVehicle(vehicle);
	 timeline.setDriver(driver);
	 timeline.setStartKm(startKm);
	 timeline.setFinishKm(finishKm);
	 timeline.setFail(fail);
	 timeline.setMaintenance(maintenance);
	 
	 System.out.println(timeline);
	}
}
