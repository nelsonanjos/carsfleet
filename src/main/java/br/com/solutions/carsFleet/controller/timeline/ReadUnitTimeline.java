package br.com.solutions.carsFleet.controller.timeline;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.solutions.carsFleet.controller.ControllerCommand;
import br.com.solutions.carsFleet.dao.TimelineDao;
import br.com.solutions.carsFleet.model.TimelineModel;

public class ReadUnitTimeline implements ControllerCommand{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			TimelineModel timeline = TimelineDao.readUnit(request.getParameter("id"));
			PrintWriter out  = response.getWriter();
			out.print("{\"date\":\""+timeline.getDate()+"\"");			
			out.print(",\"vehicle\":\""+timeline.getVehicle()+"\"");			
			out.print(",\"driver\":\""+timeline.getDriver()+"\"");			
			out.print(",\"startKm\":\""+timeline.getStartKm()+"\"");			
			out.print(",\"finishKm\":\""+timeline.getFinishKm()+"\"");			
			out.print(",\"fail\":\""+timeline.getFail()+"\"");			
			out.print(",\"maintenance\":\""+timeline.getMaintenance()+"\"}");	
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
