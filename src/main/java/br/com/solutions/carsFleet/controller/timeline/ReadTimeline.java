package br.com.solutions.carsFleet.controller.timeline;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.solutions.carsFleet.controller.ControllerCommand;
import br.com.solutions.carsFleet.dao.TimelineDao;

public class ReadTimeline implements ControllerCommand {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			PrintWriter out  = response.getWriter();
			ArrayList timelines = TimelineDao.read();
				out.println("{\"timelines\":"+timelines+"}");			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
