package com.revature.models;

import java.util.Objects;

public class accountUpdates {

	private double accBalance;
	private double accWithdraw;
	private boolean accApproval;
	private String accDelete;

	public accountUpdates() {
		super();
	}

	public accountUpdates(double accBalance, double accWithdraw, boolean accApproval, String accDelete) {
		super();
		this.accBalance = accBalance;
		this.accWithdraw = accWithdraw;
		this.accApproval = accApproval;
		this.accDelete = accDelete;
	}

	public double getAccBalance() {
		return accBalance;
	}

	public void setAccBalance(double accBalance) {
		this.accBalance = accBalance;
	}

	public double getAccWithdraw() {
		return accWithdraw;
	}

	public void setAccWithdraw(double accWithdraw) {
		this.accWithdraw = accWithdraw;
	}

	public boolean isAccApproval() {
		return accApproval;
	}

	public void setAccApproval(boolean accApproval) {
		this.accApproval = accApproval;
	}

	public String getAccDelete() {
		return accDelete;
	}

	public void setAccDelete(String accDelete) {
		this.accDelete = accDelete;
	}

	@Override
	public int hashCode() {
		return Objects.hash(accApproval, accBalance, accDelete, accWithdraw);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		accountUpdates other = (accountUpdates) obj;
		return accApproval == other.accApproval
				&& Double.doubleToLongBits(accBalance) == Double.doubleToLongBits(other.accBalance)
				&& Objects.equals(accDelete, other.accDelete)
				&& Double.doubleToLongBits(accWithdraw) == Double.doubleToLongBits(other.accWithdraw);
	}

	@Override
	public String toString() {
		return "accountUpdates [accBalance=" + accBalance + ", accWithdraw=" + accWithdraw + ", accApproval="
				+ accApproval + ", accDelete=" + accDelete + "]";
	}

}
