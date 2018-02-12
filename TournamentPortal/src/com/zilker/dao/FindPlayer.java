package com.zilker.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

import com.zilker.constant.Constants;
import com.zilker.utilities.ConnectionSetup;

public class FindPlayer {
	private Logger logger = Logger.getLogger(FindPlayer.class.getName());
//Retrieve player name from id
	public String retrieveName(int pid) {
		Connection connection = null;
		ConnectionSetup conn = new ConnectionSetup();

		connection = conn.getConnection();
		PreparedStatement prep = null;
		Statement statement = null;
		ResultSet result = null;
		String player = null;
		try {

			// Execute a query
			statement = connection.createStatement();

			prep = connection.prepareStatement(Constants.FINDNAME);
			prep.setInt(1, pid);
			result = prep.executeQuery();
			if (result == null) {
				logger.info("No record found.");
				return null;
			}
			while (result.next()) {

				player = result.getString(1);

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
		return player;
	}
	//Retrieve player id from name
	public int retrievePlayerID(String playername) {
		// TODO Auto-generated method stub
		Connection connection = null;
		ConnectionSetup conn = new ConnectionSetup();

		connection = conn.getConnection();
		PreparedStatement prep = null;
		Statement statement = null;
		ResultSet result = null;
		int player=-1;
		try {

			// Execute a query
			statement = connection.createStatement();

			prep = connection.prepareStatement(Constants.FINDPLAYER);
			prep.setString(1,playername);
			result = prep.executeQuery();
			if (result == null) {
				logger.info("No record found.");
				return -1;
			}
			while (result.next()) {

				player = result.getInt(1);

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
		return player;
	}


}
