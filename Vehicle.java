package komal.com;
import java.util.*;

public class Vehicle {
	
	    private String vehicleId;
	    private int renatlRate;
	    private int rentalDays;
	    private boolean isAvailable;
	    private boolean isInMaintenance;
		private double rentalRate;

	    public Vehicle(String vehicleId, int rentalRate) {
	        this.vehicleId = vehicleId;
	        this.renatlRate= rentalRate;
	        this.rentalDays= rentalDays;
	        this.isAvailable = true;
	        this.isInMaintenance = false;
	    }

	    // Getters & Setters
	    
	    public String getVehicleId() {
			return vehicleId;
		}

		public void setVehicleId(String vehicleId) {
			this.vehicleId = vehicleId;
		}
	    public int getRenatlRate() {
			return renatlRate;
		}

		public void setRenatlRate(int renatlRate) {
			this.renatlRate = renatlRate;
		}

		public int getRentalDays() {
			return rentalDays;
		}

		public void setRentalDays(int rentalDays) {
			this.rentalDays = rentalDays;
		}

		public boolean isAvailable() {
	        return isAvailable;
	    }

	    public void setAvailable(boolean available) {
	        isAvailable = available;
	    }

	    public boolean isInMaintenance() {
	        return isInMaintenance;
	    }

	    public void setInMaintenance(boolean inMaintenance) {
	        isInMaintenance = inMaintenance;
	    }

	    public boolean rent(int days, String name) {
	    	if(this.isAvailable) {
	    		double bill = this.renatlRate*days;
	    		System.out.println("Total Bill Amount..:"+bill);
	    		
	    		
	    		boolean payment = PaymentGateway.ProcessPayment(bill);
	    		if(payment) {
	    			isAvailable = false;
	    			rentalDays = days;
	    			
	    			RecieptGeneartor.generateReciept(name,this,bill);
	    			
	    			System.out.println("Sending bill  to your mail...");
	    			System.out.println("Enter your email-id:");
	    			Scanner sc = new Scanner(System.in);
	    			String mail = sc.next();
	    			EmailConfirmation.sendBookingConfirmation(name,days,rentalRate,bill,vehicleId,mail);
	    			
	    			return true;
	    		}
	    	
	    	System.out.println("Payment not done .... Please try again...");
		    return false;
	    	}
	    	System.out.println("Vehicle not Available...");
	    	return false;
	    	
	    }
	    public void returnVehicle() {
	    	this.isAvailable=true;
	    	this.rentalDays=0;
	    	System.out.println(this.vehicleId+"returned successfully");
	    	
	    }

		public void remove(String id) {
			
			
		}
	   
}



