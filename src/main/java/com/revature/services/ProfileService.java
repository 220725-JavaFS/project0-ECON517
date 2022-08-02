package com.revature.services;

import com.revature.models.Profiles;

import DAO.ProfileRepoTest;

public class ProfileService {

	// services connects to DAO/Repotest
	private ProfileRepoTest linkRepo = new ProfileRepoTest();

	// Business logic to change name to lower case for storage in database
	public void newProfile(Profiles profile) {
		profile.setUserName(profile.getUserName());

		// save into "database"
		linkRepo.storeProfile(profile);

	}

}
