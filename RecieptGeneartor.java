package komal.com;

public class RecieptGeneartor {

	public static void generateReciept(String name, Vehicle vehicle, double bill) {
		// TODO Auto-generated method stub
		System.out.println("---------Bill-Reciept----------");
		System.out.println("\t\tCustomer Name\t:\t"+name);
		System.out.println("\t\tVehicle-ID\t:\t"+vehicle.getVehicleId());
		System.out.println("\t\tVehicle-Rented rate\t:\t"+vehicle.getRenatlRate());
		System.out.println("\t\tRented-Days\t:\t"+vehicle.getRentalDays());
		System.out.println("\t\tTotal-Bill\t:\t"+bill+"RS");
		System.out.println("---------------------------------");
	}

}
