package com.zilker.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Logger;

import java.sql.PreparedStatement;

import com.zilker.bean.Match;
import com.zilker.bean.Player;
import com.zilker.constant.Constants;
import com.zilker.utilities.ConnectionSetup;

public class UserValidation {
	private Logger logger = Logger.getLogger(UserValidation.class.getName());
//Check for valid username and password
	public boolean userValidate(String user, String pass) {
		Connection connection = null;
		ConnectionSetup conn = new ConnectionSetup();
		connection = conn.getConnection();
		Statement statement = null;
		ResultSet result = null;
		PreparedStatement prep = null;
		String username=null,password=null;
		try {

			// Execute a query
			statement = connection.createStatement();
			result = statement.executeQuery(Constants.RETRIEVEUSER);

			if (result == null) {
				logger.info("No record found.");
				return false;
			}
			while (result.next()) {
				
             username=result.getString(1);
             password=result.getString(2);
             if(user.equals(username)==true && pass.equals(password)==true)
            	 return true;
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
		return false;
	}

}
