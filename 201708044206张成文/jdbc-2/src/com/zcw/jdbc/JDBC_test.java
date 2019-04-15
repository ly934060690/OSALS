package com.zcw.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


import javax.sound.midi.MidiDevice.Info;

import org.junit.Test;
import org.junit.runner.notification.RunListener.ThreadSafe;



public class JDBC_test {
	/**
	 * 
	 * 使用PreparedStatement解决SQL注入问题
	 */
	@Test
	public void testSqlInjection2()
	{
		String name ="a' or money = ";
		String money= "or '1'='1";
		String sql = "select * from account where name=?"+
				"and money=?";
		Connection connection=null;
		PreparedStatement preparedStatement =null;
		ResultSet resultSet =null;
		try {
			connection =JDBC_tools.getconnection();
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, money);
			resultSet=preparedStatement.executeQuery();
			if(resultSet.next())
			{
				System.out.println("登录成功");
			}else{
				System.out.println("失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally
		{
			JDBC_tools.release(resultSet, preparedStatement, connection);
		}
	}
	
	
	/**
	 * SQL注入
	 * 
	 */
	@Test
	public void testSqlInjection()
	{
		String name ="a' or money = ";
		String money= "or '1'='1";
		String sql = "select * from account where name='"+name
				+ "'and"+"money='"+money+"'";
		Connection connection=null;
		Statement statement =null;
		ResultSet resultSet =null;
		try {
			connection =JDBC_tools.getconnection();
			statement =connection.createStatement();
			resultSet=statement.executeQuery(sql);
			if(resultSet.next())
			{
				System.out.println("登录成功");
			}else{
				System.out.println("失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally
		{
			JDBC_tools.release(resultSet, statement, connection);
		}
	}
	
	
	
	/**
	 * 
	 * PreparedStatement是Statement的子接口，可以传入带占位符的sql语句，
	 *  提供了补充占位符变量的方法,还可以防范 SQL注入攻击
	 * 1)使用Statement 需要进行 sql语句的拼写
	 * 2)PreparedStatement  
	 * 1.创建PreparedStatement
	 * 
	 * String sql = "insert into account values(?,?,?)";
	 * PreparedStatement ps = conn.preparedstatement(sql);
	 * 
	 * 2.调用preparedstatement的setXXX（int index（索引值从1开始）,Object val）方法
	 *  设置占位符的值
	 *  
	 *  3.执行sql语句 executeQuery（）或executeUpdate（）  执行时不需要传入sql
	 *  
	 * 
	 */
	
//	@Test
//	public void testPreparedStatement()
//	{
//		Connection connection= null;
//		PreparedStatement preparedStatement =null;
//		try {
//			connection=JDBC_tools.getconnection();
//			String sql="insert into account(name,money)"+
//			"values(?,?)";
//			/**
//			 * update(String sql,Object...args(个数可变))
//			 * for(int i=0;i<args.length;i++)
//			 * {
//			 * preparedStatement.setObject(i+1,args[i]);
//			 * }
//			 *   
//			 */
//			preparedStatement =connection.prepareStatement(sql);
//			preparedStatement.setString(1, "Mary");
//			preparedStatement.setInt(2,1000 );
//			//preparedStatement.setDate(3, new Date(new java.util.Date().getTime()));
//			preparedStatement.executeUpdate();
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}finally {
//			JDBC_tools.release(null, preparedStatement, connection);
//		}
//	}
	
	/**
	 * 结果集，封装了使用JDBC，进行查询的结果
	 * 1.调用 Statement对象的executeQuery（Sql）可以得到结果集
	 * 2.ResultSet返回实际上就是一张数据表，有一个指针指向数据表的第一行的前面，
	 *   可以调用next（）方法检测下一行是否有效，若有效返回他惹怒，指针下移
	 *   相当于Iterator hasNext（）和next（）方法的结合体
	 *   3.当指针定位到某一行是，可以调用getXXX（index）或getXXX(columnName)
	 *     获取某一列的值  如：getInt(1),getString("name")
	 *   4.ResultSet需要关闭
	 */
	@Test
	public void testResultSet()
	{
		Connection connection = null;
		
		Statement statement =null;
		ResultSet resultSet= null;
		
		try {
			
			
			//1.获取Connection
			connection= JDBC_tools.getconnection();
			//2.获取Statement
			statement= connection.createStatement();
			//3.准备sql
			//String sql = "select id ,name,money from account where id=1";
			String sql = "select id ,name,money from account ";
			//4.执行查询得到ResultSet
			resultSet= statement.executeQuery(sql);
			//5.处理ResultSet
			while(resultSet.next())
			{
				int id= resultSet.getInt(1);
				String name = resultSet.getString("name");
				int money = resultSet.getInt(3);
				System.out.println(id);
				System.out.println(name);
				System.out.println(money);
			}
			//6.关闭
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			JDBC_tools.release(resultSet, statement, connection);
		}
		
	}
	
	
	
	
	
	
	@Test
	public void testStatement() throws Exception
	{
		
		/**
		 * execyteUpdate(sql)   sql语句可以是 insert，update，delete不能是select
		 * 
		 * 需要在finally中 关闭 connection和statement对象  因为出现异常的话  就无法关闭
		 * 
		 * 关闭连接是关闭后获取的
		 */
		
		
		/*String driverClass = null;
		String jdbcUrl = null;
		String user = null;
		String password = null;
		
		//读取配置文件
		InputStream in =
		             this.getClass().getClassLoader().getResourceAsStream("jdbc.properties");
		
		Properties properties =new Properties();
		properties.load(in);
		driverClass= properties.getProperty("driver");
		jdbcUrl= properties.getProperty("jdbcUrl");
		user= properties.getProperty("user");
		password = properties.getProperty("password");
		//JDBC向指定的数据表中插入一条记录
		//1.获取数据库连接
		Connection connection = DriverManager.getConnection(jdbcUrl, user, password);*/
		String driverClass = null;
		String jdbcUrl = null;
		String user = null;
		String password = null;
		
		//读取配置文件
		InputStream in =
		             this.getClass().getClassLoader().getResourceAsStream("jdbc.properties");
		
		Properties properties =new Properties();
		properties.load(in);
		driverClass= properties.getProperty("driver");
		jdbcUrl= properties.getProperty("jdbcUrl");
		user= properties.getProperty("user");
		password = properties.getProperty("password");
		Connection connection= null;
		Statement statement= null;
		
		try {
			connection= DriverManager.getConnection(jdbcUrl, user, password);
			
			//3.准备插入的SQL语句
	//		String sql = "insert into account(id,name,money)"+
	//		"values('4','ddd','1000')";
			
		//	String sql= "delete from account where id=4";
			String sql = "update account set name='TOM' where id=3";
			//4.执行插入
			//(1)获取操作SQL语句的statement对象:调用connection的createstatement（）方法来获取
			 statement = connection.createStatement();
			
			//（2）调用statement对象的executupdate（sql）执行sql语句进行插入
			statement.executeUpdate(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				//5.关闭statement对象
				if(statement!=null)
				{
				statement.close();
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				//2.关闭连接
				if(connection!=null)
				{
				connection.close();
				}
			}
		}
	}
	/*@Test
	public Connection getConnection2() throws Exception
	{
		String driverClass = null;
		String jdbcUrl = null;
		String user = null;
		String password = null;
		
		//读取配置文件
		InputStream in =
		             this.getClass().getClassLoader().getResourceAsStream("jdbc.properties");
		
		Properties properties =new Properties();
		properties.load(in);
		driverClass= properties.getProperty("driver");
		jdbcUrl= properties.getProperty("jdbcUrl");
		user= properties.getProperty("user");
		password = properties.getProperty("password");
		Class.forName(driverClass);
		return DriverManager.getConnection(jdbcUrl, user, password);
		}*/

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
