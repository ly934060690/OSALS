package edu.zut.cs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class JDBC {
	public static Connection getConn() {
		String driver="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/keepinformations";
		String username="root";
		String password="123456";
		Connection conn=null;
		try {
			Class.forName(driver);
			conn=(Connection)DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
}
