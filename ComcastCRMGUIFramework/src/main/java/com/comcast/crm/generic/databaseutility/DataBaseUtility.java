package com.comcast.crm.generic.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DataBaseUtility {
	Connection con;

	public void getDataBaseConnection(String url, String userName, String Password) {

		try {
			Driver driverRef = new Driver();
			DriverManager.registerDriver(driverRef);
			con = DriverManager.getConnection(url, userName, Password);

		} catch (Exception e) {
			System.out.println(" exception handled");
		}

	}

	public void closeDataBaseConnection() {
		try {
			con.close();
		} catch (Exception e) {
			System.out.println(" exception handled");
		}

	}

	public ResultSet executeSelectQuery(String query) throws SQLException {
		ResultSet resultset = null;
		try {
			Statement stat = con.createStatement();
			resultset = stat.executeQuery(query);
		} catch (Exception e) {
			System.out.println(" exception handled");
		}

		return resultset;

	}

	public int executeNonSelectQuery(String query) throws SQLException {
		int result = 0;
		try {
			Statement stat = con.createStatement();
			result = stat.executeUpdate(query);
		} catch (Exception e) {
			System.out.println(" exception handled");
		}

		return result;

	}

	public void getDataBaseConnection() {

		try {
			Driver driverRef = new Driver();
			DriverManager.registerDriver(driverRef);
			con = DriverManager.getConnection("jdbc:mysql://106.51.90.215:3333/projects", "root@%", "root");

		} catch (Exception e) {
			System.out.println(" exception handled");
		}

	}

}
