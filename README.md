# VeloRent:[Vehicle-Rental System]

# Project Overview:
This is a console-based Java application that simulates a vehicle rental system. It allows users to manage vehicle inventory, handle customer rentals, and process payments. The system demonstrates key Java concepts, including object-oriented programming (OOP), data structures, and file handling. It also includes an email confirmation feature for booking notifications.

# Features:
Admin and Customer Modules: Separate menus and functionalities for administrators and customers.
Vehicle Management: The system supports various vehicle types, including Cars, Bikes, and Buses, and allows the admin to add, remove, and manage vehicles. Each vehicle type is represented by its own class, extending a base Vehicle class, showcasing OOP principles.
Customer Management: Customers can register, rent, return, and view their rented vehicles.
Secure Authentication: Admins must authenticate with a predefined username and password to access the admin menu.
Vehicle Inventory: The VehicleInventory class manages all available vehicles, separating them by type and status (e.g., available, under maintenance).
Payment Processing: A PaymentGateway class simulates a payment process, including a check for a successful payment.
Receipt Generation: The ReceiptGenerator class creates a formatted bill for each rental transaction.
Email Confirmation: The system sends a booking confirmation email to the user upon a successful vehicle rental using JavaMail API.

# Technologies Used:
Core Java: The entire application is built on fundamental Java concepts.
OOP Principles: Utilizes inheritance (Car, Bike, Bus extending Vehicle) and encapsulation.
Collections Framework: The Customer class uses ArrayList to manage a list of rented vehicles. The 
ArrayList1.java file demonstrates a strong understanding of ArrayList methods like add(), remove(), clear(), and addAll().
JavaMail API: Integrated for sending email notifications.
java.util.Scanner: Used for handling all user input in the console.

# Code Structure:
The project is organized into several classes, each with a specific responsibility:
Admin.java: Handles admin authentication.
Bike.java, Bus.java, Car.java: Represent specific vehicle types.
Customer.java: Manages customer information and rental operations.
Main.java: The main entry point of the application, containing the primary menu and control flow.
PaymentGateway.java: Simulates the payment process.
ReceiptGenerator.java: Generates a formatted rental receipt.
EmailConfirmation.java: Manages sending email confirmations.
ArrayList1.java: A separate file demonstrating a comprehensive understanding of ArrayList functionality.


