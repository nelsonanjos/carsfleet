package br.com.solutions.carsFleet.model.composite;

public class ChangeFuelFilter extends Maintenance{

	private static String name = " Change Fuel Filter";
	
	public ChangeFuelFilter() {
		super(name);
	}

	@Override
	public String toString() {
		return name;
	}

}
