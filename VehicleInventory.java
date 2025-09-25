package komal.com;

import java.util.ArrayList;
import java.util.List;

public class VehicleInventory {
 
	
	private List<Vehicle> vehicles;
	private List<Customer> customers;
	
	public VehicleInventory() {
		vehicles = new ArrayList();
		customers = new ArrayList<Customer>();
		
		
		
	}
	
	public void addVehicle(Vehicle  vehicle) {
		vehicles.add(vehicle);
		
	}
	public void removeVehicle() {
		
		
	}
	public List<Vehicle> getAllVehicles() {
		return vehicles;
		
	}
	public void showAvailableVehicles(Class<?> type) {
		System.out.println("Available "+type.getSimpleName()+"S");
		
		for(Vehicle vehicle : vehicles) {
			if(type.isInstance(vehicle)&&vehicle.isAvailable());
			System.out.println(type.getSimpleName()+" Id:"+vehicle.getVehicleId());
			System.out.println("Rental Rate:"+vehicle.getRenatlRate());
			System.out.println("---------------------------------------");
		}
		
	}
	public void addCustomers(Customer customer) {
		customers.add(customer);
		
	}
	public List<Customer> getAllCustomers(){
		return this. customers;
		
	}

	public boolean removeVehicleById(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	public void viewAllCustomersWithRentedVehicles() {
		// TODO Auto-generated method stub
		
	}

	public boolean completeMaintenance(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean sendForMaintenance(String id) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
