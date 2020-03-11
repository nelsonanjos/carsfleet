package br.com.solutions.carsFleet.model;

public class DriverModel {
	private String name;
	private String location;
	private String phone;
	private String cpf;
	private String habilitation;
	private String expirationHabilitation;
	
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
	public String getExpirationHabilitation() {
		return expirationHabilitation;
	}
	public void setExpirationHabilitation(String expirationHabilitation) {
		this.expirationHabilitation = expirationHabilitation;
	}
	@Override
	public String toString() {
		return "DriverModel [name=" + name + ", location=" + location + ", phone=" + phone + ", cpf=" + cpf
				+ ", habilitation=" + habilitation + ", expirationHabilitation=" + expirationHabilitation + "]";
	}
	
	
	
}
