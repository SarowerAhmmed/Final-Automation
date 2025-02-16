package com.db.manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBManger {
	public static void main(String[] args) throws Throwable {

		Class.forName("oracle.jdbc.driver.OracleDriver");
		//Actual code
		Connection connection = DriverManager.getConnection("DB URL", "user", "pass");
		Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = stmt.executeQuery("select * from employees");

		List<String> columnValue = new ArrayList<String>();

		try {
			while (rs.next()) {
				System.out.println(rs.getString(1));
				columnValue.add(rs.getString(1));

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		// System.out.println(columnValue);
		// step5 close the connection object

		System.out.println(columnValue);
	}
	

}