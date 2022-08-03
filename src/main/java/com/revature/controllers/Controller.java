package com.revature.controllers;

import java.util.Random;
import java.util.Scanner;

import com.revature.models.Profiles;
import com.revature.services.Service;

public class Controller {

	private Scanner scan = new Scanner(System.in);
	private Service service = new Service();
	// connect controller object to service layer

	public void register() {
		System.out.println("Welcome! We will start with login creditials. Please enter a user name?");
		String userName = scan.nextLine();
		if (userName.equals("")) {
			return;
		}

		System.out.println("Enter a password.");
		String password = scan.nextLine();
		if (password.equals("")) {
			return;
		}

		Random rand = new Random();
		int maxNumber = 8;
		int idNumber = rand.nextInt(maxNumber) + 1;

		System.out.println("Enter your first name.");
		String firstName = scan.nextLine();
		if (firstName.equals("")) {
			return;
		}

		System.out.println("Enter your last name.");
		String lastName = scan.nextLine();
		if (lastName.equals("")) {
			return;
		}

		System.out.println("What is your home street address?");
		String address = scan.nextLine();
		if (address.equals("")) {
			return;
		}

		System.out.println("What is your phone number?");
		String phone = scan.nextLine();
		if (phone.equals("")) {
			return;
		}

		System.out.println("\nRegistration is complete:" + "\n" + firstName + " " + lastName + "\n" + address + "\n"
				+ phone + "\n\nLogin Inforamtion:" + "\nUser name - " + userName + "\nPassword  - " + password);

		Profiles user = new Profiles(userName, password, firstName, lastName, idNumber, address, phone);

		service.newProfile(user);
		// link to service through user object w/ parameters method call
		// **video 1:14**
	}
}
