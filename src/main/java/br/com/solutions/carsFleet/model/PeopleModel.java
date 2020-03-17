package br.com.solutions.carsFleet.model;

public class PeopleModel {
	private String id;
	private String name;
	private String register;
	private String cpf;
	private String user;
	private String password;
	private String group;
	
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
	public String getRegister() {
		return register;
	}
	public void setRegister(String register) {
		this.register = register;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	@Override
	public String toString() {
		return "{\"id\":\""+id + "\", \"name\":\"" + name + "\", \"register\":\"" + register + "\", \"cpf\":\"" + cpf + "\", \"user\":\""
				+ user + "\", \"password\":\"" + password + "\", \"group\":\"" + group + "\"}";
	}
	
		
}
