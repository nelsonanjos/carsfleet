package br.com.solutions.carsFleet.controller.timeline;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.solutions.carsFleet.controller.ControllerCommand;
import br.com.solutions.carsFleet.dao.TimelineDao;

public class DeleteTimeline implements 	ControllerCommand{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		TimelineDao.delete(id);
	}

}
