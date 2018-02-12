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
//Implement interface
public class RetrieveTournamentMatches implements RetrieveMatchesInterface {
	private Logger logger = Logger.getLogger(RetrieveTournamentMatches.class.getName());
//Retrieve only certain matches for normal users
	@Override
	public ArrayList<Matches> retrieveMatch() {
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
		int londonTour=findTour.retrieveTournamentID("London Open");
		int ausTour=findTour.retrieveTournamentID("Australian Open");
		try {

			// Execute a query
			statement = connection.createStatement();

			prep = connection.prepareStatement(Constants.FINDMATCHTOURNAMENT);
			prep.setInt(1, londonTour);
			prep.setInt(2, ausTour);
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
