package br.com.solutions.carsFleet.model.composite;

public class Alignment extends Maintenance{
	private static String name = "Alignment";
	
	public Alignment() {
		super(name);
	}

	@Override
	public String toString() {
		return name;
	}

}
