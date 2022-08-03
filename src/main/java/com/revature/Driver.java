package com.revature;

import com.revature.controllers.Controller;

public class Driver {
	
	public static void main(String[] args) {
		
		System.out.println("Welcome to Banking App");
		
		System.out.println("Please select an option:"+"\\1. Create new profile"+"\n2. Existing User");
		
				
		Controller controller = new Controller();
		
		controller.register();
		
		System.out.println("Please select one of the following:"+"\n1. Administrator"+"\n2.Employee"+"\3.Customer");
		
	}

}
