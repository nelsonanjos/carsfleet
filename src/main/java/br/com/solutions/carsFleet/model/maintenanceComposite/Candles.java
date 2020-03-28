package br.com.solutions.carsFleet.model.maintenanceComposite;

public class Candles extends Maintenance{
	private static String name = "Candles";
	
	public Candles() {
		super(name);
	}

	@Override
	public String toString() {
		return name;
	}

}
