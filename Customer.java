package komal.com;

import java.util.ArrayList;
import java.util.List;

public class Customer{
	
	
	private String name;
	private long mobNum;
	private boolean isliecenceAvailable;
	private List <Vehicle> vehicles;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getMobNum() {
		return mobNum;
	}

	public void setMobNum(long mobNum) {
		this.mobNum = mobNum;
	}

	public boolean isIsliecenceAvailable() {
		return isliecenceAvailable;
	}

	public void setIsliecenceAvailable(boolean isliecenceAvailable) {
		this.isliecenceAvailable = isliecenceAvailable;
	}

	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}
	
	public Customer(String name, long mobNum,boolean isliecenceAvailable) {
		
		this.name = name;
		this.mobNum = mobNum;
		this.isliecenceAvailable = isliecenceAvailable;
		
		vehicles = new ArrayList<Vehicle>();
	}
	

	
	public void rentVehicle(Vehicle vehicle,int days) {
		
		if(vehicle.rent(days,this.name)) {
			vehicles.add(vehicle);
		}
	}
	public void returnAllVehicles() {
		for(Vehicle vehicle : vehicles) {
			vehicle.returnVehicle();
		}
		vehicles.clear();
		
	}
	public void rentedVehicles() {
		
		System.out.println("List of Rented Vehicles...");
		if(vehicles.isEmpty()) {
			System.out.println("Vehicles not found...");
			
		}
		else {
			vehicles.forEach(val ->System.out.println(((Vehicle) val).getVehicleId()));
		}
	}
	
	

}
