package com.revature.models;

import java.util.Objects;

public class Accounts {

	private int profileId;
	private int acctNum;
	private String accType;
	private double accBalance;
	private double accDeposit;
	private double accWithdraw;
	
	public Accounts() {
		super();
	}

	public Accounts(int profileId, int acctNum, String accType, double accBalance, double accDeposit,
			double accWithdraw) {
		super();
		this.profileId = profileId;
		this.acctNum = acctNum;
		this.accType = accType;
		this.accBalance = accBalance;
		this.accDeposit = accDeposit;
		this.accWithdraw = accWithdraw;
	}

	public Accounts(int profileId, int acctNum, String accType, double accBalance) {
		super();
		this.profileId = profileId;
		this.acctNum = acctNum;
		this.accType = accType;
		this.accBalance = accBalance;
	}

	public Accounts(int acctNum, double accBalance) {
		super();
		this.acctNum = acctNum;
		this.accBalance = accBalance;
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

	public String getAccType() {
		return accType;
	}

	public void setAccType(String accType) {
		this.accType = accType;
	}

	public double getAccBalance() {
		return accBalance;
	}

	public void setAccBalance(double accBalance) {
		this.accBalance = accBalance;
	}

	public double getAccDeposit() {
		return accDeposit;
	}

	public void setAccDeposit(double accDeposit) {
		this.accDeposit = accDeposit;
	}

	public double getAccWithdraw() {
		return accWithdraw;
	}

	public void setAccWithdraw(double accWithdraw) {
		this.accWithdraw = accWithdraw;
	}

	@Override
	public int hashCode() {
		return Objects.hash(accBalance, accDeposit, accType, accWithdraw, acctNum, profileId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Accounts other = (Accounts) obj;
		return Double.doubleToLongBits(accBalance) == Double.doubleToLongBits(other.accBalance)
				&& Double.doubleToLongBits(accDeposit) == Double.doubleToLongBits(other.accDeposit)
				&& Objects.equals(accType, other.accType)
				&& Double.doubleToLongBits(accWithdraw) == Double.doubleToLongBits(other.accWithdraw)
				&& acctNum == other.acctNum && profileId == other.profileId;
	}

	@Override
	public String toString() {
		return "Accounts [profileId=" + profileId + ", acctNum=" + acctNum + ", accType=" + accType + ", accBalance="
				+ accBalance + ", accDeposit=" + accDeposit + ", accWithdraw=" + accWithdraw + "]";
	}

	

}
