package br.com.solutions.carsFleet.model.maintenanceComposite;

public class ChangeOil extends Maintenance{
	private static String name = "Change Oil";
	
	public ChangeOil() {
		super(name);
	}

	@Override
	public String toString() {
		return name;
	}

}
