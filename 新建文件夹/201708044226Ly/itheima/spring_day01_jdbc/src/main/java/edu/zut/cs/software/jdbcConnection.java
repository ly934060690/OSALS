package edu.zut.cs.software;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class jdbcConnection {

    private static String driver = "com.mysql.jdbc.Driver";
    private static String url = null;
    private static String userName = null;
    private static String passWord = null;

    public jdbcConnection() {
        url = "jdbc:mysql://localhost:3306/test";
        userName = "root";
        passWord = "123456";
    }
    public jdbcConnection(String url, String userName, String passWord) {
        this.url = url;
        this.userName = userName;
        this.passWord = passWord;
    }

    public static String getDriver() {
        return driver;
    }

    private static String getUrl() {
        return url;
    }

    public static void setUrl(String url) {
        jdbcConnection.url = url;
    }

    private static String getUserName() {
        return userName;
    }

    public static void setUserName(String userName) {
        jdbcConnection.userName = userName;
    }

    private static String getPassWord() {
        return passWord;
    }

    public static void setPassWord(String passWord) {
        jdbcConnection.passWord = passWord;
    }

    public static Connection getConnection() {

        Connection connection = null;
        try {
            Class.forName(getDriver());
            connection = DriverManager.getConnection(getUrl(), getUserName(), getPassWord());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
