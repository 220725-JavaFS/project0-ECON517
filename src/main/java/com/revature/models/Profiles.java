package com.revature.models;

import java.util.Objects;

public class Profiles {

	private String firstName;
	private String lastName;
	private String address;
	private String phone;
	private int profileId;
	private String userName;
	private String password;

	public Profiles() {
		super();
	}

	public Profiles(String firstName, String lastName, String address, String phone, int profileId, String userName,
			String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phone = phone;
		this.profileId = profileId;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getProfileId() {
		return profileId;
	}

	public void setProfileId(int profileId) {
		this.profileId = profileId;
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
		return Objects.hash(address, firstName, lastName, password, phone, profileId, userName);
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
		return Objects.equals(address, other.address) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(lastName, other.lastName) && Objects.equals(password, other.password)
				&& Objects.equals(phone, other.phone) && Objects.equals(profileId, other.profileId)
				&& Objects.equals(userName, other.userName);
	}

	@Override
	public String toString() {
		return "Profiles [firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + ", phone="
				+ phone + ", profileId=" + profileId + ", userName=" + userName + ", password=" + password + "]";
	}

}
