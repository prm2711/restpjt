package com.zilker.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Logger;

import com.zilker.bean.Matches;
import com.zilker.constant.Constants;
import com.zilker.interfaces.RetrieveMatchesInterface;
import com.zilker.utilities.ConnectionSetup;

public class FindTwoPlayersMatches {
	private Logger logger = Logger.getLogger(FindTwoPlayersMatches.class.getName());
//Retrieve result between two players
	public ArrayList<Matches> retrieveMatch(int p1id, int p2id, int tour) {
		Connection connection = null;
		ConnectionSetup conn = new ConnectionSetup();
		ArrayList<Matches> matches = new ArrayList<Matches>();
		connection = conn.getConnection();
		PreparedStatement prep = null;
		Statement statement = null;
		ResultSet result = null;
		FindPlayer findPlayer = new FindPlayer();
		FindTournament findTour = new FindTournament();
		Integer winner = 0, loser = 0, tourid = 0, play1id = 0, play2id = 0;
		String status = null, score = null;
		try {

			// Execute a query
			statement = connection.createStatement();

			prep = connection.prepareStatement(Constants.FINDRESULT);
			prep.setInt(1, p1id);
			prep.setInt(2, p2id);
			prep.setInt(3, p2id);
			prep.setInt(4, p1id);
			prep.setInt(5, tour);
			result = prep.executeQuery();
			if (result == null) {
				logger.info("No record found.");
				return null;
			}
			while (result.next()) {
				tourid = result.getInt(1);
				play1id = result.getInt(2);
				play2id = result.getInt(3);
				winner = result.getInt(4);
				loser = result.getInt(5);
				status = result.getString(6);
				score = result.getString(7);
				Matches match = new Matches();
				match.setTour(findTour.retrieveTournament(tourid));
				match.setPlay1(findPlayer.retrieveName(play1id));
				match.setPlay2(findPlayer.retrieveName(play2id));
				match.setWinner(findPlayer.retrieveName(winner));
				match.setLoser(findPlayer.retrieveName(loser));
				match.setStatus(status);
				match.setScore(score);
				matches.add(match);

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
		return matches;
	}
}
