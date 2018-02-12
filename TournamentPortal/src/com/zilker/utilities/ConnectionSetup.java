package com.zilker.utilities;

import java.sql.*;
import java.util.logging.Logger;

import com.zilker.constant.*;

//opening and closing a connection
public class ConnectionSetup {
	private Logger log = Logger.getLogger(ConnectionSetup.class.getName());

	public Connection getConnection()

	{
		Connection connection = null;
		try {
			Class.forName(Constants.PATH);
		} catch (ClassNotFoundException e) {
			log.warning("Class not found");
		}
		// Open a connection
		try {
			if (connection == null)
				connection = DriverManager.getConnection(Constants.DB_URL, Constants.USER, Constants.PASS);
		} catch (SQLException e) {
			log.warning("No connection setup");
		}

		return connection;
	}

	public void closeConnection(Connection connection) {
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException se) {
			log.warning("Connection null");
		}
	}

	// close result
	public void closeResult(ResultSet result) {
		try {
			if (result != null) {
				result.close();
			}
		} catch (Exception e) {
			log.warning("Result null");
		}

	}

	// close statement
	public void closeStatement(Statement statement) {

		try {
			if (statement != null) {
				statement.close();
			}
		} catch (SQLException se2) {
			log.warning("Statement null");
		}

	}

	public void closePreparedStatement(PreparedStatement statement) {

		try {
			if (statement != null) {
				statement.close();
			}
		} catch (SQLException se2) {
			log.warning("Prepared Statement null");
		}

	}
}
