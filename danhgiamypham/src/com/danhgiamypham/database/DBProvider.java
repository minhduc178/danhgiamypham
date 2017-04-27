package com.danhgiamypham.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.danhgiamypham.Utilities.DBProperties;

public class DBProvider {	
	
	public Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName(DBProperties.JDBC_DRIVER);
			connection = DriverManager.getConnection(DBProperties.DB_URL, DBProperties.USER, DBProperties.PASS);
			} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
}
