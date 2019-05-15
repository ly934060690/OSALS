package Java;



import java.sql.*;

public class JDBC {
    private static String url="jdbc:mysql://localhost::3306/软件172班";
    private static String username="root";
    private static String password="liu200045.";
    private static String driverName="com.mysql.jdbc.Driver";
    static{
        try{
            Class.forName(driverName);
        }catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }
    //加载数据库驱动
    public static Connection getConnection()throws SQLException {
        return DriverManager.getConnection(url,username,password);
    }
    //该方法获得url对应数据库的连接
    public static void release(ResultSet rs, Statement st, Connection conn){
        try{
            if(rs!=null)
                rs.close();
            if(st!=null)
                st.close();
            if(conn!=null)
                conn.close();
        }
        catch (SQLException e)
        {
        }
    }
}
