package com.revature.dao;

import com.revature.models.Accounts;
import com.revature.models.Profiles;

public interface DAO {
	
	//create user in DB
	Profiles createProfile(Profiles profile);
	
	Profiles loginCredentials(Profiles profile);
	
	Accounts createAccount(Accounts account);
	
	

}
