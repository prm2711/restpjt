package com.zilker.dao;

import com.zilker.bean.*;
import com.zilker.constant.Constants;
import com.zilker.preparedstatement.ExecuteStatement;
import com.zilker.utilities.*;

import java.sql.*;
import java.util.logging.Logger;

public class InsertData {
	private Logger logger = Logger.getLogger(InsertData.class.getName());

	// Add a Match
	public void insertMatch(Match match1) {

		ConnectionSetup conn = new ConnectionSetup();
		Connection connection = null;
		ExecuteStatement execute = new ExecuteStatement();
		connection = conn.getConnection();

		Statement statement = null;
		int tourid = match1.getTourId();
		int p1id = match1.getPlay1Id();
		int p2id = match1.getPlay2Id();
		int win = match1.getWinner();
		int lose = match1.getLoser();
		String status = match1.getStatus();
		String score = match1.getScore();
		PreparedStatement prepmatch = null, prepmatch2 = null;
		try {

			// Execute a query
			statement = connection.createStatement();

			execute.insertMatch(connection, tourid, p1id, p2id, win, lose, status, score);

			if (status.equals("Complete")) {
				execute.updateMatch(connection, win, lose);
			} else if (status.equals("Suspended")) {
				execute.updateDraw(connection, p1id, p2id);
			}
			// Updating number of matches
			prepmatch = connection.prepareStatement(Constants.UPDATEMATCH);
			prepmatch.setInt(1, p1id);
			prepmatch.executeUpdate();
			prepmatch2 = connection.prepareStatement(Constants.UPDATEMATCH);
			prepmatch2.setInt(1, p2id);
			prepmatch2.executeUpdate();

		} catch (SQLException se) {
			// Handle errors for JDBC
			logger.info("Problem in insertion");
		} finally {
			// finally block used to close resources
			conn.closePreparedStatement(prepmatch);
			conn.closePreparedStatement(prepmatch2);
			conn.closeStatement(statement);
			conn.closeConnection(connection);
		}

	}

	// Add a Tournament
	public void insertTour(Tour tour) {
		ConnectionSetup conn = new ConnectionSetup();
		Connection connection = null;
		ExecuteStatement execute = new ExecuteStatement();
		connection = conn.getConnection();
		Statement statement = null;
		String tourname = tour.getTourName();
		try {
			// Execute a query
			statement = connection.createStatement();
			execute.insertTour(connection, tourname);
		} catch (SQLException se) {
			// Handle errors for JDBC
			logger.info("Problem in insertion");
		} finally {
			// finally block used to close resources
			conn.closeStatement(statement);
			conn.closeConnection(connection);
		}

	}

	// Add a Player
	public void insertPlayer(Player play) {
		ConnectionSetup conn = new ConnectionSetup();
		Connection connection = null;
		ExecuteStatement execute = new ExecuteStatement();
		connection = conn.getConnection();

		Statement statement = null;
		String player = play.getPlayerName();
		String country = play.getCountry();
		int origpoints = play.getOrig(), newpoints = play.getNew();
		int numbermatch = play.getNumber(), won = play.getWon();
		int lost = play.getLost(), draw = play.getDraw();
		try {

			// Execute a query
			statement = connection.createStatement();

			execute.insertPlayer(connection, player, country, origpoints, newpoints, numbermatch, won, lost, draw);

		} catch (SQLException se) {
			// Handle errors for JDBC
			logger.info("Problem in insertion");
		} finally {
			// finally block used to close resources
			conn.closeStatement(statement);
			conn.closeConnection(connection);
		}

	}
}