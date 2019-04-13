package com.zcw.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_tools {

	public static void release(ResultSet rs,Statement statement,Connection connection)
	{
		
		if(rs!=null)
		{
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(statement!=null)
		{
			try {
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(connection!=null)
		{
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void getconnection()
	{
		
		
	}
}
