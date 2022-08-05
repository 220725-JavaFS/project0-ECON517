package com.revature;

import java.util.Scanner;

import com.revature.controllers.Controller;

public class Driver {
	
	public static void main(String[] args) {
				
		Scanner input = new Scanner(System.in);
		Controller controller = new Controller();
		
		System.out.println("Welcome to Alchemy Bank");
		
		System.out.println("Please select an option:"+"\n1. Create new profile"+"\n2. Existing User"+"\n3. Exit");
		
		//Switch statement
		int choice = input.nextInt();
		switch(choice) {
		
		case 1: controller.register();
		
		case 2:
			
		case 3:	
		}
		
		
		
		
		
		System.out.println("\nPlease select one of the following:"+"\n1. Administrator"+"\n2.Employee"+"\n3.Customer");
		
		//Switch
		
	}

}
