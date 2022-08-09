package com.revature.services;

import com.revature.dao.DAO;
import com.revature.dao.DAOImpl;
import com.revature.models.Accounts;
import com.revature.models.Profiles;

public class Service {

	// services connects to DAO/Repotest
	private DAO linkDAO = new DAOImpl();

	// Business logic to change name to lower case for storage in database
	public Profiles newProfile(Profiles profile) {
		//profile.setUserName(profile.getUserName());

		// save into "database"
		return linkDAO.createProfile(profile);

	}
	
	public Accounts newAccount(Accounts account) {
		
		return linkDAO.createAccount(account);
	}
	
	public Profiles login(Profiles logon) {
		return linkDAO.loginCredentials(logon);
	}
	
	public Accounts balance(Accounts account) {
		return linkDAO.balance(account);
	}
	
	public Accounts deposit(Accounts account, double deposit) {
			 //deposit = account.getAccBalance()+deposit;	
		return linkDAO.deposit(account, deposit);
	}
	
	public Accounts withdraw(Accounts account, double withdraw) {
		return linkDAO.withdraw(account, withdraw);
	}
}
