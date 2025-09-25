package komal.com;

class Car extends Vehicle {
	
	private static int rentalRate;
	private int noOfSeats;

	public Car(String vehicleId,int noofSeats, int i) {
		super(vehicleId, rentalRate);
		this.noOfSeats= noofSeats;
		
	}
	public void displayInfo() {
		
	}

}
