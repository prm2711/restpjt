package com.zilker.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Logger;

import com.zilker.bean.Matches;
import com.zilker.bean.Player;
import com.zilker.constant.Constants;
import com.zilker.utilities.ConnectionSetup;

public class ListPlayerTournament {
	private Logger logger = Logger.getLogger(ListPlayerTournament.class.getName());
//List of players
	public ArrayList<String> retrievePlayerList() {
		Connection connection = null;
		ConnectionSetup conn = new ConnectionSetup();
		connection = conn.getConnection();
		ArrayList<String> play = new ArrayList<String>();
		Statement statement = null;
		ResultSet result = null;
		String player = null;
		try {

			// Execute a query
			statement = connection.createStatement();

			result = statement.executeQuery(Constants.PLAYERLIST);
			if (result == null) {
				logger.info("No record found.");
				return null;
			}
			while (result.next()) {
				player = result.getString(1);
				play.add(player);

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
//List of Tournaments
	public ArrayList<String> retrieveTourList() {
		Connection connection = null;
		ConnectionSetup conn = new ConnectionSetup();
		ArrayList<String> tour = new ArrayList<String>();
		connection = conn.getConnection();

		Statement statement = null;
		ResultSet result = null;
		String tournament=null;
		try {

			// Execute a query
			statement = connection.createStatement();
			result = statement.executeQuery(Constants.TOURLIST);
			if (result == null) {
				logger.info("No record found.");
				return null;
			}
			while (result.next()) {
				tournament=result.getString(1);
				tour.add(tournament);

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
		return tour;
	}
	

}
