package com.zcw.jdbc;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import javax.sound.midi.MidiDevice.Info;

import org.junit.Test;



public class JDBC_test {

	/**
	 * 
	 * DriverManager  是驱动的管理类
	 * @throws Exception 
	 */
	@Test
	public void testDriverManager() throws Exception
	{
		String driverClass = null;
		String jdbcUrl = null;
		String user = null;
		String password = null;
		
		//读取配置文件
		InputStream in =
		             getClass().getClassLoader().getResourceAsStream("jdbc.properties");
		
		Properties properties =new Properties();
		properties.load(in);
		driverClass= properties.getProperty("driver");
		jdbcUrl= properties.getProperty("jdbcUrl");
		user= properties.getProperty("user");
		password = properties.getProperty("password");
		//1.加载数据库驱动
		Class.forName(driverClass);
		//2.通过DriverManager的getConnection（）方法获取数据库连接
		Connection connection =DriverManager.getConnection(jdbcUrl, user, password);
		System.out.println(connection);
	}
	/**
	 * Driver  是一个接口  ：数据库厂商必须提供实现的接口，能从其中获取数据库连接
	 * @throws SQLException 
	 */
	
	@Test
	public void testDriver() throws SQLException {
		//1.创建一个Driver实现类的对象
		Driver driver = new com.mysql.cj.jdbc.Driver();
		
		String url = "jdbc:mysql://localhost:3306/eesy?useUnicode=true&characterEncoding=UTF-8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		Properties info = new Properties();
		info.put("user", "root");
		info.put("password", "z123");
		//2.调用Driver接口的 connect  获取连接
		Connection connection =driver.connect(url, info);
		System.out.println(connection);
		
	}
	
	/**
	 * 
	 * 编写一个通用的方法，在不修改源程序的情况下，可以获得任何数据库的连接
	 * 
	 * 解决方案：配置文件 
	 * @throws Exception  
	 */

	public Connection getConnection() throws  Exception
	{
		String driverClass = null;
		String jdbcUrl = null;
		String user = null;
		String password = null;
		
		//读取配置文件
		InputStream in =
		             getClass().getClassLoader().getResourceAsStream("jdbc.properties");
		
		Properties properties =new Properties();
		properties.load(in);
		driverClass= properties.getProperty("driver");
		jdbcUrl= properties.getProperty("jdbcUrl");
		user= properties.getProperty("user");
		password = properties.getProperty("password");
		Driver driver = (Driver) Class.forName(driverClass).newInstance();
		
		Properties info= new Properties();
		info.put("user", user);
		info.put("password", password);
		Connection connection = driver.connect(jdbcUrl, info);
		return connection;
	}
	@Test
	public void testGetConnection() throws Exception
	{
		System.out.println(getConnection());
	}
}
