package com.tap.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connect {
	private static Connection con;

	public static Connection connect() {
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/foodapp", "root","root@123");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}

}
