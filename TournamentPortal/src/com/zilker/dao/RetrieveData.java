package com.zilker.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Logger;

import com.zilker.bean.Match;
import com.zilker.bean.Matches;
import com.zilker.bean.Player;
import com.zilker.constant.Constants;
import com.zilker.utilities.ConnectionSetup;

public class RetrieveData {

	private Logger logger = Logger.getLogger(RetrieveData.class.getName());
//Retrieve Player information
	public ArrayList<Player> retrievePlayer() {
		Connection connection = null;
		ConnectionSetup conn = new ConnectionSetup();
		connection = conn.getConnection();
		ArrayList<Player> play = new ArrayList<Player>();
		Statement statement = null;
		ResultSet result = null;
		Integer origpoints = 0, newpoints = 0, numbermatch = 0, won = 0, lost = 0, draw = 0;
		String player = null, country = null;
		try {

			// Execute a query
			statement = connection.createStatement();

			result = statement.executeQuery(Constants.RET);
			if (result == null) {
				logger.info("No record found.");
				return null;
			}
			while (result.next()) {
				player = result.getString(1);
				country = result.getString(2);
				origpoints = result.getInt(3);
				newpoints = result.getInt(4);
				numbermatch = result.getInt(5);
				won = result.getInt(6);
				lost = result.getInt(7);
				draw = result.getInt(8);
				//Add to collection
				Player new_player = new Player(player, country, origpoints, newpoints, numbermatch, won, lost, draw);
				play.add(new_player);

			}

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} finally {
			// finally block used to close resources
			conn.closeResult(result);
			conn.closeStatement(statement);

			conn.closeConnection(connection);

		}
		return play;
	}
//View player by country
	public ArrayList<Player> retrievePlayerByCountry(String countryname) {
		Connection connection = null;
		ConnectionSetup conn = new ConnectionSetup();
		connection = conn.getConnection();
		ArrayList<Player> play = new ArrayList<Player>();
		Statement statement = null;
		ResultSet result = null;
		Integer origpoints = 0, newpoints = 0, numbermatch = 0, won = 0, lost = 0, draw = 0;
		String player = null, country = null;
		PreparedStatement prep=null;
		try {

			// Execute a query
			statement = connection.createStatement();
			prep = connection.prepareStatement(Constants.RETRIEVEPLAYERBYCOUNTRY);
			prep.setString(1, countryname);
			result = prep.executeQuery();
			if (result == null) {
				logger.info("No record found.");
				return null;
			}
			while (result.next()) {
				player = result.getString(1);
				country = result.getString(2);
				origpoints = result.getInt(3);
				newpoints = result.getInt(4);
				numbermatch = result.getInt(5);
				won = result.getInt(6);
				lost = result.getInt(7);
				draw = result.getInt(8);
				Player new_player = new Player(player, country, origpoints, newpoints, numbermatch, won, lost, draw);
				play.add(new_player);

			}

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} finally {
			// finally block used to close resources
			conn.closeResult(result);
			conn.closeStatement(statement);

			conn.closeConnection(connection);

		}
		return play;
	}

}
