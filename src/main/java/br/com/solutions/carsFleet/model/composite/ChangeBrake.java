package br.com.solutions.carsFleet.model.composite;

public class ChangeBrake extends Maintenance{

	private static String name = " Change Brake";
	
	public ChangeBrake() {
		super(name);
	}

	@Override
	public String toString() {
		return name;
	}

}
