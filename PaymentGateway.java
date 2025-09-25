package komal.com;
import java.util.Scanner;
public class PaymentGateway {

	
	
	static Scanner sc=new Scanner(System.in);
	
	public static boolean ProcessPayment(double bill) {
		System.out.println("Enter amount to pay:");
		int amount = sc.nextInt();
		System.out.println("Payment processing...");
		
		try {
			Thread.sleep(5000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Payment Done:"+amount);
		
		if(bill<=amount) {
			if(bill==amount) {
				System.out.println("Process Done..");
			}
			if(bill<amount) {
				System.out.println("Paid extra:"+(amount-bill));
				System.out.println("Vehicle rented successfully...");
				return false;
			}
			else if(bill>amount) {
				System.out.println("Pending amount:"+(bill-amount));
				System.out.println("Vehicle not allocated..");
				return false;
			}
		}
		
		return true;
	}

}
