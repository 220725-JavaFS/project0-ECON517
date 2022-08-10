package com.revature.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.revature.models.Accounts;
import com.revature.models.Profiles;
import com.revature.utils.ConnectionUtil;

public class DAOImpl implements DAO {

	@Override
	public Profiles createProfile(Profiles profile) {

		try (Connection conn = ConnectionUtil.getConnection()) {
			String query = "INSERT INTO profiles(firstname, lastname, zip, email, username, password)" + "VALUES('"
					+ profile.getFirstName() + "', '" + profile.getLastName() + "', '" + profile.getZip() + "', '"
					+ profile.getEmail() + "', '" + profile.getUserName() + "', '" + profile.getPassword()
					+ "') returning profileid";
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(query);
			result.next();
			profile.setProfileId(result.getInt("profileId"));

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return profile;

	}

	@Override
	public Profiles loginCredentials(Profiles profile) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			String query = "SELECT * FROM profiles WHERE username = '" + profile.getUserName() + "' and password = '"
					+ profile.getPassword() + "'";
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(query);
			if (result.next()) {
				profile.setProfileId(result.getInt(1));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return profile;
	}

	@Override
	public Accounts createAccount(Accounts account) {

		try (Connection conn = ConnectionUtil.getConnection()) {
			String query = "INSERT INTO accounts(profileid, acctype, accbalance) VALUES('" + account.getProfileId()
					+ "','Checking', 0) returning acctnum";
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(query);
			if (result.next()) {
				account.setAcctNum(result.getInt(1));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return account;
	}

	@Override
	public Accounts balance(Accounts account) {

		try (Connection conn = ConnectionUtil.getConnection()) {
			String query = "SELECT acctnum, accbalance FROM accounts WHERE profileid=" + account.getProfileId();
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(query);
			if (result.next()) {
				account.setAcctNum(result.getInt(1));
				account.setAccBalance(result.getInt(2));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return account;
	}

	@Override
	public Accounts deposit(Accounts account, double deposit) {

		try (Connection conn = ConnectionUtil.getConnection()) {
			String query = "SELECT acctnum FROM accounts WHERE profileid=" + account.getProfileId() + "";
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(query);
			if (result.next()) {
				account.setAcctNum(result.getInt(1));
				// account.setAccBalance(result.getInt(2));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		try (Connection conn = ConnectionUtil.getConnection()) {
			String query1 = "SELECT accbalance FROM accounts WHERE profileid=" + account.getProfileId() + "";
			Statement statement1 = conn.createStatement();
			ResultSet result1 = statement1.executeQuery(query1);
			if (result1.next()) {
				double cbal = result1.getDouble(1);
				double ubal = cbal + deposit;
				Statement statement2 = conn.createStatement();
				String query2 = "UPDATE accounts SET accbalance= " + (ubal) + "WHERE acctnum= " + account.getAcctNum();
				double nbal = statement2.executeUpdate(query2);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return account;
	}

	@Override
	public Accounts withdraw(Accounts account, double withdraw) {

		try (Connection conn = ConnectionUtil.getConnection()) {
			String query = "SELECT acctnum FROM accounts WHERE profileid=" + account.getProfileId() + "";
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(query);
			if (result.next()) {
				account.setAcctNum(result.getInt(1));
				// account.setAccBalance(result.getInt(2));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		try (Connection conn = ConnectionUtil.getConnection()) {
			String query1 = "SELECT accbalance FROM accounts WHERE profileid=" + account.getProfileId() + "";
			Statement statement1 = conn.createStatement();
			ResultSet result1 = statement1.executeQuery(query1);
			if (result1.next()) {
				double cbal = result1.getDouble(1);
				double ubal = cbal - withdraw;
				Statement statement2 = conn.createStatement();
				String query2 = "UPDATE accounts SET accbalance= " + (ubal) + "WHERE acctnum= " + account.getAcctNum();
				double nbal = statement2.executeUpdate(query2);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return account;

	}
}