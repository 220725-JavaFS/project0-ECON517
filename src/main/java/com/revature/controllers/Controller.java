package com.revature.controllers;

import java.util.Scanner;

import com.revature.models.Accounts;
import com.revature.models.Profiles;
import com.revature.services.Service;

public class Controller {
	private Scanner input = new Scanner(System.in);

	private Service service = new Service();
	private Profiles newPro = new Profiles();
	//private Profiles rNewPro = new Profiles();
	private Accounts newAcct = new Accounts();
	
	// connect controller object to service layer

	
	
	public void register() {
				
		System.out.println("\n=========================================================");
		System.out.println("\nWelcome! We will start with login creditials for your profile. \nPlease enter a user name:");
		String userName = input.nextLine();
		if (userName.equals("")) {
			return;
		}

		System.out.println("Enter a password:");
		String password = input.nextLine();
		if (password.equals("")) {
			return;
		}
				
		System.out.println("Enter your first name:");
		String firstName = input.nextLine();
		if (firstName.equals("")) {
			return;
		}

		System.out.println("Enter your last name:");
		String lastName = input.nextLine();
		if (lastName.equals("")) {
			return;
		}

		System.out.println("Enter Zip Code:");
		String zip = input.nextLine();
		if (zip.equals("")) {
			return;
		}

		System.out.println("Enter Email Address:");
		String email = input.nextLine();
		if (email.equals("")) {
			return;
		}

		System.out.println("\n\nRegistration is complete:" + "\n" + firstName + " " + lastName + "\n" + zip + "\n"
				+ email + "\n\nLogin Inforamtion:" + "\nUser name - " + userName + "\nPassword  - " + password);

		Profiles newUser = new Profiles(userName, password, firstName, lastName,  zip, email);
		
		
		newPro = service.newProfile(newUser);
		// link to service through user object w/ parameters method call
		// **video 1:14**
		newAcct.setProfileId(newPro.getProfileId());
		service.newAccount(newAcct);
		
	}
	
	public void existingUser() {
		
		Profiles login = new Profiles();
		System.out.println("==================");
		System.out.println("Enter username:");
		login.setUserName(input.nextLine());
		System.out.println("\nEnter Password");
		login.setPassword(input.nextLine());
		
		Profiles loginInfo = service.login(login);
		newAcct.setProfileId(loginInfo.getProfileId());
		
		
	}
	
	
}
