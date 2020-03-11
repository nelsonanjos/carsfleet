package br.com.solutions.carsFleet.model;

public class VehicleModel {
	
	private String id;
	
	private String type;
	private String plate;
	private String brand;
	private String price;
	private String state;
	private String color;
	private String year;
	private String licensingExpiration;
	
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPlate() {
		return plate;
	}
	public void setPlate(String plate) {
		this.plate = plate;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getLicensingExpiration() {
		return licensingExpiration;
	}
	public void setLicensingExpiration(String licensingExpiration) {
		this.licensingExpiration = licensingExpiration;
	}
	
	@Override
	public String toString() {
		return "VehicleModel [id=" + id + ", type=" + type + ", plate=" + plate + ", brand=" + brand + ", price="
				+ price + ", state=" + state + ", color=" + color + ", year=" + year + ", licensingExpiration="
				+ licensingExpiration + "]";
	}
	
}
