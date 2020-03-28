package br.com.solutions.carsFleet.model.maintenanceComposite;

public class AirFilters extends Maintenance{
	private static String name = "Air Filters";
	
	public AirFilters() {
		super(name);
	}

	@Override
	public String toString() {
		return name;
	}

}
