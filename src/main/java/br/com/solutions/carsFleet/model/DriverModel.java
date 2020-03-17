package br.com.solutions.carsFleet.model;

public class DriverModel {
	private String id;
	private String name;
	private String location;
	private String phone;
	private String cpf;
	private String habilitation;
	private String habilitationExpiration;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getHabilitation() {
		return habilitation;
	}
	public void setHabilitation(String habilitation) {
		this.habilitation = habilitation;
	}
	public String getHabilitationExpiration() {
		return habilitationExpiration;
	}
	public void setHabilitationExpiration(String habilitationExpiration) {
		this.habilitationExpiration = habilitationExpiration;
	}
	
	@Override
	public String toString() {
		return "{\"id\":\""+id + "\", \"name\":\"" + name + "\", \"location\":\"" + location + "\", \"phone\":\"" + phone + "\", \"cpf\":\""
				+ cpf + "\", \"habilitation\":\"" + habilitation + "\", \"habilitationExpiration\":\"" + habilitationExpiration + "\"}";
	}
	
	
	
}
