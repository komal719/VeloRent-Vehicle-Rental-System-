package komal.com;
import java.util.*;

public class Admin {
	 
	
	
	 private final static String user="komal";
	 private final static String password ="komal@23";
	 
	 
	 public static boolean authentiCate(String uname,String pass) {
		 
		 if(user.equals(uname)&&(password.equals(pass))) {
			 return true;
		 }
		 
		 return false;
	 }


	
}

