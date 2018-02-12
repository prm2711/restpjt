package com.zilker.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

import com.zilker.constant.Constants;
import com.zilker.utilities.ConnectionSetup;

public class UserType {
	private Logger logger = Logger.getLogger(UserType.class.getName());

	// Find if user is Special or normal
	public String retrieveType(String user) {
		// TODO Auto-generated method stub
		Connection connection = null;
		ConnectionSetup conn = new ConnectionSetup();

		connection = conn.getConnection();
		PreparedStatement prep = null;
		Statement statement = null;
		ResultSet result = null;
		String type = null;
		try {

			// Execute a query
			statement = connection.createStatement();

			prep = connection.prepareStatement(Constants.RETRIEVEPRIVILEGEDUSER);
			prep.setString(1, user);
			result = prep.executeQuery();
			if (result == null) {
				logger.info("No record found.");
				return null;
			}
			while (result.next()) {

				type = result.getString(1);

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
		return type;
	}

}
