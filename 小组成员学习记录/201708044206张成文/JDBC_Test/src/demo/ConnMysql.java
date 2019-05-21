package demo;

import java.sql.*;

public class ConnMysql {
    public  static  void main(String [] args)
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://202.196.37.168:3306/dream","student","Student_123456");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select *from T_STUDENT order by CODE");
            while(rs.next())
            {
                int numColumns = rs.getMetaData().getColumnCount();
                StringBuffer buffer = new StringBuffer();
                for(int i = 1;i<=numColumns;i++)
                {
                    buffer.append(rs.getMetaData().getColumnLabel(i)+"="+rs.getObject(i)+" ");
                }
                System.out.println(buffer.toString());
                rs.close();
                stmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
