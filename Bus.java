package komal.com;


class Bus extends Vehicle {
	
	private int noOfSeats;

	public Bus(String vehicleId, int rentalRate,int noofSeats) {
		super(vehicleId, rentalRate);
		this.noOfSeats=noofSeats;
		
	}
	public void displayInfo() {
		
	}
   
}

