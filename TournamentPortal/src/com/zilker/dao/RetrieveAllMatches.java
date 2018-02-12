package com.zilker.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Logger;

import com.zilker.bean.Matches;
import com.zilker.constant.Constants;
import com.zilker.interfaces.RetrieveMatchesInterface;
import com.zilker.utilities.ConnectionSetup;
//Implements interface
public class RetrieveAllMatches implements RetrieveMatchesInterface {
	private Logger logger = Logger.getLogger(RetrieveAllMatches.class.getName());
//Retrieve list of matches
	@Override
	public ArrayList<Matches> retrieveMatch() {
		Connection connection = null;
		ConnectionSetup conn = new ConnectionSetup();
		ArrayList<Matches> matches = new ArrayList<Matches>();
		FindPlayer findPlayer = new FindPlayer();
		FindTournament findTour = new FindTournament();
		connection = conn.getConnection();

		Statement statement = null;
		ResultSet result = null;
		Integer play1id = 0, play2id = 0, winner = 0, loser = 0, tourid = 0;
		int count = 1;
		String status = null, score = null;
		try {

			// Execute a query
			statement = connection.createStatement();
			result = statement.executeQuery(Constants.RETMATCH);
			if (result == null) {
				logger.info("No record found.");
				return null;
			}
			while (result.next()) {
				count++;
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
			conn.closeStatement(statement);

			conn.closeConnection(connection);

		}
		return matches;
	}
}
