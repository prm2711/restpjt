package com.zilker.preparedstatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Logger;

import com.zilker.constant.Constants;
import com.zilker.utilities.ConnectionSetup;

public class ExecuteStatement {
	private Logger log = Logger.getLogger(ExecuteStatement.class.getName());

	public void insertMatch(Connection connection, int tourid,int p1id, int p2id, int win, int lose, String status, String score) {
		ConnectionSetup conn = new ConnectionSetup();
		PreparedStatement prep = null;
		try {
			prep = connection.prepareStatement(Constants.INSERTMATCH);
			prep.setInt(1, tourid);
			prep.setInt(2, p1id);
			prep.setInt(3, p2id);
			prep.setInt(4, win);
			prep.setInt(5, lose);
			prep.setString(6, status);
			prep.setString(7, score);
			prep.executeUpdate();
		} catch (SQLException e) {
			log.warning("error in prepared statement");
		} finally {
			conn.closePreparedStatement(prep);
		}
	}

	public void updateMatch(Connection connection, int win, int lose) {
		ConnectionSetup conn = new ConnectionSetup();

		PreparedStatement prepupd = null, prepwin = null, preplos = null;
		try {
			prepupd = connection.prepareStatement(Constants.UPDATEPOINT);
			prepupd.setInt(1, win);
			prepupd.executeUpdate();
			prepwin = connection.prepareStatement(Constants.UPDATEWIN);
			prepwin.setInt(1, win);
			prepwin.executeUpdate();
			preplos = connection.prepareStatement(Constants.UPDATELOSS);
			preplos.setInt(1, lose);
			preplos.executeUpdate();
		} catch (SQLException e) {
			log.warning("error in update");
		} finally {
			conn.closePreparedStatement(prepupd);
			conn.closePreparedStatement(prepwin);
			conn.closePreparedStatement(preplos);
		}
	}

	public void updateDraw(Connection connection, int p1id, int p2id) {
		PreparedStatement prepupd = null, prepupd1 = null, prepupd2 = null, prepupd3 = null;
		ConnectionSetup conn = new ConnectionSetup();
		try {
			prepupd = connection.prepareStatement(Constants.UPDATEDRAW);
			prepupd.setInt(1, p1id);
			prepupd.executeUpdate();
			prepupd1 = connection.prepareStatement(Constants.UPDATEDRAW);
			prepupd1.setInt(1, p2id);
			prepupd1.executeUpdate();
			prepupd2 = connection.prepareStatement(Constants.UPDATEPOINTSUS);
			prepupd2.setInt(1, p1id);
			prepupd2.executeUpdate();
			prepupd3 = connection.prepareStatement(Constants.UPDATEPOINTSUS);
			prepupd3.setInt(1, p2id);
			prepupd3.executeUpdate();
		} catch (SQLException e) {
			log.warning("error in update");
		} finally {
			conn.closePreparedStatement(prepupd);
			conn.closePreparedStatement(prepupd1);
			conn.closePreparedStatement(prepupd2);
			conn.closePreparedStatement(prepupd3);

		}
	}

	public void insertTour(Connection connection, String tourname) {
		ConnectionSetup conn = new ConnectionSetup();
		PreparedStatement prep = null;
		try {
			prep = connection.prepareStatement(Constants.INSERTTOURNAMENT);
			prep.setString(1, tourname);
			prep.executeUpdate();
		} catch (SQLException e) {
			log.warning("error in prepared statement");
		} finally {
			conn.closePreparedStatement(prep);
		}
		
	}

	public void insertPlayer(Connection connection, String player, String country, int origpoints, int newpoints,
			int numbermatch, int won, int lost, int draw) {
		ConnectionSetup conn = new ConnectionSetup();
		PreparedStatement prep = null;
		try {
			prep = connection.prepareStatement(Constants.INSERTPLAYER);
			prep.setString(1, player);
			prep.setString(2, country);
			prep.setInt(3, origpoints);
			prep.setInt(4, newpoints);
			prep.setInt(5, numbermatch);
			prep.setInt(6, won);
			prep.setInt(7, lost);
			prep.setInt(8, draw);
			prep.executeUpdate();
		} catch (SQLException e) {
			log.warning("error in prepared statement");
		} finally {
			conn.closePreparedStatement(prep);
		}
		
	}
}
