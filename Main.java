package komal.com;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(System.in);
    private static VehicleInventory inventory = new VehicleInventory();
    private static Customer customer;  // will be set on customer login

    public static void main(String[] args) {
        initializeVehicles();

        boolean flag = true;
        System.out.println("------------- Vehicle Rental System ------------");
        while (flag) {
            showMenu();
            int ch = sc.nextInt();
            switch (ch) {
                case 1 -> handleAdminLogin();
                case 2 -> handleCustomerLogin();
                case 3 -> {
                    flag = false;
                    System.out.println("Exiting system...");
                }
                default -> System.out.println("Invalid choice....");
            }
            // Removed the "Thanks for visiting..." inside loop, or can keep if desired
        }
        System.out.println("Thanks for visiting...");
    }

    public static void initializeVehicles() {
        inventory.addVehicle(new Car("C1002", 1200, 6));
        inventory.addVehicle(new Car("C2002", 1300, 4));
        inventory.addVehicle(new Bike("B111", 160, true));
        inventory.addVehicle(new Bike("B222", 200, false));
        inventory.addVehicle(new Bus("B434", 10000, 30));
        inventory.addVehicle(new Bus("B332", 15000, 30));
    }

    public static void showMenu() {
        System.out.println("1. Admin");
        System.out.println("2. Customer");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
    }

    public static void handleAdminLogin() {
        System.out.print("Enter Username: ");
        String uname = sc.next();
        System.out.print("Enter password: ");
        String pass = sc.next();
        if (Admin.authentiCate(uname, pass)) {
            adminMenu();
        } else {
            System.out.println("Incorrect username & password...");
        }
    }

    public static void adminMenu() {
        System.out.println("------------ Admin Details ------------");
        System.out.println("1. Add Vehicle");
        System.out.println("2. Remove Vehicle");
        System.out.println("3. Send vehicle for Maintenance");
        System.out.println("4. Complete Vehicle Maintenance");
        System.out.println("5. View All Customers with rented vehicles");
        System.out.println("6. Show all Vehicle Information");
        System.out.println("Enter your choice:");
        int choice = sc.nextInt();
        switch (choice) {
            case 1 -> {
                System.out.println("1. Bike\n2. Bus\n3. Car");
                System.out.print("Enter your choice: ");
                int ch = sc.nextInt();
                System.out.print("Enter Vehicle-Id: ");
                String id = sc.next();
                System.out.print("Enter rental-rate: ");
                double rate = sc.nextDouble();
                switch (ch) {
                    case 1 -> {
                        System.out.print("Helmet available? yes/no: ");
                        String ha = sc.next();
                        boolean b = ha.equalsIgnoreCase("yes");
                        inventory.addVehicle(new Bike(id,  (int) rate, b));
                        System.out.println("Bike added.");
                    }
                    case 2 -> {
                        System.out.print("Enter no .of seats: ");
                        int noofSeats = sc.nextInt();
                        inventory.addVehicle(new Bus(id, (int) rate, noofSeats));
                        System.out.println("Bus added.");
                    }
                    case 3 -> {
                        System.out.print("Enter no.of seats: ");
                        int noofSeats = sc.nextInt();
                        inventory.addVehicle(new Car(id, (int) rate, noofSeats));
                        System.out.println("Car added.");
                    }
                    default -> System.out.println("Invalid vehicle type choice.");
                }
            }
            case 2 -> {
                System.out.print("Enter Vehicle-Id to remove: ");
                String id = sc.next();
               Vehicle vehicle = getVehicleByID(id);
                if (vehicle!=null) {
                	vehicle.remove(id);
                }
                else {
                	System.out.println("Vehicle not found.");
                }
            }
            case 3 -> {
                System.out.print("Enter Vehicle-Id to send for maintenance: ");
                String id = sc.next();
                Vehicle vehicle = getVehicleByID(id);
                 
                if(vehicle!=null) {
                	inventory.sendForMaintenance(id);
                }
                
                else {
                	System.out.println("Vehicle not found or already in maintenance.");
                }
            }
            case 4 -> {
                System.out.print("Enter Vehicle-Id to complete maintenance: ");
                String id = sc.next();
               Vehicle vehicle = getVehicleByID(id);
                if (vehicle.isInMaintenance()) {
                	inventory.completeMaintenance(id);
                	
                }
                else {
                	System.out.println("Vehicle not found or not under maintenance.");
                }
            }
            case 5 -> {
            	System.out.println("---------All Customer-Details with rented vehicles---------");
            	for(Customer customer: inventory.getAllCustomers()) {
            		
            		System.out.println("Customer-Name :"+customer.getName());
            		System.out.println("Mobile Number :"+customer.getMobNum());
            		System.out.println("Liecense Available :"+customer.isIsliecenceAvailable());
            		System.out.println("\t\t\tVehicles Rented by :"+customer.getName());
            		
            		customer.getVehicles().forEach(val->System.out.println("\n\t\t\t Vehicle-ID :"+val.getVehicleId()));
            	}
            	
                            }
            case 6 -> {
                inventory.getAllVehicles();
            }
            default -> System.out.println("Invalid choice.");
        }
    }

    public static void handleCustomerLogin() {
        System.out.println("----------- Registration Form ------------");
        System.out.print("Enter your name: ");
        sc.nextLine(); // consume leftover newline
        String name = sc.nextLine();
        System.out.print("Enter your mobile: ");
        long mobNum = sc.nextLong();
        System.out.print("License is available or not? (yes/no): ");
        String available = sc.next();
        boolean hasLicense = available.equalsIgnoreCase("yes");
        customer = new Customer(name, mobNum, hasLicense);
        System.out.println("Registration successful..");
        customerMenu();
    }

    public static void customerMenu() {
        if (customer == null) {
            System.out.println("No customer registered. Please register first.");
            return;
        }
        boolean flag = true;
        while (flag) {
            System.out.println("---------- CUSTOMER MENU -------------");
            System.out.println("1. Show Available Bikes");
            System.out.println("2. Show Available Cars");
            System.out.println("3. Show Available Buses");
            System.out.println("4. Rent a Vehicle");
            System.out.println("5. Return all rented vehicles");
            System.out.println("6. View Rented Vehicles");
            System.out.println("7. Exit to main menu");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1 -> inventory.showAvailableVehicles(Bike.class);
                case 2 -> inventory.showAvailableVehicles(Car.class);
                case 3 -> inventory.showAvailableVehicles(Bus.class);
                case 4 -> {
                    System.out.print("Enter Vehicle-ID: ");
                    String id = sc.next();
                    Vehicle vehicle = getVehicleByID(id);
                   
                    if (customer != null) {
                       
                     System.out.println("Rental rate for this vehicle:\t"+vehicle.getRenatlRate());
                    }
                    else {
                    	System.out.println("No vehicle found...");
                    }
                    System.out.println("Enter No.of days:");
                    int days = sc.nextInt();
                    
                    if(vehicle!=null) {
                    	customer.rentVehicle(vehicle, days);
                    }
                    else {
                    	System.out.println("Vehicle not found....");
                    }
                    
                }
                case 5 -> {
                    customer.returnAllVehicles();
                }
                case 6 -> {
                    customer.rentedVehicles();
                }
                case 7 -> {
                    flag = false;
                 }
                default -> System.out.println("Invalid choice");
            }
            
            System.out.println("Returning to Customer menu... Type:-[yes/no]");
            String str1 = sc.next();
            
            if(str1.equalsIgnoreCase("yes")) {
            	flag = true;
            }
            else {
            	flag = false;
            	break;
            }
            
        }
    }

    private static Vehicle getVehicleByID(String id) {
        List<Vehicle> vehicles = inventory.getAllVehicles();
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getVehicleId().equalsIgnoreCase(id)) {
                return vehicle;
            }
        }
        return null;
    }
}
