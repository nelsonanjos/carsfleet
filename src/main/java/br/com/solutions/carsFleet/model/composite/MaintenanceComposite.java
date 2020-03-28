package br.com.solutions.carsFleet.model.composite;
import java.util.ArrayList;

public class MaintenanceComposite extends Maintenance{
	private String name;
	
	public MaintenanceComposite(String name) {
		super(name);
		this.name = name;
	}

	ArrayList<Maintenance> maintenances = new ArrayList<Maintenance>();
	
	public void add(Maintenance maintenance) {
		maintenances.add(maintenance);
	}
	
	public void remove(Maintenance maintenance) {
		maintenances.remove(maintenance);
	}

	@Override
	public String toString() {
		String saveMaintenance = name + " (";
		for (Maintenance maintenance : maintenances) {
			saveMaintenance += maintenance.getName() + ", ";
		}
		saveMaintenance += ").";
		saveMaintenance = saveMaintenance.replace(", )." , ").");		
		
		return saveMaintenance;
	}
	
	
	
}
