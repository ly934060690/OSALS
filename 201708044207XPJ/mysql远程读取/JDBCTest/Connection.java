package JDBCTest;

import java.sql.*;

public class Connection {
    private String user = "student";
    private String url = "jdbc:mysql://202.196.37.168:3306/stars?useSSL=false&allowPublicKeyRetrieval=true";
    private String password = "Student_123456";
    private String driver = "com.mysql.jdbc.Driver";
//    private Connection connection = null;
//    private Statement statement = null;
//    private ResultSet rs = null;

    public void getConnection(){
        try {
            Class.forName(driver);
            java.sql.Connection connection =  DriverManager.getConnection(url,user,password);
            Statement statement = connection.createStatement();
            statement.execute("select * from student");
            ResultSet resultSet = statement.getResultSet();
            while(resultSet.next()){
                System.out.println(resultSet.getString(1)+" "+resultSet.getString(2)+" "+resultSet.getString(3)+" "+resultSet.getInt(4));
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        Connection c = new Connection();
        c.getConnection();
    }
}
