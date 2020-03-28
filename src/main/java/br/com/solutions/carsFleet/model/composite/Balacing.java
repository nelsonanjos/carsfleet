package br.com.solutions.carsFleet.model.composite;

public class Balacing extends Maintenance{
	private static String name = "Balacing";
	
	public Balacing() {
		super(name);
	}

	@Override
	public String toString() {
		return name;
	}

}
