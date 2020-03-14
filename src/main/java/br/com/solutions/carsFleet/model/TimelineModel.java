package br.com.solutions.carsFleet.model;

public class TimelineModel {
	private long id;
	private String vehicle;
	private String driver;
	private String dateTimeline;
	private String startKm;
	private String finishKm;
	private String fail;
	private String maintenance;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getVehicle() {
		return vehicle;
	}
	public void setVehicle(String vehicle) {
		this.vehicle = vehicle;
	}
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public String getDateTimeline() {
		return dateTimeline;
	}
	public void setDateTimeline(String dateTimeline) {
		this.dateTimeline = dateTimeline;
	}
	public String getStartKm() {
		return startKm;
	}
	public void setStartKm(String startKm) {
		this.startKm = startKm;
	}
	public String getFinishKm() {
		return finishKm;
	}
	public void setFinishKm(String finishKm) {
		this.finishKm = finishKm;
	}
	public String getFail() {
		return fail;
	}
	public void setFail(String fail) {
		this.fail = fail;
	}
	public String getMaintenance() {
		return maintenance;
	}
	public void setMaintenance(String maintenance) {
		this.maintenance = maintenance;
	}
	@Override
	public String toString() {
		return "TimeLine [id=" + id + ", dateTimeline=" + dateTimeline + ", startKm=" + startKm + ", finishKm="
				+ finishKm + ", fail=" + fail + ", Maintenance=" + maintenance + "]";
	}
	
	
	
}
