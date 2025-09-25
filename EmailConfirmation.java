package komal.com;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailConfirmation {

	
	 private static String senderMail = "komalbhagwat23102004@gmail.com";
	 private static String senderPass = "pqwu lgit kwvv xwby";
	 

	public static void sendBookingConfirmation(String name,int days,double bill,double rentalRate,String vehicleId,String mail) {
		
		
		String subject ="Vehicle Rental Confirmation";
		String body = "Hello" + name +", you booked vehicle successfully with \n VehicleId\t:\t"+ vehicleId +",Rentalrate\t:\t"+ rentalRate +"\n No.of days\t:\t"+ days +"\nTotal Bill\t:\t"+ bill ;
		
		
		System.out.println("Sending email to " + mail + "...");
        System.out.println("Dear " + name + ",");
        System.out.println("You have booked vehicle " + vehicleId + " for " + days + " days");
       
        System.out.println("Total amount: " + bill);
        System.out.println("Thank you for your booking!");
        System.out.println("Email sent successfully.");
		
		//smtp -Simple Mail Transfer Protocol
		
		Properties properties = new Properties();
		properties .put("mail.smtp.auth", "true");
		properties.put("mail.smtp.host","smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.starttls.enable", "true");
		
		
		Session session = Session.getInstance(properties ,new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
			    return new PasswordAuthentication(senderMail, senderPass);
			}
		});
		
		
		Message message =new MimeMessage(session);


		 try {


		 message.setFrom(new InternetAddress(senderMail));


		 message.setRecipient(Message.RecipientType.TO, new InternetAddress(mail));


		 message.setSubject(subject);


		 message.setText(body);


		 


		 Transport.send(message);
		    

		 System.out.println("Mail sent to "+mail+" .......");


		 } catch (MessagingException e) {


		 System.out.println("Some issues occured");


		 e.printStackTrace();


		 }


		
	}
		
		
	

}
