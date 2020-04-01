package br.com.solutions.carsFleet.controller.timeline;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.solutions.carsFleet.controller.ControllerCommand;
import br.com.solutions.carsFleet.dao.TimelineDao;
import br.com.solutions.carsFleet.model.TimelineModel;
import br.com.solutions.carsFleet.model.maintenanceComposite.AirFilters;
import br.com.solutions.carsFleet.model.maintenanceComposite.Alignment;
import br.com.solutions.carsFleet.model.maintenanceComposite.Balacing;
import br.com.solutions.carsFleet.model.maintenanceComposite.Brake;
import br.com.solutions.carsFleet.model.maintenanceComposite.Candles;
import br.com.solutions.carsFleet.model.maintenanceComposite.ChangeFuelFilter;
import br.com.solutions.carsFleet.model.maintenanceComposite.ChangeOil;
import br.com.solutions.carsFleet.model.maintenanceComposite.Maintenance;
import br.com.solutions.carsFleet.model.maintenanceComposite.MaintenanceComposite;

public class UpdateTimeline implements ControllerCommand{
	
	private TimelineModel timeline = null;
	private TimelineDao timelineDao;
	
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		timeline = new TimelineModel();
		
		 String id = request.getParameter("id");
		 String date = request.getParameter("date");
		 String vehicle = request.getParameter("vehicle");
		 String driver = request.getParameter("driver");
	     String startKm = request.getParameter("startKm");
		 String finishKm = request.getParameter("finishKm");
		 String fail = request.getParameter("fail");
		 String typeMaintenance = request.getParameter("maintenance");
		 String maintenance = "";
		 
		 switch (typeMaintenance) {
			case "Preventive":
				Maintenance preventive = new MaintenanceComposite("Preventive");
				preventive.add(new Brake());
				preventive.add(new AirFilters());
				preventive.add(new Candles());
				preventive.add(new Alignment());
				preventive.add(new Balacing());
				
				maintenance = preventive.toString();
				break;
			case "Corrective":
				Maintenance corrective = new MaintenanceComposite("Corrective");
				corrective.add(new ChangeOil());
				corrective.add(new Brake());
				corrective.add(new ChangeFuelFilter());
				
				maintenance = corrective.toString();
				break;
			default:
				try {
					String packageClass = "br.com.solutions.carsFleet.model.composite.";
					String nameClass = packageClass + typeMaintenance;
					Class<?> classMaintenance = Class.forName(nameClass);
					
					Maintenance ObjMaintenance = (Maintenance) classMaintenance.newInstance();
					
					maintenance = ObjMaintenance.toString();
				} catch (Exception e) {
					
					e.printStackTrace();
				}
				break;
		}
		 
		 timeline.setId(id);
		 timeline.setDate(date);
		 timeline.setVehicle(vehicle);
		 timeline.setDriver(driver);
		 timeline.setStartKm(startKm);
		 timeline.setFinishKm(finishKm);
		 timeline.setFail(fail);
		 timeline.setTypeMaintenance(typeMaintenance);
		 timeline.setMaintenance(maintenance);
		 
		 timelineDao.update(timeline);
	}
}
