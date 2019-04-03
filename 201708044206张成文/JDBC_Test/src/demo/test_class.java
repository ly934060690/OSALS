package demo;

import java.sql.*;

public class test_class {
    public static  void main(String[] args)
    {
        String url = "jdbc:mysql://202.196.37.168:3306";
        String username = "student",password = "Student_123456";
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url,username,password);
            Statement stmt = con.createStatement();
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
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
