package edu.zut.cs.network.example.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class JdbcExample {

	protected Logger logger = LogManager.getLogger(this.getClass().getName());

	public JdbcExample() {

	}

	public void query() {
		Connection con = null;
		ResultSet rs = null;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://202.196.37.91:3306/course?useUnicode=true&characterEncoding=utf8";
			String user = "zutnlp";
			String password = "zutnlp";
			con = DriverManager.getConnection(url, user, password);
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT ID, FULLNAME FROM T_STUDENT");
			while (rs.next()) {
				logger.info("{ID:" + rs.getLong(1) + "\t fullname:" + rs.getString(2) + "}");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) {
		JdbcExample e = new JdbcExample();
		e.query();
	}

}
