package br.com.solutions.carsFleet.model;

public class MaintenanceModel {
	private String description;
	private String type;
	private String price;
	private String date;
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "MaintenanceModel [description=" + description + ", type=" + type + ", price=" + price + ", date=" + date
				+ "]";
	}
	
	
	
}
