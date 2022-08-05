package com.revature.dao;

import com.revature.models.Profiles;

public class RepoTest {

	private Profiles[] profiles = new Profiles[14];

	public void storeProfile(Profiles profile) {
		for (Profiles p : profiles) {
			if (p == null) {
				p = profile;
				return;
			}
		}

	}

	public Profiles getProfileByName(String name) {
		for (Profiles p : profiles) {
			if (p.getFirstName().equals(name)) {
				return p;
			}
		}
		return null;
	}
	
	public void getProfile() {
		for(int i=0; i<profiles.length; i++)
			System.out.println(profiles[i]);
			
		
	}
}
