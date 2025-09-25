package komal.com;

class Bike extends Vehicle {
	
   private boolean helmetAvailable;

	public Bike(String vehicleId, int rentalRate, boolean ha) {
		super(vehicleId, rentalRate);
		this.helmetAvailable=ha;
	}
	public void displayInfo() {
		
	}
    
}