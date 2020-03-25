package br.com.solutions.carsFleet.controller.timeline;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.solutions.carsFleet.controller.ControllerCommand;
import br.com.solutions.carsFleet.dao.TimelineDao;
import br.com.solutions.carsFleet.model.TimelineModel;

public class UpdateTimeline implements ControllerCommand{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
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
}
