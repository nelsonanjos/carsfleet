package br.com.solutions.carsFleet.model;

public class ToFuelModel {
	private long id;
	private String fuelStation;
	private String date;
	private String liters;
	private String price;
	private String vehicleKm;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFuelStation() {
		return fuelStation;
	}
	public void setFuelStation(String fuelStation) {
		this.fuelStation = fuelStation;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public void setLiters(String liters) {
		this.liters = liters;
	}
	public String getLiters() {
		return liters;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getVehicleKm() {
		return vehicleKm;
	}
	public void setVehicleKm(String vehicleKm) {
		vehicleKm = vehicleKm;
	}
	@Override
	public String toString() {
		return "ToFuelModel [id=" + id + ", fuelStation=" + fuelStation + ", date=" + date + ", price=" + price
				+ ", vehicleKm=" + vehicleKm + "]";
	}
	
	
	
}
