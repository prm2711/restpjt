package com.zilker.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

import com.zilker.constant.Constants;
import com.zilker.utilities.ConnectionSetup;

public class FindTournament {
	private Logger logger = Logger.getLogger(FindTournament.class.getName());

	// Find tournament name from id
	public String retrieveTournament(int tourid) {
		// TODO Auto-generated method stub
		Connection connection = null;
		ConnectionSetup conn = new ConnectionSetup();

		connection = conn.getConnection();
		PreparedStatement prep = null;
		Statement statement = null;
		ResultSet result = null;
		String tournament = null;
		try {

			// Execute a query
			statement = connection.createStatement();

			prep = connection.prepareStatement(Constants.FINDTOURNAMENT);
			prep.setInt(1, tourid);
			result = prep.executeQuery();
			if (result == null) {
				logger.info("No record found.");
				return null;
			}
			while (result.next()) {

				tournament = result.getString(1);

			}

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} finally {
			// finally block used to close resources
			conn.closeResult(result);
			conn.closePreparedStatement(prep);
			conn.closeStatement(statement);
			conn.closeConnection(connection);

		}
		return tournament;
	}

	// Find tournament id from name
	public int retrieveTournamentID(String tourname) {
		// TODO Auto-generated method stub
		Connection connection = null;
		ConnectionSetup conn = new ConnectionSetup();

		connection = conn.getConnection();
		PreparedStatement prep = null;
		Statement statement = null;
		ResultSet result = null;
		int tournament = -1;
		try {

			// Execute a query
			statement = connection.createStatement();

			prep = connection.prepareStatement(Constants.FINDTOURNAMENTID);
			prep.setString(1, tourname);
			result = prep.executeQuery();
			if (result == null) {
				logger.info("No record found.");
				return -1;
			}
			while (result.next()) {

				tournament = result.getInt(1);

			}

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} finally {
			// finally block used to close resources
			conn.closeResult(result);
			conn.closePreparedStatement(prep);
			conn.closeStatement(statement);
			conn.closeConnection(connection);

		}
		return tournament;
	}

}
