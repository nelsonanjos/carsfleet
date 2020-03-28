package br.com.solutions.carsFleet.model.composite;

public class Brake extends Maintenance{

	private static String name = "Maintenance in Brake";
	
	public Brake() {
		super(name);
	}

	@Override
	public String toString() {
		return name;
	}

}
