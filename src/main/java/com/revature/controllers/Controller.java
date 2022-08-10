package com.revature.controllers;

import java.util.Scanner;

import com.revature.models.Accounts;
import com.revature.models.Profiles;
import com.revature.services.Service;

public class Controller {
	private Scanner input = new Scanner(System.in);

	private Service service = new Service();
	private Profiles newPro = new Profiles();
	private Accounts newAcct = new Accounts();

	// connect controller object to service layer

	public void userMenu() {

		System.out.println("===============================");
		System.out.println("==  Welcome to Alchemy Bank  ==");

		String choice = "";
		menuLoop: while (!choice.equalsIgnoreCase("3")) {
			System.out.println("\n==  Please select an option:  =");
			System.out.println("===============================");
			System.out.println("\n   1. Create new profile  ");
			System.out.println("\n   2. Existing User       ");
			System.out.println("\n   3. Exit                ");
			System.out.println("===============================");
			choice = input.nextLine();

			
			switchChoice: switch (choice) {
			case "1":
				register();
				break switchChoice;
			case "2":
				existingUser();
				break switchChoice;
			case "3":
				System.out.println("===================================");
				System.out.println("Thank you for using banking system.");
				System.exit(0);
			default:
				System.out.println("=============================================");
				System.out.println("That is not a valid option, please try again.");
				break switchChoice;
			}
		}

	}

	public void register() {

		
		System.out.println("\nWe will start with creating profile.");
		System.out.println("======================================");

		System.out.println("\nEnter your first name:");
		String firstName = input.nextLine();
		if (firstName.equals("")) {
			return;
		}

		System.out.println("\nEnter your last name:");
		String lastName = input.nextLine();
		if (lastName.equals("")) {
			return;
		}

		System.out.println("\nEnter Zip Code:");
		String zip = input.nextLine();
		if (zip.equals("")) {
			return;
		}

		System.out.println("\nEnter Email Address:");
		String email = input.nextLine();
		if (email.equals("")) {
			return;
		}

		System.out.println("\nEnter a username:");
		String userName = input.nextLine();
		if (userName.equals("")) {
			return;
		}

		System.out.println("\nEnter a password:");
		System.out.println("===================================");
		String password = input.nextLine();
		if (password.equals("")) {
			return;
		}

		System.out.println("\n\nRegistration is complete:" + "\n" + firstName + " " + lastName + "\n" + zip + "\n"
				+ email + "\n\nLogin Inforamtion:" + "\nUser name - " + userName + "\nPassword  - " + password);

		Profiles newUser = new Profiles(firstName, lastName, zip, email, userName, password);

		newPro = service.newProfile(newUser);
		// link to service through user object w/ parameters method call
		// **video 1:14**
		newAcct.setProfileId(newPro.getProfileId());
		service.newAccount(newAcct);

	}

	public void existingUser() {

		String proceed = "";
		while (!proceed.equalsIgnoreCase("n")) {

			Profiles login = new Profiles();
			System.out.println("==================");
			System.out.println("Enter username:");
			login.setUserName(input.nextLine());
			System.out.println("\nEnter Password");
			login.setPassword(input.nextLine());

			// try {
			Profiles loginInfo = service.login(login);
			newAcct.setProfileId(loginInfo.getProfileId());

			int inputLogin = loginInfo.getProfileId();
			if (inputLogin != 0) {
				login.setProfileId(inputLogin);
				System.out.println("Loging Successful!");

				customerMenu();

				// customerMenu();
			} else {
				System.out.println("===================================");
				System.out.println("\nUsername or Password is incorrect." + "\nWould you like to try again else: y or n");
				proceed = input.nextLine();
			}
			/*
			 * } catch (Exception e) {
			 * System.out.println("\nWould you like to try again exception : y or n");
			 * proceed = input.nextLine(); //e.printStackTrace(); }
			 */
		}

	}

	public void customerMenu() {

		String choice = "";
		while (!choice.equalsIgnoreCase("4")) {

			// menuLoop:
			System.out.println("===================================");
			System.out.println("         Customer Menu        ");
			System.out.println("Please select one of the following:");
			System.out.println("===================================");
			System.out.println("\n1. Deposit funds" + "\n2. Withdraw Funds" + "\n3. Account Balance" + "\n4. Exit");
			System.out.println("\n===================================");

			choice = input.nextLine();
			switchChoice: switch (choice) {
			case "1":

				String choice2 = "";
				while (!choice2.equalsIgnoreCase("n")) {

									
					System.out.println("\nHow much would you like to deposit: ");
					try {
					double deposit = input.nextDouble();
					service.deposit(newAcct, deposit);
					System.out.println("===================================");
					System.out.println("\nDeposit of "+deposit+" was successful!");
					System.out.println("Would you like to make a another deposit? y or n");
					choice2 = input.nextLine();
					choice2 = input.nextLine();
					} catch (Exception e) {
						System.out.println("===================================");
						System.out.println("Seems to be a problem...");
						// e.printStackTrace();
						input.nextLine();
					}
					
					
				}
					continue;
			case "2":

				String choice3 = "";
				while (!choice3.equalsIgnoreCase("n")) {
					Accounts balance = service.balance(newAcct);
					//System.out.println("Account balance: " + balance);
					System.out.println("\nHow much would you like to withdraw: ");
					
					try {
					double withdraw = input.nextDouble();
					service.withdraw(newAcct, withdraw);
					System.out.println("===================================");
					System.out.println("Withdrawl of "+withdraw+" was successful!");
					System.out.println("Would you like to make a withdraw? y or n");
					choice3 = input.nextLine();
					choice3 = input.nextLine();
					} catch (Exception e) {
						System.out.println("===================================");
						System.out.println("Seems to be a problem..");
						// e.printStackTrace();
						input.nextLine();
					}

					
				}
					continue;
			case "3":

				Accounts balance = service.balance(newAcct);
				System.out.println("Account Number: " + balance.getAcctNum());
				System.out.println("Account balance: " + balance.getAccBalance());
				break switchChoice;

			case "4":
				System.out.println("Thank you and have a nice day!");
				System.exit(0);

			default:

				System.out.println("Invalid choice");
				System.out.println("Would you like to continue. y or n");
				choice3 = input.nextLine();
				if(choice3.equals("n")) {
					System.out.println("Thank you and have a nice day!");
					System.exit(0);
				}
				break;

			}

		}

	}

}