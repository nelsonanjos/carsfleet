package br.com.solutions.carsFleet.model.composite;

public abstract class Maintenance {
	private String name;
	
	public Maintenance(String name) {
		this.name = name;
	}
	
	public  void add(Maintenance maintenance)  {
		System.err.println("=========> Maintenance " + maintenance.getName() + " is not composite!");
	}
	
	public void remove(Maintenance maintenance) {
		System.err.println("=========> Maintenance " + maintenance.getName() + " is not composite!");
	}
	
	public String getName() {
		return name;
	}
	
	public abstract String toString();
}
