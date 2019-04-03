package com.logistics.lbw.mian;

import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @Auther: LBW
 * @Date: 2019/4/3
 * @Description: com.logistics.lbw.mian
 * @version: 1.0
 */
@Repository("DataBase")   //这里我设置此类为持久层

public class DataBase implements Datas   //这里设置数据库操作为接口类以便接下来的类使用
{
    public DataBase(){}

    public  Connection  GetConn()throws SQLException , ClassNotFoundException
    {

            Class.forName("com.mysql.jdbc.Driver");          //加载驱动
            String url = "jdbc:mysql://127.0.0.1:3306/mysql";
            String username = "root";
            String password = "123456";
            Connection conn = DriverManager.getConnection(url, username, password);
        return conn;
    }

    @Override
    public void MysqlConn(Connection str) throws ClassNotFoundException, SQLException
    {
        Statement st = str.createStatement();
    }

    @Override
    public void GoodsUp(Connection str) throws ClassNotFoundException, SQLException {

    }

    @Override
    public void GoodsDown(Connection str) throws ClassNotFoundException, SQLException {

    }

    @Override
    public void GoodsPrint(Connection str) throws ClassNotFoundException, SQLException {

    }

}

