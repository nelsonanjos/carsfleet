package br.com.solutions.carsFleet.controller.timeline;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.solutions.carsFleet.controller.ControllerCommand;
import br.com.solutions.carsFleet.dao.TimelineDao;
import br.com.solutions.carsFleet.model.TimelineModel;

public class ReadTimeline implements ControllerCommand {
	
	private ArrayList <TimelineModel> timelines;
	private TimelineDao timelineDao;
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			PrintWriter out  = response.getWriter();
			timelines = timelineDao.read();
			out.println("{\"timelines\":"+timelines+"}");			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
