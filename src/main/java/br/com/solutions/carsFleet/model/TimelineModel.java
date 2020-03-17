package br.com.solutions.carsFleet.model;

public class TimelineModel {
	private String id;
	private String vehicle;
	private String driver;
	private String date;
	private String startKm;
	private String finishKm;
	private String fail;
	private String maintenance;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
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
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
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
		return "{\"id\":\""+id + "\", \"date\":\"" + date + "\", \"vehicle\":\"" + vehicle + "\", \"driver\":\"" + driver + "\", \"startKm\":\""
				+ startKm+ "\", \"finishKm\":\"" + finishKm + "\", \"fail\":\"" + fail + "\", \"maintenance\":\"" + maintenance + "\"}";
	}
	
	
	
}
