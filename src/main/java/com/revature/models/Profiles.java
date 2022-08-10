package com.revature.models;

import java.util.Objects;

public class Profiles {

	private String firstName;
	private String lastName;
	private String zip;
	private String email;
	private int profileId;
	private int acctNum;
	private String userName;
	private String password;
	
	public Profiles() {
		super();
	}

	public Profiles(String firstName, String lastName, String zip, String email, int profileId, int acctNum,
			String userName, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.zip = zip;
		this.email = email;
		this.profileId = profileId;
		this.acctNum = acctNum;
		this.userName = userName;
		this.password = password;
	}
	
	public Profiles(String firstName, String lastName, String zip, String email, String userName, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.zip = zip;
		this.email = email;
		this.userName = userName;
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getProfileId() {
		return profileId;
	}

	public void setProfileId(int profileId) {
		this.profileId = profileId;
	}

	public int getAcctNum() {
		return acctNum;
	}

	public void setAcctNum(int acctNum) {
		this.acctNum = acctNum;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		return Objects.hash(acctNum, email, firstName, lastName, password, profileId, userName, zip);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Profiles other = (Profiles) obj;
		return acctNum == other.acctNum && Objects.equals(email, other.email)
				&& Objects.equals(firstName, other.firstName) && Objects.equals(lastName, other.lastName)
				&& Objects.equals(password, other.password) && profileId == other.profileId
				&& Objects.equals(userName, other.userName) && Objects.equals(zip, other.zip);
	}

	@Override
	public String toString() {
		return "Profiles [firstName=" + firstName + ", lastName=" + lastName + ", zip=" + zip + ", email=" + email
				+ ", profileId=" + profileId + ", acctNum=" + acctNum + ", userName=" + userName + ", password="
				+ password + "]";
	}

	
	
	
	

}