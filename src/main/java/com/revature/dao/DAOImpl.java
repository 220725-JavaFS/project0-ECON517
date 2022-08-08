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
					+ profile.getFirstName() + "', '" + profile.getLastName() + "', '" + profile.getZip() + "', "
					+ profile.getEmail() + "', " + profile.getUserName() + "', " + profile.getPassword()
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
			String query = "SELECT * FROM profile WHERE username = '" + profile.getUserName() + "' and password = '"
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
		return null; // build conn
	}

	@Override
	public Accounts balance(Accounts account) {
		return null;
	}

	@Override
	public Accounts deposit(Accounts account, double deposit) {
		return null;
	}

	@Override
	public Accounts withdraw(Accounts account, double withdraw) {

		return null;
	}
}
