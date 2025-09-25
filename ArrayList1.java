package komal.com;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayList1 {
	
	public static void main(String[] args) {
		
		
		ArrayList obj = new ArrayList();
		
		
		obj.add(22);
		obj.add(30);
		obj.add("Mayank");
		obj.add(true);
		
		System.out.println(obj);
		System.out.println(obj.isEmpty());
		
		System.out.println(obj.get(2));
		
		// for loop
		
		for(int i=0;i<obj.size();i++) {
			System.out.println(obj);
		}
		
		// Enhanced for loop
		
		for(Object a : obj) {
			System.out.println(a);
		}
		
		//functional programming
		// for each loop
		obj.forEach(val->System.out.println(val));
		
		//java streams
		obj.forEach(System.out::println);
		
		
		obj.remove(1);
		obj.remove(true);
		obj.remove(Integer.valueOf(10));
		
		
		ArrayList obj1 = new ArrayList();
		
		obj1.add(20);
		obj1.add(23);
		obj1.add("Jagruti");
		obj.add(obj1);
		obj.addAll(obj1);
		System.out.println(obj);
		obj.retainAll(obj1); // same values - store ,diff values-remove
		obj.removeAll(obj1);// diff values - store ,same values - remove
		
		obj.clear();
		
		
		//generics - 
		Collections.sort(obj);
		Collections.reverse(obj);
		
	}

}

