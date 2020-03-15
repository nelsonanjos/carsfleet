package br.com.solutions.carsFleet.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.solutions.carsFleet.dao.TimelineDao;
import br.com.solutions.carsFleet.model.TimelineModel;

/**
 * Servlet implementation class TimelineController
 */
@WebServlet("/TimelineController")
public class TimelineController extends HttpServlet {
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
		TimelineModel timeline = new TimelineModel();
		
		 String date = request.getParameter("date");
		 String vehicle = request.getParameter("vehicle");
		 String driver = request.getParameter("driver");
	     String startKm = request.getParameter("startKm");
		 String finishKm = request.getParameter("finishKm");
		 String fail = request.getParameter("fail");
		 String maintenance = request.getParameter("maintenance");
		 
		 timeline.setDate(date);
		 timeline.setVehicle(vehicle);
		 timeline.setDriver(driver);
		 timeline.setStartKm(startKm);
		 timeline.setFinishKm(finishKm);
		 timeline.setFail(fail);
		 timeline.setMaintenance(maintenance);
		 
		 TimelineDao.create(timeline);
	}
	
	public void read(HttpServletResponse response) throws IOException {
		PrintWriter out  = response.getWriter();
		ArrayList timelines = TimelineDao.read();
			out.println("{\"Timelines\":"+timelines+"}");			
	}
	
	public void readUnit(HttpServletRequest request, HttpServletResponse response) throws IOException {
		TimelineModel timeline = TimelineDao.readUnit(request.getParameter("id"));
		PrintWriter out  = response.getWriter();
		out.print("{\"date\":\""+timeline.getDate()+"\"");			
		out.print(",\"vehicle\":\""+timeline.getVehicle()+"\"");			
		out.print(",\"driver\":\""+timeline.getDriver()+"\"");			
		out.print(",\"startKm\":\""+timeline.getStartKm()+"\"");			
		out.print(",\"finishKm\":\""+timeline.getFinishKm()+"\"");			
		out.print(",\"fail\":\""+timeline.getFail()+"\"");			
		out.print(",\"maintenance\":\""+timeline.getMaintenance()+"\"");			
	}
	
	public void update(HttpServletRequest request) {
		 TimelineModel timeline = new TimelineModel();
		
		 String id = request.getParameter("id");
		 String date = request.getParameter("date");
		 String vehicle = request.getParameter("vehicle");
		 String driver = request.getParameter("driver");
	     String startKm = request.getParameter("startKm");
		 String finishKm = request.getParameter("finishKm");
		 String fail = request.getParameter("fail");
		 String  maintenance = request.getParameter("maintenance");
		 
		 timeline.setId(id);
		 timeline.setDate(date);
		 timeline.setVehicle(vehicle);
		 timeline.setDriver(driver);
		 timeline.setStartKm(startKm);
		 timeline.setFinishKm(finishKm);
		 timeline.setFail(fail);
		 timeline.setMaintenance(maintenance);
		 
		 
		 TimelineDao.update(timeline);
	}
	
	public void delete(HttpServletRequest request) {
		String id = request.getParameter("id");
		TimelineDao.delete(id);
	}
       
}
